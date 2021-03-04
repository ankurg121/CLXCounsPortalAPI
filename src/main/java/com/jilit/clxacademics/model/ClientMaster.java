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
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author birampal.singh
 */
@Entity
@Table(name = "CLIENTMASTER")
  
public class ClientMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CLIENTID")
    private String clientid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "CLIENTNAME")
    private String clientname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "OTPREQUIRED")
    private String otprequired;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "PASSWORDREQUIRED")
    private String passwordrequired;
    @Size(max = 1)
    @Column(name = "PASSWORDVALIDATIONMODE")
    private String passwordvalidationmode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "CLIENTDETAIL")
    private String clientdetail;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "LOGOFILE")
    private Serializable logofile;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "WATERMARKFILE")
    private Serializable watermarkfile;
    @Size(max = 100)
    @Column(name = "FROMEMAILID")
    private String fromemailid;
    @Size(max = 300)
    @Column(name = "FROMEMAILPWD")
    private String fromemailpwd;
    @Size(max = 300)
    @Column(name = "REMARKS")
    private String remarks;
    @Size(max = 20)
    @Column(name = "ENTRYBYUSERID")
    private String entrybyuserid;
    @Column(name = "ENTRYBYDATETIME")
    @Temporal(TemporalType.DATE)
    private Date entrybydatetime;
    @Size(max = 20)
    @Column(name = "LASTUPDATEDBYUSERID")
    private String lastupdatedbyuserid;
    @Column(name = "LASTUPDATEDDATETIME")
    @Temporal(TemporalType.DATE)
    private Date lastupdateddatetime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "CAPTCHAREQUIRED")
    private String captcharequired;
    @Size(max = 1)
    @Column(name = "PASSWORDRECOVEYMODE")
    private String passwordrecoveymode;
    @Size(max = 1)
    @Column(name = "COMPLAINTICKETREQUIRED")
    private String complainticketrequired;
    @Size(max = 1)
    @Column(name = "STAFFBDAYNOTIFICATION")
    private String staffbdaynotification;
    @Size(max = 1)
    @Column(name = "STAFFANNVNOTIFICATION")
    private String staffannvnotification;
    @Size(max = 1)
    @Column(name = "NAVIGATIONTOBECAPTURED")
    private String navigationtobecaptured;
    @Size(max = 1)
    @Column(name = "DEACTIVE")
    private String deactive;
    @Size(max = 100)
    @Column(name = "FROMEMAILHOST")
    private String fromemailhost;
    @Size(max = 20)
    @Column(name = "FROMEMAILPORT")
    private String fromemailport;
    @Size(max = 200)
    @Column(name = "CLIENTSMSURL")
    private String clientsmsurl;
    @Size(max = 1)
    @Column(name = "RESETPASSWORDMODE")
    private String resetpasswordmode;
    @Size(max = 30)
    @Column(name = "DEFAULTRESETPASSWORD")
    private String defaultresetpassword; 

    public ClientMaster() {
    }

    public ClientMaster(String clientid) {
        this.clientid = clientid;
    }

 

//	public Clientmaster(String clientid, String clientname, String otprequired, String passwordrequired,
//			String passwordvalidationmode, String clientdetail, String fromemailid, String fromemailpwd, String remarks,
//			String entrybyuserid, Date entrybydatetime, String lastupdatedbyuserid, Date lastupdateddatetime,
//			String captcharequired, String passwordrecoveymode, String complainticketrequired,
//			String staffbdaynotification, String staffannvnotification, String navigationtobecaptured, String deactive,
//			Collection<Wallmessage> wallmessageCollection) {
//		super();
//		this.clientid = clientid;
//		this.clientname = clientname;
//		this.otprequired = otprequired;
//		this.passwordrequired = passwordrequired;
//		this.passwordvalidationmode = passwordvalidationmode;
//		this.clientdetail = clientdetail;
//		this.fromemailid = fromemailid;
//		this.fromemailpwd = fromemailpwd;
//		this.remarks = remarks;
//		this.entrybyuserid = entrybyuserid;
//		this.entrybydatetime = entrybydatetime;
//		this.lastupdatedbyuserid = lastupdatedbyuserid;
//		this.lastupdateddatetime = lastupdateddatetime;
//		this.captcharequired = captcharequired;
//		this.passwordrecoveymode = passwordrecoveymode;
//		this.complainticketrequired = complainticketrequired;
//		this.staffbdaynotification = staffbdaynotification;
//		this.staffannvnotification = staffannvnotification;
//		this.navigationtobecaptured = navigationtobecaptured;
//		this.deactive = deactive;
//		this.wallmessageCollection = wallmessageCollection;
//	}

