/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jilit.clxacademics.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
*
* @author ashok.singh
*/
@Entity
@Table(name = "NUMBERINGCONTROLOTHERS")

public class NumberingControlOthers implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NumberingControlOthersPK numberingcontrolothersPK;
    @Size(max = 20)
    @Column(name = "LASTNO")
    private String lastno;
    @Column(name = "LASTRUNNINGNO")
    private BigDecimal lastrunningno;
    @Column(name = "LASTNUMBERDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastnumberdate;
    @JoinColumn(name = "GROUPID", referencedColumnName = "GROUPID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private NumberingSetupOthers numberingSetupOthers;

    public NumberingControlOthers() {
    }

    public NumberingControlOthers(NumberingControlOthersPK numberingcontrolothersPK) {
        this.numberingcontrolothersPK = numberingcontrolothersPK;
    }

    public NumberingControlOthers(String groupid, String ymd) {
        this.numberingcontrolothersPK = new NumberingControlOthersPK(groupid, ymd);
    }

    public NumberingControlOthersPK getNumberingcontrolothersPK() {
        return numberingcontrolothersPK;
    }

    public void setNumberingcontrolothersPK(NumberingControlOthersPK numberingcontrolothersPK) {
        this.numberingcontrolothersPK = numberingcontrolothersPK;
    }

    public String getLastno() {
        return lastno;
    }

    public void setLastno(String lastno) {
        this.lastno = lastno;
    }

    public BigDecimal getLastrunningno() {
        return lastrunningno;
    }

    public void setLastrunningno(BigDecimal lastrunningno) {
        this.lastrunningno = lastrunningno;
    }

    public Date getLastnumberdate() {
        return lastnumberdate;
    }

    public void setLastnumberdate(Date lastnumberdate) {
        this.lastnumberdate = lastnumberdate;
    }

    public NumberingSetupOthers getNumberingSetupOthers() {
        return numberingSetupOthers;
    }

    public void setNumberingSetupOthers(NumberingSetupOthers numberingSetupOthers) {
        this.numberingSetupOthers = numberingSetupOthers;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numberingcontrolothersPK != null ? numberingcontrolothersPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NumberingControlOthers)) {
            return false;
        }
        NumberingControlOthers other = (NumberingControlOthers) object;
        if ((this.numberingcontrolothersPK == null && other.numberingcontrolothersPK != null) || (this.numberingcontrolothersPK != null && !this.numberingcontrolothersPK.equals(other.numberingcontrolothersPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jilit.clxacademics.model.Numberingcontrolothers[ numberingcontrolothersPK=" + numberingcontrolothersPK + " ]";
    }
    
}
