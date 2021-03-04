package com.jilit.clxacademics.service.impl;
/**
*
* @author Ashok.Singh

*/

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.jilit.clxacademics.config.CookieUtil;
import com.jilit.clxacademics.config.JwtTokenUtil;
import com.jilit.clxacademics.dao.UserDao;
import com.jilit.clxacademics.util.ErrorBank;
import com.jilit.clxacademics.util.Identifier;
import com.jilit.clxacademics.util.MessageBank;
import com.jilit.clxacademics.exceptions.CLXException;
import com.jilit.clxacademics.exceptions.EntityNotFoundException;
import com.jilit.clxacademics.model.Sct_IrpMlp;
import com.jilit.clxacademics.model.Sct_IrpUsers;
import com.jilit.clxacademics.model.User;
import com.jilit.clxacademics.repository.ClientRepository;
import com.jilit.clxacademics.repository.Sct_IrpMlpRepository;
import com.jilit.clxacademics.repository.V_StaffRepository;
//import com.jilit.clxacademics.service.LoginService;
import com.jilit.clxacademics.service.UserService;
import com.jilit.clxacademics.util.OLTEncryption;
import com.jilit.clxacademics.util.OLTEncryption.EncryptionException;
import com.jilit.clxacademics.util.SmsMailUtil;
import com.jilit.clxacademics.util.CommanUtils;
import com.jilit.clxacademics.repository.CCounsLinksRepository;


@Service(value = "userService")
@PropertySource("classpath:application.properties")
public class UserServiceImpl implements UserDetailsService, UserService {
	private static final String jwtTokenCookieName = "JWT-TOKEN";
	@Autowired
	private Environment env;

	static final long ONE_MINUTE_IN_MILLIS = 60000;// millisecs
	@Value("${otptimeout}")
	private static String otptimeout;

	public static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	private UserDao userDao;
	 
	@Autowired
	CCounsLinksRepository ccounslinksrepository;

	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	public BCryptPasswordEncoder encoder;
	@Autowired
	public SmsMailUtil smsMailUtil;
	@Autowired
	public Sct_IrpMlpRepository mlpRepository;
	@Autowired
	private V_StaffRepository vStaffRepository;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
 	@Autowired
	public CommanUtils CommanUtils;

	@Autowired
	private OLTEncryption oLTEncryption; 

	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {

		User user = userDao.findByUsername(userId);

		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}

