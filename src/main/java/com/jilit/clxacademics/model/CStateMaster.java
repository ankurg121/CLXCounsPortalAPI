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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Anubhav
 */
@Entity
@Table(name = "C#STATEMASTER")
@NamedQueries({
    @NamedQuery(name = "CStateMaster.findAll", query = "SELECT c FROM CStateMaster c")})
public class CStateMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CStateMasterPK cStateMasterPK;
    @Column(name = "STATENAME")
    private String statename;
    @Column(name = "DEACTIVE")
    private Character deactive;
    @Column(name = "STATESHORTNAME")
    private String stateshortname;
    @JoinColumn(name = "COUNTRYCODE", referencedColumnName = "COUNTRYCODE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private CCountryMaster cCountryMaster;

    public CStateMaster() {
    }

    public CStateMaster(CStateMasterPK cStateMasterPK) {
        this.cStateMasterPK = cStateMasterPK;
    }

    public CStateMaster(String countrycode, String statecode) {
        this.cStateMasterPK = new CStateMasterPK(countrycode, statecode);
    }

    public CStateMasterPK getCStateMasterPK() {
        return cStateMasterPK;
    }

    public void setCStateMasterPK(CStateMasterPK cStateMasterPK) {
        this.cStateMasterPK = cStateMasterPK;
    }

    public String getStatename() {
        return statename;
    }

    public void setStatename(String statename) {
        this.statename = statename;
    }

    public Character getDeactive() {
        return deactive;
    }

    public void setDeactive(Character deactive) {
        this.deactive = deactive;
    }

    public String getStateshortname() {
        return stateshortname;
    }

    public void setStateshortname(String stateshortname) {
        this.stateshortname = stateshortname;
    }

    public CCountryMaster getCCountryMaster() {
        return cCountryMaster;
    }

    public void setCCountryMaster(CCountryMaster cCountryMaster) {
        this.cCountryMaster = cCountryMaster;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cStateMasterPK != null ? cStateMasterPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CStateMaster)) {
            return false;
        }
        CStateMaster other = (CStateMaster) object;
        if ((this.cStateMasterPK == null && other.cStateMasterPK != null) || (this.cStateMasterPK != null && !this.cStateMasterPK.equals(other.cStateMasterPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jilit.clxacademics.model.CStateMaster[ cStateMasterPK=" + cStateMasterPK + " ]";
    }
    
}
