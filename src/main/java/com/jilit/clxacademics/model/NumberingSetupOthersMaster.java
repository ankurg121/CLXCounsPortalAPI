/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jilit.clxacademics.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "NUMBERINGSETUPOTHERSMASTER")

public class NumberingSetupOthersMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "PREFIX")
    private String prefix;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NUMBERINGNAME")
    private String numberingname;
    @OneToMany(mappedBy = "numberingSetupOthersMaster")
    private Collection<NumberingSetupOthers> numberingsetupothersCollection;

    public NumberingSetupOthersMaster() {
    }

    public NumberingSetupOthersMaster(String prefix) {
        this.prefix = prefix;
    }

    public NumberingSetupOthersMaster(String prefix, String numberingname) {
        this.prefix = prefix;
        this.numberingname = numberingname;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getNumberingname() {
        return numberingname;
    }

    public void setNumberingname(String numberingname) {
        this.numberingname = numberingname;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<NumberingSetupOthers> getNumberingsetupothersCollection() {
        return numberingsetupothersCollection;
    }

    public void setNumberingsetupothersCollection(Collection<NumberingSetupOthers> numberingsetupothersCollection) {
        this.numberingsetupothersCollection = numberingsetupothersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prefix != null ? prefix.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NumberingSetupOthersMaster)) {
            return false;
        }
        NumberingSetupOthersMaster other = (NumberingSetupOthersMaster) object;
        if ((this.prefix == null && other.prefix != null) || (this.prefix != null && !this.prefix.equals(other.prefix))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jilit.clxacademics.model.Numberingsetupothersmaster[ prefix=" + prefix + " ]";
    }
    
}
