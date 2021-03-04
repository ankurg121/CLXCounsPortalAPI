package com.jilit.clxacademics.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jilit.clxacademics.model.CityMaster;
import com.jilit.clxacademics.model.CityMasterPK;

@Repository
public interface CityMasterRepository extends CrudRepository<CityMaster, CityMasterPK> {

//	@SuppressWarnings({ "rawtypes" })
//	@Query("select ctm.id.cityid as cityid,ctm.citycode as citycode,  ctm.cityname as cityname, ctm.deactive as deactive, ctm.seqid as seqid from CityMaster ctm,StateMaster st where st.id.stateid=ctm.id.stateid and st.statename=:statename")
//	public List<Map> cityByStateCode(@Param("statename") String statename);
//
//	@SuppressWarnings({ "rawtypes" })
//	@Query("select new Map(cm.citycode as citycode,  cm.cityname as cityname,cm.id.cityid as cityid , sm.statename as statename ,com.countryname as countryname) from CityMaster  cm , StateMaster sm , CountryMaster com where cm.id.countryid=com.countryid and cm.id.stateid=sm.id.stateid and sm.id.countryid=cm.id.countryid")
//	public List<Map> getAllCityWithRespectiveStateAndCountry();

}
