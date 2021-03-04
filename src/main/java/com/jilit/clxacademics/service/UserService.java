package com.jilit.clxacademics.service;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.jilit.clxacademics.exceptions.CLXException;
import com.jilit.clxacademics.model.User;
import com.jilit.clxacademics.model.User;


public interface UserService {

      User save(User user);
      List<User> findAll();
     void delete(long id);
     User findOne(String username);
     User findById(Long id);
    public UserDetails loadUsernameDecrypted(String userid) throws UsernameNotFoundException ; 
    public <T, K, V> T otpPasswordCheck(Map<K, V> Reqmap, HttpServletRequest request,	HttpServletResponse httpServletResponse) throws CLXException;
//    public <T, K, V> T otpPasswordCheckForStaff(Map<K, V> Reqmap, HttpServletRequest request,HttpServletResponse httpServletResponse) throws CLXException;
}

 