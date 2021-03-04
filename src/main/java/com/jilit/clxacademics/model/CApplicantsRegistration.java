/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jilit.clxacademics.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Sushil
 */
@Entity
@Table(name = "C_APPLICANTSREGISTRATION")
public class CApplicantsRegistration implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "REGTRANSID")
    private String regtransid;
    @Column(name = "CID")
    private String cid;
    @Basic(optional = false)
    @Column(name = "EMAILORMOBILE")
    private String emailormobile;
    @Basic(optional = false)
    @Column(name = "REGEMAILMOBILE")
    private String regemailmobile;
    @Basic(optional = false)
    @Column(name = "PWDATA")
    private String pwdata;
    @Column(name = "REGSTATUS")
    private String regstatus;
    @Column(name = "LOGINIP")
    private String loginip;
    @Column(name = "LOGINDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date logindate;
    @Column(name = "APPLICATIONID")
    private String applicationid;
    @Column(name = "OTPVALUE")
    private String otpvalue;
    @Column(name = "OTPDATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date otpdatetime;
    @Column(name = "OTPDATEVALIDUPTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date otpdatevalidupto;
    @Column(name = "SIGNUPDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date signupdate;
    
//    @JoinColumn(name = "CID", referencedColumnName = "COUNSELLINGID")
//    @ManyToOne
//    private CCounsellingId cid;

    public CApplicantsRegistration() {
    }

    public CApplicantsRegistration(String regtransid) {
        this.regtransid = regtransid;
    }

    public CApplicantsRegistration(String regtransid, String emailormobile, String regemailmobile, String pwdata) {
        this.regtransid = regtransid;
        this.emailormobile = emailormobile;
        this.regemailmobile = regemailmobile;
        this.pwdata = pwdata;
    }

    public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getRegtransid() {
        return regtransid;
    }

    public void setRegtransid(String regtransid) {
        this.regtransid = regtransid;
    }

    public String getEmailormobile() {
        return emailormobile;
    }

    public void setEmailormobile(String emailormobile) {
        this.emailormobile = emailormobile;
    }

    public String getRegemailmobile() {
        return regemailmobile;
    }

    public void setRegemailmobile(String regemailmobile) {
        this.regemailmobile = regemailmobile;
    }

    public String getPwdata() {
        return pwdata;
    }

    public void setPwdata(String pwdata) {
        this.pwdata = pwdata;
    }

    public String getRegstatus() {
        return regstatus;
    }

    public void setRegstatus(String regstatus) {
        this.regstatus = regstatus;
    }

    public String getLoginip() {
        return loginip;
    }

    public void setLoginip(String loginip) {
        this.loginip = loginip;
    }

    public Date getLogindate() {
        return logindate;
    }

    public void setLogindate(Date logindate) {
        this.logindate = logindate;
    }

    public String getApplicationid() {
        return applicationid;
    }

    public void setApplicationid(String applicationid) {
        this.applicationid = applicationid;
    }

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
    
    

//    public CCounsellingId getCid() {
//        return cid;
//    }
//
//    public void setCid(CCounsellingId cid) {
//        this.cid = cid;
//    }

    public Date getSignupdate() {
		return signupdate;
	}

	public void setSignupdate(Date signupdate) {
		this.signupdate = signupdate;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (regtransid != null ? regtransid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CApplicantsRegistration)) {
            return false;
        }
        CApplicantsRegistration other = (CApplicantsRegistration) object;
        if ((this.regtransid == null && other.regtransid != null) || (this.regtransid != null && !this.regtransid.equals(other.regtransid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jilit.clxacademics.model.CApplicantsRegistration[ regtransid=" + regtransid + " ]";
    }
    
}
