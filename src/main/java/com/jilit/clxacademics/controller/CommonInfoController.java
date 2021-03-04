package com.jilit.clxacademics.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.jilit.clxacademics.response.ObjectResponse;
import com.jilit.clxacademics.response.ResponseUtil;
import com.jilit.clxacademics.service.CommonInfoService;
import com.jilit.clxacademics.util.ErrorBank;
import com.jilit.clxacademics.util.Identifier;

@RestController
@RequestMapping("/commoninfocontroller")
@CrossOrigin(origins = "*")
//@PreAuthorize("hasRole('ROLE_ADMIN')")
public class CommonInfoController {

	@Autowired
	private CommonInfoService commonInfoService;
	@Autowired
	private ResponseUtil responseUtil;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(value = "/getcounsellingid")
	public ResponseEntity<ObjectResponse<Object>> getConsellingCid(@RequestBody Map jsonMap) throws CLXException 
	{
		final ObjectResponse<Object> endPointResponse = new ObjectResponse<>();
		List<Map> counsellingList = new ArrayList();
		Map counsellingMap = new HashMap<>();
		try {
			counsellingList = commonInfoService.getCounsellingCid();
			counsellingMap.put("counsellingID", counsellingList);
			endPointResponse.setResponse(counsellingMap);
			return ResponseEntity.status(HttpStatus.OK).body(endPointResponse);
		} catch (CLXException e) {
			return (responseUtil.getFailedResponseEntyty(e, HttpStatus.EXPECTATION_FAILED));
		}

	}
	 
}
