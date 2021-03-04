package com.jilit.clxacademics.controller;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import com.jilit.clxacademics.service.CounsellingAllocationReceiptReportService;
import com.jilit.clxacademics.util.ErrorBank;
import com.jilit.clxacademics.util.Identifier;

@RestController
@RequestMapping("/counsellingreceipt")
@CrossOrigin("*")
public class CounsellingAllocationReceiptReportController {

	@Autowired
	private CounsellingAllocationReceiptReportService counsellingreceiptreportservice;

	@Autowired
	private ResponseUtil responseUtil;

	@SuppressWarnings("rawtypes")
	@PostMapping(value = "/getstudentallottedinstitute")
	public ResponseEntity<ObjectResponse<Object>> getStudentAllotedInstitute(@RequestBody Map jsonMap)
			throws CLXException {
		final ObjectResponse<Object> endPointResponse = new ObjectResponse<>();

		try {
			if (jsonMap == null || jsonMap.isEmpty()) {
				throw new CLXException(Identifier.LOGINCREDENTIAL, ErrorBank.ERROR_INVALID_JSON_BODYDATA_SUPPLIED);
			}
			Map returnmap = new HashMap<>();
			returnmap = counsellingreceiptreportservice.getStudentAllottedInstitute(jsonMap);
			endPointResponse.setResponse(returnmap);
			return ResponseEntity.status(HttpStatus.OK).body(endPointResponse);
		} catch (CLXException e) {
			return (responseUtil.getFailedResponseEntyty(e, HttpStatus.EXPECTATION_FAILED));
		}

	}

	@RequestMapping(value = "/getcounsellingreceiptreport", method = RequestMethod.POST, produces = "application/pdf")
	public ResponseEntity<byte[]> getCounsellingReceipt(@RequestBody final Map jsonData, HttpServletRequest request,
			HttpServletResponse response1) throws CLXException {
		ResponseEntity<byte[]> response = null;
		byte[] receiptReport;
		response1.setContentType("application/pdf");
		response1.setHeader("Content-Disposition", "attachment; filename=\"CounsellingAllocationReceipt.pdf\"");
		ByteArrayOutputStream bstream = new ByteArrayOutputStream();
		try {
			if (jsonData.isEmpty()) {
				throw new BadRequestException(Identifier.LOGINCREDENTIAL,
						ErrorBank.ERROR_INVALID_JSON_BODYDATA_SUPPLIED);
			}
			receiptReport = counsellingreceiptreportservice.getCounsellingReceiptReport(jsonData, request, response1);
			response = new ResponseEntity<>(receiptReport, HttpStatus.OK);
			return response;
		} catch (Exception e) {
			return new ResponseEntity<>(bstream.toByteArray(), HttpStatus.EXPECTATION_FAILED);
		}

	}
}
