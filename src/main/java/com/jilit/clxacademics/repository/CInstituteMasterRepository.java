package com.jilit.clxacademics.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jilit.clxacademics.model.CInstituteMaster;

@Repository
public interface CInstituteMasterRepository extends CrudRepository<CInstituteMaster, String>{
	
	@Query(" select new Map(im.institutename as institutename,im.institutecode as institutecode,im.address1 as address1,"
			+ " im.address2 as address2,im.address3 as address3,im.city as city,im.state as state,im.country as country,"
			+ " im.pin as pin,im.phoneno as phoneno,im.logofilename as logofilename,im.watermarkfilename as watermarkfilename,"
			+ " im.website as website,im.faxnos as faxnos,im.stdcode as stdcode) from CInstituteMaster im where im.institutecode=:institutecode ")
	public List<Map> getInstituteData(@Param("institutecode") String institutecode);

}
