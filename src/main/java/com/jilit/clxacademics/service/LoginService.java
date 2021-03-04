package com.jilit.clxacademics.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.jilit.clxacademics.exceptions.CLXException;

@Service
public interface LoginService {

	Map applicantsValidation(Map jsonMap) throws CLXException;

	Map forgetPassword(Map jsonMap) throws CLXException;

	String changePassword(Map jsonMap) throws CLXException;

	public Map showDashBoardList(Map jsonMap) throws CLXException;
}
