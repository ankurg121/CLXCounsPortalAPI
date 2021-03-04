package com.jilit.clxacademics.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author ashutosh1.kumar
 */
@Embeddable
public class Log_Clxaudittrail_MasterId implements Serializable {

	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @Column(name = "LOGENTRYID")
    private String logentryid;
    @Basic(optional = false)
    @Column(name = "LOGID")
    private BigDecimal logid;

    public Log_Clxaudittrail_MasterId() {
    }

    public Log_Clxaudittrail_MasterId(String logentryid, BigDecimal logid) {
        this.logentryid = logentryid;
        this.logid = logid;
    }

    public String getLogentryid() {
        return logentryid;
    }

    public void setLogentryid(String logentryid) {
        this.logentryid = logentryid;
    }

    public BigDecimal getLogid() {
        return logid;
    }

    public void setLogid(BigDecimal logid) {
        this.logid = logid;
    }  
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((logentryid == null) ? 0 : logentryid.hashCode());
		result = prime * result + ((logid == null) ? 0 : logid.hashCode());
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
		Log_Clxaudittrail_MasterId other = (Log_Clxaudittrail_MasterId) obj;
		if (logentryid == null) {
			if (other.logentryid != null)
				return false;
		} else if (!logentryid.equals(other.logentryid))
			return false;
		if (logid == null) {
			if (other.logid != null)
				return false;
		} else if (!logid.equals(other.logid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Log_Clxaudittrail_MasterId [logentryid=" + logentryid + ", logid=" + logid + "]";
	}

    
}