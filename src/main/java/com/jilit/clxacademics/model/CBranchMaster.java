/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jilit.clxacademics.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Sushil
 */
@Entity
@Table(name = "C#BRANCHMASTER")
public class CBranchMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CBranchMasterPK cBranchMasterPK;
    @Column(name = "BRANCHDESC")
    private String branchdesc;
    @Column(name = "DEACTIVE")
    private String deactive;
    @Column(name = "SEQID")
    private Short seqid;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cBranchMaster")
//    private Collection<CChoiceMaster> cChoiceMasterCollection;
//    @JoinColumns({
//        @JoinColumn(name = "PROGRAMTYPE", referencedColumnName = "PROGRAMTYPE", insertable = false, updatable = false)
//        , @JoinColumn(name = "PROGRAMCODE", referencedColumnName = "PROGRAMCODE", insertable = false, updatable = false)})
//    @ManyToOne(optional = false)
//    private CProgramMaster cProgramMaster;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cBranchMaster")
//    private Collection<CInstituteBranchTagging> cInstituteBranchTaggingCollection;

    public CBranchMaster() {
    }

    public CBranchMaster(CBranchMasterPK cBranchMasterPK) {
        this.cBranchMasterPK = cBranchMasterPK;
    }

    public CBranchMaster(String programtype, String programcode, String branchcode) {
        this.cBranchMasterPK = new CBranchMasterPK(programtype, programcode, branchcode);
    }

    public CBranchMasterPK getCBranchMasterPK() {
        return cBranchMasterPK;
    }

    public void setCBranchMasterPK(CBranchMasterPK cBranchMasterPK) {
        this.cBranchMasterPK = cBranchMasterPK;
    }

    public String getBranchdesc() {
        return branchdesc;
    }

    public void setBranchdesc(String branchdesc) {
        this.branchdesc = branchdesc;
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

//    public Collection<CChoiceMaster> getCChoiceMasterCollection() {
//        return cChoiceMasterCollection;
//    }
//
//    public void setCChoiceMasterCollection(Collection<CChoiceMaster> cChoiceMasterCollection) {
//        this.cChoiceMasterCollection = cChoiceMasterCollection;
//    }
//
//    public CProgramMaster getCProgramMaster() {
//        return cProgramMaster;
//    }
//
//    public void setCProgramMaster(CProgramMaster cProgramMaster) {
//        this.cProgramMaster = cProgramMaster;
//    }
//
//    public Collection<CInstituteBranchTagging> getCInstituteBranchTaggingCollection() {
//        return cInstituteBranchTaggingCollection;
//    }
//
//    public void setCInstituteBranchTaggingCollection(Collection<CInstituteBranchTagging> cInstituteBranchTaggingCollection) {
//        this.cInstituteBranchTaggingCollection = cInstituteBranchTaggingCollection;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cBranchMasterPK != null ? cBranchMasterPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CBranchMaster)) {
            return false;
        }
        CBranchMaster other = (CBranchMaster) object;
        if ((this.cBranchMasterPK == null && other.cBranchMasterPK != null) || (this.cBranchMasterPK != null && !this.cBranchMasterPK.equals(other.cBranchMasterPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jilit.clxacademics.model.CBranchMaster[ cBranchMasterPK=" + cBranchMasterPK + " ]";
    }
    
}
