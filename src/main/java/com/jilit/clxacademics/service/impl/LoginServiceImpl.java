package com.jilit.clxacademics.service.impl;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.ibm.icu.text.SimpleDateFormat;
import com.jilit.clxacademics.business.BusinessService;
import com.jilit.clxacademics.business.IDGenerationRandom;
import com.jilit.clxacademics.config.EmailCfg;
import com.jilit.clxacademics.exceptions.CLXException;
import com.jilit.clxacademics.model.CApplicantsRegistration;
import com.jilit.clxacademics.model.CApplicationMaster;
import com.jilit.clxacademics.model.C_Current;
import com.jilit.clxacademics.repository.CApplicantsRegistrationRepository;
import com.jilit.clxacademics.repository.CApplicationMasterRepository;
import com.jilit.clxacademics.repository.CCounsLinksRepository;
import com.jilit.clxacademics.repository.C_CurrentRepository;
import com.jilit.clxacademics.service.LoginService;
import com.jilit.clxacademics.util.ErrorBank;
import com.jilit.clxacademics.util.Identifier;
import com.jilit.clxacademics.util.MessageBank;
import com.jilit.clxacademics.util.SmsMailUtil;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private CApplicationMasterRepository capplicationmasterrepository;

	@Autowired
	private CApplicantsRegistrationRepository capplicantsregistrationrepository;

	@Autowired
	private SmsMailUtil smsmailutil;

	@Autowired
	private EmailCfg emailcfg;

	@Autowired
	private IDGenerationRandom idgenerationrandom;

	@Autowired
	private C_CurrentRepository c_currentrepository;

	@Autowired
	CCounsLinksRepository ccounslinksrepository;

	@SuppressWarnings({ "unused", "unchecked", "rawtypes" })
	@Override
	public Map applicantsValidation(Map jsonMap) throws CLXException {
		Map<String, String> map = new HashMap();
		Map<String, String> datamap = new HashMap<String, String>();
		String applicationno = jsonMap.get("applicationno") == null ? "" : jsonMap.get("applicationno").toString();
		String jeerankno = jsonMap.get("jeerankno") == null ? "" : jsonMap.get("jeerankno").toString();
		//CApplicationMaster capplicationmaster = null;
		Map mLoginObj   = new HashMap();

		String emailidtoshow = "";
		String mobilenotoshow = "";
		int len = 10;
		int randNumOrigin = 48, randNumBound = 122;
		try {
			Date dobdate = new SimpleDateFormat("dd/MM/yyyy").parse(jsonMap.get("dob").toString());

			mLoginObj = capplicationmasterrepository.isUserValid(applicationno, jeerankno);

			if (mLoginObj != null) {
				if (dobdate.compareTo((Date)mLoginObj.get("dateofbirth")) != 0)
					throw new CLXException(ErrorBank.DOB_IS_INCORRECT, Identifier.LOGINSERVICE);
			} else if (mLoginObj == null) {
				if (jeerankno.equals(""))
					throw new CLXException(ErrorBank.APPLICATION_NO_INCORRECT, Identifier.LOGINSERVICE);
				else if (applicationno.equals(""))
					throw new CLXException(ErrorBank.JEE_RANK_NO_INCORRECT, Identifier.LOGINSERVICE);
				else
					throw new CLXException(ErrorBank.APPLICANT_NOT_FOUND, Identifier.LOGINSERVICE);
			}

			String cid = mLoginObj.get("counsellingid").toString();
			String applicationid = mLoginObj.get("applicationid").toString();
			String applno = mLoginObj.get("applicationno").toString();
			String emailid =  mLoginObj.get("email").toString();
			String mobileno =  mLoginObj.get("mobileno").toString();

			CApplicantsRegistration car = capplicantsregistrationrepository.isPasswordGenerated(cid, applicationid);

			if (car != null) {
				throw new CLXException(ErrorBank.APPLICANTS_ALREADY_REGISTERED, Identifier.LOGINSERVICE);
			}
			// email and mobile show to user in #pattern
			 emailidtoshow = formatEmailOrMobile(emailid, "E");
			 mobilenotoshow = formatEmailOrMobile(mobileno, "M");

			// random password generation
			String password = String.valueOf(randomPassword(len));

			CApplicantsRegistration capplicantsregistration = new CApplicantsRegistration();
			String registrationid = idgenerationrandom.generateNumber();
			capplicantsregistration.setRegtransid(registrationid);
			capplicantsregistration.setApplicationid(applicationid);
			capplicantsregistration.setEmailormobile(emailid == null ? "M" : "E");
			capplicantsregistration.setCid(cid);
			capplicantsregistration.setPwdata(password);
			capplicantsregistration.setRegemailmobile(emailid == null
					? mobileno:emailid);
			capplicantsregistration.setRegstatus("A");
			capplicantsregistration.setSignupdate(new Date());

			capplicantsregistrationrepository.save(capplicantsregistration);

			// smtp mail properties
			datamap.put("fromemailhost", emailcfg.getHost());
			datamap.put("fromemailport", String.valueOf(emailcfg.getPort()));
			datamap.put("fromemailid", emailcfg.getUsername());
			datamap.put("fromemailpwd", emailcfg.getPassword());
			datamap.put("toemailid", emailid);
			datamap.put("name",mLoginObj.get("name").toString());
			datamap.put("applno",mLoginObj.get("applicationno").toString());
			datamap.put("subject", "Jaypee Counselling On Line Registration of " + mLoginObj.get("name").toString());
			//datamap.put("msg", "Your Password is : " + password);
			datamap.put("password", password);
			// smsmailutil.sendSMSTo(url, capplicationmaster.getMobileno(),
			// capplicationmaster.getFirstname(), "Your Password id
			// :"+password);

			map.put("mobileno", "password send to : " + mobilenotoshow);
			map.put("emailid", "password send to : " + emailidtoshow);

		} catch (CLXException e) {
			throw new CLXException(e.getMessage(), Identifier.LOGINSERVICE);
		} catch (Exception e) {
			throw new CLXException(ErrorBank.SOMETHING_WENT_WRONG, Identifier.LOGINSERVICE);
		}
		try
		{
			smsmailutil.sendEmailToApplicant(datamap);
			  
		}
		 catch (Exception e) {
			throw new CLXException(ErrorBank.SOMETHING_WENT_WRONG, Identifier.LOGINSERVICE);
		}

		return map;
	}

	@SuppressWarnings({ "unused", "unchecked", "rawtypes" })
	@Override
	public Map forgetPassword(Map jsonMap) throws CLXException {
		Map<String, String> map = new HashMap();
		Map<String, String> datamap = new HashMap<String, String>();
		String applicationno = jsonMap.get("applicationno") == null ? "" : jsonMap.get("applicationno").toString();
		String jeerankno = jsonMap.get("jeerankno") == null ? "" : jsonMap.get("jeerankno").toString();
		//CApplicationMaster capplicationmaster = null;
		Map mLoginObj   = new HashMap();;
		String emailidtoshow = "";
		String mobilenotoshow = "";
		int len = 10;
		int randNumOrigin = 48, randNumBound = 122;
		try {

			Date dobdate = new SimpleDateFormat("dd/MM/yyyy").parse(jsonMap.get("dob").toString());
			mLoginObj = capplicationmasterrepository.isUserValid(applicationno, jeerankno);

			if (mLoginObj != null) {
				if (dobdate.compareTo((Date)mLoginObj.get("dateofbirth")) != 0)
					throw new CLXException(ErrorBank.DOB_IS_INCORRECT, Identifier.LOGINSERVICE);
			} else if (mLoginObj == null) {
				if (jeerankno.equals(""))
					throw new CLXException(ErrorBank.APPLICATION_NO_INCORRECT, Identifier.LOGINSERVICE);
				else if (applicationno.equals(""))
					throw new CLXException(ErrorBank.JEE_RANK_NO_INCORRECT, Identifier.LOGINSERVICE);
				else
					throw new CLXException(ErrorBank.APPLICANT_NOT_FOUND, Identifier.LOGINSERVICE);
			}

			String cid = mLoginObj.get("counsellingid").toString();
			String applicationid = mLoginObj.get("applicationid").toString();

			String emailid =  mLoginObj.get("email").toString();
			String mobileno =  mLoginObj.get("mobileno").toString();
   
			// email and mobile no show to user in # pattern
			emailidtoshow = formatEmailOrMobile(emailid, "E");
			mobilenotoshow = formatEmailOrMobile(mobileno, "M");

			// random alphanumberic password generation
			String password = String.valueOf(randomPassword(len));

			List<String> currentcid = c_currentrepository.getCurrentCID();
			CApplicantsRegistration capplicantsregistration = capplicantsregistrationrepository.getapplicants(
					currentcid.get(0) , applicationid, emailid,
					mobileno);

			capplicantsregistration.setPwdata(password);

			capplicantsregistrationrepository.save(capplicantsregistration);
			// email properties
			datamap.put("fromemailhost", emailcfg.getHost());
			datamap.put("fromemailport", String.valueOf(emailcfg.getPort()));
			datamap.put("fromemailid", emailcfg.getUsername());
			datamap.put("fromemailpwd", emailcfg.getPassword());
			datamap.put("toemailid", emailid);
			datamap.put("password", password);
			datamap.put("name",mLoginObj.get("name").toString());
			datamap.put("applno",mLoginObj.get("applicationno").toString());
			datamap.put("subject", "Jaypee Counselling (Password Reset) of  " + mLoginObj.get("name").toString());
			//datamap.put("msg", "Your New Password is : " + password);


			// smsmailutil.sendSMSTo(url, capplicationmaster.getMobileno(),
			// capplicationmaster.getFirstname(), "Your Password id
			// :"+password);

			map.put("mobileno", "password send to : " + mobilenotoshow);
			map.put("emailid", "password send to : " + emailidtoshow);

		} catch (CLXException e) {
			throw new CLXException(e.getMessage(), Identifier.LOGINSERVICE);
		} catch (Exception e) {
			throw new CLXException(ErrorBank.SOMETHING_WENT_WRONG, Identifier.LOGINSERVICE);
		}
		
		try
		{
			//smsmailutil.sendEmail(datamap);
			smsmailutil.sendEmailToApplicant(datamap);
		}
		catch (Exception e) {
			throw new CLXException(ErrorBank.SOMETHING_WENT_WRONG, Identifier.LOGINSERVICE);
		}
		return map;
	}

	@Override
	public String changePassword(Map jsonMap) throws CLXException {
		String status = "";
		Map<String, String> datamap = new HashMap<String, String>();
		//String regtransid = jsonMap.get("regtransid").toString();
		String applicationid = jsonMap.get("applicationid").toString();
		String cid = jsonMap.get("cid").toString();
		String currentpassword = jsonMap.get("currentpassword").toString();
		String password1 = jsonMap.get("password1").toString();
		String password2 = jsonMap.get("password2").toString();

		try {
			if (!password1.equals(password2)) {
				throw new CLXException(ErrorBank.PASSWORD_NOT_MATCHED, Identifier.LOGINSERVICE);
			}

			CApplicantsRegistration car = capplicantsregistrationrepository.getapplicantsForPass(applicationid, cid);

			if (!currentpassword.equals(car.getPwdata())) {
				throw new CLXException(ErrorBank.WRONG_PASS_SUPPLY, Identifier.LOGINSERVICE);
			}

			if (car != null) {
				if (!car.getRegstatus().equals("A"))
					throw new CLXException(ErrorBank.APPLICANTS_NOT_ACTIVE, Identifier.LOGINSERVICE);

				// update password in c#applicantsregistration
				car.setPwdata(password1);

				capplicantsregistrationrepository.save(car);
				status = MessageBank.UPDATE_SUCCESSFULLY;
			} else
				throw new CLXException(ErrorBank.APPLICANT_NOT_FOUND, Identifier.LOGINSERVICE);

		} catch (CLXException e) {
			throw new CLXException(e.getMessage(), Identifier.LOGINSERVICE);
		} catch (Exception e) {
			throw new CLXException(ErrorBank.SOMETHING_WENT_WRONG, Identifier.LOGINSERVICE);
		}
		return status;
	}

	public static String formatEmailOrMobile(String emailormobile, String switchval) {

		String str = "";
		String hashstr = "";
		if (emailormobile != null) {
			if (switchval.equals("E")) {
				int len = emailormobile.split("@")[0].length();
				String postemail = emailormobile.split("@")[1].toString();
				if (len > 4) {
					for (int i = 0; i < len - 4; i++) {
						hashstr = hashstr + "#";
					}
					str = emailormobile.substring(0, 1) + hashstr + emailormobile.substring(len - 2);
				} else if (len <= 4 && len > 2) {
					str = "##" + emailormobile.substring(2);
				} else {
					str = emailormobile.replace(emailormobile.substring(0), "#") + "@" + postemail;
				}
			} else {
				int len = emailormobile.length();
				// String postemail = emailormobile.split("@")[1] == null ? "" :
				// emailormobile.split("@")[1].toString();
				if (len > 4) {
					for (int i = 0; i < len - 4; i++) {
						hashstr = hashstr + "#";
					}
					str = emailormobile.substring(0, 1) + hashstr + emailormobile.substring(len - 2);
				} else if (len <= 4 && len > 2) {
					str = "##" + emailormobile.substring(2);
				} else {
					str = emailormobile.replace(emailormobile.substring(0), "#") + emailormobile.substring(len - 1);
				}
			}
		}
		return str;
	}

	// random password generation 1
	public static String generateRandomPassword(int len, int randNumOrigin, int randNumBound) {
		SecureRandom random = new SecureRandom();
		return random.ints(randNumOrigin, randNumBound + 1)
				.filter(i -> Character.isAlphabetic(i) || Character.isDigit(i)).limit(len)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
	}

	// random password generation 2
	static char[] randomPassword(int len) {
		String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String Small_chars = "abcdefghijklmnopqrstuvwxyz";
		String numbers = "0123456789";
		// String symbols = "!@#$%^&*_=+-/.?<>)";

		String values = Capital_chars + Small_chars + numbers;

		Random rndm_method = new Random();

		char[] password = new char[len];

		for (int i = 0; i < len; i++) {
			password[i] = values.charAt(rndm_method.nextInt(values.length()));

		}
		return password;
	}

	// random otp generation
	static char[] generateOTP(int len) {
		String numbers = "0123456789";
		Random rndm_method = new Random();
		char[] otp = new char[len];

		for (int i = 0; i < len; i++) {
			otp[i] = numbers.charAt(rndm_method.nextInt(numbers.length()));
		}
		return otp;
	}

	public Map showDashBoardList(Map jsonMap) throws CLXException 
	{
		String cid = jsonMap.get("cid").toString();
		String applicationid = jsonMap.get("applicationid").toString();
		
		List  urlList= new ArrayList();
		
		List  mpList = ccounslinksrepository.showDashBoardLinkList(cid);
		
		// Now Check Links is authorozed or APPLICABLE for the selected applicants or not....
		// TO BE DONE BY ASHOK 17/05/2020
		// Waiting for Link when to and whome to be accesss matrix filled by BG
		if(mpList!=null && mpList.size()>0)
		{
			for (int i=0;i<mpList.size();i++)
			{	
				urlList.add(mpList.get(i));
			}
		}
		
		Map m=new HashMap();
		//m= lst.get(0);
		m.put("links",urlList);
		return m;
	}

}
