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
public class CChoiceMasterPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "COUNSELLINGID")
    private String counsellingid;
    @Basic(optional = false)
    @Column(name = "COUNSELLINGNO")
    private short counsellingno;
    @Basic(optional = false)
    @Column(name = "RANK")
    private String rank;
    @Basic(optional = false)
    @Column(name = "CHOICENO")
    private short choiceno;
    @Basic(optional = false)
    @Column(name = "PROGRAMTYPE")
    private String programtype;
    @Basic(optional = false)
    @Column(name = "PROGRAMCODE")
    private String programcode;
    @Basic(optional = false)
    @Column(name = "BRANCHCODE")
    private String branchcode;
    @Basic(optional = false)
    @Column(name = "ALPHA")
    private String alpha;

    public CChoiceMasterPK() {
    }

    public CChoiceMasterPK(String counsellingid, short counsellingno, String rank, short choiceno, String programtype, String programcode, String branchcode, String alpha) {
        this.counsellingid = counsellingid;
        this.counsellingno = counsellingno;
        this.rank = rank;
        this.choiceno = choiceno;
        this.programtype = programtype;
        this.programcode = programcode;
        this.branchcode = branchcode;
        this.alpha = alpha;
    }

    public String getCounsellingid() {
        return counsellingid;
    }

    public void setCounsellingid(String counsellingid) {
        this.counsellingid = counsellingid;
    }

    public short getCounsellingno() {
        return counsellingno;
    }

    public void setCounsellingno(short counsellingno) {
        this.counsellingno = counsellingno;
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

    public String getAlpha() {
        return alpha;
    }

    public void setAlpha(String alpha) {
        this.alpha = alpha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (counsellingid != null ? counsellingid.hashCode() : 0);
        hash += (int) counsellingno;
        hash += (rank != null ? rank.hashCode() : 0);
        hash += (int) choiceno;
        hash += (programtype != null ? programtype.hashCode() : 0);
        hash += (programcode != null ? programcode.hashCode() : 0);
        hash += (branchcode != null ? branchcode.hashCode() : 0);
        hash += (alpha != null ? alpha.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CChoiceMasterPK)) {
            return false;
        }
        CChoiceMasterPK other = (CChoiceMasterPK) object;
        if ((this.counsellingid == null && other.counsellingid != null) || (this.counsellingid != null && !this.counsellingid.equals(other.counsellingid))) {
            return false;
        }
        if (this.counsellingno != other.counsellingno) {
            return false;
        }
        if ((this.rank == null && other.rank != null) || (this.rank != null && !this.rank.equals(other.rank))) {
            return false;
        }
        if (this.choiceno != other.choiceno) {
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
        if ((this.alpha == null && other.alpha != null) || (this.alpha != null && !this.alpha.equals(other.alpha))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jilit.clxacademics.model.CChoiceMasterPK[ counsellingid=" + counsellingid + ", counsellingno=" + counsellingno + ", rank=" + rank + ", choiceno=" + choiceno + ", programtype=" + programtype + ", programcode=" + programcode + ", branchcode=" + branchcode + ", alpha=" + alpha + " ]";
    }
    
}
