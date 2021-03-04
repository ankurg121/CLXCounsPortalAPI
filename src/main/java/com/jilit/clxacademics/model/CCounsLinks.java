/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jilit.clxacademics.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sushil.panwar
 */
@Entity
@Table(name = "C_COUNSLINKS")
public class CCounsLinks implements Serializable {

	private static final long serialVersionUID = 1L;
	@EmbeddedId
	protected CCounsLinksPK cCounslinksPK;
	@Column(name = "URLNAME")
	private String urlname;
	@Column(name = "URLTOOLTIP")
	private String urltooltip;
	@Column(name = "PAGEURL")
	private String pageurl;
	@Basic(optional = false)
	@Column(name = "STARTDATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date startdatetime;
	@Basic(optional = false)
	@Column(name = "ENDDATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date enddatetime;
	@Column(name = "INSTRUCTIONINFO")
	private String instructioninfo;
	@Column(name = "INSTRUCTIONFILEURL")
	private String instructionfileurl;
	@Column(name = "SEQID")
	private Short seqid;
	@Column(name = "DEACTIVE")
	private String deactive;
	@Column(name = "BOROADCAST")
	private String boroadcast;

	public CCounsLinks() {
	}

	public CCounsLinks(CCounsLinksPK cCounslinksPK, String urlname, String urltooltip, String pageurl,
			Date startdatetime, Date enddatetime, String instructioninfo, String instructionfileurl, Short seqid,
			String deactive, String boroadcast) {
		super();
		this.cCounslinksPK = cCounslinksPK;
		this.urlname = urlname;
		this.urltooltip = urltooltip;
		this.pageurl = pageurl;
		this.startdatetime = startdatetime;
		this.enddatetime = enddatetime;
		this.instructioninfo = instructioninfo;
		this.instructionfileurl = instructionfileurl;
		this.seqid = seqid;
		this.deactive = deactive;
		this.boroadcast = boroadcast;
	}

	public CCounsLinksPK getcCounslinksPK() {
		return cCounslinksPK;
	}

	public void setcCounslinksPK(CCounsLinksPK cCounslinksPK) {
		this.cCounslinksPK = cCounslinksPK;
	}

	public String getUrlname() {
		return urlname;
	}

	public void setUrlname(String urlname) {
		this.urlname = urlname;
	}

	public String getUrltooltip() {
		return urltooltip;
	}

	public void setUrltooltip(String urltooltip) {
		this.urltooltip = urltooltip;
	}

	public String getPageurl() {
		return pageurl;
	}

	public void setPageurl(String pageurl) {
		this.pageurl = pageurl;
	}

	public Date getStartdatetime() {
		return startdatetime;
	}

	public void setStartdatetime(Date startdatetime) {
		this.startdatetime = startdatetime;
	}

	public Date getEnddatetime() {
		return enddatetime;
	}

	public void setEnddatetime(Date enddatetime) {
		this.enddatetime = enddatetime;
	}

	public String getInstructioninfo() {
		return instructioninfo;
	}

	public void setInstructioninfo(String instructioninfo) {
		this.instructioninfo = instructioninfo;
	}

	public String getInstructionfileurl() {
		return instructionfileurl;
	}

	public void setInstructionfileurl(String instructionfileurl) {
		this.instructionfileurl = instructionfileurl;
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

	public String getBoroadcast() {
		return boroadcast;
	}

	public void setBoroadcast(String boroadcast) {
		this.boroadcast = boroadcast;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((boroadcast == null) ? 0 : boroadcast.hashCode());
		result = prime * result + ((cCounslinksPK == null) ? 0 : cCounslinksPK.hashCode());
		result = prime * result + ((deactive == null) ? 0 : deactive.hashCode());
		result = prime * result + ((enddatetime == null) ? 0 : enddatetime.hashCode());
		result = prime * result + ((instructionfileurl == null) ? 0 : instructionfileurl.hashCode());
		result = prime * result + ((instructioninfo == null) ? 0 : instructioninfo.hashCode());
		result = prime * result + ((pageurl == null) ? 0 : pageurl.hashCode());
		result = prime * result + ((seqid == null) ? 0 : seqid.hashCode());
		result = prime * result + ((startdatetime == null) ? 0 : startdatetime.hashCode());
		result = prime * result + ((urlname == null) ? 0 : urlname.hashCode());
		result = prime * result + ((urltooltip == null) ? 0 : urltooltip.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CCounsLinks other = (CCounsLinks) obj;
		if (boroadcast == null) {
			if (other.boroadcast != null)
				return false;
		} else if (!boroadcast.equals(other.boroadcast))
			return false;
		if (cCounslinksPK == null) {
			if (other.cCounslinksPK != null)
				return false;
		} else if (!cCounslinksPK.equals(other.cCounslinksPK))
			return false;
		if (deactive == null) {
			if (other.deactive != null)
				return false;
		} else if (!deactive.equals(other.deactive))
			return false;
		if (enddatetime == null) {
			if (other.enddatetime != null)
				return false;
		} else if (!enddatetime.equals(other.enddatetime))
			return false;
		if (instructionfileurl == null) {
			if (other.instructionfileurl != null)
				return false;
		} else if (!instructionfileurl.equals(other.instructionfileurl))
			return false;
		if (instructioninfo == null) {
			if (other.instructioninfo != null)
				return false;
		} else if (!instructioninfo.equals(other.instructioninfo))
			return false;
		if (pageurl == null) {
			if (other.pageurl != null)
				return false;
		} else if (!pageurl.equals(other.pageurl))
			return false;
		if (seqid == null) {
			if (other.seqid != null)
				return false;
		} else if (!seqid.equals(other.seqid))
			return false;
		if (startdatetime == null) {
			if (other.startdatetime != null)
				return false;
		} else if (!startdatetime.equals(other.startdatetime))
			return false;
		if (urlname == null) {
			if (other.urlname != null)
				return false;
		} else if (!urlname.equals(other.urlname))
			return false;
		if (urltooltip == null) {
			if (other.urltooltip != null)
				return false;
		} else if (!urltooltip.equals(other.urltooltip))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CCounsLinks [cCounslinksPK=" + cCounslinksPK + ", urlname=" + urlname + ", urltooltip=" + urltooltip
				+ ", pageurl=" + pageurl + ", startdatetime=" + startdatetime + ", enddatetime=" + enddatetime
				+ ", instructioninfo=" + instructioninfo + ", instructionfileurl=" + instructionfileurl + ", seqid="
				+ seqid + ", deactive=" + deactive + ", boroadcast=" + boroadcast + "]";
	}

}
