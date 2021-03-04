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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Sushil
 */
@Entity
@Table(name = "C#STUDENTMASTER")
public class CStudentMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CStudentMasterPK cStudentMasterPK;
    @Column(name = "ROLLNO")
    private String rollno;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Column(name = "SEX")
    private Character sex;
    @Column(name = "DATEOFBIRTH")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateofbirth;
    @Column(name = "FATHERSHUSBANDNAME")
    private String fathershusbandname;
    @Column(name = "LOCALGUARDIAN")
    private String localguardian;
    @Column(name = "SUBJECTCODE")
    private Character subjectcode;
    @Column(name = "LOCATIONCODE")
    private String locationcode;
    @Column(name = "DEACTIVE")
    private String deactive;
    @Column(name = "STUDENTID")
    private String studentid;
    @Column(name = "FEESPAID")
    private String feespaid;
    @Column(name = "QUOTA")
    private String quota;
    @Column(name = "APPLICATIONNO")
    private String applicationno;
    @Column(name = "APPLICATIONSLNO")
    private String applicationslno;
    @Column(name = "HOSTELPERMISSION")
    private String hostelpermission;
    @Column(name = "APPFEEUNPAID")
    private String appfeeunpaid;
    @Column(name = "APPLICATIONID")
    private String applicationid;
    @Column(name = "REFNO")
    private String refno;
    @Column(name = "FLAG")
    private String flag;
    @Column(name = "APPLIEDCATEGORY")
    private String appliedcategory;
