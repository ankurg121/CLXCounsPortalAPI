package com.jilit.clxacademics.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CDraftChoiceMasterPK implements Serializable{

	 @Basic(optional = false)
	    @Column(name = "COUNSELLINGID")
	    private String counsellingid;
	    @Basic(optional = false)
	    @Column(name = "COUNSELLINGNO")
	    private short counsellingno;
	    @Basic(optional = false)
	    @Column(name = "RANK")
	    private String rank;
	    @Basic(optional = false)
	    @Column(name = "CHOICENO")
	    private short choiceno;
	    @Basic(optional = false)
	    @Column(name = "PROGRAMTYPE")
	    private String programtype;
	    @Basic(optional = false)
	    @Column(name = "PROGRAMCODE")
	    private String programcode;
	    @Basic(optional = false)
	    @Column(name = "BRANCHCODE")
	    private String branchcode;
	    @Basic(optional = false)
	    @Column(name = "ALPHA")
	    private String alpha;

	    public CDraftChoiceMasterPK() {
	    }

	    public CDraftChoiceMasterPK(String counsellingid, short counsellingno, String rank, short choiceno, String programtype, String programcode, String branchcode, String alpha) {
	        this.counsellingid = counsellingid;
	        this.counsellingno = counsellingno;
	        this.rank = rank;
	        this.choiceno = choiceno;
	        this.programtype = programtype;
	        this.programcode = programcode;
	        this.branchcode = branchcode;
	        this.alpha = alpha;
	    }

	    public String getCounsellingid() {
	        return counsellingid;
	    }

	    public void setCounsellingid(String counsellingid) {
	        this.counsellingid = counsellingid;
	    }

	    public short getCounsellingno() {
	        return counsellingno;
	    }

	    public void setCounsellingno(short counsellingno) {
	        this.counsellingno = counsellingno;
	    }

	    public String getRank() {
	        return rank;
	    }

	    public void setRank(String rank) {
	        this.rank = rank;
	    }

	    public short getChoiceno() {
	        return choiceno;
	    }

	    public void setChoiceno(short choiceno) {
	        this.choiceno = choiceno;
	    }

	    public String getProgramtype() {
	        return programtype;
	    }

	    public void setProgramtype(String programtype) {
	        this.programtype = programtype;
	    }

	    public String getProgramcode() {
	        return programcode;
	    }

	    public void setProgramcode(String programcode) {
	        this.programcode = programcode;
	    }

	    public String getBranchcode() {
	        return branchcode;
	    }

	    public void setBranchcode(String branchcode) {
	        this.branchcode = branchcode;
	    }

	    public String getAlpha() {
	        return alpha;
	    }

	    public void setAlpha(String alpha) {
	        this.alpha = alpha;
	    }

	    @Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((alpha == null) ? 0 : alpha.hashCode());
			result = prime * result + ((branchcode == null) ? 0 : branchcode.hashCode());
			result = prime * result + choiceno;
			result = prime * result + ((counsellingid == null) ? 0 : counsellingid.hashCode());
			result = prime * result + counsellingno;
			result = prime * result + ((programcode == null) ? 0 : programcode.hashCode());
			result = prime * result + ((programtype == null) ? 0 : programtype.hashCode());
			result = prime * result + ((rank == null) ? 0 : rank.hashCode());
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
			CDraftChoiceMasterPK other = (CDraftChoiceMasterPK) obj;
			if (alpha == null) {
				if (other.alpha != null)
					return false;
			} else if (!alpha.equals(other.alpha))
				return false;
			if (branchcode == null) {
				if (other.branchcode != null)
					return false;
			} else if (!branchcode.equals(other.branchcode))
				return false;
			if (choiceno != other.choiceno)
				return false;
			if (counsellingid == null) {
				if (other.counsellingid != null)
					return false;
			} else if (!counsellingid.equals(other.counsellingid))
				return false;
			if (counsellingno != other.counsellingno)
				return false;
			if (programcode == null) {
				if (other.programcode != null)
					return false;
			} else if (!programcode.equals(other.programcode))
				return false;
			if (programtype == null) {
				if (other.programtype != null)
					return false;
			} else if (!programtype.equals(other.programtype))
				return false;
			if (rank == null) {
				if (other.rank != null)
					return false;
			} else if (!rank.equals(other.rank))
				return false;
			return true;
		}

		@Override
	    public String toString() {
	        return "com.jilit.clxacademics.model.CChoiceMasterPK[ counsellingid=" + counsellingid + ", counsellingno=" + counsellingno + ", rank=" + rank + ", choiceno=" + choiceno + ", programtype=" + programtype + ", programcode=" + programcode + ", branchcode=" + branchcode + ", alpha=" + alpha + " ]";
	    }
}
