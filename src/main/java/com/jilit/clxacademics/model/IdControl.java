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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

/**
*
* @author ashok.singh
*/
@Entity
@Table(name = "IDCONTROL")
@Component
public class IdControl implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected IdControlPK idControlPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LASTNUMBER")
    private long lastnumber;

    public IdControl() {
    }

    public IdControl(IdControlPK idControlPK) {
        this.idControlPK = idControlPK;
    }

    public IdControl(IdControlPK idControlPK, long lastnumber) {
        this.idControlPK = idControlPK;
        this.lastnumber = lastnumber;
    }

    public IdControl(String idcharacter, String idyear, String idmonth, String idday) {
        this.idControlPK = new IdControlPK(idcharacter, idyear, idmonth, idday);
    }

    public IdControlPK getIdControlPK() {
        return idControlPK;
    }

    public void setIdControlPK(IdControlPK idControlPK) {
        this.idControlPK = idControlPK;
    }

    public long getLastnumber() {
        return lastnumber;
    }

    public void setLastnumber(long lastnumber) {
        this.lastnumber = lastnumber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idControlPK != null ? idControlPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IdControl)) {
            return false;
        }
        IdControl other = (IdControl) object;
        if ((this.idControlPK == null && other.idControlPK != null) || (this.idControlPK != null && !this.idControlPK.equals(other.idControlPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jilit.clxacademics.model.IdControl[ idControlPK=" + idControlPK + " ]";
    }
    
}
