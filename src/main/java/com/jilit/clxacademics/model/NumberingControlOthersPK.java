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
public class NumberingControlOthersPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "GROUPID")
    private String groupid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "YMD")
    private String ymd;

    public NumberingControlOthersPK() {
    }

    public NumberingControlOthersPK(String groupid, String ymd) {
        this.groupid = groupid;
        this.ymd = ymd;
    }

    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }

    public String getYmd() {
        return ymd;
    }

    public void setYmd(String ymd) {
        this.ymd = ymd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (groupid != null ? groupid.hashCode() : 0);
        hash += (ymd != null ? ymd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NumberingControlOthersPK)) {
            return false;
        }
        NumberingControlOthersPK other = (NumberingControlOthersPK) object;
        if ((this.groupid == null && other.groupid != null) || (this.groupid != null && !this.groupid.equals(other.groupid))) {
            return false;
        }
        if ((this.ymd == null && other.ymd != null) || (this.ymd != null && !this.ymd.equals(other.ymd))) {
            return false;
        }
        return true;
    }

    
}
