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

/**
 *
 * @author Anubhav
 */
@Embeddable
public class CApplicationMasterPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "COUNSELLINGID")
    private String counsellingid;
    @Basic(optional = false)
    @Column(name = "APPLICATIONID")
    private String applicationid;

    public CApplicationMasterPK() {
    }

    public CApplicationMasterPK(String counsellingid, String applicationid) {
        this.counsellingid = counsellingid;
        this.applicationid = applicationid;
    }

    public String getCounsellingid() {
        return counsellingid;
    }

    public void setCounsellingid(String counsellingid) {
        this.counsellingid = counsellingid;
    }

    public String getApplicationid() {
        return applicationid;
    }

    public void setApplicationid(String applicationid) {
        this.applicationid = applicationid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (counsellingid != null ? counsellingid.hashCode() : 0);
        hash += (applicationid != null ? applicationid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CApplicationMasterPK)) {
            return false;
        }
        CApplicationMasterPK other = (CApplicationMasterPK) object;
        if ((this.counsellingid == null && other.counsellingid != null) || (this.counsellingid != null && !this.counsellingid.equals(other.counsellingid))) {
            return false;
        }
        if ((this.applicationid == null && other.applicationid != null) || (this.applicationid != null && !this.applicationid.equals(other.applicationid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jilit.clxacademics.model.CApplicationMasterPK[ counsellingid=" + counsellingid + ", applicationid=" + applicationid + " ]";
    }
    
}
