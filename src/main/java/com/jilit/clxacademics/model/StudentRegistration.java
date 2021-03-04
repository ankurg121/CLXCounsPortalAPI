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
 * @author nazar.mohammad
 */
@Entity
@Table(name = "STUDENTREGISTRATION")
public class StudentRegistration implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StudentRegistrationPK studentregistrationPK;
    @Column(name = "REGALLOW")
    private Character regallow;
    @Column(name = "REGALLOWUSER")
    private String regallowuser;
    @Column(name = "REGALLOWDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date regallowdate;
    @Column(name = "HOSTELALLOW")
    private Character hostelallow;
    @Column(name = "HOSTELALLOWUSER")
    private String hostelallowuser;
    @Column(name = "HOSTELALLOWDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date hostelallowdate;
    @Column(name = "FEESPAID")
    private Character feespaid;
    @Column(name = "FEESPAIDUSER")
    private String feespaiduser;
    @Column(name = "FEESPAIDDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date feespaiddate;
    @Column(name = "SUBJECTTAGGED")
    private Character subjecttagged;
    @Column(name = "REGCONFIRMATION")
    private Character regconfirmation;
    @Column(name = "REGCONFIRMATIONUSER")
    private String regconfirmationuser;
    @Column(name = "REGCONFIRMATIONDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date regconfirmationdate;
    @Column(name = "HOSTELCONFIRMATION")
    private Character hostelconfirmation;
    @Column(name = "HOSTELCONFIRMATIONUSER")
    private String hostelconfirmationuser;
    @Column(name = "HOSTELCONFIRMATIONDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date hostelconfirmationdate;
    @Column(name = "BRANCHCODE")
    private String branchcode;
    @Column(name = "REMARKS")
    private String remarks;
    @Column(name = "HOSTELTYPE")
    private String hosteltype;
    @Column(name = "HOSTELFEEPAID")
    private String hostelfeepaid;
    @Column(name = "HOSTELFEEPAIDUSER")
    private String hostelfeepaiduser;
    @Column(name = "HOSTELFEEPAIDDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date hostelfeepaiddate;

    public StudentRegistration() {
    }

    public StudentRegistration(StudentRegistrationPK studentregistrationPK) {
        this.studentregistrationPK = studentregistrationPK;
    }

    public StudentRegistration(String companycode, String institutecode, String examcode, String regcode, String academicyear, String programcode, String taggingfor, String sectionbranch, short semester, String semestertype, String studentid) {
        this.studentregistrationPK = new StudentRegistrationPK(companycode, institutecode, examcode, regcode, academicyear, programcode, taggingfor, sectionbranch, semester, semestertype, studentid);
    }

    public StudentRegistrationPK getStudentregistrationPK() {
        return studentregistrationPK;
    }

    public void setStudentregistrationPK(StudentRegistrationPK studentregistrationPK) {
        this.studentregistrationPK = studentregistrationPK;
    }

    public Character getRegallow() {
        return regallow;
    }

    public void setRegallow(Character regallow) {
        this.regallow = regallow;
    }

    public String getRegallowuser() {
        return regallowuser;
    }

    public void setRegallowuser(String regallowuser) {
        this.regallowuser = regallowuser;
    }

    public Date getRegallowdate() {
        return regallowdate;
    }

    public void setRegallowdate(Date regallowdate) {
        this.regallowdate = regallowdate;
    }

    public Character getHostelallow() {
        return hostelallow;
    }

    public void setHostelallow(Character hostelallow) {
        this.hostelallow = hostelallow;
    }

    public String getHostelallowuser() {
        return hostelallowuser;
    }

    public void setHostelallowuser(String hostelallowuser) {
        this.hostelallowuser = hostelallowuser;
    }

    public Date getHostelallowdate() {
        return hostelallowdate;
    }

    public void setHostelallowdate(Date hostelallowdate) {
        this.hostelallowdate = hostelallowdate;
    }

    public Character getFeespaid() {
        return feespaid;
    }

    public void setFeespaid(Character feespaid) {
        this.feespaid = feespaid;
    }

    public String getFeespaiduser() {
        return feespaiduser;
    }

    public void setFeespaiduser(String feespaiduser) {
        this.feespaiduser = feespaiduser;
    }

    public Date getFeespaiddate() {
        return feespaiddate;
    }

    public void setFeespaiddate(Date feespaiddate) {
        this.feespaiddate = feespaiddate;
    }

    public Character getSubjecttagged() {
        return subjecttagged;
    }

    public void setSubjecttagged(Character subjecttagged) {
        this.subjecttagged = subjecttagged;
    }

    public Character getRegconfirmation() {
        return regconfirmation;
    }

    public void setRegconfirmation(Character regconfirmation) {
        this.regconfirmation = regconfirmation;
    }

    public String getRegconfirmationuser() {
        return regconfirmationuser;
    }

    public void setRegconfirmationuser(String regconfirmationuser) {
        this.regconfirmationuser = regconfirmationuser;
    }

    public Date getRegconfirmationdate() {
        return regconfirmationdate;
    }

    public void setRegconfirmationdate(Date regconfirmationdate) {
        this.regconfirmationdate = regconfirmationdate;
    }

    public Character getHostelconfirmation() {
        return hostelconfirmation;
    }

    public void setHostelconfirmation(Character hostelconfirmation) {
        this.hostelconfirmation = hostelconfirmation;
    }

    public String getHostelconfirmationuser() {
        return hostelconfirmationuser;
    }

    public void setHostelconfirmationuser(String hostelconfirmationuser) {
        this.hostelconfirmationuser = hostelconfirmationuser;
    }

    public Date getHostelconfirmationdate() {
        return hostelconfirmationdate;
    }

    public void setHostelconfirmationdate(Date hostelconfirmationdate) {
        this.hostelconfirmationdate = hostelconfirmationdate;
    }

    public String getBranchcode() {
        return branchcode;
    }

    public void setBranchcode(String branchcode) {
        this.branchcode = branchcode;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getHosteltype() {
        return hosteltype;
    }

    public void setHosteltype(String hosteltype) {
        this.hosteltype = hosteltype;
    }

    public String getHostelfeepaid() {
        return hostelfeepaid;
    }

    public void setHostelfeepaid(String hostelfeepaid) {
        this.hostelfeepaid = hostelfeepaid;
    }

    public String getHostelfeepaiduser() {
        return hostelfeepaiduser;
    }

    public void setHostelfeepaiduser(String hostelfeepaiduser) {
        this.hostelfeepaiduser = hostelfeepaiduser;
    }

    public Date getHostelfeepaiddate() {
        return hostelfeepaiddate;
    }

    public void setHostelfeepaiddate(Date hostelfeepaiddate) {
        this.hostelfeepaiddate = hostelfeepaiddate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentregistrationPK != null ? studentregistrationPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentRegistration)) {
            return false;
        }
        StudentRegistration other = (StudentRegistration) object;
        if ((this.studentregistrationPK == null && other.studentregistrationPK != null) || (this.studentregistrationPK != null && !this.studentregistrationPK.equals(other.studentregistrationPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jilit.clxacademics.model.Studentregistration[ studentregistrationPK=" + studentregistrationPK + " ]";
    }
    
}
