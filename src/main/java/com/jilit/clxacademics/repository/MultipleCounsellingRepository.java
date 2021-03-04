package com.jilit.clxacademics.repository;

import java.util.List;
import java.util.Map;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.jilit.clxacademics.model.CMultipleCounselling;
import com.jilit.clxacademics.model.CMultipleCounsellingPK;

@Repository
public interface MultipleCounsellingRepository extends CrudRepository<CMultipleCounselling, CMultipleCounsellingPK> {

	@SuppressWarnings("rawtypes")
	@Query(" select new Map(cmc.id.cid as cid, couns.counsellingtitle as counsellingtitle, cmc.id.counsellingno as counsellingno, cmc.dateofcounselling as dateofcounselling,"
			+ " cmc.deactive as deactive,cmc.counsellingtype as counsellingtype) from CMultipleCounselling cmc, CCounsellingid couns where couns.cid=cmc.id.cid ")
	List<Map> getAllMultipleCounsellingList();
}
