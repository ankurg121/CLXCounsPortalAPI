package com.jilit.clxacademics.dao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jilit.clxacademics.model.User;

@Repository

public interface UserDao extends CrudRepository<User, Long> {
    User findByUsername(String username);
}



