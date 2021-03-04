package com.jilit.clxacademics.repository;


import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.jilit.clxacademics.model.Sct_IrpMlp;
//import com.jilit.campuslynxportal.model.StudentMaster;


public interface Sct_IrpMlpRepository extends CrudRepository<Sct_IrpMlp, Long> 
{
	 public Sct_IrpMlp findBydata4(String mloginid); 
	//Sct_IrpMlp findByUsername(String username);
	 
	 
	 
	 
	 public Sct_IrpMlp findBydata2(String muserid);
	 
	 public Sct_IrpMlp findBydata5(String memberid);
	 
	 
	 @Modifying
	    @Query("UPDATE Sct_IrpMlp t SET t.data4 = :defaultpassword WHERE t.data2 = :encodedusername")
	    int updatepassword(@Param("defaultpassword") String defaultpassword, @Param("encodedusername") String encodedusername);
	 
	 @Query("select sip.data6 as selfpassword,sip.data5 as memberid  from Sct_IrpMlp sip where sip.data4=:data4 and sip.data6=:data6" )
	 public Map validatepassword(@Param("data4") String data4
			 						,@Param("data6") String data6);
	
	
}