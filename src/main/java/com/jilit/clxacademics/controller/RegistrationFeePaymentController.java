package com.jilit.clxacademics.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.crypto.IllegalBlockSizeException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jilit.clxacademics.exceptions.CLXException;
import com.jilit.clxacademics.exceptions.EntityNotFoundException;
import com.jilit.clxacademics.response.ObjectResponse;
import com.jilit.clxacademics.response.ResponseUtil;
import com.jilit.clxacademics.response.Standards;
import com.jilit.clxacademics.response.StatusType;
import com.jilit.clxacademics.service.RegistrationFeePaymentService;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/registrationfeepayment")
public class RegistrationFeePaymentController {
	@Autowired
	private RegistrationFeePaymentService registrationFeePaymentService;
	@Autowired
	private ResponseUtil responseUtil;
	
	
	
	/**
	 * 
	 * @param jsonBody
	 * @return ResponeEntity
	 * @throws CLXPortalServiceException
	 * @author Girish.Chander
	 * @throws ParseException 
	 */
	@RequestMapping(value = "/paynow", method = RequestMethod.POST)
	public ResponseEntity<ObjectResponse<Object>> payNow(HttpServletResponse response1,@RequestBody Map jsonBody)
			throws CLXException, ParseException {

		final ObjectResponse<Object> endPointResponse = new ObjectResponse<>();
		Map responseMap = new HashMap();
		
		try {
			responseMap = registrationFeePaymentService.payNow(response1,jsonBody);
			endPointResponse.setResponse(responseMap);
			endPointResponse.setStatus(new StatusType(Standards.SUCCESS));
			return ResponseEntity.status(HttpStatus.OK).body(endPointResponse);
		} catch (EntityNotFoundException e) {
			e.printStackTrace();
			return (responseUtil.getFailedResponseEntyty(e, HttpStatus.NO_CONTENT));
		} catch (CLXException e) {
			e.printStackTrace();
			return (responseUtil.getFailedResponseEntyty(e, HttpStatus.INTERNAL_SERVER_ERROR));
		}
	}
	
	@RequestMapping(value = "/responsepayload")
	public void responseAfterPay(HttpServletResponse response1,@RequestBody String responseMessage)
			throws CLXException, ParseException{

		final ObjectResponse<Object> endPointResponse = new ObjectResponse<>();
		
		 
		Map responseMap = new HashMap();
		//@RequestBody Map jsonBody
		try {
			try {
				responseMap = registrationFeePaymentService.responseAfterPay(response1,responseMessage);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			endPointResponse.setResponse(responseMap);
			endPointResponse.setStatus(new StatusType(Standards.SUCCESS));
			//return ResponseEntity.status(HttpStatus.OK).body(endPointResponse);
		} catch (EntityNotFoundException e) {
			e.printStackTrace();
			//return (responseUtil.getFailedResponseEntyty(e, HttpStatus.NO_CONTENT));
		} catch (CLXException e) {
			e.printStackTrace();
			//return (responseUtil.getFailedResponseEntyty(e, HttpStatus.INTERNAL_SERVER_ERROR));
		}
	}
	
	

}
