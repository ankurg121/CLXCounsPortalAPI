/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jilit.clxacademics.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Anubhav
 */
@Embeddable
public class CStateMasterPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "COUNTRYCODE")
    private String countrycode;
    @Basic(optional = false)
    @Column(name = "STATECODE")
    private String statecode;

    public CStateMasterPK() {
    }

    public CStateMasterPK(String countrycode, String statecode) {
        this.countrycode = countrycode;
        this.statecode = statecode;
    }

    public String getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

    public String getStatecode() {
        return statecode;
    }

    public void setStatecode(String statecode) {
        this.statecode = statecode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (countrycode != null ? countrycode.hashCode() : 0);
        hash += (statecode != null ? statecode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CStateMasterPK)) {
            return false;
        }
        CStateMasterPK other = (CStateMasterPK) object;
        if ((this.countrycode == null && other.countrycode != null) || (this.countrycode != null && !this.countrycode.equals(other.countrycode))) {
            return false;
        }
        if ((this.statecode == null && other.statecode != null) || (this.statecode != null && !this.statecode.equals(other.statecode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jilit.clxacademics.model.CStateMasterPK[ countrycode=" + countrycode + ", statecode=" + statecode + " ]";
    }
    
}
