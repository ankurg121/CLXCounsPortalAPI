package com.jilit.clxacademics.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jilit.clxacademics.model.SFMPG_FeeTransaction;
import com.jilit.clxacademics.model.SFMPG_FeeTransactionReply;
@Repository
public interface SFMPG_FeeTransactionReplyRepository extends CrudRepository<SFMPG_FeeTransactionReply,String>{
	

}
