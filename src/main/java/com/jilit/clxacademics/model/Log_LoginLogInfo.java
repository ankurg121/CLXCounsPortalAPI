/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jilit.clxacademics.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.stereotype.Component;

/**
 *
 * @author Ashok.singh
 */
@Component
@Entity
@Table(name = "LOG#LOGINLOGINFO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Log_LoginLogInfo.findAll", query = "SELECT l FROM Log_LoginLogInfo l")})
public class Log_LoginLogInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected Log_LoginLogInfoPK id;
    @Column(name = "SLNO")
    private BigInteger slno;
    @Column(name = "LOGOUTTIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date logouttime;
    @Size(max = 30)
    @Column(name = "MACADDRESS")
    private String macaddress;
    @Size(max = 30)
    @Column(name = "IPADDRESS")
    private String ipaddress;
    @JoinColumn(name = "USERID", referencedColumnName = "USERID", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Sct_IrpUsers sctIrpUsers;

    public Log_LoginLogInfo() {
    }

    public Log_LoginLogInfo(Log_LoginLogInfoPK log_LoginloginfoPK) {
        this.id = log_LoginloginfoPK;
    }

    public Log_LoginLogInfo(String userid, Date logindatetime) {
        this.id = new Log_LoginLogInfoPK(userid, logindatetime);
    }

    public Log_LoginLogInfoPK getLog_LoginloginfoPK() {
        return id;
    }

    public void setLog_LoginloginfoPK(Log_LoginLogInfoPK log_LoginloginfoPK) {
        this.id = log_LoginloginfoPK;
    }

    public BigInteger getSlno() {
        return slno;
    }

    public void setSlno(BigInteger slno) {
        this.slno = slno;
    }

    public Date getLogouttime() {
        return logouttime;
    }

    public void setLogouttime(Date logouttime) {
        this.logouttime = logouttime;
    }

    public String getMacaddress() {
        return macaddress;
    }

    public void setMacaddress(String macaddress) {
        this.macaddress = macaddress;
    }

    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
    }

    public Sct_IrpUsers getSctIrpUsers() {
        return sctIrpUsers;
    }

    public void setSctIrpUsers(Sct_IrpUsers sctIrpUsers) {
        this.sctIrpUsers = sctIrpUsers;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Log_LoginLogInfo)) {
            return false;
        }
        Log_LoginLogInfo other = (Log_LoginLogInfo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jilit.clxacademics.model.Log_Loginloginfo[ log_LoginloginfoPK=" + id + " ]";
    }
    
}
