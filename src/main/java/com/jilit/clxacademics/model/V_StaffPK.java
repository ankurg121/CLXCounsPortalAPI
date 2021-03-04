/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jilit.clxacademics.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Ashok.Singh
 */
@Embeddable
public class V_StaffPK implements Serializable{
    @Basic(optional = false)
    @NotNull
    @Size(max = 20)
    @Column(name = "COMPANYID")
    private String companyid;
    @Basic(optional = false)
    @NotNull
    @Size(max = 20)
    @Column(name = "EMPLOYEEID")
    private String employeeid;

    public V_StaffPK(){
        
    }
    
    public V_StaffPK(String companyid, String employeeid) {
        this.companyid = companyid;
        this.employeeid = employeeid;
    }

    public String getCompanyid() {
        return companyid;
    }

    public void setCompanyid(String companyid) {
        this.companyid = companyid;
    }

    public String getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(String employeeid) {
        this.employeeid = employeeid;
    }
    
}
