package com.jilit.clxacademics.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jilit.clxacademics.model.StateMaster;
import com.jilit.clxacademics.model.StateMasterPK;


@Repository
public interface StateMasterRepository  extends CrudRepository<StateMaster,StateMasterPK>{
	
	
//	@Query("select sm.id.stateid as stateid,sm.statecode as statecode, sm.statename as statename, sm.seqid as seqid, sm.deactive as deactive  from StateMaster sm,CountryMaster cm where cm.id.countryid=sm.id.countryid and cm.countryname=:countryname")
//	public List<Map> stateList(@Param("countryname")String countryname);
}
