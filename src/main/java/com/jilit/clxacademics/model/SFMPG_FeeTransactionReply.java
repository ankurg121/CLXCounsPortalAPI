package com.jilit.clxacademics.model;
import java.io.Serializable;
import java.math.BigDecimal;
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

@Entity
@Table(name = "SFMPG#FEETRANSACTIONREPLY")
public class SFMPG_FeeTransactionReply implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TRANSACTIONID")
    private String transactionid;
    @Column(name = "PGTRANSACTIONID")
    private String pgtransactionid;
    @Column(name = "BANKTRANSACTIONID")
    private String banktransactionid;
    @Column(name = "RESPONSEMESSAGE")
    private String responsemessage;
    @Column(name = "CLIENTCODE")
    private String clientcode;
    @Column(name = "TRANSDATETIME")
    @Temporal(TemporalType.DATE)
    private Date transdatetime;
    @Column(name = "BANK_NAME")
    private String bank_name;
    @Column(name = "AMOUNT")
    private BigDecimal amount;
    
    @Column(name = "IPG_TXN_ID")
    private String ipg_txn_id;
    @Column(name = "DISCRIMINATOR")
    private String discriminator;
    @Column(name = "CARDNUMBER")
    private String cardnumber;
    @Column(name = "TRANSACTIONNO")
    private String transactionno;
    @Column(name = "STUDENTID")
    private String studentid;
    @Column(name = "REGISTRATIONID")
    private String registrationid;
    @Column(name = "EVENTID")
    private String eventid;
    @Column(name = "COMPANYID")
    private String companyid;
    @Column(name = "VOUCHERCODE")
    private String vouchercode;
    @Column(name = "VOUCHERID")
    private String voucherid;
    @Column(name = "PRNO")
    private String prno;
    
    public SFMPG_FeeTransactionReply() {
		super();
	}

	public SFMPG_FeeTransactionReply(String transactionid) {
		super();
		this.transactionid = transactionid;
	}

	public SFMPG_FeeTransactionReply(String transactionid, String pgtransactionid, String banktransactionid,
			String responsemessage, String clientcode, Date transdatetime, String bank_name, BigDecimal amount,
			String ipg_txn_id, String discriminator, String cardnumber, String transactionno, String studentid,
			String registrationid, String eventid, String companyid, String vouchercode, String voucherid,
			String prno) {
		super();
		this.transactionid = transactionid;
		this.pgtransactionid = pgtransactionid;
		this.banktransactionid = banktransactionid;
		this.responsemessage = responsemessage;
		this.clientcode = clientcode;
		this.transdatetime = transdatetime;
		this.bank_name = bank_name;
		this.amount = amount;
		this.ipg_txn_id = ipg_txn_id;
		this.discriminator = discriminator;
		this.cardnumber = cardnumber;
		this.transactionno = transactionno;
		this.studentid = studentid;
		this.registrationid = registrationid;
		this.eventid = eventid;
		this.companyid = companyid;
		this.vouchercode = vouchercode;
		this.voucherid = voucherid;
		this.prno = prno;
	}

	public String getTransactionid() {
		return transactionid;
	}

	public void setTransactionid(String transactionid) {
		this.transactionid = transactionid;
	}

	public String getPgtransactionid() {
		return pgtransactionid;
	}

	public void setPgtransactionid(String pgtransactionid) {
		this.pgtransactionid = pgtransactionid;
	}

	public String getBanktransactionid() {
		return banktransactionid;
	}

	public void setBanktransactionid(String banktransactionid) {
		this.banktransactionid = banktransactionid;
	}

	public String getResponsemessage() {
		return responsemessage;
	}

	public void setResponsemessage(String responsemessage) {
		this.responsemessage = responsemessage;
	}

	public String getClientcode() {
		return clientcode;
	}

	public void setClientcode(String clientcode) {
		this.clientcode = clientcode;
	}

	public Date getTransdatetime() {
		return transdatetime;
	}

	public void setTransdatetime(Date transdatetime) {
		this.transdatetime = transdatetime;
	}

	public String getBank_name() {
		return bank_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getIpg_txn_id() {
		return ipg_txn_id;
	}

	public void setIpg_txn_id(String ipg_txn_id) {
		this.ipg_txn_id = ipg_txn_id;
	}

	public String getDiscriminator() {
		return discriminator;
	}

	public void setDiscriminator(String discriminator) {
		this.discriminator = discriminator;
	}

	public String getCardnumber() {
		return cardnumber;
	}

	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}

	public String getTransactionno() {
		return transactionno;
	}

	public void setTransactionno(String transactionno) {
		this.transactionno = transactionno;
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

	public String getCompanyid() {
		return companyid;
	}

	public void setCompanyid(String companyid) {
		this.companyid = companyid;
	}

	public String getVouchercode() {
		return vouchercode;
	}

	public void setVouchercode(String vouchercode) {
		this.vouchercode = vouchercode;
	}

	public String getVoucherid() {
		return voucherid;
	}

	public void setVoucherid(String voucherid) {
		this.voucherid = voucherid;
	}

	public String getPrno() {
		return prno;
	}

	public void setPrno(String prno) {
		this.prno = prno;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((bank_name == null) ? 0 : bank_name.hashCode());
		result = prime * result + ((banktransactionid == null) ? 0 : banktransactionid.hashCode());
		result = prime * result + ((cardnumber == null) ? 0 : cardnumber.hashCode());
		result = prime * result + ((clientcode == null) ? 0 : clientcode.hashCode());
		result = prime * result + ((companyid == null) ? 0 : companyid.hashCode());
		result = prime * result + ((discriminator == null) ? 0 : discriminator.hashCode());
		result = prime * result + ((eventid == null) ? 0 : eventid.hashCode());
		result = prime * result + ((ipg_txn_id == null) ? 0 : ipg_txn_id.hashCode());
		result = prime * result + ((pgtransactionid == null) ? 0 : pgtransactionid.hashCode());
		result = prime * result + ((prno == null) ? 0 : prno.hashCode());
		result = prime * result + ((registrationid == null) ? 0 : registrationid.hashCode());
		result = prime * result + ((responsemessage == null) ? 0 : responsemessage.hashCode());
		result = prime * result + ((studentid == null) ? 0 : studentid.hashCode());
		result = prime * result + ((transactionid == null) ? 0 : transactionid.hashCode());
		result = prime * result + ((transactionno == null) ? 0 : transactionno.hashCode());
		result = prime * result + ((transdatetime == null) ? 0 : transdatetime.hashCode());
		result = prime * result + ((vouchercode == null) ? 0 : vouchercode.hashCode());
		result = prime * result + ((voucherid == null) ? 0 : voucherid.hashCode());
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
		SFMPG_FeeTransactionReply other = (SFMPG_FeeTransactionReply) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (bank_name == null) {
			if (other.bank_name != null)
				return false;
		} else if (!bank_name.equals(other.bank_name))
			return false;
		if (banktransactionid == null) {
			if (other.banktransactionid != null)
				return false;
		} else if (!banktransactionid.equals(other.banktransactionid))
			return false;
		if (cardnumber == null) {
			if (other.cardnumber != null)
				return false;
		} else if (!cardnumber.equals(other.cardnumber))
			return false;
		if (clientcode == null) {
			if (other.clientcode != null)
				return false;
		} else if (!clientcode.equals(other.clientcode))
			return false;
		if (companyid == null) {
			if (other.companyid != null)
				return false;
		} else if (!companyid.equals(other.companyid))
			return false;
		if (discriminator == null) {
			if (other.discriminator != null)
				return false;
		} else if (!discriminator.equals(other.discriminator))
			return false;
		if (eventid == null) {
			if (other.eventid != null)
				return false;
		} else if (!eventid.equals(other.eventid))
			return false;
		if (ipg_txn_id == null) {
			if (other.ipg_txn_id != null)
				return false;
		} else if (!ipg_txn_id.equals(other.ipg_txn_id))
			return false;
		if (pgtransactionid == null) {
			if (other.pgtransactionid != null)
				return false;
		} else if (!pgtransactionid.equals(other.pgtransactionid))
			return false;
		if (prno == null) {
			if (other.prno != null)
				return false;
		} else if (!prno.equals(other.prno))
			return false;
		if (registrationid == null) {
			if (other.registrationid != null)
				return false;
		} else if (!registrationid.equals(other.registrationid))
			return false;
		if (responsemessage == null) {
			if (other.responsemessage != null)
				return false;
		} else if (!responsemessage.equals(other.responsemessage))
			return false;
		if (studentid == null) {
			if (other.studentid != null)
				return false;
		} else if (!studentid.equals(other.studentid))
			return false;
		if (transactionid == null) {
			if (other.transactionid != null)
				return false;
		} else if (!transactionid.equals(other.transactionid))
			return false;
		if (transactionno == null) {
			if (other.transactionno != null)
				return false;
		} else if (!transactionno.equals(other.transactionno))
			return false;
		if (transdatetime == null) {
			if (other.transdatetime != null)
				return false;
		} else if (!transdatetime.equals(other.transdatetime))
			return false;
		if (vouchercode == null) {
			if (other.vouchercode != null)
				return false;
		} else if (!vouchercode.equals(other.vouchercode))
			return false;
		if (voucherid == null) {
			if (other.voucherid != null)
				return false;
		} else if (!voucherid.equals(other.voucherid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SFMPG_FeeTransactionReply [transactionid=" + transactionid + ", pgtransactionid=" + pgtransactionid
				+ ", banktransactionid=" + banktransactionid + ", responsemessage=" + responsemessage + ", clientcode="
				+ clientcode + ", transdatetime=" + transdatetime + ", bank_name=" + bank_name + ", amount=" + amount
				+ ", ipg_txn_id=" + ipg_txn_id + ", discriminator=" + discriminator + ", cardnumber=" + cardnumber
				+ ", transactionno=" + transactionno + ", studentid=" + studentid + ", registrationid=" + registrationid
				+ ", eventid=" + eventid + ", companyid=" + companyid + ", vouchercode=" + vouchercode + ", voucherid="
				+ voucherid + ", prno=" + prno + "]";
	}
    
}
