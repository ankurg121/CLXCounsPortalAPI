package com.jilit.clxacademics.repository;

import java.util.List;
import java.util.Map;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.jilit.clxacademics.model.CCounsellingid;

@Repository
public interface CounsellingIdRepository extends CrudRepository<CCounsellingid, String> {

	public CCounsellingid findByCid(String counsellingid);

	public CCounsellingid findByCounsellingtitleIgnoreCase(String title);

	@SuppressWarnings("rawtypes")
	@Query(" select new Map(c.cid as cid,c.counsellingtitle as counsellingtitle,c.counsellingdesc1 as counsellingdesc1)"
			+ " from CCounsellingid c where coalesce(c.deactive,'N')='N' and c.counsellingisover = 'N' and exists( select"
			+ " cc.cid from C_Current cc where cc.cid = c.cid)")
	public List<Map> getCounsellingCid();

}
