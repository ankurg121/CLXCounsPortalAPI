package com.jilit.clxacademics.repository;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jilit.clxacademics.model.CDraftChoiceMaster;
import com.jilit.clxacademics.model.CDraftChoiceMasterPK;

@Repository
public interface CDraftChoiceMasterRepository extends CrudRepository<CDraftChoiceMaster, CDraftChoiceMasterPK> {

	@Query("select new Map(im.institutecode as institutecode,csm.alpha as alpha,bm.seqid as seqid,pm.id.programcode as programcode,"
			+ " pm.programname as programname, pm.id.programtype as programtype,bm.id.branchcode as branchcode, bm.branchdesc as branchdesc, "
			+ " (select cm.id.choiceno from CDraftChoiceMaster cm where cm.institutecode=ibt.id.institutecode and cm.id.programtype=ibt.id.programtype and cm.id.programcode=ibt.id.programcode "
			+ " and cm.id.branchcode=ibt.id.branchcode and cm.id.alpha=csm.alpha and cm.id.rank=:rank and cm.id.counsellingid=:counsellingid) as choiceno) "
			+ " from CInstituteMaster im,CProgramMaster pm ,CBranchMaster bm ,CProgramTypeMaster ptm,CInstituteBranchTagging ibt,CSeatMaster csm "
			+ " where pm.id.programtype=ptm.programtype and pm.id.programtype=bm.id.programtype and pm.id.programcode=bm.id.programcode and ibt.id.programtype=bm.id.programtype "
			+ " and ibt.id.programcode=bm.id.programcode and ibt.id.branchcode=bm.id.branchcode and ibt.id.institutecode=im.id.institutecode and csm.id.institutecode=ibt.id.institutecode "
			+ " and csm.id.programtype=ibt.id.programtype and csm.id.programcode=ibt.id.programcode and csm.id.branchcode=ibt.id.branchcode "
			+ " and csm.id.categorycode=:categorycode order by choiceno,bm.seqid")
	List<Map> getbranchpreferencelist(@Param("counsellingid") String counsellingid, @Param("rank") String rank,
			@Param("categorycode") String categorycode);

	@Modifying
	@Transactional
	@Query("delete from CDraftChoiceMaster cm where cm.id.counsellingid=:counsellingid and cm.id.rank=:rank "
			+ " and cm.id.counsellingno=:counsellingno and cm.freeze='N'")
	void deleteMyBranchChoice(@Param("counsellingid") String counsellingid, @Param("rank") String rank,
			@Param("counsellingno") short counsellingno);

	@Query("select new Map(cm.institutecode as institutecode,cm.id.alpha as alpha,cm.id.programcode as programcode,"
			+ " cm.id.choiceno as choiceno,cm.id.programtype as programtype,cm.id.branchcode as branchcode, "
			+ " bm.branchdesc as branchdesc)"
			+ " from CDraftChoiceMaster cm,CBranchMaster bm where  cm.id.programtype=bm.id.programtype and cm.id.programcode=bm.id.programcode"
			+ " and cm.id.branchcode=bm.id.branchcode and cm.id.counsellingid=:counsellingid and cm.id.rank=:rank "
			+ " and cm.id.counsellingno=:counsellingno and coalesce(cm.freeze,'N')='N' order by cm.id.choiceno ")
	List<Map> getBranchPreferenceDraftReportlist(@Param("counsellingid") String counsellingid, @Param("rank") String rank,
			@Param("counsellingno") short counsellingno);

	@Query("select new Map(max(cm.freezedate) as freezedate, max(entrydate) as entrydate)"
			+ " from CDraftChoiceMaster cm where cm.id.counsellingid=:counsellingid and cm.id.rank=:rank "
			+ " and cm.id.counsellingno=:counsellingno order by cm.id.choiceno")
	Map isBranchFreezed(String counsellingid, String rank, short counsellingno);

	@Query("select new Map(cm.institutecode as institutecode,cm.id.alpha as alpha,cm.id.programcode as programcode,"
			+ " cm.id.choiceno as choiceno,cm.id.programtype as programtype,cm.id.branchcode as branchcode, "
			+ " bm.branchdesc as branchdesc)"
			+ " from CChoiceMaster cm,CBranchMaster bm where cm.id.programtype=bm.id.programtype and cm.id.programcode=bm.id.programcode"
			+ " and cm.id.branchcode=bm.id.branchcode and cm.id.counsellingid=:counsellingid and cm.id.rank=:rank "
			+ " and cm.id.counsellingno=:counsellingno order by cm.id.choiceno  ")
	List<Map> getBranchPreferenceFreezedReportlist(@Param("counsellingid") String counsellingid, @Param("rank") String rank,
			@Param("counsellingno") short counsellingno);

	// @Query("select from CStudentMaster csm where
	// csm.id.counsellingid=:counsellingid and csm.id.rank=:rank ")
	// void isuserValid(String counsellingid, String applicantid);

}
