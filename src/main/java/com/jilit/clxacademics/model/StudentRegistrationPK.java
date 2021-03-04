/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jilit.clxacademics.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
*
* @author nazar.mohammad
*/
@Embeddable
public class StudentRegistrationPK implements Serializable {

   @Basic(optional = false)
   @Column(name = "COMPANYCODE")
   private String companycode;
   @Basic(optional = false)
   @Column(name = "INSTITUTECODE")
   private String institutecode;
   @Basic(optional = false)
   @Column(name = "EXAMCODE")
   private String examcode;
   @Basic(optional = false)
   @Column(name = "REGCODE")
   private String regcode;
   @Basic(optional = false)
   @Column(name = "ACADEMICYEAR")
   private String academicyear;
   @Basic(optional = false)
   @Column(name = "PROGRAMCODE")
   private String programcode;
   @Basic(optional = false)
   @Column(name = "TAGGINGFOR")
   private String taggingfor;
   @Basic(optional = false)
   @Column(name = "SECTIONBRANCH")
   private String sectionbranch;
   @Basic(optional = false)
   @Column(name = "SEMESTER")
   private short semester;
   @Basic(optional = false)
   @Column(name = "SEMESTERTYPE")
   private String semestertype;
   @Basic(optional = false)
   @Column(name = "STUDENTID")
   private String studentid;

   public StudentRegistrationPK() {
   }

   public StudentRegistrationPK(String companycode, String institutecode, String examcode, String regcode, String academicyear, String programcode, String taggingfor, String sectionbranch, short semester, String semestertype, String studentid) {
       this.companycode = companycode;
       this.institutecode = institutecode;
       this.examcode = examcode;
       this.regcode = regcode;
       this.academicyear = academicyear;
       this.programcode = programcode;
       this.taggingfor = taggingfor;
       this.sectionbranch = sectionbranch;
       this.semester = semester;
       this.semestertype = semestertype;
       this.studentid = studentid;
   }

   public String getCompanycode() {
       return companycode;
   }

   public void setCompanycode(String companycode) {
       this.companycode = companycode;
   }

   public String getInstitutecode() {
       return institutecode;
   }

   public void setInstitutecode(String institutecode) {
       this.institutecode = institutecode;
   }

   public String getExamcode() {
       return examcode;
   }

   public void setExamcode(String examcode) {
       this.examcode = examcode;
   }

   public String getRegcode() {
       return regcode;
   }

   public void setRegcode(String regcode) {
       this.regcode = regcode;
   }

   public String getAcademicyear() {
       return academicyear;
   }

   public void setAcademicyear(String academicyear) {
       this.academicyear = academicyear;
   }

   public String getProgramcode() {
       return programcode;
   }

   public void setProgramcode(String programcode) {
       this.programcode = programcode;
   }

   public String getTaggingfor() {
       return taggingfor;
   }

   public void setTaggingfor(String taggingfor) {
       this.taggingfor = taggingfor;
   }

   public String getSectionbranch() {
       return sectionbranch;
   }

   public void setSectionbranch(String sectionbranch) {
       this.sectionbranch = sectionbranch;
   }

   public short getSemester() {
       return semester;
   }

   public void setSemester(short semester) {
       this.semester = semester;
   }

   public String getSemestertype() {
       return semestertype;
   }

   public void setSemestertype(String semestertype) {
       this.semestertype = semestertype;
   }

   public String getStudentid() {
       return studentid;
   }

   public void setStudentid(String studentid) {
       this.studentid = studentid;
   }

   @Override
   public int hashCode() {
       int hash = 0;
       hash += (companycode != null ? companycode.hashCode() : 0);
       hash += (institutecode != null ? institutecode.hashCode() : 0);
       hash += (examcode != null ? examcode.hashCode() : 0);
       hash += (regcode != null ? regcode.hashCode() : 0);
       hash += (academicyear != null ? academicyear.hashCode() : 0);
       hash += (programcode != null ? programcode.hashCode() : 0);
       hash += (taggingfor != null ? taggingfor.hashCode() : 0);
       hash += (sectionbranch != null ? sectionbranch.hashCode() : 0);
       hash += (int) semester;
       hash += (semestertype != null ? semestertype.hashCode() : 0);
       hash += (studentid != null ? studentid.hashCode() : 0);
       return hash;
   }

   @Override
   public boolean equals(Object object) {
       // TODO: Warning - this method won't work in the case the id fields are not set
       if (!(object instanceof StudentRegistrationPK)) {
           return false;
       }
       StudentRegistrationPK other = (StudentRegistrationPK) object;
       if ((this.companycode == null && other.companycode != null) || (this.companycode != null && !this.companycode.equals(other.companycode))) {
           return false;
       }
       if ((this.institutecode == null && other.institutecode != null) || (this.institutecode != null && !this.institutecode.equals(other.institutecode))) {
           return false;
       }
       if ((this.examcode == null && other.examcode != null) || (this.examcode != null && !this.examcode.equals(other.examcode))) {
           return false;
       }
       if ((this.regcode == null && other.regcode != null) || (this.regcode != null && !this.regcode.equals(other.regcode))) {
           return false;
       }
       if ((this.academicyear == null && other.academicyear != null) || (this.academicyear != null && !this.academicyear.equals(other.academicyear))) {
           return false;
       }
       if ((this.programcode == null && other.programcode != null) || (this.programcode != null && !this.programcode.equals(other.programcode))) {
           return false;
       }
       if ((this.taggingfor == null && other.taggingfor != null) || (this.taggingfor != null && !this.taggingfor.equals(other.taggingfor))) {
           return false;
       }
       if ((this.sectionbranch == null && other.sectionbranch != null) || (this.sectionbranch != null && !this.sectionbranch.equals(other.sectionbranch))) {
           return false;
       }
       if (this.semester != other.semester) {
           return false;
       }
       if ((this.semestertype == null && other.semestertype != null) || (this.semestertype != null && !this.semestertype.equals(other.semestertype))) {
           return false;
       }
       if ((this.studentid == null && other.studentid != null) || (this.studentid != null && !this.studentid.equals(other.studentid))) {
           return false;
       }
       return true;
   }

   @Override
   public String toString() {
       return "com.jilit.clxacademics.model.StudentregistrationPK[ companycode=" + companycode + ", institutecode=" + institutecode + ", examcode=" + examcode + ", regcode=" + regcode + ", academicyear=" + academicyear + ", programcode=" + programcode + ", taggingfor=" + taggingfor + ", sectionbranch=" + sectionbranch + ", semester=" + semester + ", semestertype=" + semestertype + ", studentid=" + studentid + " ]";
   }
   
}
