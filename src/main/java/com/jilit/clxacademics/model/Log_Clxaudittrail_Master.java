package com.jilit.clxacademics.model;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ashutosh1.kumar
 */
@Entity
@Table(name = "LOG#CLXAUDITTRAIL#MASTER")

public class Log_Clxaudittrail_Master implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected Log_Clxaudittrail_MasterId log_Clxaudittrail_MasterPK;
    @Column(name = "PKCOLUMNNAME")
    private String pkcolumnname;
    @Column(name = "PKVALUES")
    private String pkvalues;
    @Column(name = "ACTIVITY")
    private String activity;
    @Column(name = "ONTABLE")
    private String ontable;
    @Column(name = "ONCOLUMN")
    private String oncolumn;
    @Column(name = "OLDVALUE")
    private String oldvalue;
    @Column(name = "NEWVALUE")
    private String newvalue;
    @Column(name = "REMARKS")
    private String remarks;
    @Column(name = "LOGDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date logdate;
    @Column(name = "LOGBYMEMBERTYPE")
    private String logbymembertype;
    @Column(name = "LOGBYMEMBERID")
    private String logbymemberid;
    @Column(name = "LOGBYMEMBERCODE")
    private String logbymembercode;
    @Column(name = "LOGBYMEMBERNAME")
    private String logbymembername;
    @Column(name = "MACADDRESS")
    private String macaddress;
    @Column(name = "IPADDRESS")
    private String ipaddress;
    @Basic(optional = false)
    @Column(name = "MODULECODE")
    private String modulecode;
    @Column(name = "LOGSTATUS")
    private String logstatus;
    @Column(name = "MENUNAME")
    private String menuname;

    public Log_Clxaudittrail_Master() {
    }

    public Log_Clxaudittrail_Master(Log_Clxaudittrail_MasterId log_Clxaudittrail_MasterPK) {
        this.log_Clxaudittrail_MasterPK = log_Clxaudittrail_MasterPK;
    }

    public Log_Clxaudittrail_Master(Log_Clxaudittrail_MasterId log_Clxaudittrail_MasterPK, String modulecode) {
        this.log_Clxaudittrail_MasterPK = log_Clxaudittrail_MasterPK;
        this.modulecode = modulecode;
    }

    public Log_Clxaudittrail_Master(String logentryid, BigDecimal logid) {
        this.log_Clxaudittrail_MasterPK = new Log_Clxaudittrail_MasterId(logentryid, logid);
    }

    public Log_Clxaudittrail_MasterId getLog_Clxaudittrail_MasterPK() {
        return log_Clxaudittrail_MasterPK;
    }

    public void setLog_Clxaudittrail_MasterPK(Log_Clxaudittrail_MasterId log_Clxaudittrail_MasterPK) {
        this.log_Clxaudittrail_MasterPK = log_Clxaudittrail_MasterPK;
    }

    public String getPkcolumnname() {
        return pkcolumnname;
    }

    public void setPkcolumnname(String pkcolumnname) {
        this.pkcolumnname = pkcolumnname;
    }

    public String getPkvalues() {
        return pkvalues;
    }

    public void setPkvalues(String pkvalues) {
        this.pkvalues = pkvalues;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getOntable() {
        return ontable;
    }

    public void setOntable(String ontable) {
        this.ontable = ontable;
    }

    public String getOncolumn() {
        return oncolumn;
    }

    public void setOncolumn(String oncolumn) {
        this.oncolumn = oncolumn;
    }

    public String getOldvalue() {
        return oldvalue;
    }

    public void setOldvalue(String oldvalue) {
        this.oldvalue = oldvalue;
    }

    public String getNewvalue() {
        return newvalue;
    }

    public void setNewvalue(String newvalue) {
        this.newvalue = newvalue;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getLogdate() {
        return logdate;
    }

    public void setLogdate(Date logdate) {
        this.logdate = logdate;
    }

    public String getLogbymembertype() {
        return logbymembertype;
    }

    public void setLogbymembertype(String logbymembertype) {
        this.logbymembertype = logbymembertype;
    }

    public String getLogbymemberid() {
        return logbymemberid;
    }

    public void setLogbymemberid(String logbymemberid) {
        this.logbymemberid = logbymemberid;
    }

    public String getLogbymembercode() {
        return logbymembercode;
    }

    public void setLogbymembercode(String logbymembercode) {
        this.logbymembercode = logbymembercode;
    }

    public String getLogbymembername() {
        return logbymembername;
    }

    public void setLogbymembername(String logbymembername) {
        this.logbymembername = logbymembername;
    }

    public String getMacaddress() {
        return macaddress;
    }

    public void setMacaddress(String macaddress) {
        this.macaddress = macaddress;
    }

    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
    }

    public String getModulecode() {
        return modulecode;
    }

    public void setModulecode(String modulecode) {
        this.modulecode = modulecode;
    }

    public String getLogstatus() {
        return logstatus;
    }

    public void setLogstatus(String logstatus) {
        this.logstatus = logstatus;
    }

    public String getMenuname() {
        return menuname;
    }

    @Override
	public String toString() {
		return "Log_Clxaudittrail_Master [log_Clxaudittrail_MasterPK=" + log_Clxaudittrail_MasterPK + ", pkcolumnname="
				+ pkcolumnname + ", pkvalues=" + pkvalues + ", activity=" + activity + ", ontable=" + ontable
				+ ", oncolumn=" + oncolumn + ", oldvalue=" + oldvalue + ", newvalue=" + newvalue + ", remarks="
				+ remarks + ", logdate=" + logdate + ", logbymembertype=" + logbymembertype + ", logbymemberid="
				+ logbymemberid + ", logbymembercode=" + logbymembercode + ", logbymembername=" + logbymembername
				+ ", macaddress=" + macaddress + ", ipaddress=" + ipaddress + ", modulecode=" + modulecode
				+ ", logstatus=" + logstatus + ", menuname=" + menuname + "]";
	}

	public void setMenuname(String menuname) {
        this.menuname = menuname;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (log_Clxaudittrail_MasterPK != null ? log_Clxaudittrail_MasterPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Log_Clxaudittrail_Master)) {
            return false;
        }
        Log_Clxaudittrail_Master other = (Log_Clxaudittrail_Master) object;
        if ((this.log_Clxaudittrail_MasterPK == null && other.log_Clxaudittrail_MasterPK != null) || (this.log_Clxaudittrail_MasterPK != null && !this.log_Clxaudittrail_MasterPK.equals(other.log_Clxaudittrail_MasterPK))) {
            return false;
        }
        return true;
    }

  
    
}