//	public Clientmaster(String clientid, String clientname, String otprequired, String passwordrequired, String clientdetail, Serializable logofile, Serializable watermarkfile, String captcharequired) {
//        this.clientid = clientid;
//        this.clientname = clientname;
//        this.otprequired = otprequired;
//        this.passwordrequired = passwordrequired;
//        this.clientdetail = clientdetail;
//        this.logofile = logofile;
//        this.watermarkfile = watermarkfile;
//        this.captcharequired = captcharequired;
//    }

    public String getClientid() {
        return clientid;
    }

    public ClientMaster(String clientid, String clientname, String otprequired, String passwordrequired,
			String passwordvalidationmode, String clientdetail, String fromemailid, String fromemailpwd, String remarks,
			String entrybyuserid, Date entrybydatetime, String lastupdatedbyuserid, Date lastupdateddatetime,
			String captcharequired, String passwordrecoveymode, String complainticketrequired,
			String staffbdaynotification, String staffannvnotification, String navigationtobecaptured, String deactive,
			String fromemailhost, String fromemailport, String clientsmsurl, String resetpasswordmode
			) {
		super();
		this.clientid = clientid;
		this.clientname = clientname;
		this.otprequired = otprequired;
		this.passwordrequired = passwordrequired;
		this.passwordvalidationmode = passwordvalidationmode;
		this.clientdetail = clientdetail;
		this.fromemailid = fromemailid;
		this.fromemailpwd = fromemailpwd;
		this.remarks = remarks;
		this.entrybyuserid = entrybyuserid;
		this.entrybydatetime = entrybydatetime;
		this.lastupdatedbyuserid = lastupdatedbyuserid;
		this.lastupdateddatetime = lastupdateddatetime;
		this.captcharequired = captcharequired;
		this.passwordrecoveymode = passwordrecoveymode;
		this.complainticketrequired = complainticketrequired;
		this.staffbdaynotification = staffbdaynotification;
		this.staffannvnotification = staffannvnotification;
		this.navigationtobecaptured = navigationtobecaptured;
		this.deactive = deactive;
		this.fromemailhost = fromemailhost;
		this.fromemailport = fromemailport;
		this.clientsmsurl = clientsmsurl;
		this.resetpasswordmode = resetpasswordmode;
		this.defaultresetpassword = defaultresetpassword;
		 
	} 

	public String getFromemailhost() {
		return fromemailhost;
	}

	public void setFromemailhost(String fromemailhost) {
		this.fromemailhost = fromemailhost;
	}

	public String getFromemailport() {
		return fromemailport;
	}

	public void setFromemailport(String fromemailport) {
		this.fromemailport = fromemailport;
	}

	public String getClientsmsurl() {
		return clientsmsurl;
	}

	public void setClientsmsurl(String clientsmsurl) {
		this.clientsmsurl = clientsmsurl;
	}

	public String getResetpasswordmode() {
		return resetpasswordmode;
	}

	public void setResetpasswordmode(String resetpasswordmode) {
		this.resetpasswordmode = resetpasswordmode;
	}

	public String getDefaultresetpassword() {
		return defaultresetpassword;
	}

	public void setDefaultresetpassword(String defaultresetpassword) {
		this.defaultresetpassword = defaultresetpassword;
	}

	public void setClientid(String clientid) {
        this.clientid = clientid;
    }

    public String getClientname() {
        return clientname;
    }

    public void setClientname(String clientname) {
        this.clientname = clientname;
    }

    public String getOtprequired() {
        return otprequired;
    }

    public void setOtprequired(String otprequired) {
        this.otprequired = otprequired;
    }

    public String getPasswordrequired() {
        return passwordrequired;
    }

    public void setPasswordrequired(String passwordrequired) {
        this.passwordrequired = passwordrequired;
    }

    public String getPasswordvalidationmode() {
        return passwordvalidationmode;
    }

    public void setPasswordvalidationmode(String passwordvalidationmode) {
        this.passwordvalidationmode = passwordvalidationmode;
    }

    public String getClientdetail() {
        return clientdetail;
    }

    public void setClientdetail(String clientdetail) {
        this.clientdetail = clientdetail;
    }

    public Serializable getLogofile() {
        return logofile;
    }

    public void setLogofile(Serializable logofile) {
        this.logofile = logofile;
    }

    public Serializable getWatermarkfile() {
        return watermarkfile;
    }

    public void setWatermarkfile(Serializable watermarkfile) {
        this.watermarkfile = watermarkfile;
    }

    public String getFromemailid() {
        return fromemailid;
    }

	public void setFromemailid(String fromemailid) {
        this.fromemailid = fromemailid;
    }

    public String getFromemailpwd() {
        return fromemailpwd;
    }

    public void setFromemailpwd(String fromemailpwd) {
        this.fromemailpwd = fromemailpwd;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getEntrybyuserid() {
        return entrybyuserid;
    }

    public void setEntrybyuserid(String entrybyuserid) {
        this.entrybyuserid = entrybyuserid;
    }

    public Date getEntrybydatetime() {
        return entrybydatetime;
    }

    public void setEntrybydatetime(Date entrybydatetime) {
        this.entrybydatetime = entrybydatetime;
    }

    public String getLastupdatedbyuserid() {
        return lastupdatedbyuserid;
    }

    public void setLastupdatedbyuserid(String lastupdatedbyuserid) {
        this.lastupdatedbyuserid = lastupdatedbyuserid;
    }

    public Date getLastupdateddatetime() {
        return lastupdateddatetime;
    }

    public void setLastupdateddatetime(Date lastupdateddatetime) {
        this.lastupdateddatetime = lastupdateddatetime;
    }

    public String getCaptcharequired() {
        return captcharequired;
    }

    public void setCaptcharequired(String captcharequired) {
        this.captcharequired = captcharequired;
    }

    public String getPasswordrecoveymode() {
        return passwordrecoveymode;
    }

    public void setPasswordrecoveymode(String passwordrecoveymode) {
        this.passwordrecoveymode = passwordrecoveymode;
    }

    public String getComplainticketrequired() {
        return complainticketrequired;
    }

    public void setComplainticketrequired(String complainticketrequired) {
        this.complainticketrequired = complainticketrequired;
    }

    public String getStaffbdaynotification() {
        return staffbdaynotification;
    }

    public void setStaffbdaynotification(String staffbdaynotification) {
        this.staffbdaynotification = staffbdaynotification;
    }

    public String getStaffannvnotification() {
        return staffannvnotification;
    }

    public void setStaffannvnotification(String staffannvnotification) {
        this.staffannvnotification = staffannvnotification;
    }

    public String getNavigationtobecaptured() {
        return navigationtobecaptured;
    }

    public void setNavigationtobecaptured(String navigationtobecaptured) {
        this.navigationtobecaptured = navigationtobecaptured;
    }

    public String getDeactive() {
        return deactive;
    }

    public void setDeactive(String deactive) {
        this.deactive = deactive;
    }

     
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clientid != null ? clientid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClientMaster)) {
            return false;
        }
        ClientMaster other = (ClientMaster) object;
        if ((this.clientid == null && other.clientid != null) || (this.clientid != null && !this.clientid.equals(other.clientid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jilit.clxacademics.model.Clientmaster[ clientid=" + clientid + " ]";
    }
    
}
