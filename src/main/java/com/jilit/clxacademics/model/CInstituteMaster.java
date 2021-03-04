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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Sushil
 */
@Entity
@Table(name = "C#INSTITUTEMASTER")
public class CInstituteMaster implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "INSTITUTECODE")
	private String institutecode;
	@Basic(optional = false)
	@Column(name = "INSTITUTENAME")
	private String institutename;
	@Column(name = "ADDRESS1")
	private String address1;
	@Column(name = "ADDRESS2")
	private String address2;
	@Column(name = "ADDRESS3")
	private String address3;
	@Column(name = "CITY")
	private String city;
	@Column(name = "STATE")
	private String state;
	@Column(name = "PIN")
	private Integer pin;
	@Column(name = "PHONENO")
	private String phoneno;
	@Column(name = "DEACTIVE")
	private String deactive;
	@Column(name = "SEQID")
	private Short seqid;
	@Column(name = "SHORTNAME")
	private String shortname;
	@Column(name = "HOSTELAPPLICABLE")
	private String hostelapplicable;
	@Column(name = "EXAMCODE")
	private String examcode;
	@Column(name = "LOGOFILENAME")
	private String logofilename;
	@Column(name = "WATERMARKFILENAME")
	private String watermarkfilename;
	@Column(name = "COUNTRY")
	private String country;
	@Column(name = "STDCODE")
	private String stdcode;
	@Column(name = "FAXNOS")
	private String faxnos;
	@Column(name = "WEBSITE")
	private String website;

	// @OneToMany(cascade = CascadeType.ALL, mappedBy = "cInstituteMaster")
	// private Collection<CInstituteCategoryTagging>
	// cInstituteCategoryTaggingCollection;
	// @OneToMany(cascade = CascadeType.ALL, mappedBy = "cInstituteMaster")
	// private Collection<CSeatTransferTagging> cSeatTransferTaggingCollection;
	// @OneToMany(cascade = CascadeType.ALL, mappedBy = "cInstituteMaster")
	// private Collection<CInstituteBranchTagging>
	// cInstituteBranchTaggingCollection;
	// @OneToMany(cascade = CascadeType.ALL, mappedBy = "cInstituteMaster")
	// private Collection<CDocumentCategoryTagging>
	// cDocumentCategoryTaggingCollection;
	// @OneToMany(cascade = CascadeType.ALL, mappedBy = "cInstituteMaster")
	// private Collection<CStudentAttendance> cStudentAttendanceCollection;
	// @OneToMany(cascade = CascadeType.ALL, mappedBy = "cInstituteMaster")
	// private Collection<CStudentDocumentMaster>
	// cStudentDocumentMasterCollection;
	// @OneToMany(cascade = CascadeType.ALL, mappedBy = "cInstituteMaster")
	// private Collection<CStudentMaster> cStudentMasterCollection;
	// @OneToMany(cascade = CascadeType.ALL, mappedBy = "cInstituteMaster")
	// private Collection<CHostelType> cHostelTypeCollection;
	// @OneToMany(cascade = CascadeType.ALL, mappedBy = "cInstituteMaster")
	// private Collection<CStudentInstituteChoice>
	// cStudentInstituteChoiceCollection;
	// @OneToOne(cascade = CascadeType.ALL, mappedBy = "cInstituteMaster")
	// private CDdPayableAt cDdPayableAt;

	public CInstituteMaster() {
	}

	public CInstituteMaster(String institutecode) {
		this.institutecode = institutecode;
	}

	public CInstituteMaster(String institutecode, String institutename) {
		this.institutecode = institutecode;
		this.institutename = institutename;
	}

	public String getInstitutecode() {
		return institutecode;
	}

	public void setInstitutecode(String institutecode) {
		this.institutecode = institutecode;
	}

	public String getInstitutename() {
		return institutename;
	}

	public void setInstitutename(String institutename) {
		this.institutename = institutename;
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

	public String getAddress3() {
		return address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getPin() {
		return pin;
	}

	public void setPin(Integer pin) {
		this.pin = pin;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String getDeactive() {
		return deactive;
	}

	public void setDeactive(String deactive) {
		this.deactive = deactive;
	}

	public Short getSeqid() {
		return seqid;
	}

	public void setSeqid(Short seqid) {
		this.seqid = seqid;
	}

	public String getShortname() {
		return shortname;
	}

	public void setShortname(String shortname) {
		this.shortname = shortname;
	}

	public String getHostelapplicable() {
		return hostelapplicable;
	}

	public void setHostelapplicable(String hostelapplicable) {
		this.hostelapplicable = hostelapplicable;
	}

	// public Collection<CInstituteCategoryTagging>
	// getCInstituteCategoryTaggingCollection() {
	// return cInstituteCategoryTaggingCollection;
	// }
	//
	// public void
	// setCInstituteCategoryTaggingCollection(Collection<CInstituteCategoryTagging>
	// cInstituteCategoryTaggingCollection) {
	// this.cInstituteCategoryTaggingCollection =
	// cInstituteCategoryTaggingCollection;
	// }
	//
	// public Collection<CSeatTransferTagging>
	// getCSeatTransferTaggingCollection() {
	// return cSeatTransferTaggingCollection;
	// }
	//
	// public void
	// setCSeatTransferTaggingCollection(Collection<CSeatTransferTagging>
	// cSeatTransferTaggingCollection) {
	// this.cSeatTransferTaggingCollection = cSeatTransferTaggingCollection;
	// }
	//
	// public Collection<CInstituteBranchTagging>
	// getCInstituteBranchTaggingCollection() {
	// return cInstituteBranchTaggingCollection;
	// }
	//
	// public void
	// setCInstituteBranchTaggingCollection(Collection<CInstituteBranchTagging>
	// cInstituteBranchTaggingCollection) {
	// this.cInstituteBranchTaggingCollection =
	// cInstituteBranchTaggingCollection;
	// }
	//
	// public Collection<CDocumentCategoryTagging>
	// getCDocumentCategoryTaggingCollection() {
	// return cDocumentCategoryTaggingCollection;
	// }
	//
	// public void
	// setCDocumentCategoryTaggingCollection(Collection<CDocumentCategoryTagging>
	// cDocumentCategoryTaggingCollection) {
	// this.cDocumentCategoryTaggingCollection =
	// cDocumentCategoryTaggingCollection;
	// }
	//
	// public Collection<CStudentAttendance> getCStudentAttendanceCollection() {
	// return cStudentAttendanceCollection;
	// }
	//
	// public void
	// setCStudentAttendanceCollection(Collection<CStudentAttendance>
	// cStudentAttendanceCollection) {
	// this.cStudentAttendanceCollection = cStudentAttendanceCollection;
	// }
	//
	// public Collection<CStudentDocumentMaster>
	// getCStudentDocumentMasterCollection() {
	// return cStudentDocumentMasterCollection;
	// }
	//
	// public void
	// setCStudentDocumentMasterCollection(Collection<CStudentDocumentMaster>
	// cStudentDocumentMasterCollection) {
	// this.cStudentDocumentMasterCollection = cStudentDocumentMasterCollection;
	// }
	//
	// public Collection<CStudentMaster> getCStudentMasterCollection() {
	// return cStudentMasterCollection;
	// }
	//
	// public void setCStudentMasterCollection(Collection<CStudentMaster>
	// cStudentMasterCollection) {
	// this.cStudentMasterCollection = cStudentMasterCollection;
	// }
	//
	// public Collection<CHostelType> getCHostelTypeCollection() {
	// return cHostelTypeCollection;
	// }
	//
	// public void setCHostelTypeCollection(Collection<CHostelType>
	// cHostelTypeCollection) {
	// this.cHostelTypeCollection = cHostelTypeCollection;
	// }
	//
	// public Collection<CStudentInstituteChoice>
	// getCStudentInstituteChoiceCollection() {
	// return cStudentInstituteChoiceCollection;
	// }
	//
	// public void
	// setCStudentInstituteChoiceCollection(Collection<CStudentInstituteChoice>
	// cStudentInstituteChoiceCollection) {
	// this.cStudentInstituteChoiceCollection =
	// cStudentInstituteChoiceCollection;
	// }
	//
	// public CDdPayableAt getCDdPayableAt() {
	// return cDdPayableAt;
	// }
	//
	// public void setCDdPayableAt(CDdPayableAt cDdPayableAt) {
	// this.cDdPayableAt = cDdPayableAt;
	// }

	public String getExamcode() {
		return examcode;
	}

	public void setExamcode(String examcode) {
		this.examcode = examcode;
	}

	public String getLogofilename() {
		return logofilename;
	}

	public void setLogofilename(String logofilename) {
		this.logofilename = logofilename;
	}

	public String getWatermarkfilename() {
		return watermarkfilename;
	}

	public void setWatermarkfilename(String watermarkfilename) {
		this.watermarkfilename = watermarkfilename;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getStdcode() {
		return stdcode;
	}

	public void setStdcode(String stdcode) {
		this.stdcode = stdcode;
	}

	public String getFaxnos() {
		return faxnos;
	}

	public void setFaxnos(String faxnos) {
		this.faxnos = faxnos;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address1 == null) ? 0 : address1.hashCode());
		result = prime * result + ((address2 == null) ? 0 : address2.hashCode());
		result = prime * result + ((address3 == null) ? 0 : address3.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((deactive == null) ? 0 : deactive.hashCode());
		result = prime * result + ((examcode == null) ? 0 : examcode.hashCode());
		result = prime * result + ((faxnos == null) ? 0 : faxnos.hashCode());
		result = prime * result + ((hostelapplicable == null) ? 0 : hostelapplicable.hashCode());
		result = prime * result + ((institutecode == null) ? 0 : institutecode.hashCode());
		result = prime * result + ((institutename == null) ? 0 : institutename.hashCode());
		result = prime * result + ((logofilename == null) ? 0 : logofilename.hashCode());
		result = prime * result + ((phoneno == null) ? 0 : phoneno.hashCode());
		result = prime * result + ((pin == null) ? 0 : pin.hashCode());
		result = prime * result + ((seqid == null) ? 0 : seqid.hashCode());
		result = prime * result + ((shortname == null) ? 0 : shortname.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((stdcode == null) ? 0 : stdcode.hashCode());
		result = prime * result + ((watermarkfilename == null) ? 0 : watermarkfilename.hashCode());
		result = prime * result + ((website == null) ? 0 : website.hashCode());
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
		CInstituteMaster other = (CInstituteMaster) obj;
		if (address1 == null) {
			if (other.address1 != null)
				return false;
		} else if (!address1.equals(other.address1))
			return false;
		if (address2 == null) {
			if (other.address2 != null)
				return false;
		} else if (!address2.equals(other.address2))
			return false;
		if (address3 == null) {
			if (other.address3 != null)
				return false;
		} else if (!address3.equals(other.address3))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (deactive == null) {
			if (other.deactive != null)
				return false;
		} else if (!deactive.equals(other.deactive))
			return false;
		if (examcode == null) {
			if (other.examcode != null)
				return false;
		} else if (!examcode.equals(other.examcode))
			return false;
		if (faxnos == null) {
			if (other.faxnos != null)
				return false;
		} else if (!faxnos.equals(other.faxnos))
			return false;
		if (hostelapplicable == null) {
			if (other.hostelapplicable != null)
				return false;
		} else if (!hostelapplicable.equals(other.hostelapplicable))
			return false;
		if (institutecode == null) {
			if (other.institutecode != null)
				return false;
		} else if (!institutecode.equals(other.institutecode))
			return false;
		if (institutename == null) {
			if (other.institutename != null)
				return false;
		} else if (!institutename.equals(other.institutename))
			return false;
		if (logofilename == null) {
			if (other.logofilename != null)
				return false;
		} else if (!logofilename.equals(other.logofilename))
			return false;
		if (phoneno == null) {
			if (other.phoneno != null)
				return false;
		} else if (!phoneno.equals(other.phoneno))
			return false;
		if (pin == null) {
			if (other.pin != null)
				return false;
		} else if (!pin.equals(other.pin))
			return false;
		if (seqid == null) {
			if (other.seqid != null)
				return false;
		} else if (!seqid.equals(other.seqid))
			return false;
		if (shortname == null) {
			if (other.shortname != null)
				return false;
		} else if (!shortname.equals(other.shortname))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (stdcode == null) {
			if (other.stdcode != null)
				return false;
		} else if (!stdcode.equals(other.stdcode))
			return false;
		if (watermarkfilename == null) {
			if (other.watermarkfilename != null)
				return false;
		} else if (!watermarkfilename.equals(other.watermarkfilename))
			return false;
		if (website == null) {
			if (other.website != null)
				return false;
		} else if (!website.equals(other.website))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CInstituteMaster [institutecode=" + institutecode + ", institutename=" + institutename + ", address1="
				+ address1 + ", address2=" + address2 + ", address3=" + address3 + ", city=" + city + ", state=" + state
				+ ", pin=" + pin + ", phoneno=" + phoneno + ", deactive=" + deactive + ", seqid=" + seqid
				+ ", shortname=" + shortname + ", hostelapplicable=" + hostelapplicable + ", examcode=" + examcode
				+ ", logofilename=" + logofilename + ", watermarkfilename=" + watermarkfilename + ", country=" + country
				+ ", stdcode=" + stdcode + ", faxnos=" + faxnos + ", website=" + website + "]";
	}

}
