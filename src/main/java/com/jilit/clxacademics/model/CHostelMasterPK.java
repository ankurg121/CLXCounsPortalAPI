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
public class CHostelMasterPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "INSTITUTECODE")
    private String institutecode;
    @Basic(optional = false)
    @Column(name = "HOSTELTYPE")
    private String hosteltype;
    @Basic(optional = false)
    @Column(name = "HOSTELCODE")
    private String hostelcode;

    public CHostelMasterPK() {
    }

    public CHostelMasterPK(String institutecode, String hosteltype, String hostelcode) {
        this.institutecode = institutecode;
        this.hosteltype = hosteltype;
        this.hostelcode = hostelcode;
    }

    public String getInstitutecode() {
        return institutecode;
    }

    public void setInstitutecode(String institutecode) {
        this.institutecode = institutecode;
    }

    public String getHosteltype() {
        return hosteltype;
    }

    public void setHosteltype(String hosteltype) {
        this.hosteltype = hosteltype;
    }

    public String getHostelcode() {
        return hostelcode;
    }

    public void setHostelcode(String hostelcode) {
        this.hostelcode = hostelcode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (institutecode != null ? institutecode.hashCode() : 0);
        hash += (hosteltype != null ? hosteltype.hashCode() : 0);
        hash += (hostelcode != null ? hostelcode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CHostelMasterPK)) {
            return false;
        }
        CHostelMasterPK other = (CHostelMasterPK) object;
        if ((this.institutecode == null && other.institutecode != null) || (this.institutecode != null && !this.institutecode.equals(other.institutecode))) {
            return false;
        }
        if ((this.hosteltype == null && other.hosteltype != null) || (this.hosteltype != null && !this.hosteltype.equals(other.hosteltype))) {
            return false;
        }
        if ((this.hostelcode == null && other.hostelcode != null) || (this.hostelcode != null && !this.hostelcode.equals(other.hostelcode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jilit.clxacademics.model.CHostelMasterPK[ institutecode=" + institutecode + ", hosteltype=" + hosteltype + ", hostelcode=" + hostelcode + " ]";
    }
    
}