//    @OneToOne(cascade = CascadeType.ALL, mappedBy = "cStudentMaster")
//    private CAdmissionLetterNumber cAdmissionLetterNumber;
//    @OneToOne(cascade = CascadeType.ALL, mappedBy = "cStudentMaster")
//    private COnlineRequest cOnlineRequest;
//    @JoinColumn(name = "COUNSELLINGID", referencedColumnName = "COUNSELLINGID", insertable = false, updatable = false)
//    @ManyToOne(optional = false)
//    private CCounsellingId cCounsellingId;
//    @JoinColumn(name = "INSTITUTECODE", referencedColumnName = "INSTITUTECODE", insertable = false, updatable = false)
//    @ManyToOne(optional = false)
//    private CInstituteMaster cInstituteMaster;
//    @JoinColumn(name = "PROGRAMTYPE", referencedColumnName = "PROGRAMTYPE", insertable = false, updatable = false)
//    @ManyToOne(optional = false)
//    private CProgramTypeMaster cProgramTypeMaster;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cStudentMaster")
//    private Collection<CAllocationDetail> cAllocationDetailCollection;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cStudentMaster")
//    private Collection<CStudentMasterPrint> cStudentMasterPrintCollection;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cStudentMaster")
//    private Collection<CCategoryAppliedFor> cCategoryAppliedForCollection;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cStudentMaster")
//    private Collection<CWlCandidate> cWlCandidateCollection;

    public CStudentMaster() {
    }

    public CStudentMaster(CStudentMasterPK cStudentMasterPK) {
        this.cStudentMasterPK = cStudentMasterPK;
    }

    public CStudentMaster(CStudentMasterPK cStudentMasterPK, String name) {
        this.cStudentMasterPK = cStudentMasterPK;
        this.name = name;
    }

    public CStudentMaster(String institutecode, String counsellingid, String programtype, String rank) {
        this.cStudentMasterPK = new CStudentMasterPK(institutecode, counsellingid, programtype, rank);
    }

    public CStudentMasterPK getCStudentMasterPK() {
        return cStudentMasterPK;
    }

    public void setCStudentMasterPK(CStudentMasterPK cStudentMasterPK) {
        this.cStudentMasterPK = cStudentMasterPK;
    }

    public String getRollno() {
        return rollno;
    }

    public void setRollno(String rollno) {
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Character getSex() {
        return sex;
    }

    public void setSex(Character sex) {
        this.sex = sex;
    }

    public Date getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(Date dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getFathershusbandname() {
        return fathershusbandname;
    }

    public void setFathershusbandname(String fathershusbandname) {
        this.fathershusbandname = fathershusbandname;
    }

    public String getLocalguardian() {
        return localguardian;
    }

    public void setLocalguardian(String localguardian) {
        this.localguardian = localguardian;
    }

    public Character getSubjectcode() {
        return subjectcode;
    }

    public void setSubjectcode(Character subjectcode) {
        this.subjectcode = subjectcode;
    }

    public String getLocationcode() {
        return locationcode;
    }

    public void setLocationcode(String locationcode) {
        this.locationcode = locationcode;
    }

    public String getDeactive() {
        return deactive;
    }

    public void setDeactive(String deactive) {
        this.deactive = deactive;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public String getFeespaid() {
        return feespaid;
    }

    public void setFeespaid(String feespaid) {
        this.feespaid = feespaid;
    }

    public String getQuota() {
        return quota;
    }

    public void setQuota(String quota) {
        this.quota = quota;
    }

    public String getApplicationno() {
        return applicationno;
    }

    public void setApplicationno(String applicationno) {
        this.applicationno = applicationno;
    }

    public String getApplicationslno() {
        return applicationslno;
    }

    public void setApplicationslno(String applicationslno) {
        this.applicationslno = applicationslno;
    }

    public String getHostelpermission() {
        return hostelpermission;
    }

    public void setHostelpermission(String hostelpermission) {
        this.hostelpermission = hostelpermission;
    }

    public String getAppfeeunpaid() {
        return appfeeunpaid;
    }

    public void setAppfeeunpaid(String appfeeunpaid) {
        this.appfeeunpaid = appfeeunpaid;
    }

    public String getApplicationid() {
        return applicationid;
    }

    public void setApplicationid(String applicationid) {
        this.applicationid = applicationid;
    }

    public String getRefno() {
        return refno;
    }

    public void setRefno(String refno) {
        this.refno = refno;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getAppliedcategory() {
        return appliedcategory;
    }

    public void setAppliedcategory(String appliedcategory) {
        this.appliedcategory = appliedcategory;
    }

//    public CAdmissionLetterNumber getCAdmissionLetterNumber() {
//        return cAdmissionLetterNumber;
//    }
//
//    public void setCAdmissionLetterNumber(CAdmissionLetterNumber cAdmissionLetterNumber) {
//        this.cAdmissionLetterNumber = cAdmissionLetterNumber;
//    }
//
//    public COnlineRequest getCOnlineRequest() {
//        return cOnlineRequest;
//    }
//
//    public void setCOnlineRequest(COnlineRequest cOnlineRequest) {
//        this.cOnlineRequest = cOnlineRequest;
//    }
//
//    public CCounsellingId getCCounsellingId() {
//        return cCounsellingId;
//    }
//
//    public void setCCounsellingId(CCounsellingId cCounsellingId) {
//        this.cCounsellingId = cCounsellingId;
//    }

//    public CInstituteMaster getCInstituteMaster() {
//        return cInstituteMaster;
//    }
//
//    public void setCInstituteMaster(CInstituteMaster cInstituteMaster) {
//        this.cInstituteMaster = cInstituteMaster;
//    }
//
//    public CProgramTypeMaster getCProgramTypeMaster() {
//        return cProgramTypeMaster;
//    }
//
//    public void setCProgramTypeMaster(CProgramTypeMaster cProgramTypeMaster) {
//        this.cProgramTypeMaster = cProgramTypeMaster;
//    }
//
//    public Collection<CAllocationDetail> getCAllocationDetailCollection() {
//        return cAllocationDetailCollection;
//    }
//
//    public void setCAllocationDetailCollection(Collection<CAllocationDetail> cAllocationDetailCollection) {
//        this.cAllocationDetailCollection = cAllocationDetailCollection;
//    }

//    public Collection<CStudentMasterPrint> getCStudentMasterPrintCollection() {
//        return cStudentMasterPrintCollection;
//    }
//
//    public void setCStudentMasterPrintCollection(Collection<CStudentMasterPrint> cStudentMasterPrintCollection) {
//        this.cStudentMasterPrintCollection = cStudentMasterPrintCollection;
//    }

//    public Collection<CCategoryAppliedFor> getCCategoryAppliedForCollection() {
//        return cCategoryAppliedForCollection;
//    }
//
//    public void setCCategoryAppliedForCollection(Collection<CCategoryAppliedFor> cCategoryAppliedForCollection) {
//        this.cCategoryAppliedForCollection = cCategoryAppliedForCollection;
//    }

//    public Collection<CWlCandidate> getCWlCandidateCollection() {
//        return cWlCandidateCollection;
//    }
//
//    public void setCWlCandidateCollection(Collection<CWlCandidate> cWlCandidateCollection) {
//        this.cWlCandidateCollection = cWlCandidateCollection;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cStudentMasterPK != null ? cStudentMasterPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CStudentMaster)) {
            return false;
        }
        CStudentMaster other = (CStudentMaster) object;
        if ((this.cStudentMasterPK == null && other.cStudentMasterPK != null) || (this.cStudentMasterPK != null && !this.cStudentMasterPK.equals(other.cStudentMasterPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jilit.clxacademics.model.CStudentMaster[ cStudentMasterPK=" + cStudentMasterPK + " ]";
    }
    
}
