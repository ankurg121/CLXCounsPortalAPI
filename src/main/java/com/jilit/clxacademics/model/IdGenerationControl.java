/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jilit.clxacademics.model;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import org.springframework.stereotype.Component;

/**
*
* @author ashok.singh
*/
@Entity
@Table(name = "IDGENERATIONCONTROL")
@Component
public class IdGenerationControl implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected IdGenerationControlPK id;
    @Size(max = 20)
    @Column(name = "LASTID")
    private String lastid;

    public IdGenerationControlPK getId() {
        return id;
    }

    public void setId(IdGenerationControlPK id) {
        this.id = id;
    }
    @Column(name = "LASTRUNNINGNO")
    private BigInteger lastrunningno;
    @JoinColumn(name = "IDCODE", referencedColumnName = "IDCODE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private IdGenerationSetup idGenerationSetup;

    public IdGenerationControl() {
    }

    public IdGenerationControl(IdGenerationControlPK idGenerationControlPK) {
        this.id = idGenerationControlPK;
    }

    public IdGenerationControl(String icid, String idcode, String year, String month, Character alpha) {
        this.id = new IdGenerationControlPK(icid, idcode, year, month, alpha);
    }

    public IdGenerationControlPK getIdGenerationControlPK() {
        return id;
    }

    public void setIdGenerationControlPK(IdGenerationControlPK idGenerationControlPK) {
        this.id = idGenerationControlPK;
    }

    public String getLastid() {
        return lastid;
    }

    public void setLastid(String lastid) {
        this.lastid = lastid;
    }

    public BigInteger getLastrunningno() {
        return lastrunningno;
    }

    public void setLastrunningno(BigInteger lastrunningno) {
        this.lastrunningno = lastrunningno;
    }

    public IdGenerationSetup getIdGenerationSetup() {
        return idGenerationSetup;
    }

    public void setIdGenerationSetup(IdGenerationSetup idGenerationSetup) {
        this.idGenerationSetup = idGenerationSetup;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IdGenerationControl)) {
            return false;
        }
        IdGenerationControl other = (IdGenerationControl) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jilit.clxacademics.model.IdGenerationControl[ idGenerationControlPK=" + id + " ]";
    }
    
}
