package com.jilit.clxacademics.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jilit.clxacademics.model.V_Staff;
import com.jilit.clxacademics.model.V_StaffPK;

@Repository
public interface V_StaffRepository extends CrudRepository<V_Staff,V_StaffPK> 
{
//	@Query("Select ep.photo as photo, ep.signature as signature from EmployeePhoto ep "
//			+ " where ep.employeeid=:employeeid ")
//	public Map getEmployeePhoto(@Param("employeeid") String employeeid);
//    
//	@Query("Select new Map(v.employeecode as employeecode ,v.id.employeeid as employeeid,v.employeename as employeename,v.stafftype as stafftype,v.designation as designation) from V_Staff v where v.id.companyid in (select cit.id.companyid from CompanyInstituteTagging cit where cit.id.instituteid=:instituteid )"
//			+ " and (v.deactive='N' or v.deactive is null)")
//	public List<Map> getAllStaffForinstitute(@Param("instituteid")String instituteid);
	@Query("Select vs.employeename as employeename, vs.employeecode as employeecode from V_Staff vs "
			+ " where vs.id.employeeid=:employeeid and vs.stafftype=:usertype")
			public Map getEmployeeDetail(@Param("employeeid") String employeeid,@Param("usertype") String usertype);

	@Query("Select cs.name as name, vs.cid as cid, vs.regtransid as regtransid, vs.emailormobile as emailormobile, vs.regemailmobile as regemailmobile, vs.pwdata as pwdata, vs.applicationid as applicationid, vs.otpvalue as otpvalue,to_char(vs.otpdatevalidupto,'YYYYMMDD') as otpdatevalidupto  "
			+ "  from CApplicantsRegistration vs,  CStudentMaster cs where vs.regstatus='A' "
			+ "  and cs.id.counsellingid = vs.cid and vs.applicationid=cs.applicationid and ( ('R'=:logintype and cs.id.rank=:loginid ) or "
			+ " ('A'=:logintype and cs.applicationno=:loginid ))")
			public Map getCandidateLoginDetail(@Param("loginid") String loginid,@Param("logintype") String logintype);

	@Query("Select vs.applicationid as name, vs.cid as cid, vs.regtransid as regtransid, vs.emailormobile as emailormobile, vs.regemailmobile as regemailmobile, vs.pwdata as pwdata, vs.applicationid as applicationid, vs.otpvalue as otpvalue,to_char(vs.otpdatevalidupto,'YYYYMMDD') as otpdatevalidupto  "
			+ "  from CApplicantsRegistration vs where vs.regstatus='A' "
			+ "  and vs.cid in (select cs.cid from C_Current cs) and "
			+ " 'D'=:logintype and vs.regtransid=:loginid ")
			public Map getCandidateLoginDetailAdmin(@Param("loginid") String loginid,@Param("logintype") String logintype);

}
