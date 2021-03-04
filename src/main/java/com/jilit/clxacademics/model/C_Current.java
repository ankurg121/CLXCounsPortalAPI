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
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author smriti.porwal
 */
@Entity
@Table(name = "C#CURRENT")
@XmlRootElement
public class C_Current implements Serializable {

	private static final long serialVersionUID = 1L;
    
	@Id
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 20)
	@Column(name = "COUNSELLINGID")
	private String cid;
	
	@Column(name = "ACADEMICYEAR")
	private String academicyear;
	
	@Column(name = "YEARFROM")
	@Temporal(TemporalType.TIMESTAMP)
	private Date yearfrom;
	
	@Column(name = "YEARTO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date yearto;
	
	@Column(name = "CASHGLID")
	private String cashglid;
	
	@Column(name = "BANKGLID")
	private String bankglid;
	
	@Column(name = "JVGLID")
	private String jvglid;
	
	@Column(name = "LOCATIONCODE")
	private String LOCATIONCODE;
	
	@Column(name = "PROGRAMCODE")
	private String PROGRAMCODE;
	
	@Column(name = "ACCOUNTINGCOMPANY")
	private String accountingcompany;
	
	@Column(name = "HOSTELALLOTEDFROM")
	@Temporal(TemporalType.TIMESTAMP)
	private Date hostelallotedfrom;
	
	@Column(name = "HOSTELALLOTEDTO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date hostelallotedto;
	
	@Column(name = "SNAPSHOTS")
	private String snapshots;
	
	@Column(name = "COUNSELLINGNO")
	private Integer counsellingno;
	
	@Column(name = "ATTENDANCESNAPSHOTS")
	private String attendancesnapshots;
	
	@Column(name = "REGCODE")
	private String regcode;
	
	@Column(name = "COUNSELLINGMSG")
	private String counsellingmsg;
	
	@Column(name = "STOPSEATDISPLAY")
	private String stopseatdisplay;
	
	@Column(name = "CATEGORYID")
	private String categoryid;
	
	@Column(name = "COUNSELLINGSTARTDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date counsellingstartdate;

	

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getAcademicyear() {
		return academicyear;
	}

	public void setAcademicyear(String academicyear) {
		this.academicyear = academicyear;
	}

	public Date getYearfrom() {
		return yearfrom;
	}

	public void setYearfrom(Date yearfrom) {
		this.yearfrom = yearfrom;
	}

	public Date getYearto() {
		return yearto;
	}

	public void setYearto(Date yearto) {
		this.yearto = yearto;
	}

	public String getCashglid() {
		return cashglid;
	}

	public void setCashglid(String cashglid) {
		this.cashglid = cashglid;
	}

	public String getBankglid() {
		return bankglid;
	}

	public void setBankglid(String bankglid) {
		this.bankglid = bankglid;
	}

	public String getJvglid() {
		return jvglid;
	}

	public void setJvglid(String jvglid) {
		this.jvglid = jvglid;
	}

	public String getLOCATIONCODE() {
		return LOCATIONCODE;
	}

	public void setLOCATIONCODE(String lOCATIONCODE) {
		LOCATIONCODE = lOCATIONCODE;
	}

	public String getPROGRAMCODE() {
		return PROGRAMCODE;
	}

	public void setPROGRAMCODE(String pROGRAMCODE) {
		PROGRAMCODE = pROGRAMCODE;
	}

	public String getAccountingcompany() {
		return accountingcompany;
	}

	public void setAccountingcompany(String accountingcompany) {
		this.accountingcompany = accountingcompany;
	}

	public Date getHostelallotedfrom() {
		return hostelallotedfrom;
	}

	public void setHostelallotedfrom(Date hostelallotedfrom) {
		this.hostelallotedfrom = hostelallotedfrom;
	}

	public Date getHostelallotedto() {
		return hostelallotedto;
	}

	public void setHostelallotedto(Date hostelallotedto) {
		this.hostelallotedto = hostelallotedto;
	}

	public String getSnapshots() {
		return snapshots;
	}

	public void setSnapshots(String snapshots) {
		this.snapshots = snapshots;
	}

	public Integer getCounsellingno() {
		return counsellingno;
	}

	public void setCounsellingno(Integer counsellingno) {
		this.counsellingno = counsellingno;
	}

	public String getAttendancesnapshots() {
		return attendancesnapshots;
	}

	public void setAttendancesnapshots(String attendancesnapshots) {
		this.attendancesnapshots = attendancesnapshots;
	}

	public String getRegcode() {
		return regcode;
	}

	public void setRegcode(String regcode) {
		this.regcode = regcode;
	}

	public String getCounsellingmsg() {
		return counsellingmsg;
	}

	public void setCounsellingmsg(String counsellingmsg) {
		this.counsellingmsg = counsellingmsg;
	}

	public String getStopseatdisplay() {
		return stopseatdisplay;
	}

	public void setStopseatdisplay(String stopseatdisplay) {
		this.stopseatdisplay = stopseatdisplay;
	}

	public String getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(String categoryid) {
		this.categoryid = categoryid;
	}

	public Date getCounsellingstartdate() {
		return counsellingstartdate;
	}

	public void setCounsellingstartdate(Date counsellingstartdate) {
		this.counsellingstartdate = counsellingstartdate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((LOCATIONCODE == null) ? 0 : LOCATIONCODE.hashCode());
		result = prime * result + ((PROGRAMCODE == null) ? 0 : PROGRAMCODE.hashCode());
		result = prime * result + ((academicyear == null) ? 0 : academicyear.hashCode());
		result = prime * result + ((accountingcompany == null) ? 0 : accountingcompany.hashCode());
		result = prime * result + ((attendancesnapshots == null) ? 0 : attendancesnapshots.hashCode());
		result = prime * result + ((bankglid == null) ? 0 : bankglid.hashCode());
		result = prime * result + ((cashglid == null) ? 0 : cashglid.hashCode());
		result = prime * result + ((categoryid == null) ? 0 : categoryid.hashCode());
		result = prime * result + ((cid == null) ? 0 : cid.hashCode());
		result = prime * result + ((counsellingmsg == null) ? 0 : counsellingmsg.hashCode());
		result = prime * result + ((counsellingno == null) ? 0 : counsellingno.hashCode());
		result = prime * result + ((counsellingstartdate == null) ? 0 : counsellingstartdate.hashCode());
		result = prime * result + ((hostelallotedfrom == null) ? 0 : hostelallotedfrom.hashCode());
		result = prime * result + ((hostelallotedto == null) ? 0 : hostelallotedto.hashCode());
		result = prime * result + ((jvglid == null) ? 0 : jvglid.hashCode());
		result = prime * result + ((regcode == null) ? 0 : regcode.hashCode());
		result = prime * result + ((snapshots == null) ? 0 : snapshots.hashCode());
		result = prime * result + ((stopseatdisplay == null) ? 0 : stopseatdisplay.hashCode());
		result = prime * result + ((yearfrom == null) ? 0 : yearfrom.hashCode());
		result = prime * result + ((yearto == null) ? 0 : yearto.hashCode());
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
		C_Current other = (C_Current) obj;
		if (LOCATIONCODE == null) {
			if (other.LOCATIONCODE != null)
				return false;
		} else if (!LOCATIONCODE.equals(other.LOCATIONCODE))
			return false;
		if (PROGRAMCODE == null) {
			if (other.PROGRAMCODE != null)
				return false;
		} else if (!PROGRAMCODE.equals(other.PROGRAMCODE))
			return false;
		if (academicyear == null) {
			if (other.academicyear != null)
				return false;
		} else if (!academicyear.equals(other.academicyear))
			return false;
		if (accountingcompany == null) {
			if (other.accountingcompany != null)
				return false;
		} else if (!accountingcompany.equals(other.accountingcompany))
			return false;
		if (attendancesnapshots == null) {
			if (other.attendancesnapshots != null)
				return false;
		} else if (!attendancesnapshots.equals(other.attendancesnapshots))
			return false;
		if (bankglid == null) {
			if (other.bankglid != null)
				return false;
		} else if (!bankglid.equals(other.bankglid))
			return false;
		if (cashglid == null) {
			if (other.cashglid != null)
				return false;
		} else if (!cashglid.equals(other.cashglid))
			return false;
		if (categoryid == null) {
			if (other.categoryid != null)
				return false;
		} else if (!categoryid.equals(other.categoryid))
			return false;
		if (cid == null) {
			if (other.cid != null)
				return false;
		} else if (!cid.equals(other.cid))
			return false;
		if (counsellingmsg == null) {
			if (other.counsellingmsg != null)
				return false;
		} else if (!counsellingmsg.equals(other.counsellingmsg))
			return false;
		if (counsellingno == null) {
			if (other.counsellingno != null)
				return false;
		} else if (!counsellingno.equals(other.counsellingno))
			return false;
		if (counsellingstartdate == null) {
			if (other.counsellingstartdate != null)
				return false;
		} else if (!counsellingstartdate.equals(other.counsellingstartdate))
			return false;
		if (hostelallotedfrom == null) {
			if (other.hostelallotedfrom != null)
				return false;
		} else if (!hostelallotedfrom.equals(other.hostelallotedfrom))
			return false;
		if (hostelallotedto == null) {
			if (other.hostelallotedto != null)
				return false;
		} else if (!hostelallotedto.equals(other.hostelallotedto))
			return false;
		if (jvglid == null) {
			if (other.jvglid != null)
				return false;
		} else if (!jvglid.equals(other.jvglid))
			return false;
		if (regcode == null) {
			if (other.regcode != null)
				return false;
		} else if (!regcode.equals(other.regcode))
			return false;
		if (snapshots == null) {
			if (other.snapshots != null)
				return false;
		} else if (!snapshots.equals(other.snapshots))
			return false;
		if (stopseatdisplay == null) {
			if (other.stopseatdisplay != null)
				return false;
		} else if (!stopseatdisplay.equals(other.stopseatdisplay))
			return false;
		if (yearfrom == null) {
			if (other.yearfrom != null)
				return false;
		} else if (!yearfrom.equals(other.yearfrom))
			return false;
		if (yearto == null) {
			if (other.yearto != null)
				return false;
		} else if (!yearto.equals(other.yearto))
			return false;
		return true;
	}

	
}
