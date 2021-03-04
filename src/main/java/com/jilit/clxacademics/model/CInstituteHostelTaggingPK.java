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
public class CInstituteHostelTaggingPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "INSTITUTECODE")
    private String institutecode;
    @Basic(optional = false)
    @Column(name = "HOSTELTYPE")
    private String hosteltype;

    public CInstituteHostelTaggingPK() {
    }

    public CInstituteHostelTaggingPK(String institutecode, String hosteltype) {
        this.institutecode = institutecode;
        this.hosteltype = hosteltype;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (institutecode != null ? institutecode.hashCode() : 0);
        hash += (hosteltype != null ? hosteltype.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CInstituteHostelTaggingPK)) {
            return false;
        }
        CInstituteHostelTaggingPK other = (CInstituteHostelTaggingPK) object;
        if ((this.institutecode == null && other.institutecode != null) || (this.institutecode != null && !this.institutecode.equals(other.institutecode))) {
            return false;
        }
        if ((this.hosteltype == null && other.hosteltype != null) || (this.hosteltype != null && !this.hosteltype.equals(other.hosteltype))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jilit.clxacademics.model.CInstituteHostelTaggingPK[ institutecode=" + institutecode + ", hosteltype=" + hosteltype + " ]";
    }
    
}
