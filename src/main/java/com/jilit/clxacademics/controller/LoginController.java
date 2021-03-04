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
import com.jilit.clxacademics.service.LoginService;
import com.jilit.clxacademics.util.ErrorBank;
import com.jilit.clxacademics.util.Identifier;

@RestController
@RequestMapping("/applicantsregistration")
@CrossOrigin(origins = "*")
public class LoginController {

	@Autowired
	private ResponseUtil responseUtil;

	@Autowired
	private LoginService loginservice;

	//
	// @SuppressWarnings({"unchecked", "rawtypes"})
	// @RequestMapping(value = "/changepass", method = RequestMethod.POST)
	// public ResponseEntity<ObjectResponse<Object>> changePassword(@RequestBody
	// Map jsonMap) throws CLXException {
	// final ObjectResponse<Object> endPointResponse = new ObjectResponse<>();
	// Map loginresponsemap = new HashMap();
	// Map map = new HashMap<>();
	// try {
	// loginresponsemap =loginservice.changePassword(jsonMap);
	// map.put("loginstatus", loginresponsemap);
	// endPointResponse.setResponse(map);
	// return ResponseEntity.status(HttpStatus.OK).body(endPointResponse);
	// } catch (CLXException e) {
	// return (responseUtil.getFailedResponseEntyty(e,
	// HttpStatus.EXPECTATION_FAILED));
	// }
	// }
	//
	// @SuppressWarnings({"unchecked", "rawtypes"})
	// @RequestMapping(value = "/forgetpassword", method = RequestMethod.POST)
	// public ResponseEntity<ObjectResponse<Object>> forgetPassword(@RequestBody
	// Map jsonMap) throws CLXException {
	// final ObjectResponse<Object> endPointResponse = new ObjectResponse<>();
	// Map loginresponsemap = new HashMap();
	// Map map = new HashMap<>();
	// try {
	// loginresponsemap =loginservice.forgetPassword(jsonMap);
	// map.put("loginstatus", loginresponsemap);
	// endPointResponse.setResponse(map);
	// return ResponseEntity.status(HttpStatus.OK).body(endPointResponse);
	// } catch (CLXException e) {
	// return (responseUtil.getFailedResponseEntyty(e,
	// HttpStatus.EXPECTATION_FAILED));
	// }
	// }

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/changepass", method = RequestMethod.POST)
	public ResponseEntity<ObjectResponse<Object>> changePassword(@RequestBody Map jsonMap) throws CLXException {
		final ObjectResponse<Object> endPointResponse = new ObjectResponse<>();
		String changepassstatus = "";
		Map map = new HashMap<>();
		try {
			changepassstatus = loginservice.changePassword(jsonMap);
			map.put("loginstatus", changepassstatus);
			endPointResponse.setResponse(map);
			return ResponseEntity.status(HttpStatus.OK).body(endPointResponse);
		} catch (CLXException e) {
			return (responseUtil.getFailedResponseEntyty(e, HttpStatus.EXPECTATION_FAILED));
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping(value = "/showdashboardlist")
	public ResponseEntity<ObjectResponse<Object>> showPortalDashBoard(@RequestBody Map jsonMap) throws CLXException {
		final ObjectResponse<Object> endPointResponse = new ObjectResponse<>();
		Map returnMap = new HashMap<>();
		try {
			if (jsonMap == null || jsonMap.isEmpty()) {
				throw new CLXException(Identifier.LOGINCREDENTIAL,
						ErrorBank.ERROR_INVALID_JSON_BODYDATA_SUPPLIED);
			}
			List<Map> dataList = new ArrayList();
			Map mp = loginservice.showDashBoardList(jsonMap);
			endPointResponse.setResponse(mp);
			return ResponseEntity.status(HttpStatus.OK).body(endPointResponse);
		} catch (CLXException e) {
			return (responseUtil.getFailedResponseEntyty(e, HttpStatus.EXPECTATION_FAILED));
		}
	}
}
