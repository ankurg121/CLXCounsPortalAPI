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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author birampal.singh
 */
@Embeddable
public class StateMasterPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "COUNTRYID")
    private String countryid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "STATEID")
    private String stateid;

    public StateMasterPK() {
    }

    public StateMasterPK(String countryid, String stateid) {
        this.countryid = countryid;
        this.stateid = stateid;
    }

    public String getCountryid() {
        return countryid;
    }

    public void setCountryid(String countryid) {
        this.countryid = countryid;
    }

    public String getStateid() {
        return stateid;
    }

    public void setStateid(String stateid) {
        this.stateid = stateid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (countryid != null ? countryid.hashCode() : 0);
        hash += (stateid != null ? stateid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StateMasterPK)) {
            return false;
        }
        StateMasterPK other = (StateMasterPK) object;
        if ((this.countryid == null && other.countryid != null) || (this.countryid != null && !this.countryid.equals(other.countryid))) {
            return false;
        }
        if ((this.stateid == null && other.stateid != null) || (this.stateid != null && !this.stateid.equals(other.stateid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jilit.clxacademics.model.StatemasterPK[ countryid=" + countryid + ", stateid=" + stateid + " ]";
    }
    
}
