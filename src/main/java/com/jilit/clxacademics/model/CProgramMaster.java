/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jilit.clxacademics.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Sushil
 */
@Entity
@Table(name = "C#PROGRAMMASTER")
public class CProgramMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CProgramMasterPK cProgramMasterPK;
    @Basic(optional = false)
    @Column(name = "PROGRAMNAME")
    private String programname;
    @Column(name = "SHORTNAME")
    private String shortname;
    @Column(name = "FEEREQ")
    private String feereq;
    @Column(name = "DEACTIVE")
    private String deactive;
    @Column(name = "SEQID")
    private Short seqid;
//    @JoinColumn(name = "PROGRAMTYPE", referencedColumnName = "PROGRAMTYPE", insertable = false, updatable = false)
//    @ManyToOne(optional = false)
//    private CProgramTypeMaster cProgramTypeMaster;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cProgramMaster")
//    private Collection<CBranchMaster> cBranchMasterCollection;

    public CProgramMaster() {
    }

    public CProgramMaster(CProgramMasterPK cProgramMasterPK) {
        this.cProgramMasterPK = cProgramMasterPK;
    }

    public CProgramMaster(CProgramMasterPK cProgramMasterPK, String programname) {
        this.cProgramMasterPK = cProgramMasterPK;
        this.programname = programname;
    }

    public CProgramMaster(String programtype, String programcode) {
        this.cProgramMasterPK = new CProgramMasterPK(programtype, programcode);
    }

    public CProgramMasterPK getCProgramMasterPK() {
        return cProgramMasterPK;
    }

    public void setCProgramMasterPK(CProgramMasterPK cProgramMasterPK) {
        this.cProgramMasterPK = cProgramMasterPK;
    }

    public String getProgramname() {
        return programname;
    }

    public void setProgramname(String programname) {
        this.programname = programname;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getFeereq() {
        return feereq;
    }

    public void setFeereq(String feereq) {
        this.feereq = feereq;
    }

    public String getDeactive() {
        return deactive;
    }

    public void setDeactive(String deactive) {
        this.deactive = deactive;
    }

    public Short getSeqid() {
        return seqid;
    }

    public void setSeqid(Short seqid) {
        this.seqid = seqid;
    }

//    public CProgramTypeMaster getCProgramTypeMaster() {
//        return cProgramTypeMaster;
//    }
//
//    public void setCProgramTypeMaster(CProgramTypeMaster cProgramTypeMaster) {
//        this.cProgramTypeMaster = cProgramTypeMaster;
//    }
//
//    public Collection<CBranchMaster> getCBranchMasterCollection() {
//        return cBranchMasterCollection;
//    }
//
//    public void setCBranchMasterCollection(Collection<CBranchMaster> cBranchMasterCollection) {
//        this.cBranchMasterCollection = cBranchMasterCollection;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cProgramMasterPK != null ? cProgramMasterPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CProgramMaster)) {
            return false;
        }
        CProgramMaster other = (CProgramMaster) object;
        if ((this.cProgramMasterPK == null && other.cProgramMasterPK != null) || (this.cProgramMasterPK != null && !this.cProgramMasterPK.equals(other.cProgramMasterPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jilit.clxacademics.model.CProgramMaster[ cProgramMasterPK=" + cProgramMasterPK + " ]";
    }
    
}
