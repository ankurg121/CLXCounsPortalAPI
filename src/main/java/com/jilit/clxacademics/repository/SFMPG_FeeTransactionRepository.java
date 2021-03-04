package com.jilit.clxacademics.repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jilit.clxacademics.model.SFMPG_FeeTransaction;

@Repository
public interface SFMPG_FeeTransactionRepository extends CrudRepository<SFMPG_FeeTransaction,String>{

//	@Query( "select  decode(a.transactiontype,'R',b.feeamount,0)-decode(a.transactiontype,'P',b.feeamount,0) as amt" + 
//			" from Feetransaction a,Feetransactiondetail b, Feeheads d" + 
//			" where a.id.instituteid=b.id.instituteid and a.id.prid =b.id.prid and b.id.instituteid =d.id.instituteid  and b.feeheadid=d.id.feeheadid" + 
//			" and  a.feecollectionevents.id.eventid  =decode(:eventid,'All',a.feecollectionevents.id.eventid,:eventid)" + 
//			" and d.id.feeheadid=decode(:feeheadid,'All',d.id.feeheadid,:feeheadid)" + 
//			" and a.studentMaster.studentid=:studentid" + 
//			" and a.id.instituteid =:instituteid " + 
//			" and b.feecurrencyid.currencyid =:currencyid" + 
//			" and  b.styType.id.stytypeid =decode(:stytypeid,'All',b.styType.id.stytypeid,:stytypeid)" + 
//			" and  b.feespaidstynumber =decode(:stynumber,'All',b.feespaidstynumber,:stynumber)" + 
//			" and  d.feetype = 'A'")
//	public String savePostPGFeeData(@Param("instituteid") String instituteid,@Param("eventid") String eventid,@Param("stynumber") Short stynumber,@Param("stytypeid") String stytypeid,@Param("studentid") String studentid,@Param("feeheadid") String feeheadid,@Param("currencyid") String currencyid);
	

}
