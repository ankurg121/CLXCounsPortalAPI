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
public class CityMasterPK implements Serializable {

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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CITYID")
    private String cityid;

    public CityMasterPK() {
    }

    public CityMasterPK(String countryid, String stateid, String cityid) {
        this.countryid = countryid;
        this.stateid = stateid;
        this.cityid = cityid;
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

    public String getCityid() {
        return cityid;
    }

    public void setCityid(String cityid) {
        this.cityid = cityid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (countryid != null ? countryid.hashCode() : 0);
        hash += (stateid != null ? stateid.hashCode() : 0);
        hash += (cityid != null ? cityid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CityMasterPK)) {
            return false;
        }
        CityMasterPK other = (CityMasterPK) object;
        if ((this.countryid == null && other.countryid != null) || (this.countryid != null && !this.countryid.equals(other.countryid))) {
            return false;
        }
        if ((this.stateid == null && other.stateid != null) || (this.stateid != null && !this.stateid.equals(other.stateid))) {
            return false;
        }
        if ((this.cityid == null && other.cityid != null) || (this.cityid != null && !this.cityid.equals(other.cityid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jilit.clxacademics.model.CitymasterPK[ countryid=" + countryid + ", stateid=" + stateid + ", cityid=" + cityid + " ]";
    }
    
}
