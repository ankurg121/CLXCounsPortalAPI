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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Anubhav
 */
@Entity
@Table(name = "C#HOSTELTYPE")
@NamedQueries({
    @NamedQuery(name = "CHostelType.findAll", query = "SELECT c FROM CHostelType c")})
public class CHostelType implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CHostelTypePK cHostelTypePK;
    @Basic(optional = false)
    @Column(name = "HOSTELDESC")
    private String hosteldesc;
    @Column(name = "SHORTNAME")
    private String shortname;
    @Column(name = "DEACTIVE")
    private String deactive;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "cHostelType")
    private CInstituteHostelTagging cInstituteHostelTagging;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cHostelType")
    private Collection<CHostelMaster> cHostelMasterCollection;
    @JoinColumn(name = "INSTITUTECODE", referencedColumnName = "INSTITUTECODE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private CInstituteMaster cInstituteMaster;

    public CHostelType() {
    }

    public CHostelType(CHostelTypePK cHostelTypePK) {
        this.cHostelTypePK = cHostelTypePK;
    }

    public CHostelType(CHostelTypePK cHostelTypePK, String hosteldesc) {
        this.cHostelTypePK = cHostelTypePK;
        this.hosteldesc = hosteldesc;
    }

    public CHostelType(String institutecode, String hosteltype) {
        this.cHostelTypePK = new CHostelTypePK(institutecode, hosteltype);
    }

    public CHostelTypePK getCHostelTypePK() {
        return cHostelTypePK;
    }

    public void setCHostelTypePK(CHostelTypePK cHostelTypePK) {
        this.cHostelTypePK = cHostelTypePK;
    }

    public String getHosteldesc() {
        return hosteldesc;
    }

    public void setHosteldesc(String hosteldesc) {
        this.hosteldesc = hosteldesc;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getDeactive() {
        return deactive;
    }

    public void setDeactive(String deactive) {
        this.deactive = deactive;
    }

    public CInstituteHostelTagging getCInstituteHostelTagging() {
        return cInstituteHostelTagging;
    }

    public void setCInstituteHostelTagging(CInstituteHostelTagging cInstituteHostelTagging) {
        this.cInstituteHostelTagging = cInstituteHostelTagging;
    }

    public Collection<CHostelMaster> getCHostelMasterCollection() {
        return cHostelMasterCollection;
    }

    public void setCHostelMasterCollection(Collection<CHostelMaster> cHostelMasterCollection) {
        this.cHostelMasterCollection = cHostelMasterCollection;
    }

    public CInstituteMaster getCInstituteMaster() {
        return cInstituteMaster;
    }

    public void setCInstituteMaster(CInstituteMaster cInstituteMaster) {
        this.cInstituteMaster = cInstituteMaster;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cHostelTypePK != null ? cHostelTypePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CHostelType)) {
            return false;
        }
        CHostelType other = (CHostelType) object;
        if ((this.cHostelTypePK == null && other.cHostelTypePK != null) || (this.cHostelTypePK != null && !this.cHostelTypePK.equals(other.cHostelTypePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jilit.clxacademics.model.CHostelType[ cHostelTypePK=" + cHostelTypePK + " ]";
    }
    
}
