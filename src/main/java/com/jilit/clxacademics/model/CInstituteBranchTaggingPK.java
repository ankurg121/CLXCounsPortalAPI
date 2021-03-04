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
public class CInstituteBranchTaggingPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "INSTITUTECODE")
    private String institutecode;
    @Basic(optional = false)
    @Column(name = "PROGRAMTYPE")
    private String programtype;
    @Basic(optional = false)
    @Column(name = "PROGRAMCODE")
    private String programcode;
    @Basic(optional = false)
    @Column(name = "BRANCHCODE")
    private String branchcode;

    public CInstituteBranchTaggingPK() {
    }

    public CInstituteBranchTaggingPK(String institutecode, String programtype, String programcode, String branchcode) {
        this.institutecode = institutecode;
        this.programtype = programtype;
        this.programcode = programcode;
        this.branchcode = branchcode;
    }

    public String getInstitutecode() {
        return institutecode;
    }

    public void setInstitutecode(String institutecode) {
        this.institutecode = institutecode;
    }

    public String getProgramtype() {
        return programtype;
    }

    public void setProgramtype(String programtype) {
        this.programtype = programtype;
    }

    public String getProgramcode() {
        return programcode;
    }

    public void setProgramcode(String programcode) {
        this.programcode = programcode;
    }

    public String getBranchcode() {
        return branchcode;
    }

    public void setBranchcode(String branchcode) {
        this.branchcode = branchcode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (institutecode != null ? institutecode.hashCode() : 0);
        hash += (programtype != null ? programtype.hashCode() : 0);
        hash += (programcode != null ? programcode.hashCode() : 0);
        hash += (branchcode != null ? branchcode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CInstituteBranchTaggingPK)) {
            return false;
        }
        CInstituteBranchTaggingPK other = (CInstituteBranchTaggingPK) object;
        if ((this.institutecode == null && other.institutecode != null) || (this.institutecode != null && !this.institutecode.equals(other.institutecode))) {
            return false;
        }
        if ((this.programtype == null && other.programtype != null) || (this.programtype != null && !this.programtype.equals(other.programtype))) {
            return false;
        }
        if ((this.programcode == null && other.programcode != null) || (this.programcode != null && !this.programcode.equals(other.programcode))) {
            return false;
        }
        if ((this.branchcode == null && other.branchcode != null) || (this.branchcode != null && !this.branchcode.equals(other.branchcode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jilit.clxacademics.model.CInstituteBranchTaggingPK[ institutecode=" + institutecode + ", programtype=" + programtype + ", programcode=" + programcode + ", branchcode=" + branchcode + " ]";
    }
    
}
