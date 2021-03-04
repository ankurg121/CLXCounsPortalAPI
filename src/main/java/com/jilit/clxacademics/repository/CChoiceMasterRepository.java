package com.jilit.clxacademics.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jilit.clxacademics.model.CChoiceMaster;
import com.jilit.clxacademics.model.CChoiceMasterPK;
@Repository
public interface CChoiceMasterRepository extends CrudRepository<CChoiceMaster,CChoiceMasterPK>{
	
	@SuppressWarnings("rawtypes")
	@Query("select new Map(cm.id.choiceno as choiceno, cm.id.programtype as programtype, cm.id.programcode as programcode,"
			+ " cm.id.branchcode as branchcode, cm.id.alpha as alpha, cm.institutecode as institutecode, "
			+ " cm.branchalloted as branchalloted, cm.allotedinstitute as allotedinstitute, cm.counsellingdate as counsellingdate,"
			+ " cm.allocationfromcategory as allocationfromcategory )" 
			+ " from CChoiceMaster cm where cm.id.counsellingid=:counsellingid"
			+ " and cm.id.counsellingno=:counsellingno and cm.id.rank=:rank and nvl(cm.deactive,'N')='N'")
	public List<Map> getOfferedBranchList(@Param("counsellingid") String counsellingid, @Param("counsellingno") short counsellingno, @Param("rank") String rank);

	@SuppressWarnings("rawtypes")
	@Query("select new Map(ad.allotedalpha as allotedalpha, ad.allotedbranch as allotedbranch, ad.allotedinstitute as allotedinstitute, ad.allotedprogram  as allotedprogram )" 
			+ " from CAllocationDetail  ad where ad.id.counsellingid=:counsellingid and ad.fromcategory=:category and ad.id.rank=:rank")
	public List<Map> getAllocationDetail(@Param("counsellingid") String counsellingid, @Param("category") String category, @Param("rank") String rank);
	
	@SuppressWarnings("rawtypes")
	@Query("select new Map(sr.id.companycode as companycode, sr.id.institutecode as institutecode, sr.id.examcode as examcode, sr.id.regcode as regcode, sr.id.academicyear as academicyear, " + 
			"sr.id.programcode as programcode, sr.id.taggingfor as taggingfor, sr.id.sectionbranch as sectionbranch, sr.id.semester as semester, sr.id.semestertype as semestertype," + 
			" sr.id.studentid as studentid,  sr.feespaid as feespaid, sr.hostelconfirmation as hostelconfirmation,sr.branchcode as branchcode, sr.hosteltype as hosteltype, sr.hostelfeepaid as hostelfeepaid, sm.sex as sex )" 
			+ " from StudentRegistration sr, CStudentMaster sm where sr.id.studentid = sm.studentid and sr.id.institutecode=:institutecode and sm.id.counsellingid=:counsellingid and sm.appliedcategory=:appliedcategory and sm.id.rank=:rank and  sr.regallow='Y'  ")
	public List<Map> getFeeHostelStatus(@Param("counsellingid") String counsellingid, @Param("appliedcategory") String appliedcategory, @Param("rank") String rank,@Param("institutecode") String institutecode);

}
