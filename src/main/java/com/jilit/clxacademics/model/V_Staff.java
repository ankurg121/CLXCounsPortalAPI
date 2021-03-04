/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jilit.clxacademics.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Ashok.Singh
 */
@Entity
@Table(name = "V#STAFF")
//@NamedQueries({
//    @NamedQuery(name = "V_Staff.findAll", query = "SELECT v FROM V_Staff v")})
public class V_Staff implements Serializable {

	private static final long serialVersionUID = 1L;
	@EmbeddedId
	protected V_StaffPK id;
	@Size(max = 20)
	@Column(name = "EMPLOYEECODE")
	private String employeecode;
	@Size(max = 20)
	@Column(name = "SALUTATIONID")
	private String salutationid;
	@Size(max = 100)
	@Column(name = "EMPLOYEENAME")
	private String employeename;
	@Size(max = 20)
	@Column(name = "DEPARTMENTID")
	private String departmentid;
	@Size(max = 20)
	@Column(name = "DEPARTMENTCODE")
	private String departmentcode;
	@Size(max = 100)
	@Column(name = "DEPARTMENT")
	private String department;
	@Size(max = 20)
	@Column(name = "DESIGNATIONID")
	private String designationid;
	@Size(max = 20)
	@Column(name = "DESIGNATIONCODE")
	private String designationcode;
	@Size(max = 100)
	@Column(name = "DESIGNATION")
	private String designation;
	@Size(max = 1)
	@Column(name = "STAFFTYPE")
	private String stafftype;
	@Size(max = 10)
	@Column(name = "SHORTNAME")
	private String shortname;
	@Size(max = 20)
	@Column(name = "EMPLOYEETYPEID")
	private String employeetypeid;
	@Size(max = 20)
	@Column(name = "EMPLOYEETYPE")
	private String employeetype;
	@Size(max = 1)
	@Column(name = "DEACTIVE")
	private String deactive;

	@Column(name = "EMAILID")
	private String emailid;

	public V_Staff() {
	}

	public String getEmployeecode() {
		return employeecode;
	}

	public void setEmployeecode(String employeecode) {
		this.employeecode = employeecode;
	}

	public String getSalutationid() {
		return salutationid;
	}

	public void setSalutationid(String salutationid) {
		this.salutationid = salutationid;
	}

	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	public String getDepartmentid() {
		return departmentid;
	}

	public void setDepartmentid(String departmentid) {
		this.departmentid = departmentid;
	}

	public String getDepartmentcode() {
		return departmentcode;
	}

	public void setDepartmentcode(String departmentcode) {
		this.departmentcode = departmentcode;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDesignationid() {
		return designationid;
	}

	public void setDesignationid(String designationid) {
		this.designationid = designationid;
	}

	public String getDesignationcode() {
		return designationcode;
	}

	public void setDesignationcode(String designationcode) {
		this.designationcode = designationcode;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getStafftype() {
		return stafftype;
	}

	public void setStafftype(String stafftype) {
		this.stafftype = stafftype;
	}

	public String getShortname() {
		return shortname;
	}

	public void setShortname(String shortname) {
		this.shortname = shortname;
	}

	public String getEmployeetypeid() {
		return employeetypeid;
	}

	public void setEmployeetypeid(String employeetypeid) {
		this.employeetypeid = employeetypeid;
	}

	public String getEmployeetype() {
		return employeetype;
	}

	public void setEmployeetype(String employeetype) {
		this.employeetype = employeetype;
	}

	public String getDeactive() {
		return deactive;
	}

	public void setDeactive(String deactive) {
		this.deactive = deactive;
	}

	public V_StaffPK getV_StaffPK() {
		return id;
	}

	public void setV_StaffPK(V_StaffPK v_StaffPK) {
		this.id = v_StaffPK;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

}
