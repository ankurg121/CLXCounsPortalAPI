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
 * @author Sushil
 */
@Entity
@Table(name = "C#CATEGORYAPPLIEDFOR")
public class CCategoryAppliedFor implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CCategoryAppliedForPK cCategoryAppliedForPK;
    @Basic(optional = false)
    @Column(name = "CATEGORY")
    private String category;
    @Column(name = "DEACTIVE")
    private String deactive;
    @Basic(optional = false)
    @Column(name = "ELIGIBLE")
    private String eligible;
    @JoinColumns({
        @JoinColumn(name = "INSTITUTECODE", referencedColumnName = "INSTITUTECODE", insertable = false, updatable = false)
        , @JoinColumn(name = "COUNSELLINGID", referencedColumnName = "COUNSELLINGID", insertable = false, updatable = false)
        , @JoinColumn(name = "PROGRAMTYPE", referencedColumnName = "PROGRAMTYPE", insertable = false, updatable = false)
        , @JoinColumn(name = "RANK", referencedColumnName = "RANK", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private CStudentMaster cStudentMaster;

    public CCategoryAppliedFor() {
    }

    public CCategoryAppliedFor(CCategoryAppliedForPK cCategoryAppliedForPK) {
        this.cCategoryAppliedForPK = cCategoryAppliedForPK;
    }

    public CCategoryAppliedFor(CCategoryAppliedForPK cCategoryAppliedForPK, String category, String eligible) {
        this.cCategoryAppliedForPK = cCategoryAppliedForPK;
        this.category = category;
        this.eligible = eligible;
    }

    public CCategoryAppliedFor(String institutecode, String counsellingid, String programtype, String rank, short choiceno) {
        this.cCategoryAppliedForPK = new CCategoryAppliedForPK(institutecode, counsellingid, programtype, rank, choiceno);
    }

    public CCategoryAppliedForPK getCCategoryAppliedForPK() {
        return cCategoryAppliedForPK;
    }

    public void setCCategoryAppliedForPK(CCategoryAppliedForPK cCategoryAppliedForPK) {
        this.cCategoryAppliedForPK = cCategoryAppliedForPK;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDeactive() {
        return deactive;
    }

    public void setDeactive(String deactive) {
        this.deactive = deactive;
    }

    public String getEligible() {
        return eligible;
    }

    public void setEligible(String eligible) {
        this.eligible = eligible;
    }

    public CStudentMaster getCStudentMaster() {
        return cStudentMaster;
    }

    public void setCStudentMaster(CStudentMaster cStudentMaster) {
        this.cStudentMaster = cStudentMaster;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cCategoryAppliedForPK != null ? cCategoryAppliedForPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CCategoryAppliedFor)) {
            return false;
        }
        CCategoryAppliedFor other = (CCategoryAppliedFor) object;
        if ((this.cCategoryAppliedForPK == null && other.cCategoryAppliedForPK != null) || (this.cCategoryAppliedForPK != null && !this.cCategoryAppliedForPK.equals(other.cCategoryAppliedForPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jilit.clxacademics.model.CCategoryAppliedFor[ cCategoryAppliedForPK=" + cCategoryAppliedForPK + " ]";
    }
    
}
