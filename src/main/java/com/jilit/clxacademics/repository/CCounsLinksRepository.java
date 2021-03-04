package com.jilit.clxacademics.repository;

import java.util.List;
import java.util.Map;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.jilit.clxacademics.model.CCounsLinks;
import com.jilit.clxacademics.model.CCounsLinksPK;

@Repository
public interface CCounsLinksRepository extends CrudRepository<CCounsLinks, CCounsLinksPK> {

	@SuppressWarnings("rawtypes")
 	@Query("select new Map( cl.id.urllinknameid as urllinknameid, cl.instructioninfo as instructioninfo,cl.pageurl as pageurl,  cl.urlname as urlname, cl.urltooltip as urltooltip ) "
			+ " from  CCounsLinks cl where  cl.id.cid=:cid and to_char(sysdate,'yyyymmddhh24mi') between to_char( cl.startdatetime,'yyyymmddhh24mi') and to_char(cl.enddatetime,'yyyymmddhh24mi') "
			+ " and nvl(cl.boroadcast,'N')='Y'  and cl.deactive='N'    order by cl.seqid ")
	public List<Map> showDashBoardLinkList(@Param("cid") String cid);
//
//	@Query("select new Map(cl.id.cid as cid,cl.id.urllinknameid as urllinknameid, cl.deactive as deactive, cl.enddatetime as enddatetime, "
//			+ " cl.instructionfileurl as instructionfileurl, cl.instructioninfo as instructioninfo,cl.pageurl as pageurl,"
//			+ " cl.seqid as seqid, cl.startdatetime as startdatetime, cl.urlname as urlname, cl.urltooltip as urltooltip,"
//			+ " cl.boroadcast as boroadcast,csm.studentid as studentid,csm.name as name,csm.dateofbirth as dateofbirth) "
//			+ " from  CCounsLinks cl, CStudentMaster csm where cl.id.cid = csm.id.counsellingid and cl.id.cid=:cid and csm.studentid=:studentid ")
//	public List<Map> showDashBoardList(@Param("cid") String cid, @Param("studentid") String studentid);
	
	
 
	@SuppressWarnings("rawtypes")
	@Query("select new Map(csm.studentid as studentid,csm.name as name,csm.dateofbirth as dateofbirth, rollno as rollno , csm.id.rank as rank, csm.fathershusbandname as fathershusbandname,"
			+ "csm.sex as sex, csm.quota as quota, csm.applicationno as applicationno, appliedcategory as category  ) "
			+ " from   CStudentMaster csm where  csm.id.counsellingid=:cid and csm.applicationid=:applicationid ")
	public List<Map> showDashBoardData(@Param("cid") String cid, @Param("applicationid") String studentid);
}
