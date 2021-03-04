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
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Sushil
 */
@Embeddable
public class CApplicantLoginDetailPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "LOGINUNIQUEID")
    private String loginuniqueid;
    @Basic(optional = false)
    @Column(name = "REGTRANSID")
    private String regtransid;
    @Basic(optional = false)
    @Column(name = "LOGINDATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date logindatetime;

    public CApplicantLoginDetailPK() {
    }

    public CApplicantLoginDetailPK(String loginuniqueid, String regtransid, Date logindatetime) {
        this.loginuniqueid = loginuniqueid;
        this.regtransid = regtransid;
        this.logindatetime = logindatetime;
    }

    public String getLoginuniqueid() {
        return loginuniqueid;
    }

    public void setLoginuniqueid(String loginuniqueid) {
        this.loginuniqueid = loginuniqueid;
    }

    public String getRegtransid() {
        return regtransid;
    }

    public void setRegtransid(String regtransid) {
        this.regtransid = regtransid;
    }

    public Date getLogindatetime() {
        return logindatetime;
    }

    public void setLogindatetime(Date logindatetime) {
        this.logindatetime = logindatetime;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (loginuniqueid != null ? loginuniqueid.hashCode() : 0);
        hash += (regtransid != null ? regtransid.hashCode() : 0);
        hash += (logindatetime != null ? logindatetime.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CApplicantLoginDetailPK)) {
            return false;
        }
        CApplicantLoginDetailPK other = (CApplicantLoginDetailPK) object;
        if ((this.loginuniqueid == null && other.loginuniqueid != null) || (this.loginuniqueid != null && !this.loginuniqueid.equals(other.loginuniqueid))) {
            return false;
        }
        if ((this.regtransid == null && other.regtransid != null) || (this.regtransid != null && !this.regtransid.equals(other.regtransid))) {
            return false;
        }
        if ((this.logindatetime == null && other.logindatetime != null) || (this.logindatetime != null && !this.logindatetime.equals(other.logindatetime))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jilit.clxacademics.model.CApplicantLoginDetailPK[ loginuniqueid=" + loginuniqueid + ", regtransid=" + regtransid + ", logindatetime=" + logindatetime + " ]";
    }
    
}
