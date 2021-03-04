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
public class CCategoryAppliedForPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "INSTITUTECODE")
    private String institutecode;
    @Basic(optional = false)
    @Column(name = "COUNSELLINGID")
    private String counsellingid;
    @Basic(optional = false)
    @Column(name = "PROGRAMTYPE")
    private String programtype;
    @Basic(optional = false)
    @Column(name = "RANK")
    private String rank;
    @Basic(optional = false)
    @Column(name = "CHOICENO")
    private short choiceno;

    public CCategoryAppliedForPK() {
    }

    public CCategoryAppliedForPK(String institutecode, String counsellingid, String programtype, String rank, short choiceno) {
        this.institutecode = institutecode;
        this.counsellingid = counsellingid;
        this.programtype = programtype;
        this.rank = rank;
        this.choiceno = choiceno;
    }

    public String getInstitutecode() {
        return institutecode;
    }

    public void setInstitutecode(String institutecode) {
        this.institutecode = institutecode;
    }

    public String getCounsellingid() {
        return counsellingid;
    }

    public void setCounsellingid(String counsellingid) {
        this.counsellingid = counsellingid;
    }

    public String getProgramtype() {
        return programtype;
    }

    public void setProgramtype(String programtype) {
        this.programtype = programtype;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public short getChoiceno() {
        return choiceno;
    }

    public void setChoiceno(short choiceno) {
        this.choiceno = choiceno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (institutecode != null ? institutecode.hashCode() : 0);
        hash += (counsellingid != null ? counsellingid.hashCode() : 0);
        hash += (programtype != null ? programtype.hashCode() : 0);
        hash += (rank != null ? rank.hashCode() : 0);
        hash += (int) choiceno;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CCategoryAppliedForPK)) {
            return false;
        }
        CCategoryAppliedForPK other = (CCategoryAppliedForPK) object;
        if ((this.institutecode == null && other.institutecode != null) || (this.institutecode != null && !this.institutecode.equals(other.institutecode))) {
            return false;
        }
        if ((this.counsellingid == null && other.counsellingid != null) || (this.counsellingid != null && !this.counsellingid.equals(other.counsellingid))) {
            return false;
        }
        if ((this.programtype == null && other.programtype != null) || (this.programtype != null && !this.programtype.equals(other.programtype))) {
            return false;
        }
        if ((this.rank == null && other.rank != null) || (this.rank != null && !this.rank.equals(other.rank))) {
            return false;
        }
        if (this.choiceno != other.choiceno) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jilit.clxacademics.model.CCategoryAppliedForPK[ institutecode=" + institutecode + ", counsellingid=" + counsellingid + ", programtype=" + programtype + ", rank=" + rank + ", choiceno=" + choiceno + " ]";
    }
    
}
