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
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.stereotype.Component;

/**
 *
 * @author ashok.singh
 */
@Entity
@Component
@Table(name = "IDGENERATIONSETUP")
public class IdGenerationSetup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "IDCODE")
    private String idcode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SLNO")
    private short slno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "IDDESC")
    private String iddesc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "TABLENAME")
    private String tablename;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "MODULECODE")
    private String modulecode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "PREFIX")
    private String prefix;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGenerationSetup")
    private Collection<IdGenerationControl> idGenerationControlCollection;

    public IdGenerationSetup() {
    }

    public IdGenerationSetup(String idcode) {
        this.idcode = idcode;
    }

    public IdGenerationSetup(String idcode, short slno, String iddesc, String tablename, String modulecode, String prefix) {
        this.idcode = idcode;
        this.slno = slno;
        this.iddesc = iddesc;
        this.tablename = tablename;
        this.modulecode = modulecode;
        this.prefix = prefix;
    }

    public String getIdcode() {
        return idcode;
    }

    public void setIdcode(String idcode) {
        this.idcode = idcode;
    }

    public short getSlno() {
        return slno;
    }

    public void setSlno(short slno) {
        this.slno = slno;
    }

    public String getIddesc() {
        return iddesc;
    }

    public void setIddesc(String iddesc) {
        this.iddesc = iddesc;
    }

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename;
    }

    public String getModulecode() {
        return modulecode;
    }

    public void setModulecode(String modulecode) {
        this.modulecode = modulecode;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

	@XmlTransient
    @JsonIgnore

    public Collection<IdGenerationControl> getIdGenerationControlCollection() {
        return idGenerationControlCollection;
    }

    public void setIdGenerationControlCollection(Collection<IdGenerationControl> idGenerationControlCollection) {
        this.idGenerationControlCollection = idGenerationControlCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcode != null ? idcode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IdGenerationSetup)) {
            return false;
        }
        IdGenerationSetup other = (IdGenerationSetup) object;
        if ((this.idcode == null && other.idcode != null) || (this.idcode != null && !this.idcode.equals(other.idcode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jilit.clxacademics.model.IdGenerationSetup[ idcode=" + idcode + " ]";
    }
    
}
