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
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Anubhav
 */
@Entity
@Table(name = "C#COUNTRYMASTER")
@NamedQueries({
    @NamedQuery(name = "CCountryMaster.findAll", query = "SELECT c FROM CCountryMaster c")})
public class CCountryMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COUNTRYCODE")
    private String countrycode;
    @Column(name = "COUNTRYNAME")
    private String countryname;
    @Column(name = "DEACTIVE")
    private Character deactive;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cCountryMaster")
    private Collection<CStateMaster> cStateMasterCollection;

    public CCountryMaster() {
    }

    public CCountryMaster(String countrycode) {
        this.countrycode = countrycode;
    }

    public String getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

    public String getCountryname() {
        return countryname;
    }

    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }

    public Character getDeactive() {
        return deactive;
    }

    public void setDeactive(Character deactive) {
        this.deactive = deactive;
    }

    public Collection<CStateMaster> getCStateMasterCollection() {
        return cStateMasterCollection;
    }

    public void setCStateMasterCollection(Collection<CStateMaster> cStateMasterCollection) {
        this.cStateMasterCollection = cStateMasterCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (countrycode != null ? countrycode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CCountryMaster)) {
            return false;
        }
        CCountryMaster other = (CCountryMaster) object;
        if ((this.countrycode == null && other.countrycode != null) || (this.countrycode != null && !this.countrycode.equals(other.countrycode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jilit.clxacademics.model.CCountryMaster[ countrycode=" + countrycode + " ]";
    }
    
}
