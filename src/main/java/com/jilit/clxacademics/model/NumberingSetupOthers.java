/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jilit.clxacademics.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
*
* @author ashok.singh
*/
@Entity
@Table(name = "NUMBERINGSETUPOTHERS")
public class NumberingSetupOthers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "GROUPID")
    private String groupid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "COMPANYINSTID")
    private String companyinstid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "COMPANYINSTITUTE")
    private String companyinstitute;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "YMD")
    private String ymd;
    @Column(name = "TOTALWIDTH")
    private Short totalwidth;
    @JoinColumn(name = "PREFIX", referencedColumnName = "PREFIX")
    @ManyToOne
    private NumberingSetupOthersMaster numberingSetupOthersMaster;

    public NumberingSetupOthers() {
    }


    
	public NumberingSetupOthers(String groupid) {
        this.groupid = groupid;
    }

    public NumberingSetupOthersMaster getNumberingSetupOthersMaster() {
		return numberingSetupOthersMaster;
	}

	public void setNumberingSetupOthersMaster(NumberingSetupOthersMaster numberingSetupOthersMaster) {
		this.numberingSetupOthersMaster = numberingSetupOthersMaster;
	}

	public NumberingSetupOthers(String groupid, String companyinstid, String companyinstitute, String ymd) {
        this.groupid = groupid;
        this.companyinstid = companyinstid;
        this.companyinstitute = companyinstitute;
        this.ymd = ymd;
    }

    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }

    public String getCompanyinstid() {
        return companyinstid;
    }

    public void setCompanyinstid(String companyinstid) {
        this.companyinstid = companyinstid;
    }

    public String getCompanyinstitute() {
        return companyinstitute;
    }

    public void setCompanyinstitute(String companyinstitute) {
        this.companyinstitute = companyinstitute;
    }

    public String getYmd() {
        return ymd;
    }

    public void setYmd(String ymd) {
        this.ymd = ymd;
    }

    public Short getTotalwidth() {
        return totalwidth;
    }

    public void setTotalwidth(Short totalwidth) {
        this.totalwidth = totalwidth;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (groupid != null ? groupid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NumberingSetupOthers)) {
            return false;
        }
        NumberingSetupOthers other = (NumberingSetupOthers) object;
        if ((this.groupid == null && other.groupid != null) || (this.groupid != null && !this.groupid.equals(other.groupid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jilit.clxacademics.model.Numberingsetupothers[ groupid=" + groupid + " ]";
    }
    
}
