package com.jilit.clxacademics.service;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.jilit.clxacademics.exceptions.CLXException;

public interface RegistrationFeePaymentService {

	public Map payNow(HttpServletResponse response1, Map jsonMap) throws CLXException;
	public Map responseAfterPay(HttpServletResponse response1,String responseMessage) throws CLXException, UnsupportedEncodingException;
}
