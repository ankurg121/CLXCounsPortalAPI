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
import org.springframework.stereotype.Component;
/**
*
* @author ashok.singh
*/
@Embeddable
@Component
public class IdControlPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "IDCHARACTER")
    private String idcharacter;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "IDYEAR")
    private String idyear;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "IDMONTH")
    private String idmonth;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "IDDAY")
    private String idday;

    public IdControlPK() {
    }

    public IdControlPK(String idcharacter, String idyear, String idmonth, String idday) {
        this.idcharacter = idcharacter;
        this.idyear = idyear;
        this.idmonth = idmonth;
        this.idday = idday;
    }

    public String getIdcharacter() {
        return idcharacter;
    }

    public void setIdcharacter(String idcharacter) {
        this.idcharacter = idcharacter;
    }

    public String getIdyear() {
        return idyear;
    }

    public void setIdyear(String idyear) {
        this.idyear = idyear;
    }

    public String getIdmonth() {
        return idmonth;
    }

    public void setIdmonth(String idmonth) {
        this.idmonth = idmonth;
    }

    public String getIdday() {
        return idday;
    }

    public void setIdday(String idday) {
        this.idday = idday;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcharacter != null ? idcharacter.hashCode() : 0);
        hash += (idyear != null ? idyear.hashCode() : 0);
        hash += (idmonth != null ? idmonth.hashCode() : 0);
        hash += (idday != null ? idday.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IdControlPK)) {
            return false;
        }
        IdControlPK other = (IdControlPK) object;
        if ((this.idcharacter == null && other.idcharacter != null) || (this.idcharacter != null && !this.idcharacter.equals(other.idcharacter))) {
            return false;
        }
        if ((this.idyear == null && other.idyear != null) || (this.idyear != null && !this.idyear.equals(other.idyear))) {
            return false;
        }
        if ((this.idmonth == null && other.idmonth != null) || (this.idmonth != null && !this.idmonth.equals(other.idmonth))) {
            return false;
        }
        if ((this.idday == null && other.idday != null) || (this.idday != null && !this.idday.equals(other.idday))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jilit.clxacademics.model.IdControlPK[ idcharacter=" + idcharacter + ", idyear=" + idyear + ", idmonth=" + idmonth + ", idday=" + idday + " ]";
    }
    
}
