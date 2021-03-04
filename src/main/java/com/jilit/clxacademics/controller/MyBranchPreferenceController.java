package com.jilit.clxacademics.controller;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jilit.clxacademics.exceptions.BadRequestException;
import com.jilit.clxacademics.exceptions.CLXException;
import com.jilit.clxacademics.repository.C_CurrentRepository;
import com.jilit.clxacademics.response.ObjectResponse;
import com.jilit.clxacademics.response.ResponseUtil;
import com.jilit.clxacademics.service.MyBranchPreferenceService;
import com.jilit.clxacademics.util.ErrorBank;
import com.jilit.clxacademics.util.Identifier;

@RestController
@RequestMapping("/branchdraftchoice")
@CrossOrigin(origins = "*")
public class MyBranchPreferenceController {

	@Autowired
	private MyBranchPreferenceService mybranchpreferenceservice;
	@Autowired
	private ResponseUtil responseUtil;
	
//	@Value("${branchchoicemandetary}")
//	private String branchchoicemandetary;
	
	

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(value = "/draftchoicegrid")
	public ResponseEntity<ObjectResponse<Object>> getBranchPreerenceList(@RequestBody Map jsonMap) throws CLXException 
	{
		final ObjectResponse<Object> endPointResponse = new ObjectResponse<>();
		Map branchchoiceMap = new HashMap<>();
		try {
			branchchoiceMap = mybranchpreferenceservice.getBranchPreerenceList(jsonMap);
		//	branchchoiceMap.put("branchchoicemandetary", branchchoicemandetary);
			endPointResponse.setResponse(branchchoiceMap);
			return ResponseEntity.status(HttpStatus.OK).body(endPointResponse);
		} catch (CLXException e) {
			return (responseUtil.getFailedResponseEntyty(e, HttpStatus.EXPECTATION_FAILED));
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/savedraftchoice", method = RequestMethod.POST)
	public ResponseEntity<ObjectResponse<Object>> changePassword(@RequestBody Map jsonMap) throws CLXException {
		final ObjectResponse<Object> endPointResponse = new ObjectResponse<>();
		String savestatus = "";
		Map map = new HashMap<>();
		try {
			savestatus = mybranchpreferenceservice.saveDraftChoice(jsonMap);
			map.put("status", savestatus);
			endPointResponse.setResponse(map);
			return ResponseEntity.status(HttpStatus.OK).body(endPointResponse);
		} catch (CLXException e) {
			return (responseUtil.getFailedResponseEntyty(e, HttpStatus.EXPECTATION_FAILED));
		}
	}
	
	 @SuppressWarnings("unused")
	    @RequestMapping(value = "/getreport", method = RequestMethod.POST, produces = "application/pdf")
	    public ResponseEntity<byte[]> branchPreferenceDraftReport(HttpServletResponse response1, @RequestBody Map bodyMap) throws CLXException {
	        ResponseEntity<byte[]> response = null;
	        byte[] branchpreference;
	        response1.setContentType("application/pdf");
	        response1.setHeader("Content-Disposition", "attachment;filename=" + "Branch Preference Report" + ".pdf");
	        ByteArrayOutputStream bstream = new ByteArrayOutputStream();
	        try {

	            if (bodyMap == null || bodyMap.isEmpty()) {
	                throw new BadRequestException(Identifier.LOGINCREDENTIAL, ErrorBank.ERROR_INVALID_JSON_BODYDATA_SUPPLIED);
	            }
	            
	            
	            branchpreference = mybranchpreferenceservice.getReport(response1, bodyMap);
	            response = new ResponseEntity<>(branchpreference, HttpStatus.OK);

	            return response;
	        } catch (Exception e) {
	            return new ResponseEntity<>(bstream.toByteArray(), HttpStatus.EXPECTATION_FAILED);
	        }

	    }
	    
	    @SuppressWarnings({ "unchecked", "rawtypes" })
		@PostMapping(value = "/branchchoicereportgrid")
		public ResponseEntity<ObjectResponse<Object>> getDraftReportGridChoice(@RequestBody Map jsonMap) throws CLXException 
		{
			final ObjectResponse<Object> endPointResponse = new ObjectResponse<>();
			List<Map> branchpreferencereportlist = new ArrayList();
			List<Map> isfreezedlist = new ArrayList();
			Map branchchoiceMap = new HashMap<>();
			try {
				branchchoiceMap = mybranchpreferenceservice.getDraftReportGridChoice(jsonMap);
				endPointResponse.setResponse(branchchoiceMap);
				return ResponseEntity.status(HttpStatus.OK).body(endPointResponse);
			} catch (CLXException e) {
				return (responseUtil.getFailedResponseEntyty(e, HttpStatus.EXPECTATION_FAILED));
			}
		}
}
