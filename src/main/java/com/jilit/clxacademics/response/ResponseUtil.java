package com.jilit.clxacademics.response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jilit.clxacademics.exceptions.CLXException;
import com.jilit.clxacademics.util.ErrorBank;

@Service
public class ResponseUtil {

	// To B Used with Exception Generalized Message based exceptions
	public	ResponseEntity<ObjectResponse<Object>> getFailedResponseEntyty(CLXException e, final HttpStatus status )
	{
		String msg=e.getMessage();
		String msgIdentfier=e.getIdentifier();		
		Map errorMap = new HashMap<>();
		List errorList =new ArrayList();
		errorList.add(msg);
		final ObjectResponse<Object> errorEndPointResponse = new ObjectResponse<>();
		errorMap.put("status", "Failed");
		errorEndPointResponse.setResponse(errorMap);
		errorEndPointResponse.setStatus(new StatusType(Standards.FAILURE,msgIdentfier,errorList ));
		//response.status(HttpStatus.FAILED_DEPENDENCY).b;
		//return response;//
		return ResponseEntity.status(status).body(errorEndPointResponse);
	}
	

	public ResponseEntity<ObjectResponse<Object>> returnFailedResponseStatus(final HttpStatus status) {
		Map errorMap = new HashMap<>();
		final ObjectResponse<Object> errorEndPointResponse = new ObjectResponse<>();
		errorMap.put("status", ErrorBank.ERROR_WHILE_SAVING);
		errorEndPointResponse.setResponse(errorMap);
		errorEndPointResponse.setStatus(new StatusType(Standards.FAILURE, null));
		return ResponseEntity.status(status).body(errorEndPointResponse);
		
	}
	
	public ResponseEntity<ObjectResponse<Object>> returnFailSavingStatus(final HttpStatus status,String identifierName, final String errorMessage) 
		{
			Map errorMap = new HashMap<>();
			List errorList =new ArrayList();
			errorList.add(errorMessage);
			final ObjectResponse<Object> errorEndPointResponse = new ObjectResponse<>();
			errorMap.put("status", "Failed");
			errorEndPointResponse.setResponse(errorMap);
			errorEndPointResponse.setStatus(new StatusType(Standards.FAILURE,identifierName,errorList ));
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorEndPointResponse);
		}
	   
}
