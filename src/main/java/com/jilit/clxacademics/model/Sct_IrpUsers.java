/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jilit.clxacademics.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.stereotype.Component;

/**
 *
 * @author Gaurav.mathur
 */
@Entity
@Component
@Table(name = "SCT#IRPUSERS")
public class Sct_IrpUsers implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "USERID")
    private String userid;
    @Column(name = "LASTVISITEDDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastvisiteddate;
    @Size(max = 200)
    @Column(name = "DATA1")
    private String data1;
    @Size(max = 200)
    @Column(name = "DATA2")
    private String data2;
    @Size(max = 200)
    @Column(name = "DATA3")
    private String data3;
    @Size(max = 200)
    @Column(name = "DATA4")
    private String data4;
    @Size(max = 200)
    @Column(name = "DATA5")
    private String data5;
    @Column(name = "LASTVISITEDDATEPARENT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastvisiteddateparent;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "APPLIACTIONACCESS")
    private String appliactionaccess;
    
    @Size(max = 1)
    @Column(name = "LOGINSTATUS")
    private String loginstatus;
    
    @Size(max = 20)
    @Column(name = "OTPVALUE")
    private String otpvalue;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "OTPDATETIME")
    private Date otpdatetime;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "OTPDATEVALIDUPTO")
    private Date otpdatevalidupto;
    
    
    public String getOtpvalue() {
		return otpvalue;
	}

	public void setOtpvalue(String otpvalue) {
		this.otpvalue = otpvalue;
	}

	

	public Date getOtpdatetime() {
		return otpdatetime;
	}

	public void setOtpdatetime(Date otpdatetime) {
		this.otpdatetime = otpdatetime;
	}

	public Date getOtpdatevalidupto() {
		return otpdatevalidupto;
	}

	public void setOtpdatevalidupto(Date otpdatevalidupto) {
		this.otpdatevalidupto = otpdatevalidupto;
	}


//
//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "sctIrpUsers", fetch = FetchType.LAZY)
//    private Set<Sct_UserRoles> sctUserRolesSet;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sctIrpUsers", fetch = FetchType.LAZY)
//    private Set<Sct_Urts> sctUrtsSet;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sctIrpUsers", fetch = FetchType.LAZY)
//    private Set<Sct_UserLocation> sctUserLocationSet;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sctIrpUsers", fetch = FetchType.LAZY)
//    private Set<Log_LoginLogInfo> logLoginloginfoSet;

    public Sct_IrpUsers() {
    }

    public Sct_IrpUsers(String userid) {
        this.userid = userid;
    }

    public Sct_IrpUsers(String userid, String appliactionaccess) {
        this.userid = userid;
        this.appliactionaccess = appliactionaccess;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Date getLastvisiteddate() {
        return lastvisiteddate;
    }

    public void setLastvisiteddate(Date lastvisiteddate) {
        this.lastvisiteddate = lastvisiteddate;
    }

    public String getData1() {
        return data1;
    }

    public void setData1(String data1) {
        this.data1 = data1;
    }

    public String getData2() {
        return data2;
    }

    public void setData2(String data2) {
        this.data2 = data2;
    }

    public String getData3() {
        return data3;
    }

    public void setData3(String data3) {
        this.data3 = data3;
    }

    public String getData4() {
        return data4;
    }

    public void setData4(String data4) {
        this.data4 = data4;
    }

    public String getData5() {
        return data5;
    }

    public void setData5(String data5) {
        this.data5 = data5;
    }

    public Date getLastvisiteddateparent() {
        return lastvisiteddateparent;
    }

    public void setLastvisiteddateparent(Date lastvisiteddateparent) {
        this.lastvisiteddateparent = lastvisiteddateparent;
    }

    public String getAppliactionaccess() {
        return appliactionaccess;
    }

    public void setAppliactionaccess(String appliactionaccess) {
        this.appliactionaccess = appliactionaccess;
    }

    public String getLoginstatus() {
        return loginstatus;
    }

    public void setLoginstatus(String loginstatus) {
        this.loginstatus = loginstatus;
    }

   
 
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userid != null ? userid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sct_IrpUsers)) {
            return false;
        }
        Sct_IrpUsers other = (Sct_IrpUsers) object;
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jilit.campusportal.dto.Sct_IrpUsers[ userid=" + userid + " ]";
    }
 
    
}
