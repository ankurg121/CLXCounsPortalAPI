/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jilit.clxacademics.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Anubhav
 */
@Entity
@Table(name = "C#SEATMASTER")
@NamedQueries({
    @NamedQuery(name = "CSeatMaster.findAll", query = "SELECT c FROM CSeatMaster c")})
public class CSeatMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CSeatMasterPK cSeatMasterPK;
    @Basic(optional = false)
    @Column(name = "ALPHA")
    private String alpha;
    @Basic(optional = false)
    @Column(name = "NOOFSEATS")
    private short noofseats;
    @Column(name = "ALLOTEDSEATS")
    private Short allotedseats;
    @Column(name = "DEACTIVE")
    private String deactive;
    @JoinColumn(name = "CATEGORYCODE", referencedColumnName = "CATEGORYCODE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private CCategoryMaster cCategoryMaster;
    @JoinColumns({
        @JoinColumn(name = "INSTITUTECODE", referencedColumnName = "INSTITUTECODE", insertable = false, updatable = false)
        , @JoinColumn(name = "PROGRAMTYPE", referencedColumnName = "PROGRAMTYPE", insertable = false, updatable = false)
        , @JoinColumn(name = "PROGRAMCODE", referencedColumnName = "PROGRAMCODE", insertable = false, updatable = false)
        , @JoinColumn(name = "BRANCHCODE", referencedColumnName = "BRANCHCODE", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private CInstituteBranchTagging cInstituteBranchTagging;

    public CSeatMaster() {
    }

    public CSeatMaster(CSeatMasterPK cSeatMasterPK) {
        this.cSeatMasterPK = cSeatMasterPK;
    }

    public CSeatMaster(CSeatMasterPK cSeatMasterPK, String alpha, short noofseats) {
        this.cSeatMasterPK = cSeatMasterPK;
        this.alpha = alpha;
        this.noofseats = noofseats;
    }

    public CSeatMaster(String institutecode, String programtype, String programcode, String branchcode, String categorycode) {
        this.cSeatMasterPK = new CSeatMasterPK(institutecode, programtype, programcode, branchcode, categorycode);
    }

    public CSeatMasterPK getCSeatMasterPK() {
        return cSeatMasterPK;
    }

    public void setCSeatMasterPK(CSeatMasterPK cSeatMasterPK) {
        this.cSeatMasterPK = cSeatMasterPK;
    }

    public String getAlpha() {
        return alpha;
    }

    public void setAlpha(String alpha) {
        this.alpha = alpha;
    }

    public short getNoofseats() {
        return noofseats;
    }

    public void setNoofseats(short noofseats) {
        this.noofseats = noofseats;
    }

    public Short getAllotedseats() {
        return allotedseats;
    }

    public void setAllotedseats(Short allotedseats) {
        this.allotedseats = allotedseats;
    }

    public String getDeactive() {
        return deactive;
    }

    public void setDeactive(String deactive) {
        this.deactive = deactive;
    }

    public CCategoryMaster getCCategoryMaster() {
        return cCategoryMaster;
    }

    public void setCCategoryMaster(CCategoryMaster cCategoryMaster) {
        this.cCategoryMaster = cCategoryMaster;
    }

    public CInstituteBranchTagging getCInstituteBranchTagging() {
        return cInstituteBranchTagging;
    }

    public void setCInstituteBranchTagging(CInstituteBranchTagging cInstituteBranchTagging) {
        this.cInstituteBranchTagging = cInstituteBranchTagging;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cSeatMasterPK != null ? cSeatMasterPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CSeatMaster)) {
            return false;
        }
        CSeatMaster other = (CSeatMaster) object;
        if ((this.cSeatMasterPK == null && other.cSeatMasterPK != null) || (this.cSeatMasterPK != null && !this.cSeatMasterPK.equals(other.cSeatMasterPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jilit.clxacademics.model.CSeatMaster[ cSeatMasterPK=" + cSeatMasterPK + " ]";
    }
    
}