		String loginid = "", pwd = "";
		SimpleGrantedAuthority auth = null;
		try {
			loginid = user.getUsername();
			pwd = user.getPassword();
			pwd = encoder.encode(pwd);
			String roles = oLTEncryption.decode(user.getRole());
			if (roles.equalsIgnoreCase("C")) {
//				auth = new SimpleGrantedAuthority("ROLE_CANDIDATE");
				auth = new SimpleGrantedAuthority("A");
			} else// if (roles.equalsIgnoreCase("A")) 
			{
				auth = new SimpleGrantedAuthority("A");
				//			auth = new SimpleGrantedAuthority("ROLE_ADMIN");
			}
		} catch (Exception ex) {
		}
		return new org.springframework.security.core.userdetails.User(loginid, pwd, Arrays.asList(auth));

	}

	@Override
	public UserDetails loadUsernameDecrypted(String userid) throws UsernameNotFoundException {
		User user = userDao.findByUsername(userid);
		if (user == null) 
		{
			throw new UsernameNotFoundException("Invalid username or password.");
		}

		String loginid = "", pwd = "";
		try {
				loginid = oLTEncryption.decode(user.getUsername());
				pwd = oLTEncryption.decode(user.getPassword());
				pwd = encoder.encode(pwd);
			} 
		catch (Exception ex) 
			{
			}
		return new org.springframework.security.core.userdetails.User(loginid, pwd, getAuthority());
	   }

	private List<SimpleGrantedAuthority> getAuthority() 
	{
		return Arrays.asList(new SimpleGrantedAuthority("A")); //"ROLE_CANDIDATE"
	}

	public List<User> findAll() {
		List<User> list = new ArrayList<>();
		userDao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public void delete(long id) {
		userDao.deleteById(id);
	}

	@Override
	public User findOne(String username) {
		return userDao.findByUsername(username);
	}

	@Override
	public User findById(Long id) {
		Optional<User> u= userDao.findById(id);
	return u.get();	
	}

	@Override
	public User save(User user) {
		return userDao.save(user);
	}

 	public <T, K, V> T otpPasswordCheck(Map<K, V> Reqmap, HttpServletRequest request,
			HttpServletResponse httpServletResponse) throws CLXException {
		HashMap<String, Object> responsemap = new HashMap<>();
		Map resdata = new HashMap();
		HashMap<String, Object> datamap = new HashMap<>();	
		datamap=(HashMap<String, Object>) Reqmap;
		if (datamap.containsKey("otppwd")) {

			String operation = datamap.get("otppwd").toString();
			try {
				
				
// TO BE CHANGED BY ASHOK
			//	datamap.put("usertype", "C"); // C=Candidate
				//datamap.put("userid", "userid");
				List<SimpleGrantedAuthority> role = new ArrayList<>();
				//role.add(new SimpleGrantedAuthority("ROLE_CANDIDATE"));
				//final Map mCandidate=vStaffRepository.getCandidateLoginDetail(datamap.get("username").toString(),datamap.get("logintype").toString());
				final Map m=vStaffRepository.getCandidateLoginDetail(datamap.get("username").toString(),datamap.get("logintype").toString());
				//final Map mAdmin=vStaffRepository.getCandidateLoginDetailAdmin(datamap.get("username").toString(),datamap.get("logintype").toString());
				if (m==null)
					{
						if(datamap.get("logintype").toString().equals("A"))			// Application No			
							throw new  CLXException(Identifier.LOGINCREDENTIAL,ErrorBank.APPLICATION_NO_INCORRECT);
						else if(datamap.get("logintype").toString().equals("R"))	// JEE RANK No	
							throw new  CLXException(Identifier.LOGINCREDENTIAL,ErrorBank.JEE_RANK_NO_INCORRECT);
						else 	//	// 'D' Admin User
							throw new  CLXException(Identifier.LOGINCREDENTIAL,ErrorBank.INVALID_LOGIN_CREDENTIAL);
					}
				// Check password Here
				
				if (operation.contains("P")) // If PASSWORD BASED Authorization is required then
				{
					String password=(m.get("pwdata")==null ?"":m.get("pwdata").toString());
					String passwordotpvalue=(datamap.get("passwordotpvalue")==null ?"":datamap.get("passwordotpvalue").toString());
					
					if (!password.equals(passwordotpvalue))
					{
						throw new  CLXException(ErrorBank.PASSWORD_NOT_MATCHED,Identifier.LOGINCREDENTIAL);
					}
				}

				final User user =findOne(m.get("applicationid").toString());
				UserDetails users = new org.springframework.security.core.userdetails.User(
						datamap.get("username").toString().toUpperCase(),
						datamap.get("passwordotpvalue").toString().toUpperCase(), true, true, true, true, role);
				UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(users, null, role);

				SecurityContextHolder.getContext().setAuthentication(auth);

				
				
				// TEMPORARY
				
				final String token = jwtTokenUtil.generateToken(user);
				CookieUtil.create(httpServletResponse, jwtTokenCookieName, token, false, -1, "localhost");

				List<Map> lst =ccounslinksrepository.showDashBoardData(m.get("cid").toString(), m.get("applicationid").toString());
				if (lst==null ||lst.size()==0)
				{
					throw new CLXException("No Application Found.....(Invalid Login)",Identifier.LOGINCREDENTIAL);
				}
				if (lst.size()>1)
				{
					throw new CLXException("Multiple Application Found.....(Invalid Login  )",Identifier.LOGINCREDENTIAL);
				}
				
				resdata.put("cid", m.get("cid")==null?"":m.get("cid").toString());
				resdata.put("applicationid",m.get("applicationid").toString());
				resdata.put("membertype", "C" );
				resdata.put("token", token);
				resdata.put("name", m.get("name")==null?"":m.get("name").toString());
				resdata.putAll(lst.get(0));
			//	resdata.put("lastvisitdate", otpvalid.get("lastvisitdate"));
				responsemap.put("regdata", resdata);
				
			} catch (Exception e) {
				//e.printStackTrace();
				throw new CLXException( e.getMessage(),Identifier.OTP_SAVE_UPDATE);
			}
		}
		return (T) responsemap;
		// }
	}

	 
}
