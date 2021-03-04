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
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Anubhav
 */
@Entity
@Table(name = "C#INSTITUTEHOSTELTAGGING")
@NamedQueries({
    @NamedQuery(name = "CInstituteHostelTagging.findAll", query = "SELECT c FROM CInstituteHostelTagging c")})
public class CInstituteHostelTagging implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CInstituteHostelTaggingPK cInstituteHostelTaggingPK;
    @Column(name = "DEACTIVE")
    private String deactive;
    @JoinColumns({
        @JoinColumn(name = "INSTITUTECODE", referencedColumnName = "INSTITUTECODE", insertable = false, updatable = false)
        , @JoinColumn(name = "HOSTELTYPE", referencedColumnName = "HOSTELTYPE", insertable = false, updatable = false)})
    @OneToOne(optional = false)
    private CHostelType cHostelType;

    public CInstituteHostelTagging() {
    }

    public CInstituteHostelTagging(CInstituteHostelTaggingPK cInstituteHostelTaggingPK) {
        this.cInstituteHostelTaggingPK = cInstituteHostelTaggingPK;
    }

    public CInstituteHostelTagging(String institutecode, String hosteltype) {
        this.cInstituteHostelTaggingPK = new CInstituteHostelTaggingPK(institutecode, hosteltype);
    }

    public CInstituteHostelTaggingPK getCInstituteHostelTaggingPK() {
        return cInstituteHostelTaggingPK;
    }

    public void setCInstituteHostelTaggingPK(CInstituteHostelTaggingPK cInstituteHostelTaggingPK) {
        this.cInstituteHostelTaggingPK = cInstituteHostelTaggingPK;
    }

    public String getDeactive() {
        return deactive;
    }

    public void setDeactive(String deactive) {
        this.deactive = deactive;
    }

    public CHostelType getCHostelType() {
        return cHostelType;
    }

    public void setCHostelType(CHostelType cHostelType) {
        this.cHostelType = cHostelType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cInstituteHostelTaggingPK != null ? cInstituteHostelTaggingPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CInstituteHostelTagging)) {
            return false;
        }
        CInstituteHostelTagging other = (CInstituteHostelTagging) object;
        if ((this.cInstituteHostelTaggingPK == null && other.cInstituteHostelTaggingPK != null) || (this.cInstituteHostelTaggingPK != null && !this.cInstituteHostelTaggingPK.equals(other.cInstituteHostelTaggingPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jilit.clxacademics.model.CInstituteHostelTagging[ cInstituteHostelTaggingPK=" + cInstituteHostelTaggingPK + " ]";
    }
    
}
