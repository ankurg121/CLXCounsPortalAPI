package com.jilit.clxacademics.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jilit.clxacademics.model.CApplicantsRegistration;

@Repository
public interface CApplicantsRegistrationRepository extends CrudRepository<CApplicantsRegistration, String> {

	@Query("select car from CApplicantsRegistration car where car.applicationid=:applicationid and cid=:cid ")
	CApplicantsRegistration isPasswordGenerated(@Param("cid")String cid, @Param("applicationid")String applicationid);

	@Query("select car from CApplicantsRegistration car where (car.regemailmobile=:mobileno or car.regemailmobile=:emailid)"
			+ " and car.cid=:cid and car.applicationid=:applicationid ")
	CApplicantsRegistration getapplicants(@Param("cid")String cid,@Param("applicationid")String applicationid,@Param("emailid")String emailid, @Param("mobileno")String mobileno);

	@Query("select car from CApplicantsRegistration car where  car.applicationid=:applicationid  and car.cid=:cid")
	CApplicantsRegistration getapplicantsForPass(@Param("applicationid")String applicationid,@Param("cid")String cid);

}
