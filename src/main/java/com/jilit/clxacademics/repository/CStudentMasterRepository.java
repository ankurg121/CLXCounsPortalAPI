package com.jilit.clxacademics.repository;

import java.util.List;
import java.util.Map;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.jilit.clxacademics.model.CStudentMaster;
import com.jilit.clxacademics.model.CStudentMasterPK;

@Repository
public interface CStudentMasterRepository extends CrudRepository<CStudentMaster, CStudentMasterPK> {

	@Query(" select new Map(ad.allotedinstitute as allotedinstitute, pm.id.programcode as programcode,pm.programname as programname,"
			+ " bm.id.branchcode as branchcode,bm.branchdesc as branchdesc,cam.dateofbirth as dateofbirth,cam.applicationid as applicationid,"
			+ " cam.applicationno as applicationno,cam.name as name,ad.id.rank as rank,ad.fromcategory as fromcategory,"
			+ " ad.allotedalpha as allotedalpha,cam.studentid as studentid,cam.rollno as rollno,ad.counsellingdate as allocationdate,ad.id.counsellingno as counsellingno) "
			+ " from CStudentMaster cam, CAllocationDetail ad, CBranchMaster bm, CProgramMaster pm "
			+ " where ad.id.counsellingno=(select cc.counsellingno from C_Current cc) and ad.id.institutecode=cam.id.institutecode "
			+ " and cam.id.counsellingid=ad.id.counsellingid and ad.id.programtype=cam.id.programtype and cam.id.rank=ad.id.rank and "
			+ " cam.id.counsellingid=:counsellingid and cam.id.rank=:rank and cam.applicationid=:applicationid and ad.allotedprogram = pm.id.programcode "
			+ " and cam.studentid is not null and bm.id.programtype=pm.id.programtype and bm.id.programcode=pm.id.programcode "
			+ " and bm.id.branchcode=ad.allotedbranch and cam.id.rank is not null and cam.applicationno is not null "
			+ " and coalesce(ad.admissionconfirmed,'N') ='Y' and coalesce(ad.hold,'N')='N' and coalesce(ad.defaulter,'N')='N' ")
	public List<Map> getStudentDetail(@Param("counsellingid") String counsellingid, @Param("rank") String rank,
			@Param("applicationid") String applicationid);

	@Query(" select new Map(coalesce(sr.hostelconfirmation,'N') as hostelconfirmation,sr.remarks as remarks) from StudentRegistration sr, "
			+ " CInstituteMaster im where sr.id.institutecode=im.institutecode and sr.id.examcode=im.examcode and "
			+ " sr.id.studentid=:studentid and im.id.institutecode=:institutecode")
	public List<Map> getHostelConfirmation(@Param("studentid") String studentid,
			@Param("institutecode") String institutecode);

	@Query("select new Map(cm.id.choiceno as choiceno,cm.id.programtype as programtype, cm.institutecode as institutecode, "
			+ " cm.id.branchcode as branchcode, cm.id.alpha as alpha,cm.branchalloted as branchalloted,bm.branchdesc as branchdesc)"
			+ " from CChoiceMaster cm, CBranchMaster bm where cm.id.counsellingid=:counsellingid and cm.id.counsellingno=:counsellingno "
			+ " and cm.id.rank=:rank and cm.id.programtype=bm.id.programtype and cm.id.programcode=bm.id.programcode and "
			+ " cm.id.branchcode=bm.id.branchcode and coalesce(cm.deactive,'N')='N' order by cm.id.choiceno ")
	public List<Map> getCousellingChoiceList(@Param("counsellingid") String counsellingid,
			@Param("counsellingno") Short counsellingno, @Param("rank") String rank);

	@Query(" select new Map(ad.allotedinstitute as allotedinstitute, pm.id.programcode as programcode,pm.programname as programname,"
			+ " bm.id.branchcode as branchcode,bm.branchdesc as branchdesc,cam.applicationno as applicationno,cam.name as name,"
			+ " ad.id.rank as rank,ad.fromcategory as fromcategory,cam.studentid as studentid,cam.rollno as rollno,ad.id.counsellingno as counsellingno) "
			+ " from CStudentMaster cam, CAllocationDetail ad, CBranchMaster bm, CProgramMaster pm "
			+ " where ad.id.counsellingno=(select cc.counsellingno from C_Current cc) and ad.id.institutecode=cam.id.institutecode "
			+ " and cam.id.counsellingid=ad.id.counsellingid and ad.id.programtype=cam.id.programtype and cam.id.rank=ad.id.rank and "
			+ " cam.id.counsellingid=:counsellingid and cam.id.rank=:rank and cam.applicationid=:applicationid and ad.allotedprogram = pm.id.programcode "
			+ " and cam.studentid is not null and bm.id.programtype=pm.id.programtype and bm.id.programcode=pm.id.programcode "
			+ " and bm.id.branchcode=ad.allotedbranch and cam.id.rank is not null and cam.applicationno is not null "
			+ " and coalesce(ad.admissionconfirmed,'N') ='Y' and coalesce(ad.hold,'N')='N' and coalesce(ad.defaulter,'N')='N' ")
	public List<Map> getStudentAllotedData(@Param("counsellingid") String counsellingid, @Param("rank") String rank,
			@Param("applicationid") String applicationid);
}
