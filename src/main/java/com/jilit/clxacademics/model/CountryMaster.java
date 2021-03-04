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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author ashok.singh
 */
@Entity
@Table(name = "COUNTRYMASTER")
@XmlRootElement
/*@NamedQueries({
    @NamedQuery(name = "Countrymaster.findAll", query = "SELECT c FROM Countrymaster c"),
    @NamedQuery(name = "Countrymaster.findByCountryid", query = "SELECT c FROM Countrymaster c WHERE c.countryid = :countryid"),
    @NamedQuery(name = "Countrymaster.findByCountrycode", query = "SELECT c FROM Countrymaster c WHERE c.countrycode = :countrycode"),
    @NamedQuery(name = "Countrymaster.findByCountryname", query = "SELECT c FROM Countrymaster c WHERE c.countryname = :countryname"),
    @NamedQuery(name = "Countrymaster.findBySeqid", query = "SELECT c FROM Countrymaster c WHERE c.seqid = :seqid"),
    @NamedQuery(name = "Countrymaster.findByDeactive", query = "SELECT c FROM Countrymaster c WHERE c.deactive = :deactive")})*/
public class CountryMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "COUNTRYID")
    private String countryid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "COUNTRYCODE")
    private String countrycode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "COUNTRYNAME")
    private String countryname;
    @Column(name = "SEQID")
    private Short seqid;
    @Size(max = 1)
    @Column(name = "DEACTIVE")
    private String deactive;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "countrymaster")
    private Collection<StateMaster> statemasterCollection;

    public CountryMaster() {
    }

    public CountryMaster(String countryid) {
        this.countryid = countryid;
    }

    public CountryMaster(String countryid, String countrycode, String countryname) {
        this.countryid = countryid;
        this.countrycode = countrycode;
        this.countryname = countryname;
    }

    public String getCountryid() {
        return countryid;
    }

    public void setCountryid(String countryid) {
        this.countryid = countryid;
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

    @XmlTransient
    @JsonIgnore
    public Collection<StateMaster> getStatemasterCollection() {
        return statemasterCollection;
    }

    public void setStatemasterCollection(Collection<StateMaster> statemasterCollection) {
        this.statemasterCollection = statemasterCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (countryid != null ? countryid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CountryMaster)) {
            return false;
        }
        CountryMaster other = (CountryMaster) object;
        if ((this.countryid == null && other.countryid != null) || (this.countryid != null && !this.countryid.equals(other.countryid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jilit.clxacademics.model.CountryMaster[ countryid=" + countryid + " ]";
    }
    
}
