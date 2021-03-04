package com.jilit.clxacademics.service;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jilit.clxacademics.exceptions.CLXException;

public interface CounsellingAllocationReceiptReportService {

	@SuppressWarnings("rawtypes")
	public Map getStudentAllottedInstitute(Map jsonMap) throws CLXException;

	@SuppressWarnings("rawtypes")
	public byte[] getCounsellingReceiptReport(Map jsonMap, HttpServletRequest request, HttpServletResponse response);

}
