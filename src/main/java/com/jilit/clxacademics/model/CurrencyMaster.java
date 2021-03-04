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
import javax.persistence.Lob;
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
 * @author Administrator
 */
@Entity
@Table(name = "CURRENCYMASTER")
 
public class CurrencyMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CURRENCYID")
    private String currencyid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CURRENCYCODE")
    private String currencycode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "CURRENCYDESC")
    private String currencydesc;
    @Lob
    @Column(name = "CURRENCYIMAGE")
    private Serializable currencyimage;
    @Size(max = 1)
    @Column(name = "ACCOUNTINGCURRENCY")
    private String accountingcurrency;
    @Column(name = "SEQID")
    private Short seqid;
    @Size(max = 1)
    @Column(name = "DEACTIVE")
    private String deactive;
     
     
    
    public CurrencyMaster() {
    }

    public CurrencyMaster(String currencyid) {
        this.currencyid = currencyid;
    }

    public CurrencyMaster(String currencyid, String currencycode, String currencydesc) {
        this.currencyid = currencyid;
        this.currencycode = currencycode;
        this.currencydesc = currencydesc;
    }

    public String getCurrencyid() {
        return currencyid;
    }

    public void setCurrencyid(String currencyid) {
        this.currencyid = currencyid;
    }

    public String getCurrencycode() {
        return currencycode;
    }

    public void setCurrencycode(String currencycode) {
        this.currencycode = currencycode;
    }

    public String getCurrencydesc() {
        return currencydesc;
    }

    public void setCurrencydesc(String currencydesc) {
        this.currencydesc = currencydesc;
    }

    public Serializable getCurrencyimage() {
        return currencyimage;
    }

    public void setCurrencyimage(Serializable currencyimage) {
        this.currencyimage = currencyimage;
    }

    public String getAccountingcurrency() {
        return accountingcurrency;
    }

    public void setAccountingcurrency(String accountingcurrency) {
        this.accountingcurrency = accountingcurrency;
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

     
 

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (currencyid != null ? currencyid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CurrencyMaster)) {
            return false;
        }
        CurrencyMaster other = (CurrencyMaster) object;
        if ((this.currencyid == null && other.currencyid != null) || (this.currencyid != null && !this.currencyid.equals(other.currencyid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jilit.clxacademics.model.CurrencyMaster[ currencyid=" + currencyid + " ]";
    }
    
}
