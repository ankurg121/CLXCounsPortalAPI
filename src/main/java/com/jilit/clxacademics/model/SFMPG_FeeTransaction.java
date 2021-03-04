package com.jilit.clxacademics.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "SFMPG#FEETRANSACTION")
public class SFMPG_FeeTransaction implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "TRANSACTIONID")
    private String transactionid;
    @Size(min = 1, max = 20)
    @Column(name = "INSTITUTEID")
    private String instituteid;
    @Size(min = 1, max = 20)
    @Column(name = "STUDENTID")
    private String studentid;
    @Size(min = 1, max = 20)
    @Column(name = "REGISTRATIONID")
    private String registrationid;
    @Size(min = 1, max = 20)
    @Column(name = "EVENTID")
    private String eventid;
    @Column(name = "TRANSDATETIME")
    @Temporal(TemporalType.DATE)
    private Date transdatetime;
    @Size(min = 1, max = 20)
    @Column(name = "FEECURRENCYID")
    private String feecurrencyid;
    @Column(name = "FEEAMOUNT")
    private BigDecimal feeamount;
    @Column(name = "OTHERCHARGESAMOUNT")
    private BigDecimal otherchargesamount;
    @Column(name = "TOTALPAIDAMOUNT")
    private BigDecimal totalpaidamount;
    @Size(min = 1, max = 20)
    @Column(name = "PAYMENTCURRENCYID")
    private String paymentcurrencyid;
    @Size(min = 1, max = 50)
    @Column(name = "TRANSACTIONDONEBY")
    private String transactiondoneby;
    @Column(name = "TRANSACTIONSTATUS")
    private String transactionstatus;
    @Size(min = 1, max = 200)
    @Column(name = "REMARKS")
    private String remarks;
    @Size(min = 1, max = 20)
    @Column(name = "IPADDRESS")
    private String ipaddress;
    
	public SFMPG_FeeTransaction() {
		super();
	}

	public String getTransactionid() {
		return transactionid;
	}

	public void setTransactionid(String transactionid) {
		this.transactionid = transactionid;
	}

	public String getInstituteid() {
		return instituteid;
	}

	public void setInstituteid(String instituteid) {
		this.instituteid = instituteid;
	}

	public String getStudentid() {
		return studentid;
	}

	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}

	

	

	public String getRegistrationid() {
		return registrationid;
	}

	public void setRegistrationid(String registrationid) {
		this.registrationid = registrationid;
	}

	public String getEventid() {
		return eventid;
	}

	public void setEventid(String eventid) {
		this.eventid = eventid;
	}

	public Date getTransdatetime() {
		return transdatetime;
	}

	public void setTransdatetime(Date transdatetime) {
		this.transdatetime = transdatetime;
	}

	public String getFeecurrencyid() {
		return feecurrencyid;
	}

	public void setFeecurrencyid(String feecurrencyid) {
		this.feecurrencyid = feecurrencyid;
	}

	public BigDecimal getFeeamount() {
		return feeamount;
	}

	public void setFeeamount(BigDecimal feeamount) {
		this.feeamount = feeamount;
	}

	public BigDecimal getOtherchargesamount() {
		return otherchargesamount;
	}

	public void setOtherchargesamount(BigDecimal otherchargesamount) {
		this.otherchargesamount = otherchargesamount;
	}

	public BigDecimal getTotalpaidamount() {
		return totalpaidamount;
	}

	public void setTotalpaidamount(BigDecimal totalpaidamount) {
		this.totalpaidamount = totalpaidamount;
	}

	public String getPaymentcurrencyid() {
		return paymentcurrencyid;
	}

	public void setPaymentcurrencyid(String paymentcurrencyid) {
		this.paymentcurrencyid = paymentcurrencyid;
	}

	public String getTransactiondoneby() {
		return transactiondoneby;
	}

	public void setTransactiondoneby(String transactiondoneby) {
		this.transactiondoneby = transactiondoneby;
	}

	public String getTransactionstatus() {
		return transactionstatus;
	}

	public void setTransactionstatus(String transactionstatus) {
		this.transactionstatus = transactionstatus;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getIpaddress() {
		return ipaddress;
	}

	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((registrationid == null) ? 0 : registrationid.hashCode());
		result = prime * result + ((eventid == null) ? 0 : eventid.hashCode());
		result = prime * result + ((feeamount == null) ? 0 : feeamount.hashCode());
		result = prime * result + ((feecurrencyid == null) ? 0 : feecurrencyid.hashCode());
		result = prime * result + ((instituteid == null) ? 0 : instituteid.hashCode());
		result = prime * result + ((ipaddress == null) ? 0 : ipaddress.hashCode());
		result = prime * result + ((otherchargesamount == null) ? 0 : otherchargesamount.hashCode());
		result = prime * result + ((paymentcurrencyid == null) ? 0 : paymentcurrencyid.hashCode());
		result = prime * result + ((remarks == null) ? 0 : remarks.hashCode());
		result = prime * result + ((studentid == null) ? 0 : studentid.hashCode());
		result = prime * result + ((totalpaidamount == null) ? 0 : totalpaidamount.hashCode());
		result = prime * result + ((transactiondoneby == null) ? 0 : transactiondoneby.hashCode());
		result = prime * result + ((transactionid == null) ? 0 : transactionid.hashCode());
		result = prime * result + ((transactionstatus == null) ? 0 : transactionstatus.hashCode());
		result = prime * result + ((transdatetime == null) ? 0 : transdatetime.hashCode());
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
		SFMPG_FeeTransaction other = (SFMPG_FeeTransaction) obj;
		if (registrationid == null) {
			if (other.registrationid != null)
				return false;
		} else if (!registrationid.equals(other.registrationid))
			return false;
		if (eventid == null) {
			if (other.eventid != null)
				return false;
		} else if (!eventid.equals(other.eventid))
			return false;
		if (feeamount == null) {
			if (other.feeamount != null)
				return false;
		} else if (!feeamount.equals(other.feeamount))
			return false;
		if (feecurrencyid == null) {
			if (other.feecurrencyid != null)
				return false;
		} else if (!feecurrencyid.equals(other.feecurrencyid))
			return false;
		if (instituteid == null) {
			if (other.instituteid != null)
				return false;
		} else if (!instituteid.equals(other.instituteid))
			return false;
		if (ipaddress == null) {
			if (other.ipaddress != null)
				return false;
		} else if (!ipaddress.equals(other.ipaddress))
			return false;
		if (otherchargesamount == null) {
			if (other.otherchargesamount != null)
				return false;
		} else if (!otherchargesamount.equals(other.otherchargesamount))
			return false;
		if (paymentcurrencyid == null) {
			if (other.paymentcurrencyid != null)
				return false;
		} else if (!paymentcurrencyid.equals(other.paymentcurrencyid))
			return false;
		if (remarks == null) {
			if (other.remarks != null)
				return false;
		} else if (!remarks.equals(other.remarks))
			return false;
		if (studentid == null) {
			if (other.studentid != null)
				return false;
		} else if (!studentid.equals(other.studentid))
			return false;
		if (totalpaidamount == null) {
			if (other.totalpaidamount != null)
				return false;
		} else if (!totalpaidamount.equals(other.totalpaidamount))
			return false;
		if (transactiondoneby == null) {
			if (other.transactiondoneby != null)
				return false;
		} else if (!transactiondoneby.equals(other.transactiondoneby))
			return false;
		if (transactionid == null) {
			if (other.transactionid != null)
				return false;
		} else if (!transactionid.equals(other.transactionid))
			return false;
		if (transactionstatus == null) {
			if (other.transactionstatus != null)
				return false;
		} else if (!transactionstatus.equals(other.transactionstatus))
			return false;
		if (transdatetime == null) {
			if (other.transdatetime != null)
				return false;
		} else if (!transdatetime.equals(other.transdatetime))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SFMPG_FeeTransaction [transactionid=" + transactionid + ", instituteid=" + instituteid + ", studentid="
				+ studentid + ", registrationid=" + registrationid + ", eventid=" + eventid + ", transdatetime="
				+ transdatetime + ", feecurrencyid=" + feecurrencyid + ", feeamount=" + feeamount
				+ ", otherchargesamount=" + otherchargesamount + ", totalpaidamount=" + totalpaidamount
				+ ", paymentcurrencyid=" + paymentcurrencyid + ", transactiondoneby=" + transactiondoneby
				+ ", transactionstatus=" + transactionstatus + ", remarks=" + remarks + ", ipaddress=" + ipaddress
				+ "]";
	}
}
