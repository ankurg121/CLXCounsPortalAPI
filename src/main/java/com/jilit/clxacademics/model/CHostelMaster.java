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
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Anubhav
 */
@Entity
@Table(name = "C#HOSTELMASTER")
@NamedQueries({
    @NamedQuery(name = "CHostelMaster.findAll", query = "SELECT c FROM CHostelMaster c")})
public class CHostelMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CHostelMasterPK cHostelMasterPK;
    @Column(name = "HOSTELDESCRIPTION")
    private String hosteldescription;
    @Column(name = "SHORTNAME")
    private String shortname;
    @Basic(optional = false)
    @Column(name = "HOSTELFOR")
    private Character hostelfor;
    @Column(name = "TOTALSEATS")
    private Short totalseats;
    @Column(name = "ALLOTEDSEATS")
    private Short allotedseats;
    @Column(name = "HOSTELLOCATION")
    private Character hostellocation;
    @Column(name = "ADDRESS1")
    private String address1;
    @Column(name = "ADDRESS2")
    private String address2;
    @Column(name = "CITY")
    private String city;
    @Column(name = "PIN")
    private String pin;
    @Column(name = "DEACTIVE")
    private String deactive;
    @Column(name = "ACCEPTWAITING")
    private String acceptwaiting;
    @Column(name = "NOOFWAITING")
    private Short noofwaiting;
    @Column(name = "NOOFWAITINGCTR")
    private Short noofwaitingctr;
    @JoinColumns({
        @JoinColumn(name = "INSTITUTECODE", referencedColumnName = "INSTITUTECODE", insertable = false, updatable = false)
        , @JoinColumn(name = "HOSTELTYPE", referencedColumnName = "HOSTELTYPE", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private CHostelType cHostelType;

    public CHostelMaster() {
    }

    public CHostelMaster(CHostelMasterPK cHostelMasterPK) {
        this.cHostelMasterPK = cHostelMasterPK;
    }

    public CHostelMaster(CHostelMasterPK cHostelMasterPK, Character hostelfor) {
        this.cHostelMasterPK = cHostelMasterPK;
        this.hostelfor = hostelfor;
    }

    public CHostelMaster(String institutecode, String hosteltype, String hostelcode) {
        this.cHostelMasterPK = new CHostelMasterPK(institutecode, hosteltype, hostelcode);
    }

    public CHostelMasterPK getCHostelMasterPK() {
        return cHostelMasterPK;
    }

    public void setCHostelMasterPK(CHostelMasterPK cHostelMasterPK) {
        this.cHostelMasterPK = cHostelMasterPK;
    }

    public String getHosteldescription() {
        return hosteldescription;
    }

    public void setHosteldescription(String hosteldescription) {
        this.hosteldescription = hosteldescription;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public Character getHostelfor() {
        return hostelfor;
    }

    public void setHostelfor(Character hostelfor) {
        this.hostelfor = hostelfor;
    }

    public Short getTotalseats() {
        return totalseats;
    }

    public void setTotalseats(Short totalseats) {
        this.totalseats = totalseats;
    }

    public Short getAllotedseats() {
        return allotedseats;
    }

    public void setAllotedseats(Short allotedseats) {
        this.allotedseats = allotedseats;
    }

    public Character getHostellocation() {
        return hostellocation;
    }

    public void setHostellocation(Character hostellocation) {
        this.hostellocation = hostellocation;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getDeactive() {
        return deactive;
    }

    public void setDeactive(String deactive) {
        this.deactive = deactive;
    }

    public String getAcceptwaiting() {
        return acceptwaiting;
    }

    public void setAcceptwaiting(String acceptwaiting) {
        this.acceptwaiting = acceptwaiting;
    }

    public Short getNoofwaiting() {
        return noofwaiting;
    }

    public void setNoofwaiting(Short noofwaiting) {
        this.noofwaiting = noofwaiting;
    }

    public Short getNoofwaitingctr() {
        return noofwaitingctr;
    }

    public void setNoofwaitingctr(Short noofwaitingctr) {
        this.noofwaitingctr = noofwaitingctr;
    }

    public CHostelType getCHostelType() {
        return cHostelType;
    }

    public void setCHostelType(CHostelType cHostelType) {
        this.cHostelType = cHostelType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cHostelMasterPK != null ? cHostelMasterPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CHostelMaster)) {
            return false;
        }
        CHostelMaster other = (CHostelMaster) object;
        if ((this.cHostelMasterPK == null && other.cHostelMasterPK != null) || (this.cHostelMasterPK != null && !this.cHostelMasterPK.equals(other.cHostelMasterPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jilit.clxacademics.model.CHostelMaster[ cHostelMasterPK=" + cHostelMasterPK + " ]";
    }
    
}
