package com.jilit.clxacademics.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Embeddable
public class CMultipleCounsellingPK implements Serializable {
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 20)
	@Column(name = "CID")
	private String cid;
	@Basic(optional = false)
	@NotNull
	@Size(max = 5)
	@Column(name = "COUNSELLINGNO")
	private int counsellingno;

	public CMultipleCounsellingPK() {

	}

	public CMultipleCounsellingPK(@NotNull @Size(min = 1, max = 20) String cid,
			@NotNull @Size(max = 5) int counsellingno) {
		super();
		this.cid = cid;
		this.counsellingno = counsellingno;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public int getCounsellingno() {
		return counsellingno;
	}

	public void setCounsellingno(int counsellingno) {
		this.counsellingno = counsellingno;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cid == null) ? 0 : cid.hashCode());
		result = prime * result + counsellingno;
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
		CMultipleCounsellingPK other = (CMultipleCounsellingPK) obj;
		if (cid == null) {
			if (other.cid != null)
				return false;
		} else if (!cid.equals(other.cid))
			return false;
		if (counsellingno != other.counsellingno)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CMultipleCounsellingPK [cid=" + cid + ", counsellingno=" + counsellingno + "]";
	}

}
