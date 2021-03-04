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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author birampal.singh
 */
@Entity
@Table(name = "STATEMASTER")
@XmlRootElement
/*@NamedQueries({
    @NamedQuery(name = "Statemaster.findAll", query = "SELECT s FROM Statemaster s"),
    @NamedQuery(name = "Statemaster.findByCountryid", query = "SELECT s FROM Statemaster s WHERE s.statemasterPK.countryid = :countryid"),
    @NamedQuery(name = "Statemaster.findByStateid", query = "SELECT s FROM Statemaster s WHERE s.statemasterPK.stateid = :stateid"),
    @NamedQuery(name = "Statemaster.findByStatecode", query = "SELECT s FROM Statemaster s WHERE s.statecode = :statecode"),
    @NamedQuery(name = "Statemaster.findByStatename", query = "SELECT s FROM Statemaster s WHERE s.statename = :statename"),
    @NamedQuery(name = "Statemaster.findBySeqid", query = "SELECT s FROM Statemaster s WHERE s.seqid = :seqid"),
    @NamedQuery(name = "Statemaster.findByDeactive", query = "SELECT s FROM Statemaster s WHERE s.deactive = :deactive")})*/
public class StateMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StateMasterPK statemasterPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "STATECODE")
    private String statecode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "STATENAME")
    private String statename;
    @Column(name = "SEQID")
    private Short seqid;
    @Size(max = 1)
    @Column(name = "DEACTIVE")
    private String deactive;
    @JoinColumn(name = "COUNTRYID", referencedColumnName = "COUNTRYID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private CountryMaster countrymaster;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "statemaster")
    private Collection<CityMaster> citymasterCollection;

    public StateMaster() {
    }

    public StateMaster(StateMasterPK statemasterPK) {
        this.statemasterPK = statemasterPK;
    }

    public StateMaster(StateMasterPK statemasterPK, String statecode, String statename) {
        this.statemasterPK = statemasterPK;
        this.statecode = statecode;
        this.statename = statename;
    }

    public StateMaster(String countryid, String stateid) {
        this.statemasterPK = new StateMasterPK(countryid, stateid);
    }

    public StateMasterPK getStatemasterPK() {
        return statemasterPK;
    }

    public void setStatemasterPK(StateMasterPK statemasterPK) {
        this.statemasterPK = statemasterPK;
    }

    public String getStatecode() {
        return statecode;
    }

    public void setStatecode(String statecode) {
        this.statecode = statecode;
    }

    public String getStatename() {
        return statename;
    }

    public void setStatename(String statename) {
        this.statename = statename;
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

    public CountryMaster getCountrymaster() {
        return countrymaster;
    }

    public void setCountrymaster(CountryMaster countrymaster) {
        this.countrymaster = countrymaster;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<CityMaster> getCitymasterCollection() {
        return citymasterCollection;
    }

    public void setCitymasterCollection(Collection<CityMaster> citymasterCollection) {
        this.citymasterCollection = citymasterCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (statemasterPK != null ? statemasterPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StateMaster)) {
            return false;
        }
        StateMaster other = (StateMaster) object;
        if ((this.statemasterPK == null && other.statemasterPK != null) || (this.statemasterPK != null && !this.statemasterPK.equals(other.statemasterPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jilit.clxacademics.model.Statemaster[ statemasterPK=" + statemasterPK + " ]";
    }
    
}
