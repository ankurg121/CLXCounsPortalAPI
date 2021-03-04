package com.jilit.clxacademics.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.jilit.clxacademics.exceptions.CLXException;

@Service
public interface MyBranchPreferenceService {

	Map getBranchPreerenceList(Map jsonMap)throws CLXException;

	String saveDraftChoice(Map jsonMap)throws CLXException;

	byte[] getReport(HttpServletResponse response1, Map bodyMap)throws CLXException;

	Map getDraftReportGridChoice(Map jsonMap)throws CLXException;

}
