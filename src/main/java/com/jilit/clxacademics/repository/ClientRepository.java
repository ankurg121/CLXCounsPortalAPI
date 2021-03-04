package com.jilit.clxacademics.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.jilit.clxacademics.model.ClientMaster;
 


public interface ClientRepository extends CrudRepository<ClientMaster, String> {

//	public ClientMaster findByClientid(String clientid);
// 	@Query("select distinct sm.name as name from StudentMaster sm "
//			+ "where  sm.studentid=:userid ")
//	public String getloginUserNameStudent(@Param("userid") String userid);
//	
//	
//	@Query("select distinct sm.employeename as employeename from V_Staff sm "
//			+ "where  sm.id.employeeid=:userid and nvl(sm.deactive,'N')='N'")
//	public String getloginUserNameEmployee(@Param("userid") String userid);

}
