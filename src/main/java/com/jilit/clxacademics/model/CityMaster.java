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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author birampal.singh
 */
@Entity
@Table(name = "CITYMASTER")
public class CityMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CityMasterPK citymasterPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CITYCODE")
    private String citycode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "CITYNAME")
    private String cityname;
    @Column(name = "SEQID")
    private Short seqid;
    @Size(max = 1)
    @Column(name = "DEACTIVE")
    private String deactive;
    @JoinColumns({
        @JoinColumn(name = "COUNTRYID", referencedColumnName = "COUNTRYID", insertable = false, updatable = false),
        @JoinColumn(name = "STATEID", referencedColumnName = "STATEID", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private StateMaster statemaster;

    public CityMaster() {
    }

    public CityMaster(CityMasterPK citymasterPK) {
        this.citymasterPK = citymasterPK;
    }

    public CityMaster(CityMasterPK citymasterPK, String citycode, String cityname) {
        this.citymasterPK = citymasterPK;
        this.citycode = citycode;
        this.cityname = cityname;
    }

    public CityMaster(String countryid, String stateid, String cityid) {
        this.citymasterPK = new CityMasterPK(countryid, stateid, cityid);
    }

    public CityMasterPK getCitymasterPK() {
        return citymasterPK;
    }

    public void setCitymasterPK(CityMasterPK citymasterPK) {
        this.citymasterPK = citymasterPK;
    }

    public String getCitycode() {
        return citycode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public Short getSeqid() {
        return seqid;
    }

    public void setSeqid(Short seqid) {
        this.seqid = seqid;
    }

    public String getDeactive() {
        return deactive;
    }

    public void setDeactive(String deactive) {
        this.deactive = deactive;
    }

    public StateMaster getStatemaster() {
        return statemaster;
    }

    public void setStatemaster(StateMaster statemaster) {
        this.statemaster = statemaster;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (citymasterPK != null ? citymasterPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CityMaster)) {
            return false;
        }
        CityMaster other = (CityMaster) object;
        if ((this.citymasterPK == null && other.citymasterPK != null) || (this.citymasterPK != null && !this.citymasterPK.equals(other.citymasterPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jilit.clxacademics.dto.Citymaster[ citymasterPK=" + citymasterPK + " ]";
    }
    
}
