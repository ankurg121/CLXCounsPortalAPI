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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.stereotype.Component;

/**
 *
 * @author Ashok.singh
 */
@Component
@Embeddable
public class Log_LoginLogInfoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "USERID")
    private String userid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LOGINDATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date logindatetime;

    public Log_LoginLogInfoPK() {
    }

    public Log_LoginLogInfoPK(String userid, Date logindatetime) {
        this.userid = userid;
        this.logindatetime = logindatetime;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
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
        hash += (userid != null ? userid.hashCode() : 0);
        hash += (logindatetime != null ? logindatetime.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Log_LoginLogInfoPK)) {
            return false;
        }
        Log_LoginLogInfoPK other = (Log_LoginLogInfoPK) object;
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid))) {
            return false;
        }
        if ((this.logindatetime == null && other.logindatetime != null) || (this.logindatetime != null && !this.logindatetime.equals(other.logindatetime))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jilit.clxacademics.model.Log_LoginloginfoPK[ userid=" + userid + ", logindatetime=" + logindatetime + " ]";
    }
    
}
