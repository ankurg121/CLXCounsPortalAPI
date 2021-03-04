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
* @author ashok.singh
*/
@Embeddable
public class IdGenerationControlPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ICID")
    private String icid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "IDCODE")
    private String idcode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "YEAR")
    private String year;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "MONTH")
    private String month;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ALPHA")
    private Character alpha;

    public IdGenerationControlPK() {
    }

    public IdGenerationControlPK(String icid, String idcode, String year, String month, Character alpha) {
        this.icid = icid;
        this.idcode = idcode;
        this.year = year;
        this.month = month;
        this.alpha = alpha;
    }

    public String getIcid() {
        return icid;
    }

    public void setIcid(String icid) {
        this.icid = icid;
    }

    public String getIdcode() {
        return idcode;
    }

    public void setIdcode(String idcode) {
        this.idcode = idcode;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Character getAlpha() {
        return alpha;
    }

    public void setAlpha(Character alpha) {
        this.alpha = alpha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (icid != null ? icid.hashCode() : 0);
        hash += (idcode != null ? idcode.hashCode() : 0);
        hash += (year != null ? year.hashCode() : 0);
        hash += (month != null ? month.hashCode() : 0);
        hash += (alpha != null ? alpha.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IdGenerationControlPK)) {
            return false;
        }
        IdGenerationControlPK other = (IdGenerationControlPK) object;
        if ((this.icid == null && other.icid != null) || (this.icid != null && !this.icid.equals(other.icid))) {
            return false;
        }
        if ((this.idcode == null && other.idcode != null) || (this.idcode != null && !this.idcode.equals(other.idcode))) {
            return false;
        }
        if ((this.year == null && other.year != null) || (this.year != null && !this.year.equals(other.year))) {
            return false;
        }
        if ((this.month == null && other.month != null) || (this.month != null && !this.month.equals(other.month))) {
            return false;
        }
        if ((this.alpha == null && other.alpha != null) || (this.alpha != null && !this.alpha.equals(other.alpha))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jilit.clxacademics.model.IdGenerationControlPK[ icid=" + icid + ", idcode=" + idcode + ", year=" + year + ", month=" + month + ", alpha=" + alpha + " ]";
    }
    
}
