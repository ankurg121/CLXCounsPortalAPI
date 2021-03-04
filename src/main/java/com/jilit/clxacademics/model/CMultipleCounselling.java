package com.jilit.clxacademics.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "C_MULTIPLECOUNSELLING")
public class CMultipleCounselling implements Serializable {

	@EmbeddedId
	protected CMultipleCounsellingPK id;
	@Basic(optional = false)
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATEOFCOUNSELLING")
	private Date dateofcounselling;
	@Size(max = 1)
	@Column(name = "DEACTIVE")
	private String deactive;
	@Size(max = 1)
	@Column(name = "COUNSELLINGTYPE")
	private String counsellingtype;

	@JoinColumn(name = "CID", referencedColumnName = "CID", insertable = false, updatable = false)
	@ManyToOne(optional = false)
	private CCounsellingid ccounsellingid;

	public CMultipleCounselling() {

	}

	public CMultipleCounselling(CMultipleCounsellingPK id, @NotNull Date dateofcounselling,
			@Size(max = 1) String deactive, @Size(max = 1) String counsellingtype, CCounsellingid ccounsellingid) {
		super();
		this.id = id;
		this.dateofcounselling = dateofcounselling;
		this.deactive = deactive;
		this.counsellingtype = counsellingtype;
		this.ccounsellingid = ccounsellingid;
	}

	public CMultipleCounsellingPK getCmultiplecounsellingpk() {
		return id;
	}

	public void setCmultiplecounsellingpk(CMultipleCounsellingPK id) {
		this.id = id;
	}

	public Date getDateofcounselling() {
		return dateofcounselling;
	}

	public void setDateofcounselling(Date dateofcounselling) {
		this.dateofcounselling = dateofcounselling;
	}

	public String getDeactive() {
		return deactive;
	}

	public void setDeactive(String deactive) {
		this.deactive = deactive;
	}

	public String getCounsellingtype() {
		return counsellingtype;
	}

	public void setCounsellingtype(String counsellingtype) {
		this.counsellingtype = counsellingtype;
	}

	public CCounsellingid getCcounsellingid() {
		return ccounsellingid;
	}

	public void setCcounsellingid(CCounsellingid ccounsellingid) {
		this.ccounsellingid = ccounsellingid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ccounsellingid == null) ? 0 : ccounsellingid.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((counsellingtype == null) ? 0 : counsellingtype.hashCode());
		result = prime * result + ((dateofcounselling == null) ? 0 : dateofcounselling.hashCode());
		result = prime * result + ((deactive == null) ? 0 : deactive.hashCode());
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
		CMultipleCounselling other = (CMultipleCounselling) obj;
		if (ccounsellingid == null) {
			if (other.ccounsellingid != null)
				return false;
		} else if (!ccounsellingid.equals(other.ccounsellingid))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (counsellingtype == null) {
			if (other.counsellingtype != null)
				return false;
		} else if (!counsellingtype.equals(other.counsellingtype))
			return false;
		if (dateofcounselling == null) {
			if (other.dateofcounselling != null)
				return false;
		} else if (!dateofcounselling.equals(other.dateofcounselling))
			return false;
		if (deactive == null) {
			if (other.deactive != null)
				return false;
		} else if (!deactive.equals(other.deactive))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CMultipleCounselling [id=" + id + ", dateofcounselling="
				+ dateofcounselling + ", deactive=" + deactive + ", counsellingtype=" + counsellingtype
				+ ", ccounsellingid=" + ccounsellingid + "]";
	}

}
