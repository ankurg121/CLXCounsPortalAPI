package com.jilit.clxacademics.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jilit.clxacademics.exceptions.CLXException;
import com.jilit.clxacademics.response.ObjectResponse;
import com.jilit.clxacademics.response.ResponseUtil;
import com.jilit.clxacademics.service.OfferedBranchService;

@RestController
@RequestMapping("/offeredbranchcontroller")
@CrossOrigin(origins = "*")
public class OfferedBranchController {
	
	@Autowired
	private ResponseUtil responseUtil;
	@Autowired
	private OfferedBranchService offeredBranchService;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(value = "/getOfferedBranch")
	public ResponseEntity<ObjectResponse<Object>> getOfferedBranch(@RequestBody Map jsonMap) throws CLXException 
	{
		final ObjectResponse<Object> endPointResponse = new ObjectResponse<>();
		Map branchchoiceMap = new HashMap<>();
		try {
			branchchoiceMap = offeredBranchService.getOfferedBranchList(jsonMap);
		//	branchchoiceMap.put("branchchoicemandetary", branchchoicemandetary);
			endPointResponse.setResponse(branchchoiceMap);
			return ResponseEntity.status(HttpStatus.OK).body(endPointResponse);
		} catch (CLXException e) {
			return (responseUtil.getFailedResponseEntyty(e, HttpStatus.EXPECTATION_FAILED));
		}
	}

}
