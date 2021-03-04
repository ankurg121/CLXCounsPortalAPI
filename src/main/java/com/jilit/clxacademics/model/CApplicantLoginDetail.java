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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "C_APPLICANTLOGINDETAIL")
public class CApplicantLoginDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CApplicantLoginDetailPK cApplicantLoginDetailPK;
    @Basic(optional = false)
    @Column(name = "LOGINBASEDON")
    private String loginbasedon;
    @Basic(optional = false)
    @Column(name = "REGEMAILMOBILE")
    private String regemailmobile;
    @Column(name = "LOGINSTATUS")
    private String loginstatus;
    @Column(name = "LOGINIP")
    private String loginip;
    @Column(name = "OTPVALUE")
    private String otpvalue;
    @Column(name = "OTPDATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date otpdatetime;
    @Column(name = "OTPDATEVALIDUPTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date otpdatevalidupto;
    @Column(name = "BROWSERDETAIL")
    private String browserdetail;

    public CApplicantLoginDetail() {
    }

    public CApplicantLoginDetail(CApplicantLoginDetailPK cApplicantLoginDetailPK) {
        this.cApplicantLoginDetailPK = cApplicantLoginDetailPK;
    }

    public CApplicantLoginDetail(CApplicantLoginDetailPK cApplicantLoginDetailPK, String loginbasedon, String regemailmobile) {
        this.cApplicantLoginDetailPK = cApplicantLoginDetailPK;
        this.loginbasedon = loginbasedon;
        this.regemailmobile = regemailmobile;
    }

    public CApplicantLoginDetail(String loginuniqueid, String regtransid, Date logindatetime) {
        this.cApplicantLoginDetailPK = new CApplicantLoginDetailPK(loginuniqueid, regtransid, logindatetime);
    }

    public CApplicantLoginDetailPK getCApplicantLoginDetailPK() {
        return cApplicantLoginDetailPK;
    }

    public void setCApplicantLoginDetailPK(CApplicantLoginDetailPK cApplicantLoginDetailPK) {
        this.cApplicantLoginDetailPK = cApplicantLoginDetailPK;
    }

    public String getLoginbasedon() {
        return loginbasedon;
    }

    public void setLoginbasedon(String loginbasedon) {
        this.loginbasedon = loginbasedon;
    }

    public String getRegemailmobile() {
        return regemailmobile;
    }

    public void setRegemailmobile(String regemailmobile) {
        this.regemailmobile = regemailmobile;
    }

    public String getLoginstatus() {
        return loginstatus;
    }

    public void setLoginstatus(String loginstatus) {
        this.loginstatus = loginstatus;
    }

    public String getLoginip() {
        return loginip;
    }

    public void setLoginip(String loginip) {
        this.loginip = loginip;
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

    public String getBrowserdetail() {
        return browserdetail;
    }

    public void setBrowserdetail(String browserdetail) {
        this.browserdetail = browserdetail;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cApplicantLoginDetailPK != null ? cApplicantLoginDetailPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CApplicantLoginDetail)) {
            return false;
        }
        CApplicantLoginDetail other = (CApplicantLoginDetail) object;
        if ((this.cApplicantLoginDetailPK == null && other.cApplicantLoginDetailPK != null) || (this.cApplicantLoginDetailPK != null && !this.cApplicantLoginDetailPK.equals(other.cApplicantLoginDetailPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jilit.clxacademics.model.CApplicantLoginDetail[ cApplicantLoginDetailPK=" + cApplicantLoginDetailPK + " ]";
    }
    
}
