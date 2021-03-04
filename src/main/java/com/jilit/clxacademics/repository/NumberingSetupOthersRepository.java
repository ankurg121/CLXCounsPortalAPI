package com.jilit.clxacademics.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jilit.clxacademics.model.NumberingSetupOthers;

@Repository
public interface NumberingSetupOthersRepository extends CrudRepository<NumberingSetupOthers, String> {

	@Query("select a.groupid as groupid ,a.ymd as ymd ,a.totalwidth as totalwidth from NumberingSetupOthers a where a.companyinstid=:companyinstid"
			+" and a.companyinstitute=:companyinstitute"
		    + " and	a.numberingSetupOthersMaster.prefix=:prefix")
	public List getNumberingSetupGroupID(@Param("companyinstid")String companyinstid,@Param("prefix") String prefix,@Param("companyinstitute") String companyinstitute);
}
