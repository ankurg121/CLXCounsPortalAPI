package com.jilit.clxacademics.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jilit.clxacademics.model.CountryMaster;




@Repository
public interface CountryMasterRepository extends CrudRepository<CountryMaster,String>{

//	@Query("select cm.countryid as countryid, cm.countryname as countryname, cm.countrycode as countrycode, cm.seqid as seqid, cm.deactive as deactive from  CountryMaster cm")
//	public List<Map> countryList();
	
}
