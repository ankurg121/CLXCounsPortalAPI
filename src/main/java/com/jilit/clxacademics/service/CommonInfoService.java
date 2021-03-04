package com.jilit.clxacademics.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import com.jilit.clxacademics.exceptions.CLXException;


@Service
public interface CommonInfoService {

	public List getCounsellingCid() throws CLXException;

	@SuppressWarnings("rawtypes")
	public List<Map> countriesList() throws CLXException;

	@SuppressWarnings("rawtypes")
	public List<Map> statesByCountryCode(Map stateMap) throws CLXException;

	@SuppressWarnings("rawtypes")
	public List<Map> cityByStateCode(Map cityMap) throws CLXException;

}
