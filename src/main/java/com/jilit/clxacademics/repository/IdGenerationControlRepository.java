package com.jilit.clxacademics.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jilit.clxacademics.model.IdGenerationControl;
import com.jilit.clxacademics.model.IdGenerationControlPK;
@Repository
public interface IdGenerationControlRepository extends CrudRepository<IdGenerationControl,IdGenerationControlPK> {
	
	@Query("select igc.id.alpha as alpha, igc.lastid as lastid from IdGenerationControl igc " + 
			" where igc.id.icid=:icid " + 
			" and igc.id.idcode=:idcode " + 
			" and igc.id.year=:year " + 
			" and igc.id.month=:month ")
	public List getAlpha(@Param("icid") String icid,@Param("idcode") String idcode,@Param("year")String year,@Param("month")String month);

//	@Query(" select igc.id.alpha as alpha, igc.lastid as lastid from IdGenerationControl igc " + 
//			" where igc.id.icid=:compunqid " + 
//			" and igc.id.idcode=:idcode " + 
//			" and igc.id.year=:year " + 
//			" and igc.id.month=:month ")
//	public List getAlpha(@Param("compunqid") String compunqid, @Param("idcode") String idcode, @Param("year") String year, @Param("month") String month);


}
