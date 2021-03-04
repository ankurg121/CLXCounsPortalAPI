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
public class CProgramMasterPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "PROGRAMTYPE")
    private String programtype;
    @Basic(optional = false)
    @Column(name = "PROGRAMCODE")
    private String programcode;

    public CProgramMasterPK() {
    }

    public CProgramMasterPK(String programtype, String programcode) {
        this.programtype = programtype;
        this.programcode = programcode;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (programtype != null ? programtype.hashCode() : 0);
        hash += (programcode != null ? programcode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CProgramMasterPK)) {
            return false;
        }
        CProgramMasterPK other = (CProgramMasterPK) object;
        if ((this.programtype == null && other.programtype != null) || (this.programtype != null && !this.programtype.equals(other.programtype))) {
            return false;
        }
        if ((this.programcode == null && other.programcode != null) || (this.programcode != null && !this.programcode.equals(other.programcode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jilit.clxacademics.model.CProgramMasterPK[ programtype=" + programtype + ", programcode=" + programcode + " ]";
    }
    
}
