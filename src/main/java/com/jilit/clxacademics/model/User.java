package com.jilit.clxacademics.model;
//package com.devglan.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="C_PORTALUSERS")
//@Table(name="USERS")
public class User {

    @Id
  //  @GeneratedValue(strategy= GenerationType.AUTO)
    @Column (name="REGTRANSID")   //LoginID
    private String id;
    
    //@Column (name="REGEMAILMOBILE")   //LoginID
    @Column (name="APPLICATIONID")   //LoginID
    private String username;
    
    @Column (name="PWDATA")  // UserID
    @JsonIgnore
    private String password;
    
    @Column (name="USERTYPE")   //Member Type
    @JsonIgnore
    private String role;

	public User() {
		
	}

	public User(String id, String username, String password, String role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
    
    
    
}