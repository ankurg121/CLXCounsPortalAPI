package com.jilit.clxacademics.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.stereotype.Repository;

import com.jilit.clxacademics.model.NumberingControlOthers;
import com.jilit.clxacademics.model.NumberingControlOthersPK;

@Repository
public interface NumberingControlOthersRepository extends JpaRepository<NumberingControlOthers,NumberingControlOthersPK> {

}
