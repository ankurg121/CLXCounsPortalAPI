package com.jilit.clxacademics.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jilit.clxacademics.model.IdGenerationSetup;
 
@Repository
public interface IdGenerationSetupRepository extends CrudRepository<IdGenerationSetup,String>{
	//IdGenerationSetup findOne(String idcode).;
}
