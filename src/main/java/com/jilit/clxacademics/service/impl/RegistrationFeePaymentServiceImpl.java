package com.jilit.clxacademics.service.impl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import com.jilit.campuslynxportal.util.Identifier;
import com.jilit.clxacademics.business.BusinessService;
import com.jilit.clxacademics.exceptions.CLXException;
import com.jilit.clxacademics.model.SFMPG_FeeTransaction;
import com.jilit.clxacademics.model.SFMPG_FeeTransactionReply;
import com.jilit.clxacademics.repository.SFMPG_FeeTransactionReplyRepository;
import com.jilit.clxacademics.repository.SFMPG_FeeTransactionRepository;
import com.jilit.clxacademics.service.RegistrationFeePaymentService;
import com.jilit.clxacademics.util.ErrorBank;
import com.jilit.clxacademics.util.Identifier;
//import com.tp.pg.util.TransactionRequestBean;
//import com.tp.pg.util.TransactionResponseBean;

@Service
public class RegistrationFeePaymentServiceImpl  implements RegistrationFeePaymentService{
	@Autowired
	private BusinessService businessService;
	@Autowired
	private SFMPG_FeeTransactionRepository sfmPG_FeeTransactionRepository;
	@Autowired
	private SFMPG_FeeTransactionReplyRepository sfmPG_FeeTransactionReplyRepository;
	
	@Value("${paymentgatewayresponse}")
	private String paymentgatewayresponse;
	

