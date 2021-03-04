package com.jilit.clxacademics.repository;

import java.util.Date;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jilit.clxacademics.model.CApplicationMaster;
import com.jilit.clxacademics.model.CApplicationMasterPK;

@Repository
public interface CApplicationMasterRepository extends CrudRepository<CApplicationMaster, CApplicationMasterPK> {

	@Query("select new Map( cam.id.counsellingid as counsellingid, cam.dateofbirth as dateofbirth,cam.applicationid as applicationid, am.email as email, am.mobileno as mobileno,cam.applicationno as applicationno, cam.name as name  ) from CStudentMaster cam, CApplicationMaster am where cam.id.counsellingid=(select cc.cid from C_Current cc) "
			+ " and  cam.id.counsellingid=am.id.counsellingid and am.id.applicationid =cam.applicationid and cam.id.rank is not null and cam.applicationno is not null and (cam.id.rank=:jeerankno or cam.applicationno=:applicationno)")
	Map isUserValid( @Param("applicationno")String applicationid, @Param("jeerankno")String jeerankno);
 
//	@Query("select cam from CApplicationMaster cam where cam.id.counsellingid=:counsellingid and cam.applicationno=:jeerollno and cam.dateofbirth=:dobdate")
//	CApplicationMaster isUserValidJEERollNo1(@Param("counsellingid")String counsellingid, @Param("jeerollno")String applicationid,@Param("dobdate")Date dobdate);
//	
//	@Query("select cam from CApplicationMaster cam where cam.id.counsellingid=:counsellingid and cam.id.applicationid=:applicationid")
//	CApplicationMaster getApplicantForRePass1(@Param("counsellingid")String cid,@Param("applicationid")String applicationid);

	
}
