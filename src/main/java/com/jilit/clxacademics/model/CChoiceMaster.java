/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jilit.clxacademics.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Anubhav
 */
@Entity
@Table(name = "C#CHOICEMASTER")
@NamedQueries({
    @NamedQuery(name = "CChoiceMaster.findAll", query = "SELECT c FROM CChoiceMaster c")})
public class CChoiceMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CChoiceMasterPK cChoiceMasterPK;
    @Basic(optional = false)
    @Column(name = "INSTITUTECODE")
    private String institutecode;
    @Column(name = "BRANCHALLOTED")
    private Character branchalloted;
    @Column(name = "ALLOTEDINSTITUTE")
    private String allotedinstitute;
    @Column(name = "LOCATIONCODE")
    private String locationcode;
    @Column(name = "COUNSELLINGDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date counsellingdate;
    @Column(name = "ALLOCATIONFROMCATEGORY")
    private String allocationfromcategory;
    @Column(name = "DEACTIVE")
    private String deactive;
    @Column(name = "ENTRYBY")
    private String entryby;
    @Column(name = "ENTRYDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date entrydate;
    @JoinColumns({
        @JoinColumn(name = "PROGRAMTYPE", referencedColumnName = "PROGRAMTYPE", insertable = false, updatable = false)
        , @JoinColumn(name = "PROGRAMCODE", referencedColumnName = "PROGRAMCODE", insertable = false, updatable = false)
        , @JoinColumn(name = "BRANCHCODE", referencedColumnName = "BRANCHCODE", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private CBranchMaster cBranchMaster;

    public CChoiceMaster() {
    }

    public CChoiceMaster(CChoiceMasterPK cChoiceMasterPK) {
        this.cChoiceMasterPK = cChoiceMasterPK;
    }

    public CChoiceMaster(CChoiceMasterPK cChoiceMasterPK, String institutecode) {
        this.cChoiceMasterPK = cChoiceMasterPK;
        this.institutecode = institutecode;
    }

    public CChoiceMaster(String counsellingid, short counsellingno, String rank, short choiceno, String programtype, String programcode, String branchcode, String alpha) {
        this.cChoiceMasterPK = new CChoiceMasterPK(counsellingid, counsellingno, rank, choiceno, programtype, programcode, branchcode, alpha);
    }

    public CChoiceMasterPK getCChoiceMasterPK() {
        return cChoiceMasterPK;
    }

    public void setCChoiceMasterPK(CChoiceMasterPK cChoiceMasterPK) {
        this.cChoiceMasterPK = cChoiceMasterPK;
    }

    public String getInstitutecode() {
        return institutecode;
    }

    public void setInstitutecode(String institutecode) {
        this.institutecode = institutecode;
    }

    public Character getBranchalloted() {
        return branchalloted;
    }

    public void setBranchalloted(Character branchalloted) {
        this.branchalloted = branchalloted;
    }

    public String getAllotedinstitute() {
        return allotedinstitute;
    }

    public void setAllotedinstitute(String allotedinstitute) {
        this.allotedinstitute = allotedinstitute;
    }

    public String getLocationcode() {
        return locationcode;
    }

    public void setLocationcode(String locationcode) {
        this.locationcode = locationcode;
    }

    public Date getCounsellingdate() {
        return counsellingdate;
    }

    public void setCounsellingdate(Date counsellingdate) {
        this.counsellingdate = counsellingdate;
    }

    public String getAllocationfromcategory() {
        return allocationfromcategory;
    }

    public void setAllocationfromcategory(String allocationfromcategory) {
        this.allocationfromcategory = allocationfromcategory;
    }

    public String getDeactive() {
        return deactive;
    }

    public void setDeactive(String deactive) {
        this.deactive = deactive;
    }

    public String getEntryby() {
        return entryby;
    }

    public void setEntryby(String entryby) {
        this.entryby = entryby;
    }

    public Date getEntrydate() {
        return entrydate;
    }

    public void setEntrydate(Date entrydate) {
        this.entrydate = entrydate;
    }

    public CBranchMaster getCBranchMaster() {
        return cBranchMaster;
    }

    public void setCBranchMaster(CBranchMaster cBranchMaster) {
        this.cBranchMaster = cBranchMaster;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cChoiceMasterPK != null ? cChoiceMasterPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CChoiceMaster)) {
            return false;
        }
        CChoiceMaster other = (CChoiceMaster) object;
        if ((this.cChoiceMasterPK == null && other.cChoiceMasterPK != null) || (this.cChoiceMasterPK != null && !this.cChoiceMasterPK.equals(other.cChoiceMasterPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jilit.clxacademics.model.CChoiceMaster[ cChoiceMasterPK=" + cChoiceMasterPK + " ]";
    }
    
}
