/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jilit.clxacademics.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import ch.qos.logback.core.subst.Token.Type;

/**
 *
 * @author ankur.goyal
 */
@Entity
@Table(name = "C_COUNSELLINGID")
@XmlRootElement
public class CCounsellingid implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 20)
	@Column(name = "CID")
	private String cid;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "COUNSELLINGTITLE")
	private String counsellingtitle;
	@Basic(optional = false)
	@NotNull
	@Column(name = "DATEOFCOUNSELLING")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateofcounselling;
	@Size(max = 75)
	@Column(name = "COUNSELLINGDESC1")
	private String counsellingdesc1;
	@Size(max = 75)
	@Column(name = "COUNSELLINGDESC2")
	private String counsellingdesc2;
	@Size(max = 75)
	@Column(name = "COUNSELLINGDESC3")
	private String counsellingdesc3;
	@Size(max = 1)
	@Column(name = "MULTIPLECOUNSELLING")
	private String multiplecounselling;
	@Size(max = 1)
	@Column(name = "DUALATTENDANCE")
	private String dualattendance;
	@Size(max = 1)
	@Column(name = "COUNSELLINGISOVER")
	private String counsellingisover;
	@Column(name = "OVERDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date overdate;
	@Size(max = 8)
	@Column(name = "ACADEMICYEAR")
	private String academicyear;
	@Column(name = "APPLICATIONFORMFEE")
	private Long applicationformfee;
	@Size(max = 1)
	@Column(name = "REMUNERATIONPAYABLE")
	private String remunerationpayable;
	@Size(max = 20)
	@Column(name = "REMUNERATIONCOMPANYID")
	private String remunerationcompanyid;
	@Size(max = 20)
	@Column(name = "REMUNERATIONGLID")
	private String remunerationglid;
	@Size(max = 1)
	@Column(name = "SHOWAPPLICATIONENTRY")
	private String showapplicationentry;
	@Size(max = 1)
	@Column(name = "SHOWAPPLICATIONMODIFICATION")
	private String showapplicationmodification;
	@Size(max = 1)
	@Column(name = "SHOWAPPLICATIONSTATUS")
	private String showapplicationstatus;
	@Size(max = 1)
	@Column(name = "SHOWCENTEALLOTMENT")
	private String showcenteallotment;
	@Size(max = 1)
	@Column(name = "SHOWRANKCARD")
	private String showrankcard;
	@Size(max = 1)
	@Column(name = "SHOWCOUNSELLINGINFO")
	private String showcounsellinginfo;
	@Size(max = 1)
	@Column(name = "SHOWPOSTCOUNSELLINGSTATUS")
	private String showpostcounsellingstatus;
	@Size(max = 1)
	@Column(name = "CURRENTCOUNSELLING")
	private String currentcounselling;
	@Size(max = 1)
	@Column(name = "DEACTIVE")
	private String deactive;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "PAYMENTREQUIRDE")
	private String paymentrequirde;
	@Size(max = 60)
	@Column(name = "SAATEXAMTITLE")
	private String saatexamtitle;
	@Size(max = 60)
	@Column(name = "SAATEXAMDATE")
	private String saatexamdate;
	@Size(max = 260)
	@Column(name = "COUNSELINGVENUE")
	private String counselingvenue;
	@Size(max = 1)
	@Column(name = "ONLINECOUNSMODE")
	private String onlinecounsmode;
	@Size(max = 10)
	@Column(name = "PEREFIX")
	private String perefix;
	@Column(name = "ALLOTMENTNOTFICATIONDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date allotmentnotficationdate;
	@Size(max = 30)
	@Column(name = "DATETILLADDBRANCHCHOICE")
	private String datetilladdbranchchoice;
	@Size(max = 30)
	@Column(name = "DATETIMEOFMOCKALLOCATION")
	private String datetimeofmockallocation;
	@Size(max = 30)
	@Column(name = "DATETILLMODIFYBRANCHCHOICE")
	private String datetillmodifybranchchoice;
	@Size(max = 30)
	@Column(name = "DATETIMEOFFINALALLOCATION")
	private String datetimeoffinalallocation;
	@Size(max = 30)
	@Column(name = "DATETILLEARNESTMONEYTOBPAID")
	private String datetillearnestmoneytobpaid;
	@Size(max = 30)
	@Column(name = "DATEOFFINALADMNNOTIFY")
	private String dateoffinaladmnnotify;
	@Size(max = 3000)
	@Column(name = "POPUPINSTRUCTION")
	private String popupinstruction;
//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cCounsellingid", fetch = FetchType.LAZY)
//	private Collection<CInstitutemaster> cInstitutemasterCollection;
//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cCounsellingid", fetch = FetchType.LAZY)
//	private Collection<CRankingpatterncoursemaster> cRankingpatterncoursemasterCollection;
//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cCounsellingid", fetch = FetchType.LAZY)
//	private Collection<CProgramtypemaster> cProgramtypemasterCollection;
//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cCounsellingid", fetch = FetchType.LAZY)
//	private Collection<CQualificationmaster> cQualificationmasterCollection;
//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cCounsellingid", fetch = FetchType.LAZY)
//	private Collection<CRankingpatternmaster> cRankingpatternmasterCollection;
//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cCounsellingid", fetch = FetchType.LAZY)
//	private Collection<CTestsubject> cTestsubjectCollection;
//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cCounsellingid", fetch = FetchType.LAZY)
//	private Collection<CCategorymaster> cCategorymasterCollection;

	public CCounsellingid() {
	}

	public CCounsellingid(String cid) {
		this.cid = cid;
	}

	public CCounsellingid(String cid, String counsellingtitle, Date dateofcounselling, String paymentrequirde) {
		this.cid = cid;
		this.counsellingtitle = counsellingtitle;
		this.dateofcounselling = dateofcounselling;
		this.paymentrequirde = paymentrequirde;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getCounsellingtitle() {
		return counsellingtitle;
	}

	public void setCounsellingtitle(String counsellingtitle) {
		this.counsellingtitle = counsellingtitle;
	}

	public Date getDateofcounselling() {
		return dateofcounselling;
	}

	public void setDateofcounselling(Date dateofcounselling) {
		this.dateofcounselling = dateofcounselling;
	}

	public String getCounsellingdesc1() {
		return counsellingdesc1;
	}

	public void setCounsellingdesc1(String counsellingdesc1) {
		this.counsellingdesc1 = counsellingdesc1;
	}

	public String getCounsellingdesc2() {
		return counsellingdesc2;
	}

	public void setCounsellingdesc2(String counsellingdesc2) {
		this.counsellingdesc2 = counsellingdesc2;
	}

	public String getCounsellingdesc3() {
		return counsellingdesc3;
	}

	public void setCounsellingdesc3(String counsellingdesc3) {
		this.counsellingdesc3 = counsellingdesc3;
	}

	public String getMultiplecounselling() {
		return multiplecounselling;
	}

	public void setMultiplecounselling(String multiplecounselling) {
		this.multiplecounselling = multiplecounselling;
	}

	public String getDualattendance() {
		return dualattendance;
	}

	public void setDualattendance(String dualattendance) {
		this.dualattendance = dualattendance;
	}

	public String getCounsellingisover() {
		return counsellingisover;
	}

	public void setCounsellingisover(String counsellingisover) {
		this.counsellingisover = counsellingisover;
	}

	public Date getOverdate() {
		return overdate;
	}

	public void setOverdate(Date overdate) {
		this.overdate = overdate;
	}

	public String getAcademicyear() {
		return academicyear;
	}

	public void setAcademicyear(String academicyear) {
		this.academicyear = academicyear;
	}

	public Long getApplicationformfee() {
		return applicationformfee;
	}

	public void setApplicationformfee(Long applicationformfee) {
		this.applicationformfee = applicationformfee;
	}

	public String getRemunerationpayable() {
		return remunerationpayable;
	}

	public void setRemunerationpayable(String remunerationpayable) {
		this.remunerationpayable = remunerationpayable;
	}

	public String getRemunerationcompanyid() {
		return remunerationcompanyid;
	}

	public void setRemunerationcompanyid(String remunerationcompanyid) {
		this.remunerationcompanyid = remunerationcompanyid;
	}

	public String getRemunerationglid() {
		return remunerationglid;
	}

	public void setRemunerationglid(String remunerationglid) {
		this.remunerationglid = remunerationglid;
	}

	public String getShowapplicationentry() {
		return showapplicationentry;
	}

	public void setShowapplicationentry(String showapplicationentry) {
		this.showapplicationentry = showapplicationentry;
	}

	public String getShowapplicationmodification() {
		return showapplicationmodification;
	}

	public void setShowapplicationmodification(String showapplicationmodification) {
		this.showapplicationmodification = showapplicationmodification;
	}

	public String getShowapplicationstatus() {
		return showapplicationstatus;
	}

	public void setShowapplicationstatus(String showapplicationstatus) {
		this.showapplicationstatus = showapplicationstatus;
	}

	public String getShowcenteallotment() {
		return showcenteallotment;
	}

	public void setShowcenteallotment(String showcenteallotment) {
		this.showcenteallotment = showcenteallotment;
	}

	public String getShowrankcard() {
		return showrankcard;
	}

	public void setShowrankcard(String showrankcard) {
		this.showrankcard = showrankcard;
	}

	public String getShowcounsellinginfo() {
		return showcounsellinginfo;
	}

	public void setShowcounsellinginfo(String showcounsellinginfo) {
		this.showcounsellinginfo = showcounsellinginfo;
	}

	public String getShowpostcounsellingstatus() {
		return showpostcounsellingstatus;
	}

	public void setShowpostcounsellingstatus(String showpostcounsellingstatus) {
		this.showpostcounsellingstatus = showpostcounsellingstatus;
	}

	public String getCurrentcounselling() {
		return currentcounselling;
	}

	public void setCurrentcounselling(String currentcounselling) {
		this.currentcounselling = currentcounselling;
	}

	public String getDeactive() {
		return deactive;
	}

	public void setDeactive(String deactive) {
		this.deactive = deactive;
	}

	public String getPaymentrequirde() {
		return paymentrequirde;
	}

	public void setPaymentrequirde(String paymentrequirde) {
		this.paymentrequirde = paymentrequirde;
	}

	public String getSaatexamtitle() {
		return saatexamtitle;
	}

	public void setSaatexamtitle(String saatexamtitle) {
		this.saatexamtitle = saatexamtitle;
	}

	public String getSaatexamdate() {
		return saatexamdate;
	}

	public void setSaatexamdate(String saatexamdate) {
		this.saatexamdate = saatexamdate;
	}

	public String getCounselingvenue() {
		return counselingvenue;
	}

	public void setCounselingvenue(String counselingvenue) {
		this.counselingvenue = counselingvenue;
	}

	public String getOnlinecounsmode() {
		return onlinecounsmode;
	}

	public void setOnlinecounsmode(String onlinecounsmode) {
		this.onlinecounsmode = onlinecounsmode;
	}

	public String getPerefix() {
		return perefix;
	}

	public void setPerefix(String perefix) {
		this.perefix = perefix;
	}

	public Date getAllotmentnotficationdate() {
		return allotmentnotficationdate;
	}

	public void setAllotmentnotficationdate(Date allotmentnotficationdate) {
		this.allotmentnotficationdate = allotmentnotficationdate;
	}

	public String getDatetilladdbranchchoice() {
		return datetilladdbranchchoice;
	}

	public void setDatetilladdbranchchoice(String datetilladdbranchchoice) {
		this.datetilladdbranchchoice = datetilladdbranchchoice;
	}

	public String getDatetimeofmockallocation() {
		return datetimeofmockallocation;
	}

	public void setDatetimeofmockallocation(String datetimeofmockallocation) {
		this.datetimeofmockallocation = datetimeofmockallocation;
	}

	public String getDatetillmodifybranchchoice() {
		return datetillmodifybranchchoice;
	}

	public void setDatetillmodifybranchchoice(String datetillmodifybranchchoice) {
		this.datetillmodifybranchchoice = datetillmodifybranchchoice;
	}

	public String getDatetimeoffinalallocation() {
		return datetimeoffinalallocation;
	}

	public void setDatetimeoffinalallocation(String datetimeoffinalallocation) {
		this.datetimeoffinalallocation = datetimeoffinalallocation;
	}

	public String getDatetillearnestmoneytobpaid() {
		return datetillearnestmoneytobpaid;
	}

	public void setDatetillearnestmoneytobpaid(String datetillearnestmoneytobpaid) {
		this.datetillearnestmoneytobpaid = datetillearnestmoneytobpaid;
	}

	public String getDateoffinaladmnnotify() {
		return dateoffinaladmnnotify;
	}

	public void setDateoffinaladmnnotify(String dateoffinaladmnnotify) {
		this.dateoffinaladmnnotify = dateoffinaladmnnotify;
	}

	public String getPopupinstruction() {
		return popupinstruction;
	}

	public void setPopupinstruction(String popupinstruction) {
		this.popupinstruction = popupinstruction;
	}

//	@XmlTransient
//	public Collection<CInstitutemaster> getCInstitutemasterCollection() {
//		return cInstitutemasterCollection;
//	}
//
//	public void setCInstitutemasterCollection(Collection<CInstitutemaster> cInstitutemasterCollection) {
//		this.cInstitutemasterCollection = cInstitutemasterCollection;
//	}
//
//	@XmlTransient
//	public Collection<CRankingpatterncoursemaster> getCRankingpatterncoursemasterCollection() {
//		return cRankingpatterncoursemasterCollection;
//	}
//
//	public void setCRankingpatterncoursemasterCollection(
//			Collection<CRankingpatterncoursemaster> cRankingpatterncoursemasterCollection) {
//		this.cRankingpatterncoursemasterCollection = cRankingpatterncoursemasterCollection;
//	}
//
//	@XmlTransient
//	public Collection<CProgramtypemaster> getCProgramtypemasterCollection() {
//		return cProgramtypemasterCollection;
//	}
//
//	public void setCProgramtypemasterCollection(Collection<CProgramtypemaster> cProgramtypemasterCollection) {
//		this.cProgramtypemasterCollection = cProgramtypemasterCollection;
//	}
//
//	@XmlTransient
//	public Collection<CQualificationmaster> getCQualificationmasterCollection() {
//		return cQualificationmasterCollection;
//	}
//
//	public void setCQualificationmasterCollection(Collection<CQualificationmaster> cQualificationmasterCollection) {
//		this.cQualificationmasterCollection = cQualificationmasterCollection;
//	}
//
//	@XmlTransient
//	public Collection<CRankingpatternmaster> getCRankingpatternmasterCollection() {
//		return cRankingpatternmasterCollection;
//	}
//
//	public void setCRankingpatternmasterCollection(Collection<CRankingpatternmaster> cRankingpatternmasterCollection) {
//		this.cRankingpatternmasterCollection = cRankingpatternmasterCollection;
//	}
//
//	@XmlTransient
//	public Collection<CTestsubject> getCTestsubjectCollection() {
//		return cTestsubjectCollection;
//	}
//
//	public void setCTestsubjectCollection(Collection<CTestsubject> cTestsubjectCollection) {
//		this.cTestsubjectCollection = cTestsubjectCollection;
//	}
//
//	@XmlTransient
//	public Collection<CCategorymaster> getCCategorymasterCollection() {
//		return cCategorymasterCollection;
//	}
//
//	public void setCCategorymasterCollection(Collection<CCategorymaster> cCategorymasterCollection) {
//		this.cCategorymasterCollection = cCategorymasterCollection;
//	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (cid != null ? cid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof CCounsellingid)) {
			return false;
		}
		CCounsellingid other = (CCounsellingid) object;
		if ((this.cid == null && other.cid != null) || (this.cid != null && !this.cid.equals(other.cid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.jilit.clxacademics.model.CCounsellingid[ cid=" + cid + " ]";
	}

}
