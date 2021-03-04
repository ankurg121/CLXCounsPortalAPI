package com.jilit.clxacademics.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jilit.clxacademics.config.CookieUtil;
import com.jilit.clxacademics.config.JwtTokenUtil;
import com.jilit.clxacademics.exceptions.BadRequestException;
import com.jilit.clxacademics.exceptions.CLXException;
import com.jilit.clxacademics.response.ObjectResponse;
import com.jilit.clxacademics.response.ResponseUtil;
import com.jilit.clxacademics.response.Standards;
import com.jilit.clxacademics.response.StatusType;
import com.jilit.clxacademics.service.LoginService;
import com.jilit.clxacademics.service.UserService;
import com.jilit.clxacademics.util.CommanUtils;
import com.jilit.clxacademics.util.ErrorBank;
import com.jilit.clxacademics.util.Identifier;
import com.jilit.clxacademics.util.JISDateUtil;
import com.jilit.clxacademics.util.OLTEncryption;
 
@RestController
//@CrossOrigin(origins = {"http://172.16.5.5", "http://172.16.7.252:8090"},maxAge = 4800, allowCredentials = "false") 
//@CrossOrigin(origins = {"http://172.16.5.105", "http://172.16.7.252:8090"})
@CrossOrigin(origins = "*")
@RequestMapping("/token")
public class AuthenticationController {
	public static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);
	@Autowired
	private AuthenticationManager authenticationManager;
	 private static final String jwtTokenCookieName = "JWT-TOKEN";
	@Autowired
	private JISDateUtil jISDateUtil;
	
	@Autowired
	private CommanUtils commanUtils;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserService userService;

	//@Autowired
	//private LoginService loginservice;

	@Autowired
	private ResponseUtil responseutil;

	@Autowired
	private OLTEncryption olt;
	
	@Autowired
	private LoginService loginservice;

	@RequestMapping(value = "/generate-token", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<ObjectResponse<Object>> otpCheck(@RequestBody String jsonData, HttpServletRequest request,
			HttpServletResponse httpServletResponse) throws CLXException {

		final ObjectResponse<Object> endpointresponse = new ObjectResponse<>();

		HashMap<String, Object> responsemap = new HashMap<>();
		HashMap<String, Object> datamap = new HashMap<>();

		try {
			if (jsonData == null) {
				throw new BadRequestException(Identifier.LOGINCREDENTIAL,
						ErrorBank.ERROR_INVALID_JSON_BODYDATA_SUPPLIED);
			}
			datamap = new Gson().fromJson(jsonData, new TypeToken<HashMap<String, Object>>() {
			}.getType());

			if (datamap.isEmpty() || (!datamap.containsKey("username")) || (!datamap.containsKey("otppwd"))) {
				throw new BadRequestException(Identifier.LOGINCREDENTIAL,
						ErrorBank.ERROR_INVALID_JSON_BODYDATA_SUPPLIED);
			}
			//logintype =[A]pplication No / [R]roll No
			if (datamap.isEmpty() || (!datamap.containsKey("logintype")) || (!datamap.containsKey("logintype"))) {
				throw new BadRequestException(Identifier.LOGINCREDENTIAL,
						ErrorBank.ERROR_INVALID_JSON_BODYDATA_SUPPLIED);
			}
			
			datamap.put("ip", commanUtils.getIPadress(request));
			responsemap = userService.otpPasswordCheck(datamap, request, httpServletResponse);
		    SecurityContext context=SecurityContextHolder.getContext();
		    Object user= context.getAuthentication().getDetails();
			System.out.println(user+" is accessing this page.");			

			endpointresponse.setResponse(responsemap);
			endpointresponse.setStatus(new StatusType(Standards.SUCCESS));
			return ResponseEntity.status(HttpStatus.OK).body(endpointresponse);

		} catch (CLXException e) {
			return (responseutil.getFailedResponseEntyty(e, HttpStatus.NOT_FOUND));
		}

	}

	@RequestMapping("/logout")
    public String logout(HttpServletResponse httpServletResponse) {
        CookieUtil.clear(httpServletResponse, jwtTokenCookieName);
        return "redirect:/";
        
    }

	@RequestMapping(value = "/marqeelist", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<ObjectResponse<Map>> getMargeeList() {
		Map<String, Object> map = new HashMap<>();
		final ObjectResponse<Map> endpointresponse = new ObjectResponse<>();
		List marqueeList = new ArrayList<>();
		marqueeList.add("Demo message by user1");
		marqueeList.add("Demo message by user2");
		marqueeList.add("Demo message by user3");
		marqueeList.add("Demo message by user4");
		marqueeList.add("Demo message by user5");
		marqueeList.add("Demo message by user6");
		marqueeList.add("Demo message by user7");
		map.put("text", marqueeList);
		endpointresponse.setResponse(map);
		endpointresponse.setStatus(new StatusType(Standards.SUCCESS, null));
		return ResponseEntity.status(HttpStatus.OK).body(endpointresponse);

	}

/*	@RequestMapping(value = "/forget-changepassword", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<ObjectResponse<Object>> forgetchangepassword(@RequestBody String jsonData,
			HttpServletRequest request, HttpServletResponse httpServletResponse)
			throws Exception {
		
		final ObjectResponse<Object> endpointresponse = new ObjectResponse<>();

		HashMap<String, Object> responsemap = new HashMap<>();
		HashMap<String, Object> datamap = new HashMap<>();

		try {
			if (jsonData == null) {
				throw new BadRequestException(Identifier.LOGINCREDENTIAL,
						ErrorBank.ERROR_INVALID_JSON_BODYDATA_SUPPLIED);
			}
			datamap = new Gson().fromJson(jsonData, new TypeToken<HashMap<String, Object>>() {
			}.getType());

			if (datamap.isEmpty() || (!datamap.containsKey("username"))) {
				throw new BadRequestException(Identifier.LOGINCREDENTIAL,
						ErrorBank.ERROR_INVALID_JSON_BODYDATA_SUPPLIED);
			}
			datamap.put("ip", commanUtils.getIPadress(request));
			datamap.put("encodedusername", (olt.encode(datamap.get("username").toString())));

			responsemap = userService.forgetchangepassword(datamap);

			endpointresponse.setResponse(responsemap);
			endpointresponse.setStatus(new StatusType(Standards.SUCCESS));
			return ResponseEntity.status(HttpStatus.OK).body(endpointresponse);

		} catch (CLXException e) {
			return (responseutil.getFailedResponseEntyty(e, HttpStatus.NOT_FOUND));

		}

	}
	
	@RequestMapping(value = "/marqeelist1", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<ObjectResponse<Object>> getMargeeList1() throws Exception{
		final ObjectResponse<Object> endpointresponse = new ObjectResponse<>();
		HashMap<String, Object> responsemap = new HashMap<>();
		HashMap<String, Object> datamap = new HashMap<>();
		try {			
			responsemap = userService.getMargeeList();
			endpointresponse.setResponse(responsemap);
			endpointresponse.setStatus(new StatusType(Standards.SUCCESS));
			return ResponseEntity.status(HttpStatus.OK).body(endpointresponse);

		} catch (CLXException e) {
			return (responseutil.getFailedResponseEntyty(e, HttpStatus.NOT_FOUND));
		}

	}*/
	
	 @SuppressWarnings({"unchecked", "rawtypes"})
	    @RequestMapping(value = "/signup", method = RequestMethod.POST)
	    public ResponseEntity<ObjectResponse<Object>> applicantsSignup(@RequestBody Map jsonMap) throws CLXException {
	        final ObjectResponse<Object> endPointResponse = new ObjectResponse<>();
	        Map loginresponsemap = new HashMap();
	        Map map = new HashMap<>();
	        try {
	        	loginresponsemap =loginservice.applicantsValidation(jsonMap);
	            map.put("loginstatus", loginresponsemap);
	            endPointResponse.setResponse(map);
	            return ResponseEntity.status(HttpStatus.OK).body(endPointResponse);
	        } catch (CLXException e) {
	            return (responseutil.getFailedResponseEntyty(e, HttpStatus.EXPECTATION_FAILED));
	        }
	    }
	    
	    @SuppressWarnings({"unchecked", "rawtypes"})
	    @RequestMapping(value = "/forgetpassword", method = RequestMethod.POST)
	    public ResponseEntity<ObjectResponse<Object>> forgetPassword(@RequestBody Map jsonMap) throws CLXException {
	        final ObjectResponse<Object> endPointResponse = new ObjectResponse<>();
	        Map loginresponsemap = new HashMap();
	        Map map = new HashMap<>();
	        try {
	        	loginresponsemap =loginservice.forgetPassword(jsonMap);
	            map.put("loginstatus", loginresponsemap);
	            endPointResponse.setResponse(map);
	            return ResponseEntity.status(HttpStatus.OK).body(endPointResponse);
	        } catch (CLXException e) {
	            return (responseutil.getFailedResponseEntyty(e, HttpStatus.EXPECTATION_FAILED));
	        }
	    }

}
