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

/**
 *
 * @author sushil.panwar
 */
@Embeddable
public class CCounsLinksPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "CID")
    private String cid;
    @Basic(optional = false)
    @Column(name = "URLLINKNAMEID")
    private String urllinknameid;

    public CCounsLinksPK() {
    }

    public CCounsLinksPK(String cid, String urllinknameid) {
        this.cid = cid;
        this.urllinknameid = urllinknameid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getUrllinknameid() {
        return urllinknameid;
    }

    public void setUrllinknameid(String urllinknameid) {
        this.urllinknameid = urllinknameid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cid != null ? cid.hashCode() : 0);
        hash += (urllinknameid != null ? urllinknameid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CCounsLinksPK)) {
            return false;
        }
        CCounsLinksPK other = (CCounsLinksPK) object;
        if ((this.cid == null && other.cid != null) || (this.cid != null && !this.cid.equals(other.cid))) {
            return false;
        }
        if ((this.urllinknameid == null && other.urllinknameid != null) || (this.urllinknameid != null && !this.urllinknameid.equals(other.urllinknameid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jilit.clxacademics.model.CCounslinksPK[ cid=" + cid + ", urllinknameid=" + urllinknameid + " ]";
    }
    
}