	@Override
	@SuppressWarnings({"rawtypes", "unchecked"})
	public Map payNow(HttpServletResponse response1, Map jsonMap) throws CLXException {

		Map finalMap = new HashMap();
		List<Map> paymentGatewayList = new ArrayList();
		Map map = new HashMap();
		Map paymentmap = new HashMap();
		List<Map> list = new ArrayList();
		String transactionid = businessService.generateId(jsonMap.get("clientid").toString(),
				jsonMap.get("companyid").toString(), "PGTransactionId");
		List<Map> feeHeads = new ArrayList();
//		feeHeads = (List<Map>) jsonMap.get("feeheads");

		try {

			String PGTransactionid = transactionid;
			String strMarketCode = "";
			String strAcctNo = "1";
			String strTransactionAmount = "";
			String strPropPath = "";
			String studentid = jsonMap.get("memberid").toString();
//			String semesterCode = jsonMap.get("registrationcode") == null ? ""
//					: jsonMap.get("registrationcode").toString();
//			String enrollmentno = jsonMap.get("enrollmentno") == null ? "" : jsonMap.get("enrollmentno").toString();
//			String studentname = jsonMap.get("name") == null ? "" : jsonMap.get("name").toString();
//		//	String fathersname = jsonMap.get("fathersname") == null ? "" : jsonMap.get("fathersname").toString();
//			//String dateofbirth = jsonMap.get("dateofbirth") == null ? "" : jsonMap.get("dateofbirth").toString();
//			String registrationid = jsonMap.get("registrationid").toString();
//			String stytypeid =jsonMap.get("stytypeid").toString();
//			String stynumber =jsonMap.get("stynumber").toString();
			String mTime = "";
			String mTranDate = "";
//			String identifier= jsonMap.get("identifier")==null?"":jsonMap.get("identifier").toString();
			String identifier= Identifier.Registration_Fee_Payment_Service;
			// String
			// locatatorURL="https://payments.paynimo.com/PaynimoProxy/services/TransactionLiveDetails";
			String locatorURL = "https://payments.paynimo.com/PaynimoProxy/services/TransactionLiveDetails";
			String sCurrancycode = "INR";
//			String instituteid = jsonMap.get("instituteid").toString();
			String returnURL = jsonMap.get("returnurl").toString();
			if (jsonMap.get("totaldueamount") == null) {

				strTransactionAmount = "0";
			} else {

				strTransactionAmount = jsonMap.get("totaldueamount").toString().trim();
			}

			Date sysdate = new Date();
			SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
			String[] transDateInfo = (sdf1.format(sysdate)).split(" ", 2);
			//String transDate = "04-12-2019";
			String transDate = transDateInfo[0]; 
			// String transTime = "11:25:35";

			/****************** inserting into SFMPG#FeeTransaction ***********************/

			SFMPG_FeeTransaction sfmPG_FeeTransaction = new SFMPG_FeeTransaction();
 			sfmPG_FeeTransaction.setTransactionid(PGTransactionid);
			// if (sfmPG_FeeTransaction != null) {
			//
			//
			// }
// 			sfmPG_FeeTransaction.setInstituteid(instituteid);
//			sfmPG_FeeTransaction.setStudentid(studentid);
//			sfmPG_FeeTransaction.setRegistrationid(jsonMap.get("registrationid").toString());
//			sfmPG_FeeTransaction.setEventid(jsonMap.get("eventid").toString());
			sfmPG_FeeTransaction.setTransdatetime(sysdate);
//			sfmPG_FeeTransaction.setFeecurrencyid(jsonMap.get("currencyid").toString());
			sfmPG_FeeTransaction.setFeeamount(new BigDecimal(jsonMap.get("totaldueamount").toString()));
			sfmPG_FeeTransaction.setOtherchargesamount(new BigDecimal("0"));
			BigDecimal othercharges = new BigDecimal("0");
			sfmPG_FeeTransaction.setTotalpaidamount(new BigDecimal(strTransactionAmount).add(othercharges));
//			sfmPG_FeeTransaction.setPaymentcurrencyid(jsonMap.get("currencyid").toString());
//			sfmPG_FeeTransaction.setTransactiondoneby(studentid);
			sfmPG_FeeTransaction.setTransactionstatus("P");
			sfmPG_FeeTransaction.setIpaddress("172.16.5.203");
			sfmPG_FeeTransactionRepository.save(sfmPG_FeeTransaction);

			/******************* Transaction process ****************/
			
//			Map feeHeadInfo= new HashMap();
//			
//			String feeHeadsToAppend ="";
//			String 	quotaid = (feeHeads.get(0).get("quotaid")).toString();
//			String currencyid = (feeHeads.get(0).get("currencyid")).toString();
//			if(feeHeads!=null && feeHeads.size()!=0) {
//				
//				for(int i=0;i<feeHeads.size();i++) {
//				
//					feeHeadInfo=new HashMap();
//					feeHeadInfo = feeHeads.get(i);
//					if(!feeHeadsToAppend.equals("")) {
//						feeHeadsToAppend = feeHeadsToAppend+"&";
//					}
//					feeHeadsToAppend =feeHeadsToAppend+ feeHeadInfo.get("feeheadid").toString()+"@"+feeHeadInfo.get("dueamount").toString();
//				
//				}
//			}
			
			//feeHeadInfo = feeHeads

//			TransactionRequestBean objTransactionRequestBean = new TransactionRequestBean();
//			objTransactionRequestBean.setStrRequestType("T");
//			objTransactionRequestBean.setStrMerchantCode("T2835"); // T2835 for test and amount must be 2 user will be
//																	// test and password will be test
//			objTransactionRequestBean.setMerchantTxnRefNumber(PGTransactionid);
//			objTransactionRequestBean.setStrAmount(jsonMap.get("totaldueamount").toString()); // to be change
//			objTransactionRequestBean.setStrCurrencyCode(sCurrancycode);
////			objTransactionRequestBean.setStrITC(studentid + "~" + semesterCode + "~" + instituteid + "~"
////					+ strTransactionAmount + "~" + registrationid + "~" + jsonMap.get("eventid").toString()+"~"+stynumber+"~"+stytypeid
////					+"~"+enrollmentno+"~"+feeHeadsToAppend+"~"+quotaid+"~"+currencyid+"~"+identifier);
//			
//			String schemacode = "FIRST_" + jsonMap.get("totaldueamount").toString() + "_0.0";
//			objTransactionRequestBean.setStrShoppingCartDetails(schemacode);
//			objTransactionRequestBean.setTxnDate(transDate); // to be change
//			objTransactionRequestBean.setWebServiceLocator(locatorURL);
//			objTransactionRequestBean.setStrTPSLTxnID("");
//			objTransactionRequestBean.setStrBankCode("");
//			objTransactionRequestBean.setCardID("");
//			objTransactionRequestBean.setAccountNo("");
//			objTransactionRequestBean.setStrTimeOut("");
//			objTransactionRequestBean.setStrS2SReturnURL("");
//			objTransactionRequestBean.setStrMobileNumber("");
//			objTransactionRequestBean.setStrEmail("");
//			objTransactionRequestBean.setStrReturnURL(paymentgatewayresponse);
//			objTransactionRequestBean.setStrReturnURL(returnURL);
//			objTransactionRequestBean.setAdditionalInfo(feeHeads.toString());
//
//			String enkey = "8706193636DFPCMW";
//			String eniv = "3259392797JHRWSE";
//			objTransactionRequestBean.setKey(enkey.getBytes());
//			objTransactionRequestBean.setIv(eniv.getBytes());
//
//			String token = objTransactionRequestBean.getTransactionToken();
//
//			System.out.println("token: " + token);
//			finalMap.put("token", token);
		} catch (Exception e) {

			e.printStackTrace();

		}
		return finalMap;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	@Transactional
	public Map responseAfterPay(HttpServletResponse response1,String responseMessage) throws CLXException, UnsupportedEncodingException {

		
//		int n = 0;
//		// OLTEncryption enc=new OLTEncryption();
//		String strResponseMsg = "";
//		String strCheckSumValue = "";
//		String merchantid = "";
//		String customerID = "";
//		String txnreferenceNo = "";
//		String bankReferenceNo = "";
//		String txnAmount = "";
//		String bankID = "";
//		String bankMerchantid = "";
//		String txnType = "";
//		String currencyName = "";
//		String itemCode = "";
//		String securityType = "";
//		String securityID = "";
//		String securityPassword = "";
//		String txnDate = "";
//		String authStatus = "";
//		String settlementType = "";
//
//		String additionalInfo1 = "";
//		String additionalInfo2 = "";
//		String additionalInfo3 = "";
//		String additionalInfo4 = "";
//		String additionalInfo5 = "";
//		String additionalInfo6 = "";
//		String additionalInfo7 = "";
//		String errorStatus = "";
//		String errorDescription = "";
//		String checkSum = "";
//		String invalidPNRNoMsg = "";
//		String mProgramCode = "";
//		String mBranchCode = "";
//		String mCurrentSem = "";
//		String sysDate = "";
//		String bankMERCHANTID = "";
//		String studentid = "";
//		String statusFlag = "";
//		String mInstituteCode = "";
//		String mCompanyCode = "";
//		String feecurrencycode = "";
//		String paymentCurrencyCode = "";
//		String mAcademicYearCode = "";
//		String mTempStr = "";
//		String instituteid = "";
//		String eventid = "";
//		String registrationid = "";
//		String stynumber = "";
//		String stytypeid = "";
//		String enrollmentno = "";
//		String quotaid = "";
//		String transactionid = "";
//		String message[] = responseMessage.split("&", 2);
//		String data[] = message[0].split("=", 2);
//		String currencyid = "";
//		Map finalMap = new HashMap();
//
//		// System.out.println(responseMessage);
//		TransactionResponseBean beanObj = new TransactionResponseBean();
//		String key = "8706193636DFPCMW";
//		String iv = "3259392797JHRWSE";
//
//		String msg = data[1];
//		System.out.println(msg);
//		String decodedmsg = URLDecoder.decode(msg, "UTF-8");
//		beanObj.setIv(iv.getBytes("UTF-8"));
//		beanObj.setKey(key.getBytes("UTF-8"));
//		String responseString = "";
//		beanObj.setResponsePayload(decodedmsg);
//		responseString = beanObj.getResponsePayload();
////		System.out.println(responseString);
//
//		// beanObj.setResponsePayload("kFh6izbhJDrstQDvql7XWLxMQcLcs7I1eqLzWRODFTy3iYKy3vhs/xhF52I5T0R+HZDbs3ITb9P76bYeij4qRUqRtRcsXUHFwmTPMo2DOMGXl3d3Tivmn63/6B5k5BVxGzCkCZ/y+sdRkXMTWV1URt4QzUOpfDHoQceeaiyZ1RuOcxfHkjHaZTlHtMz7gyHYaAS/jUVmBuqqKFR01M6Fh2/eEtbalwxsSkP9VDUCv0DLiIiARlN6NaY1eCRkH7H4uwdfRGtX5EbLTYu0UnZbXSJt6kyGVk8ZUsZM5sBJMJjonvjf2wWa2bZ2MnHAspuVZE4HkwgVgG6pM1lOZe4DoxpPI3UUJB8gqlOtAKDhmIGPARdPcjhazB3vZjsbdzutI5s3G6fcDal0S+8WsJUNh2vW/ONC7sjmCHIHx+rog8cYjzMlMjEBKqct0vIw57MKUj+loRL5gZNLzUb2sFyljijyobJFKwC0Qb8Q8V3R83l2tM9b0NWsPHnzQ+TTUS/VCI1nRS1oL+ZG5hPAgJdKGCRBYI7FJdHuejMGGXqU2cs=");
//		// beanObj.setLogPath("D://payloadLog//MerchantResponseLog//OutTWC.log");
//		String statusFromResponse = responseString;
//		String temp = responseString.replace('|', '<');
//		String[] testString = temp.split("<");
//		String auth = testString[0].split("=", 2)[1];
//
//		if ("0300".equals(auth)) {
//
//			statusFlag = "S";
//
//		} else if ("0399".equals(auth) || "0392".equalsIgnoreCase(auth)) {
//
//			statusFlag = "F";
//		}
//		String[] itc = new String[testString[7].split(":", 2).length];
//		if ("S".equals(statusFlag)) {
//
////			itc = testString[7].split(":", 2); // array separating field name from their variables
////			String itcForReply[] = itc[1].replace("}", "").split("~", 25); // array where fields are separated by ~
//			customerID = testString[3].split("=", 2)[1]; // transaction id which is send to pg at time of request
//			// txnreferenceNo = testString[2]; SOAUPGT1912A0000001
//			// bankReferenceNo = testString[3]; 982130175
//			txnAmount = testString[6].split("=", 2)[1];
//			// bankID = testString[5]; 470
//			// bankMERCHANTID = testString[6];
//			// txnType = testString[7];
//			// currencyName = testString[8];
//			// itemCode = testString[9];
//			// securityType = testString[10];
//			// securityID = testString[11];
//			// securityPassword = testString[12];
//			txnDate = testString[8].split("=", 2)[1].split(" ", 2)[0];
//			// authStatus = testString[14];
//			// settlementType = testString[15];
////			eventid = itcForReply[5];
//			instituteid = "SOAUINSD1312A0000002";
////			errorStatus = testString[2].split("=", 2)[1];
////			studentid = itcForReply[0];
////			registrationid = itcForReply[4];
////			stynumber = itcForReply[6];
////			stytypeid = itcForReply[7];
////			enrollmentno = itcForReply[8];
////			quotaid = itcForReply[10];
////			currencyid = itcForReply[11];
//			transactionid = testString[5].split("=", 2)[1];
//			// errorDescription = testString[24];
//			// checkSum = testString[25];
//
//			/******** insert into SFMPG_FeeTransaction *********/
//			SFMPG_FeeTransaction sfmPG_FeeTransaction = new SFMPG_FeeTransaction();
//
//			Optional<SFMPG_FeeTransaction> sfmPG_FeeTransaction1 = sfmPG_FeeTransactionRepository.findById(customerID);
//			if ( sfmPG_FeeTransaction1.isPresent() && sfmPG_FeeTransaction1 != null) {
//				
//				sfmPG_FeeTransaction =(SFMPG_FeeTransaction) sfmPG_FeeTransaction1.get();
//				sfmPG_FeeTransaction.setTransactionid(customerID);
//				sfmPG_FeeTransaction.setTransactionstatus(statusFlag);
//				sfmPG_FeeTransactionRepository.save(sfmPG_FeeTransaction);
//			}
//
//			/************ generate prid *****************/
//
//			String prId = "";
//			String prno = "";
//			String idcode1 = "PaymentReceiptID";
//			String instunqid = "53"; // In Doubt
//			BigDecimal transferamount = BigDecimal.ZERO;
//
//			prId = businessService.generateId(instunqid, instituteid, idcode1);
//			// if (prId == null || prId.length() < 0)
//			// throw new CLXException(Identifier.FEECOLLECTIONBANKEXCELUPLOADSERVICE,
//			// ErrorBank.ERROR_WHILE_IDGENERATION);
//
//			prno = businessService.generateNumber(instituteid, "PRNO", "I", new Date(), instunqid);
//			// if (prno == null || prno.length() < 0)
//			// throw new CLXException(Identifier.FEECOLLECTIONBANKEXCELUPLOADSERVICE,
//			// ErrorBank.ERROR_WHILE_NUmberGENERATION);
//
//			/****** insert into SFMPG_FeeTransactionReply *******/
//			SimpleDateFormat d = new SimpleDateFormat("dd-mm-yyyy");
//
//			SFMPG_FeeTransactionReply sfmPG_FeeTransactionReply = new SFMPG_FeeTransactionReply();
//			Optional<SFMPG_FeeTransactionReply> sfmPG_FeeTransactionReply1 = sfmPG_FeeTransactionReplyRepository.findById(testString[5].split("=", 2)[1]);
//
//			if ( !sfmPG_FeeTransactionReply1.isPresent() && sfmPG_FeeTransactionReply1==null) {
//
//				sfmPG_FeeTransactionReply = new SFMPG_FeeTransactionReply();
//				sfmPG_FeeTransactionReply= (SFMPG_FeeTransactionReply) sfmPG_FeeTransactionReply1.get();
//			}
//
//			sfmPG_FeeTransactionReply.setTransactionid(testString[5].split("=", 2)[1]);// in doubt txn_id
//			sfmPG_FeeTransactionReply.setAmount(new BigDecimal(txnAmount));
//			// sfmPG_FeeTransactionReply.setBank_name(bank_name);
//			sfmPG_FeeTransactionReply.setRegistrationid(registrationid);
//			// sfmPG_FeeTransactionReply.setBanktransactionid(banktransactionid);
//			// sfmPG_FeeTransactionReply.setClientcode(clientcode);
//			// sfmPG_FeeTransactionReply.setCompanyid(companyid);
//			if (!errorStatus.equals("NA")) {
//
//				sfmPG_FeeTransactionReply.setDiscriminator(errorStatus);
//			} else {
//
//				sfmPG_FeeTransactionReply.setDiscriminator("");
//			}
//			sfmPG_FeeTransactionReply.setEventid(eventid);
//			// sfmPG_FeeTransactionReply.setIpg_txn_id(ipg_txn_id);
//			sfmPG_FeeTransactionReply.setPgtransactionid(customerID); // in doubt
//			sfmPG_FeeTransactionReply.setPrno(prno);
//			sfmPG_FeeTransactionReply.setResponsemessage(responseMessage);
//			sfmPG_FeeTransactionReply.setStudentid(studentid);
//			// sfmPG_FeeTransactionReply.setTransactionno(transactionno);
//			// sfmPG_FeeTransactionReply.setVouchercode(vouchercode);
//			// sfmPG_FeeTransactionReply.setVoucherid(voucherid);
//
//			sfmPG_FeeTransactionReplyRepository.save(sfmPG_FeeTransactionReply);
//
////			Feetransaction feeTransaction = new Feetransaction();
////			FeetransactionPK feetransactionPK = new FeetransactionPK();
////
////			feetransactionPK.setInstituteid(instituteid);
////			feetransactionPK.setPrid(prId);
////			feeTransaction = feeTransactionRepository.findOne(feetransactionPK);
////
////			if (feeTransaction == null) {
////
////				feeTransaction = new Feetransaction();
////			}
////			feeTransaction.setFeetransactionPK(feetransactionPK);
////			   feeTransaction.setTransactiontype("R");
////			   feeTransaction.setDocmode("F");
////			   feeTransaction.setPrno(prno);
////			try {
////				feeTransaction.setEntrybydate(d.parse(txnDate));
////			} catch (ParseException e) {
////		
////				e.printStackTrace();
////			}
////			feeTransaction.setEntrybyuserid(studentid);
////			feeTransaction.setStynumber(Short.parseShort(stynumber));
////			feeTransaction.setStudentid(studentid);
////			feeTransaction.setStytypeid(stytypeid);
////			StudentQuota studentQuota = new StudentQuota();
////			StudentQuotaPK studentQuotaPK = new StudentQuotaPK();
////			studentQuotaPK.setInstituteid(instituteid);
////			studentQuotaPK.setQuotaid(quotaid);
////			studentQuota =  studentQuotaRepository.findOne(studentQuotaPK);
////			feeTransaction.setStudentQuota(studentQuota);
////			feeTransaction.setForeventid(eventid);
////			feeTransaction.setEventid(eventid);
////			feeTransaction.setQuotaid(quotaid);
////			try {
////				feeTransaction.setPrdate(d.parse(txnDate));
////			} catch (ParseException e) {
////
////				e.printStackTrace();
////			}
////			feeTransaction.setPrno(prno);
////			feeTransaction.setStynumber(Short.parseShort(stynumber));
////			try {
////			feeTransactionRepository.save(feeTransaction);
////			}catch(Exception e) {
////				
////				e.printStackTrace();
////			}
//////			String prid = feeTransactionRepository.PostPGFeeData(instituteid, registrationid, studentid, eventid,
//////					stynumber, stytypeid, enrollmentno, txnAmount, customerID);
////			Feetransactiondetail feeTransactionalDetail = new Feetransactiondetail();
////			FeetransactiondetailPK feetransactiondetailPK = new FeetransactiondetailPK();
////			
////			List<Map> feeHeadsList = new ArrayList();
////			
//////			
//////			String []feeHeadsArray =  itcForReply[9].split("&",2);
//////			int feeHeadsCount = feeHeadsArray.length;
//////			
//////			for(int i=0;i<feeHeadsCount;i++) {
//////				
//////				Map feeHeadsMap =new HashMap();
//////				feeHeadsMap.put("feeheadid",feeHeadsArray[i].split("@",2)[0]);
//////				feeHeadsMap.put("feeamount",feeHeadsArray[i].split("@",2)[1]);
//////				feeHeadsList.add(feeHeadsMap);
//////			}
//////			
////		
////			Feetransactiondetail feeTransactionDetail = new Feetransactiondetail();
////			feetransactiondetailPK.setInstituteid(instituteid);
////			feetransactiondetailPK.setPrid(prId);
////			feeHeadsList = feeheadsRepository.getParticularStudentFeeHead(instituteid, registrationid, studentid,
////					Short.parseShort(stynumber), stytypeid);
////			Set<FeeParticulars> feeParticularsSet = new HashSet<FeeParticulars>();
////			for(int j =0;j<feeHeadsList.size();j++) {
////				
////				short slno = Short.parseShort(feeHeadsList.get(j).get("slno").toString());
////				int  count = feeHeadsList.size();
////				feetransactiondetailPK.setSlno(slno);
////				feeTransactionDetail = feetransactiondetailRepository.findOne(feetransactiondetailPK);
////				if(feeTransactionDetail==null) {
////					
////					feeTransactionDetail = new Feetransactiondetail();
////				}
////				feeTransactionDetail.setFeetransactiondetailPK(feetransactiondetailPK);
////				feeTransactionDetail.setFeeamount(new BigDecimal(feeHeadsList.get(j).get("feeamount").toString()));
////				feeTransactionDetail.setFeeheadid(feeHeadsList.get(j).get("feeheadid").toString());
////				feeTransactionDetail.setFeespaidstynumber(Short.parseShort(stynumber));
////	
////				
////				
////				/************** insert into fee particulars*************/
////				FeeParticulars feeParticulars = new FeeParticulars();
////				FeeParticularsPK feeParticularsPK = new FeeParticularsPK();
////				
////				feeParticularsPK.setInstituteid(instituteid);
////				feeParticularsPK.setSlno(slno);
////				feeParticularsPK.setPrid(prId);
////				feeParticularsPK.setParticularsno(transactionid);
////				feeParticulars = feeParticularsrRepository.findOne(feeParticularsPK);
////				if(feeParticulars == null) {
////					
////					feeParticulars = new FeeParticulars();
////				}
////				feeParticulars.setFeeparticularsPK(feeParticularsPK);
////				feeParticulars.setAmount(new BigDecimal(feeHeadsList.get(j).get("feeamount").toString()));
////				try {
////					
////					feeParticulars.setParticularsdate(d.parse(txnDate));
////				
////				} catch (ParseException e) {
////		
////					e.printStackTrace();
////					
////				}
////				feeParticularsSet.add(feeParticulars);
////				
////				if (feeParticularsSet != null) {
////				
////					feeTransactionDetail.setFeeParticularsSet(feeParticularsSet);
////					feetransactiondetailRepository.save(feeTransactionDetail);
////				}
////						
////				/*************** insert into fee finalization *****************/
////				
////				FeeFinalization feeFinalization = new FeeFinalization();
////				FeeFinalizationPK feeFinalizationPK = new FeeFinalizationPK();
////				
////				feeFinalizationPK.setSlno(slno);
////				feeFinalizationPK.setStudentid(studentid);
////				feeFinalizationPK.setStynumber(Short.parseShort(stynumber));
////				feeFinalizationPK.setStytypeid(stytypeid);
////				feeFinalizationPK.setFeeheadid(feeHeadsList.get(j).get("feeheadid").toString());
////				feeFinalizationPK.setInstituteid(instituteid);
////				feeFinalizationPK.setCurrencyid(currencyid);
////				feeFinalizationPK.setQuotaid(quotaid);
////				feeFinalizationPK.setRegistrationid(registrationid);
////				
////				feeFinalization = feeFinalizationRepository.findOne(feeFinalizationPK);
////				if(feeFinalization ==  null && (itcForReply[12].equalsIgnoreCase("") || itcForReply[12].equalsIgnoreCase(""))) {
////					
////					throw new PaymentGatewayException(itcForReply[12],ErrorBank.ERROR_FEEDUES_NOTAVAILABLE);
////				}
////				feeFinalization.setFeefinalizationPK(feeFinalizationPK);
////				BigDecimal receivedAmount =new BigDecimal(feeHeadsList.get(j).get("feeamount").toString());
////				if(feeFinalization.getReceiveamount()== null) {
////					
////					feeFinalization.setReceiveamount(new BigDecimal(feeHeadsList.get(j).get("feeamount").toString()));
////					
////				}else {
////					
////					feeFinalization.setReceiveamount(feeFinalization.getReceiveamount().add(new BigDecimal(feeHeadsList.get(j)
////							.get("feeamount").toString())));
////				}
////				BigDecimal dueAmountLeft = receivedAmount.subtract(feeFinalization.getDueamount());
////				feeFinalization.setDueamount(dueAmountLeft);
////				feeFinalizationRepository.save(feeFinalization);
////			}	
//			//finalMap.put("status","success");
//			
//			try {
//				response1.sendRedirect("http://localhost:4200/student/returnurl?status=success");
//			} catch (IOException e) {
//				
//				e.printStackTrace();
//			}
//		}
//		else {
//			
//			SFMPG_FeeTransactionReply sfmPG_FeeTransactionReply = new SFMPG_FeeTransactionReply();
//			Optional<SFMPG_FeeTransactionReply> sfmPG_FeeTransactionReply1 = sfmPG_FeeTransactionReplyRepository.findById(testString[5].split("=", 2)[1]);
//
//			if (sfmPG_FeeTransactionReply1.isPresent() || sfmPG_FeeTransactionReply1 == null) {
//
//				sfmPG_FeeTransactionReply = new SFMPG_FeeTransactionReply();
//				sfmPG_FeeTransactionReply= (SFMPG_FeeTransactionReply) sfmPG_FeeTransactionReply1.get();
//			}
//
//			sfmPG_FeeTransactionReply.setTransactionid(testString[5].split("=", 2)[1]);// in doubt txn_id
//			sfmPG_FeeTransactionReply.setAmount(new BigDecimal(txnAmount));
//			// sfmPG_FeeTransactionReply.setBank_name(bank_name);
//			sfmPG_FeeTransactionReply.setRegistrationid(registrationid);
//			// sfmPG_FeeTransactionReply.setBanktransactionid(banktransactionid);
//			// sfmPG_FeeTransactionReply.setClientcode(clientcode);
//			// sfmPG_FeeTransactionReply.setCompanyid(companyid);
//			if (!errorStatus.equals("NA")) {
//
//				sfmPG_FeeTransactionReply.setDiscriminator(errorStatus);
//			} else {
//
//				sfmPG_FeeTransactionReply.setDiscriminator("");
//			}
//			sfmPG_FeeTransactionReply.setEventid(eventid);
//			sfmPG_FeeTransactionReply.setPgtransactionid(customerID); // in doubt
//		//	sfmPG_FeeTransactionReply.setPrno(prno);
//			sfmPG_FeeTransactionReply.setResponsemessage(responseMessage);
//			sfmPG_FeeTransactionReply.setStudentid(studentid);
//			// sfmPG_FeeTransactionReply.setTransactionno(transactionno);
//			// sfmPG_FeeTransactionReply.setVouchercode(vouchercode);
//			// sfmPG_FeeTransactionReply.setVoucherid(voucherid);
//			
//
//			sfmPG_FeeTransactionReplyRepository.save(sfmPG_FeeTransactionReply);
//			//finalMap.put("status","Failure");
//			
//			try {
//				response1.sendRedirect("http://localhost:4200/student/returnurl?status=failure");
//			} catch (IOException e) {
//				
//				e.printStackTrace();
//			}
//		}
		
		return null;
	
	}

}
