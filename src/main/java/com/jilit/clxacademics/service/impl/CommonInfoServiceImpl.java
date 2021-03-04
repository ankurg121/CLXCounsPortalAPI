package com.jilit.clxacademics.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jilit.clxacademics.exceptions.CLXException;
import com.jilit.clxacademics.repository.CityMasterRepository;
import com.jilit.clxacademics.repository.CounsellingIdRepository;
import com.jilit.clxacademics.repository.CountryMasterRepository; 
import com.jilit.clxacademics.repository.StateMasterRepository;
import com.jilit.clxacademics.service.CommonInfoService;

@Service
public class CommonInfoServiceImpl implements CommonInfoService {  

	@Autowired
	private CounsellingIdRepository cCounsellingidRepository;
	
	@Autowired
	private CountryMasterRepository countryMasterRepository;
	@Autowired
	private StateMasterRepository stateMasterRepository;
	@Autowired
	private CityMasterRepository cityMasterRepository;
	
	
//
//	@Autowired
//	BusinessService businessService;

	public List getCounsellingCid() throws CLXException {
		List<Map> list = cCounsellingidRepository.getCounsellingCid();
		return list;
	}
 
	@Override
	@SuppressWarnings("rawtypes")
	public List<Map> countriesList() throws CLXException {
		List<Map> countryList = null;
		//countryList = countryMasterRepository.countryList();
		return countryList;
	}

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Map> statesByCountryCode(Map stateMap) throws CLXException {
		List<Map> stateList = new ArrayList();
		//stateList = stateMasterRepository.stateList(stateMap.get("countryname").toString());
		return stateList;
	}

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Map> cityByStateCode(Map cityMap) throws CLXException {
		List<Map> cityList = new ArrayList();
		//cityList = cityMasterRepository.cityByStateCode(cityMap.get("statename").toString());
		return cityList;
	}


}
