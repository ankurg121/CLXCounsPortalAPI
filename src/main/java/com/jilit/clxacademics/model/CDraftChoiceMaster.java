package com.jilit.clxacademics.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "C#DRAFTCHOICEMASTER")
public class CDraftChoiceMaster {
	 private static final long serialVersionUID = 1L;
	    @EmbeddedId
	    protected CDraftChoiceMasterPK CDraftChoiceMasterPK;
	    @Basic(optional = false)
	    @Column(name = "INSTITUTECODE")
	    private String institutecode;
	    @Column(name = "DEACTIVE")
	    private String deactive;
	    @Column(name = "ENTRYBY")
	    private String entryby;
	    @Column(name = "ENTRYDATE")
	    @Temporal(TemporalType.TIMESTAMP)
	    private Date entrydate;
	    @Column(name = "FREEZE")
	    private String freeze;	   
	    @Column(name = "FREEZEDATE")
	    @Temporal(TemporalType.TIMESTAMP)
	    private Date freezedate;
	    @JoinColumns({
	        @JoinColumn(name = "PROGRAMTYPE", referencedColumnName = "PROGRAMTYPE", insertable = false, updatable = false)
	        , @JoinColumn(name = "PROGRAMCODE", referencedColumnName = "PROGRAMCODE", insertable = false, updatable = false)
	        , @JoinColumn(name = "BRANCHCODE", referencedColumnName = "BRANCHCODE", insertable = false, updatable = false)})
	    @ManyToOne(optional = false)
	    private CBranchMaster cBranchMaster;
	    
		public CDraftChoiceMaster() {
			super();
			// TODO Auto-generated constructor stub
		}

		public CDraftChoiceMasterPK getCDraftChoiceMasterPK() {
			return CDraftChoiceMasterPK;
		}

		public void setCDraftChoiceMasterPK(CDraftChoiceMasterPK cDraftChoiceMasterPK) {
			CDraftChoiceMasterPK = cDraftChoiceMasterPK;
		}

		public String getInstitutecode() {
			return institutecode;
		}

		public void setInstitutecode(String institutecode) {
			this.institutecode = institutecode;
		}

		public String getDeactive() {
			return deactive;
		}

		public void setDeactive(String deactive) {
			this.deactive = deactive;
		}

		public String getEntryby() {
			return entryby;
		}

		public void setEntryby(String entryby) {
			this.entryby = entryby;
		}

		public Date getEntrydate() {
			return entrydate;
		}

		public void setEntrydate(Date entrydate) {
			this.entrydate = entrydate;
		}

		public String getFreeze() {
			return freeze;
		}

		public void setFreeze(String freeze) {
			this.freeze = freeze;
		}

		public Date getFreezedate() {
			return freezedate;
		}

		public void setFreezedate(Date freezedate) {
			this.freezedate = freezedate;
		}

		public CBranchMaster getcBranchMaster() {
			return cBranchMaster;
		}

		public void setcBranchMaster(CBranchMaster cBranchMaster) {
			this.cBranchMaster = cBranchMaster;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((CDraftChoiceMasterPK == null) ? 0 : CDraftChoiceMasterPK.hashCode());
			result = prime * result + ((cBranchMaster == null) ? 0 : cBranchMaster.hashCode());
			result = prime * result + ((deactive == null) ? 0 : deactive.hashCode());
			result = prime * result + ((entryby == null) ? 0 : entryby.hashCode());
			result = prime * result + ((entrydate == null) ? 0 : entrydate.hashCode());
			result = prime * result + ((freeze == null) ? 0 : freeze.hashCode());
			result = prime * result + ((freezedate == null) ? 0 : freezedate.hashCode());
			result = prime * result + ((institutecode == null) ? 0 : institutecode.hashCode());
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
			CDraftChoiceMaster other = (CDraftChoiceMaster) obj;
			if (CDraftChoiceMasterPK == null) {
				if (other.CDraftChoiceMasterPK != null)
					return false;
			} else if (!CDraftChoiceMasterPK.equals(other.CDraftChoiceMasterPK))
				return false;
			if (cBranchMaster == null) {
				if (other.cBranchMaster != null)
					return false;
			} else if (!cBranchMaster.equals(other.cBranchMaster))
				return false;
			if (deactive == null) {
				if (other.deactive != null)
					return false;
			} else if (!deactive.equals(other.deactive))
				return false;
			if (entryby == null) {
				if (other.entryby != null)
					return false;
			} else if (!entryby.equals(other.entryby))
				return false;
			if (entrydate == null) {
				if (other.entrydate != null)
					return false;
			} else if (!entrydate.equals(other.entrydate))
				return false;
			if (freeze == null) {
				if (other.freeze != null)
					return false;
			} else if (!freeze.equals(other.freeze))
				return false;
			if (freezedate == null) {
				if (other.freezedate != null)
					return false;
			} else if (!freezedate.equals(other.freezedate))
				return false;
			if (institutecode == null) {
				if (other.institutecode != null)
					return false;
			} else if (!institutecode.equals(other.institutecode))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "CDraftChoiceMaster [CDraftChoiceMasterPK=" + CDraftChoiceMasterPK + ", institutecode="
					+ institutecode + ", deactive=" + deactive + ", entryby=" + entryby + ", entrydate=" + entrydate
					+ ", freeze=" + freeze + ", freezedate=" + freezedate + ", cBranchMaster=" + cBranchMaster + "]";
		}

		
}
