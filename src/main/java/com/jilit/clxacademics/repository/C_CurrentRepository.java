package com.jilit.clxacademics.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jilit.clxacademics.model.C_Current;

@Repository
public interface C_CurrentRepository extends CrudRepository<C_Current, String> {

	@Query("select cid from C_Current")
	List<String> getCurrentCID();

	@Query("select cc.counsellingno from C_Current cc where cc.cid=:counsellingid")
	List getCurrentCounsellingNo(@Param("counsellingid")String counsellingid);

}
