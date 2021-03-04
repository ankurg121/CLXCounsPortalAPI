/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jilit.clxacademics.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
@Table(name = "C#INSTITUTEBRANCHTAGGING")
public class CInstituteBranchTagging implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CInstituteBranchTaggingPK cInstituteBranchTaggingPK;
    @Column(name = "ALPHA")
    private String alpha;
    @Column(name = "SEQID")
    private Short seqid;
    @Column(name = "DEACTIVE")
    private String deactive;
//    @JoinColumns({
//        @JoinColumn(name = "PROGRAMTYPE", referencedColumnName = "PROGRAMTYPE", insertable = false, updatable = false)
//        , @JoinColumn(name = "PROGRAMCODE", referencedColumnName = "PROGRAMCODE", insertable = false, updatable = false)
//        , @JoinColumn(name = "BRANCHCODE", referencedColumnName = "BRANCHCODE", insertable = false, updatable = false)})
//    @ManyToOne(optional = false)
//    private CBranchMaster cBranchMaster;
//    @JoinColumn(name = "INSTITUTECODE", referencedColumnName = "INSTITUTECODE", insertable = false, updatable = false)
//    @ManyToOne(optional = false)
//    private CInstituteMaster cInstituteMaster;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cInstituteBranchTagging")
//    private Collection<CSeatMaster> cSeatMasterCollection;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cInstituteBranchTagging")
//    private Collection<CAllocationDetail> cAllocationDetailCollection;
   // @OneToMany(cascade = CascadeType.ALL, mappedBy = "cInstituteBranchTagging")
   // private Collection<CSeatsTransfer> cSeatsTransferCollection;

    public CInstituteBranchTagging() {
    }

    public CInstituteBranchTagging(CInstituteBranchTaggingPK cInstituteBranchTaggingPK) {
        this.cInstituteBranchTaggingPK = cInstituteBranchTaggingPK;
    }

    public CInstituteBranchTagging(String institutecode, String programtype, String programcode, String branchcode) {
        this.cInstituteBranchTaggingPK = new CInstituteBranchTaggingPK(institutecode, programtype, programcode, branchcode);
    }

    public CInstituteBranchTaggingPK getCInstituteBranchTaggingPK() {
        return cInstituteBranchTaggingPK;
    }

    public void setCInstituteBranchTaggingPK(CInstituteBranchTaggingPK cInstituteBranchTaggingPK) {
        this.cInstituteBranchTaggingPK = cInstituteBranchTaggingPK;
    }

    public String getAlpha() {
        return alpha;
    }

    public void setAlpha(String alpha) {
        this.alpha = alpha;
    }

    public Short getSeqid() {
        return seqid;
    }

    public void setSeqid(Short seqid) {
        this.seqid = seqid;
    }

    public String getDeactive() {
        return deactive;
    }

    public void setDeactive(String deactive) {
        this.deactive = deactive;
    }

//    public CBranchMaster getCBranchMaster() {
//        return cBranchMaster;
//    }
//
//    public void setCBranchMaster(CBranchMaster cBranchMaster) {
//        this.cBranchMaster = cBranchMaster;
//    }
//
//    public CInstituteMaster getCInstituteMaster() {
//        return cInstituteMaster;
//    }
//
//    public void setCInstituteMaster(CInstituteMaster cInstituteMaster) {
//        this.cInstituteMaster = cInstituteMaster;
//    }

//    public Collection<CSeatMaster> getCSeatMasterCollection() {
//        return cSeatMasterCollection;
//    }
//
//    public void setCSeatMasterCollection(Collection<CSeatMaster> cSeatMasterCollection) {
//        this.cSeatMasterCollection = cSeatMasterCollection;
//    }
//
//    public Collection<CAllocationDetail> getCAllocationDetailCollection() {
//        return cAllocationDetailCollection;
//    }
//
//    public void setCAllocationDetailCollection(Collection<CAllocationDetail> cAllocationDetailCollection) {
//        this.cAllocationDetailCollection = cAllocationDetailCollection;
//    }

//    public Collection<CSeatsTransfer> getCSeatsTransferCollection() {
//        return cSeatsTransferCollection;
//    }
//
//    public void setCSeatsTransferCollection(Collection<CSeatsTransfer> cSeatsTransferCollection) {
//        this.cSeatsTransferCollection = cSeatsTransferCollection;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cInstituteBranchTaggingPK != null ? cInstituteBranchTaggingPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CInstituteBranchTagging)) {
            return false;
        }
        CInstituteBranchTagging other = (CInstituteBranchTagging) object;
        if ((this.cInstituteBranchTaggingPK == null && other.cInstituteBranchTaggingPK != null) || (this.cInstituteBranchTaggingPK != null && !this.cInstituteBranchTaggingPK.equals(other.cInstituteBranchTaggingPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jilit.clxacademics.model.CInstituteBranchTagging[ cInstituteBranchTaggingPK=" + cInstituteBranchTaggingPK + " ]";
    }
    
}
