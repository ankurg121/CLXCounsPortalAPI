
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jilit.clxacademics.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Anubhav
 */
@Entity
@Table(name = "C#ALLOCATIONDETAIL")
public class CAllocationDetail implements Serializable {

	private static final long serialVersionUID = 1L;
	@EmbeddedId
	protected CAllocationDetailPK cAllocationDetailPK;
	@Column(name = "ACADEMICYEAR")
	private String academicyear;
	@Column(name = "FROMCATEGORY")
	private String fromcategory;
	@Column(name = "QUOTA")
	private String quota;
	@Column(name = "ALLOTEDALPHA")
	private String allotedalpha;
	@Column(name = "FIXIT")
	private String fixit;
	@Column(name = "COUNSELLINGDONE")
	private String counsellingdone;
	@Column(name = "ACTUALCOUNSELLINGDONE")
	private String actualcounsellingdone;
	@Column(name = "LATE")
	private String late;
	@Column(name = "COUNSELLINGDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date counsellingdate;
	@Column(name = "ADMISSIONCONFIRMED")
	private String admissionconfirmed;
	@Column(name = "HOSTELREQUIRED")
	private Character hostelrequired;
	@Column(name = "HOSTELTYPEALLOTED")
	private String hosteltypealloted;
	@Column(name = "HOSTELCODEALLOTED")
	private String hostelcodealloted;
	@Column(name = "HOSTELALLOTEDDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date hostelalloteddate;
	@Column(name = "ABSENT")
	private String absent;
	@Column(name = "DEFAULTER")
	private String defaulter;
	@Column(name = "DEFAULTERDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date defaulterdate;
	@Column(name = "DEFAULTERREMARKS")
	private String defaulterremarks;
	@Column(name = "FORMERINSTITUTE")
	private String formerinstitute;
	@Column(name = "FORMERPROGRAM")
	private String formerprogram;
	@Column(name = "FORMERBRANCH")
	private String formerbranch;
	@Column(name = "FORMERALPHA")
	private String formeralpha;
	@Column(name = "LASTCOUNSELLINGNO")
	private Integer lastcounsellingno;
	@Column(name = "LASTHOSTELALLOTEDNO")
	private Integer lasthostelallotedno;
	@Column(name = "COUNSFORINSTITUTE")
	private String counsforinstitute;
	@Column(name = "HOSTELWAITING")
	private String hostelwaiting;
	@Column(name = "DIRECTWAITENTRY")
	private String directwaitentry;
	@Column(name = "SEQID")
	private Integer seqid;
	@Column(name = "FIXREMARKS")
	private String fixremarks;
	@Column(name = "FIXDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fixdate;
	@Column(name = "FIXBY")
	private String fixby;
	@Column(name = "DEFAULTERBY")
	private String defaulterby;
	@Column(name = "ALLOTEDINSTITUTE")
	private String allotedinstitute;
	@Column(name = "ALLOTEDPROGRAM")
	private String allotedprogram;
	@Column(name = "ALLOTEDBRANCH")
	private String allotedbranch;
	@Column(name = "HOLD")
	private String hold;
	// @JoinColumns({
	// @JoinColumn(name = "ALLOTEDINSTITUTE", referencedColumnName =
	// "INSTITUTECODE")
	// , @JoinColumn(name = "PROGRAMTYPE", referencedColumnName = "PROGRAMTYPE")
	// , @JoinColumn(name = "ALLOTEDPROGRAM", referencedColumnName =
	// "PROGRAMCODE")
	// , @JoinColumn(name = "ALLOTEDBRANCH", referencedColumnName =
	// "BRANCHCODE")})
	// @ManyToOne(optional = false)
	// private CInstituteBranchTagging cInstituteBranchTagging;
	// @JoinColumns({
	// @JoinColumn(name = "INSTITUTECODE", referencedColumnName =
	// "INSTITUTECODE")
	// , @JoinColumn(name = "COUNSELLINGID", referencedColumnName =
	// "COUNSELLINGID")
	// , @JoinColumn(name = "PROGRAMTYPE", referencedColumnName = "PROGRAMTYPE")
	// , @JoinColumn(name = "RANK", referencedColumnName = "RANK")})
	// @ManyToOne(optional = false)
	// private CStudentMaster cStudentMaster;

	public CAllocationDetail() {
	}

	public CAllocationDetailPK getcAllocationDetailPK() {
		return cAllocationDetailPK;
	}

	public void setcAllocationDetailPK(CAllocationDetailPK cAllocationDetailPK) {
		this.cAllocationDetailPK = cAllocationDetailPK;
	}

	// public CInstituteBranchTagging getcInstituteBranchTagging() {
	// return cInstituteBranchTagging;
	// }
	//
	//
	//
	// public void setcInstituteBranchTagging(CInstituteBranchTagging
	// cInstituteBranchTagging) {
	// this.cInstituteBranchTagging = cInstituteBranchTagging;
	// }
	//
	//
	//
	// public CStudentMaster getcStudentMaster() {
	// return cStudentMaster;
	// }
	//
	//
	//
	// public void setcStudentMaster(CStudentMaster cStudentMaster) {
	// this.cStudentMaster = cStudentMaster;
	// }
	//

	public CAllocationDetail(CAllocationDetailPK cAllocationDetailPK) {
		this.cAllocationDetailPK = cAllocationDetailPK;
	}

	public CAllocationDetail(String institutecode, String counsellingid, short counsellingno, String programtype,
			String rank) {
		this.cAllocationDetailPK = new CAllocationDetailPK(institutecode, counsellingid, counsellingno, programtype,
				rank);
	}

	public CAllocationDetailPK getCAllocationDetailPK() {
		return cAllocationDetailPK;
	}

	public void setCAllocationDetailPK(CAllocationDetailPK cAllocationDetailPK) {
		this.cAllocationDetailPK = cAllocationDetailPK;
	}

	public String getAcademicyear() {
		return academicyear;
	}

	public void setAcademicyear(String academicyear) {
		this.academicyear = academicyear;
	}

	public String getFromcategory() {
		return fromcategory;
	}

	public void setFromcategory(String fromcategory) {
		this.fromcategory = fromcategory;
	}

	public String getQuota() {
		return quota;
	}

	public void setQuota(String quota) {
		this.quota = quota;
	}

	public String getAllotedalpha() {
		return allotedalpha;
	}

	public void setAllotedalpha(String allotedalpha) {
		this.allotedalpha = allotedalpha;
	}

	public String getFixit() {
		return fixit;
	}

	public void setFixit(String fixit) {
		this.fixit = fixit;
	}

	public String getCounsellingdone() {
		return counsellingdone;
	}

	public void setCounsellingdone(String counsellingdone) {
		this.counsellingdone = counsellingdone;
	}

	public String getActualcounsellingdone() {
		return actualcounsellingdone;
	}

	public void setActualcounsellingdone(String actualcounsellingdone) {
		this.actualcounsellingdone = actualcounsellingdone;
	}

	public String getLate() {
		return late;
	}

	public void setLate(String late) {
		this.late = late;
	}

	public Date getCounsellingdate() {
		return counsellingdate;
	}

	public void setCounsellingdate(Date counsellingdate) {
		this.counsellingdate = counsellingdate;
	}

	public String getAdmissionconfirmed() {
		return admissionconfirmed;
	}

	public void setAdmissionconfirmed(String admissionconfirmed) {
		this.admissionconfirmed = admissionconfirmed;
	}

	public Character getHostelrequired() {
		return hostelrequired;
	}

	public void setHostelrequired(Character hostelrequired) {
		this.hostelrequired = hostelrequired;
	}

	public String getHosteltypealloted() {
		return hosteltypealloted;
	}

	public void setHosteltypealloted(String hosteltypealloted) {
		this.hosteltypealloted = hosteltypealloted;
	}

	public String getHostelcodealloted() {
		return hostelcodealloted;
	}

	public void setHostelcodealloted(String hostelcodealloted) {
		this.hostelcodealloted = hostelcodealloted;
	}

	public Date getHostelalloteddate() {
		return hostelalloteddate;
	}

	public void setHostelalloteddate(Date hostelalloteddate) {
		this.hostelalloteddate = hostelalloteddate;
	}

	public String getAbsent() {
		return absent;
	}

	public void setAbsent(String absent) {
		this.absent = absent;
	}

	public String getDefaulter() {
		return defaulter;
	}

	public void setDefaulter(String defaulter) {
		this.defaulter = defaulter;
	}

	public Date getDefaulterdate() {
		return defaulterdate;
	}

	public void setDefaulterdate(Date defaulterdate) {
		this.defaulterdate = defaulterdate;
	}

	public String getDefaulterremarks() {
		return defaulterremarks;
	}

	public void setDefaulterremarks(String defaulterremarks) {
		this.defaulterremarks = defaulterremarks;
	}

	public String getFormerinstitute() {
		return formerinstitute;
	}

	public void setFormerinstitute(String formerinstitute) {
		this.formerinstitute = formerinstitute;
	}

	public String getFormerprogram() {
		return formerprogram;
	}

	public void setFormerprogram(String formerprogram) {
		this.formerprogram = formerprogram;
	}

	public String getFormerbranch() {
		return formerbranch;
	}

	public void setFormerbranch(String formerbranch) {
		this.formerbranch = formerbranch;
	}

	public String getFormeralpha() {
		return formeralpha;
	}

	public void setFormeralpha(String formeralpha) {
		this.formeralpha = formeralpha;
	}

	public Integer getLastcounsellingno() {
		return lastcounsellingno;
	}

	public void setLastcounsellingno(Integer lastcounsellingno) {
		this.lastcounsellingno = lastcounsellingno;
	}

	public Integer getLasthostelallotedno() {
		return lasthostelallotedno;
	}

	public void setLasthostelallotedno(Integer lasthostelallotedno) {
		this.lasthostelallotedno = lasthostelallotedno;
	}

	public String getCounsforinstitute() {
		return counsforinstitute;
	}

	public void setCounsforinstitute(String counsforinstitute) {
		this.counsforinstitute = counsforinstitute;
	}

	public String getHostelwaiting() {
		return hostelwaiting;
	}

	public void setHostelwaiting(String hostelwaiting) {
		this.hostelwaiting = hostelwaiting;
	}

	public String getDirectwaitentry() {
		return directwaitentry;
	}

	public void setDirectwaitentry(String directwaitentry) {
		this.directwaitentry = directwaitentry;
	}

	public Integer getSeqid() {
		return seqid;
	}

	public void setSeqid(Integer seqid) {
		this.seqid = seqid;
	}

	public String getFixremarks() {
		return fixremarks;
	}

	public void setFixremarks(String fixremarks) {
		this.fixremarks = fixremarks;
	}

	public Date getFixdate() {
		return fixdate;
	}

	public void setFixdate(Date fixdate) {
		this.fixdate = fixdate;
	}

	public String getFixby() {
		return fixby;
	}

	public void setFixby(String fixby) {
		this.fixby = fixby;
	}

	public String getDefaulterby() {
		return defaulterby;
	}

	public void setDefaulterby(String defaulterby) {
		this.defaulterby = defaulterby;
	}

	public String getAllotedinstitute() {
		return allotedinstitute;
	}

	public void setAllotedinstitute(String allotedinstitute) {
		this.allotedinstitute = allotedinstitute;
	}

	public String getAllotedprogram() {
		return allotedprogram;
	}

	public void setAllotedprogram(String allotedprogram) {
		this.allotedprogram = allotedprogram;
	}

	public String getAllotedbranch() {
		return allotedbranch;
	}

	public void setAllotedbranch(String allotedbranch) {
		this.allotedbranch = allotedbranch;
	}

	public String getHold() {
		return hold;
	}

	public void setHold(String hold) {
		this.hold = hold;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((absent == null) ? 0 : absent.hashCode());
		result = prime * result + ((academicyear == null) ? 0 : academicyear.hashCode());
		result = prime * result + ((actualcounsellingdone == null) ? 0 : actualcounsellingdone.hashCode());
		result = prime * result + ((admissionconfirmed == null) ? 0 : admissionconfirmed.hashCode());
		result = prime * result + ((allotedalpha == null) ? 0 : allotedalpha.hashCode());
		result = prime * result + ((allotedbranch == null) ? 0 : allotedbranch.hashCode());
		result = prime * result + ((allotedinstitute == null) ? 0 : allotedinstitute.hashCode());
		result = prime * result + ((allotedprogram == null) ? 0 : allotedprogram.hashCode());
		result = prime * result + ((cAllocationDetailPK == null) ? 0 : cAllocationDetailPK.hashCode());
		result = prime * result + ((counsellingdate == null) ? 0 : counsellingdate.hashCode());
		result = prime * result + ((counsellingdone == null) ? 0 : counsellingdone.hashCode());
		result = prime * result + ((counsforinstitute == null) ? 0 : counsforinstitute.hashCode());
		result = prime * result + ((defaulter == null) ? 0 : defaulter.hashCode());
		result = prime * result + ((defaulterby == null) ? 0 : defaulterby.hashCode());
		result = prime * result + ((defaulterdate == null) ? 0 : defaulterdate.hashCode());
		result = prime * result + ((defaulterremarks == null) ? 0 : defaulterremarks.hashCode());
		result = prime * result + ((directwaitentry == null) ? 0 : directwaitentry.hashCode());
		result = prime * result + ((fixby == null) ? 0 : fixby.hashCode());
		result = prime * result + ((fixdate == null) ? 0 : fixdate.hashCode());
		result = prime * result + ((fixit == null) ? 0 : fixit.hashCode());
		result = prime * result + ((fixremarks == null) ? 0 : fixremarks.hashCode());
		result = prime * result + ((formeralpha == null) ? 0 : formeralpha.hashCode());
		result = prime * result + ((formerbranch == null) ? 0 : formerbranch.hashCode());
		result = prime * result + ((formerinstitute == null) ? 0 : formerinstitute.hashCode());
		result = prime * result + ((formerprogram == null) ? 0 : formerprogram.hashCode());
		result = prime * result + ((fromcategory == null) ? 0 : fromcategory.hashCode());
		result = prime * result + ((hold == null) ? 0 : hold.hashCode());
		result = prime * result + ((hostelalloteddate == null) ? 0 : hostelalloteddate.hashCode());
		result = prime * result + ((hostelcodealloted == null) ? 0 : hostelcodealloted.hashCode());
		result = prime * result + ((hostelrequired == null) ? 0 : hostelrequired.hashCode());
		result = prime * result + ((hosteltypealloted == null) ? 0 : hosteltypealloted.hashCode());
		result = prime * result + ((hostelwaiting == null) ? 0 : hostelwaiting.hashCode());
		result = prime * result + ((lastcounsellingno == null) ? 0 : lastcounsellingno.hashCode());
		result = prime * result + ((lasthostelallotedno == null) ? 0 : lasthostelallotedno.hashCode());
		result = prime * result + ((late == null) ? 0 : late.hashCode());
		result = prime * result + ((quota == null) ? 0 : quota.hashCode());
		result = prime * result + ((seqid == null) ? 0 : seqid.hashCode());
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
		CAllocationDetail other = (CAllocationDetail) obj;
		if (absent == null) {
			if (other.absent != null)
				return false;
		} else if (!absent.equals(other.absent))
			return false;
		if (academicyear == null) {
			if (other.academicyear != null)
				return false;
		} else if (!academicyear.equals(other.academicyear))
			return false;
		if (actualcounsellingdone == null) {
			if (other.actualcounsellingdone != null)
				return false;
		} else if (!actualcounsellingdone.equals(other.actualcounsellingdone))
			return false;
		if (admissionconfirmed == null) {
			if (other.admissionconfirmed != null)
				return false;
		} else if (!admissionconfirmed.equals(other.admissionconfirmed))
			return false;
		if (allotedalpha == null) {
			if (other.allotedalpha != null)
				return false;
		} else if (!allotedalpha.equals(other.allotedalpha))
			return false;
		if (allotedbranch == null) {
			if (other.allotedbranch != null)
				return false;
		} else if (!allotedbranch.equals(other.allotedbranch))
			return false;
		if (allotedinstitute == null) {
			if (other.allotedinstitute != null)
				return false;
		} else if (!allotedinstitute.equals(other.allotedinstitute))
			return false;
		if (allotedprogram == null) {
			if (other.allotedprogram != null)
				return false;
		} else if (!allotedprogram.equals(other.allotedprogram))
			return false;
		if (cAllocationDetailPK == null) {
			if (other.cAllocationDetailPK != null)
				return false;
		} else if (!cAllocationDetailPK.equals(other.cAllocationDetailPK))
			return false;
		if (counsellingdate == null) {
			if (other.counsellingdate != null)
				return false;
		} else if (!counsellingdate.equals(other.counsellingdate))
			return false;
		if (counsellingdone == null) {
			if (other.counsellingdone != null)
				return false;
		} else if (!counsellingdone.equals(other.counsellingdone))
			return false;
		if (counsforinstitute == null) {
			if (other.counsforinstitute != null)
				return false;
		} else if (!counsforinstitute.equals(other.counsforinstitute))
			return false;
		if (defaulter == null) {
			if (other.defaulter != null)
				return false;
		} else if (!defaulter.equals(other.defaulter))
			return false;
		if (defaulterby == null) {
			if (other.defaulterby != null)
				return false;
		} else if (!defaulterby.equals(other.defaulterby))
			return false;
		if (defaulterdate == null) {
			if (other.defaulterdate != null)
				return false;
		} else if (!defaulterdate.equals(other.defaulterdate))
			return false;
		if (defaulterremarks == null) {
			if (other.defaulterremarks != null)
				return false;
		} else if (!defaulterremarks.equals(other.defaulterremarks))
			return false;
		if (directwaitentry == null) {
			if (other.directwaitentry != null)
				return false;
		} else if (!directwaitentry.equals(other.directwaitentry))
			return false;
		if (fixby == null) {
			if (other.fixby != null)
				return false;
		} else if (!fixby.equals(other.fixby))
			return false;
		if (fixdate == null) {
			if (other.fixdate != null)
				return false;
		} else if (!fixdate.equals(other.fixdate))
			return false;
		if (fixit == null) {
			if (other.fixit != null)
				return false;
		} else if (!fixit.equals(other.fixit))
			return false;
		if (fixremarks == null) {
			if (other.fixremarks != null)
				return false;
		} else if (!fixremarks.equals(other.fixremarks))
			return false;
		if (formeralpha == null) {
			if (other.formeralpha != null)
				return false;
		} else if (!formeralpha.equals(other.formeralpha))
			return false;
		if (formerbranch == null) {
			if (other.formerbranch != null)
				return false;
		} else if (!formerbranch.equals(other.formerbranch))
			return false;
		if (formerinstitute == null) {
			if (other.formerinstitute != null)
				return false;
		} else if (!formerinstitute.equals(other.formerinstitute))
			return false;
		if (formerprogram == null) {
			if (other.formerprogram != null)
				return false;
		} else if (!formerprogram.equals(other.formerprogram))
			return false;
		if (fromcategory == null) {
			if (other.fromcategory != null)
				return false;
		} else if (!fromcategory.equals(other.fromcategory))
			return false;
		if (hold == null) {
			if (other.hold != null)
				return false;
		} else if (!hold.equals(other.hold))
			return false;
		if (hostelalloteddate == null) {
			if (other.hostelalloteddate != null)
				return false;
		} else if (!hostelalloteddate.equals(other.hostelalloteddate))
			return false;
		if (hostelcodealloted == null) {
			if (other.hostelcodealloted != null)
				return false;
		} else if (!hostelcodealloted.equals(other.hostelcodealloted))
			return false;
		if (hostelrequired == null) {
			if (other.hostelrequired != null)
				return false;
		} else if (!hostelrequired.equals(other.hostelrequired))
			return false;
		if (hosteltypealloted == null) {
			if (other.hosteltypealloted != null)
				return false;
		} else if (!hosteltypealloted.equals(other.hosteltypealloted))
			return false;
		if (hostelwaiting == null) {
			if (other.hostelwaiting != null)
				return false;
		} else if (!hostelwaiting.equals(other.hostelwaiting))
			return false;
		if (lastcounsellingno == null) {
			if (other.lastcounsellingno != null)
				return false;
		} else if (!lastcounsellingno.equals(other.lastcounsellingno))
			return false;
		if (lasthostelallotedno == null) {
			if (other.lasthostelallotedno != null)
				return false;
		} else if (!lasthostelallotedno.equals(other.lasthostelallotedno))
			return false;
		if (late == null) {
			if (other.late != null)
				return false;
		} else if (!late.equals(other.late))
			return false;
		if (quota == null) {
			if (other.quota != null)
				return false;
		} else if (!quota.equals(other.quota))
			return false;
		if (seqid == null) {
			if (other.seqid != null)
				return false;
		} else if (!seqid.equals(other.seqid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CAllocationDetail [cAllocationDetailPK=" + cAllocationDetailPK + ", academicyear=" + academicyear
				+ ", fromcategory=" + fromcategory + ", quota=" + quota + ", allotedalpha=" + allotedalpha + ", fixit="
				+ fixit + ", counsellingdone=" + counsellingdone + ", actualcounsellingdone=" + actualcounsellingdone
				+ ", late=" + late + ", counsellingdate=" + counsellingdate + ", admissionconfirmed="
				+ admissionconfirmed + ", hostelrequired=" + hostelrequired + ", hosteltypealloted=" + hosteltypealloted
				+ ", hostelcodealloted=" + hostelcodealloted + ", hostelalloteddate=" + hostelalloteddate + ", absent="
				+ absent + ", defaulter=" + defaulter + ", defaulterdate=" + defaulterdate + ", defaulterremarks="
				+ defaulterremarks + ", formerinstitute=" + formerinstitute + ", formerprogram=" + formerprogram
				+ ", formerbranch=" + formerbranch + ", formeralpha=" + formeralpha + ", lastcounsellingno="
				+ lastcounsellingno + ", lasthostelallotedno=" + lasthostelallotedno + ", counsforinstitute="
				+ counsforinstitute + ", hostelwaiting=" + hostelwaiting + ", directwaitentry=" + directwaitentry
				+ ", seqid=" + seqid + ", fixremarks=" + fixremarks + ", fixdate=" + fixdate + ", fixby=" + fixby
				+ ", defaulterby=" + defaulterby + ", allotedinstitute=" + allotedinstitute + ", allotedprogram="
				+ allotedprogram + ", allotedbranch=" + allotedbranch + ", hold=" + hold + "]";
	}

	// public CInstituteBranchTagging getCInstituteBranchTagging() {
	// return cInstituteBranchTagging;
	// }
	//
	// public void setCInstituteBranchTagging(CInstituteBranchTagging
	// cInstituteBranchTagging) {
	// this.cInstituteBranchTagging = cInstituteBranchTagging;
	// }
	//
	// public CStudentMaster getCStudentMaster() {
	// return cStudentMaster;
	// }
	//
	// public void setCStudentMaster(CStudentMaster cStudentMaster) {
	// this.cStudentMaster = cStudentMaster;
	// }

}

