/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jilit.clxacademics.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Sushil
 */
@Entity
@Table(name = "C#PROGRAMTYPEMASTER")
public class CProgramTypeMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PROGRAMTYPE")
    private String programtype;
    @Basic(optional = false)
    @Column(name = "PROGRAMTYPENAME")
    private String programtypename;
    @Column(name = "SHORTNAME")
    private String shortname;
    @Column(name = "DEACTIVE")
    private String deactive;
    @Column(name = "SEQID")
    private BigInteger seqid;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cProgramTypeMaster")
//    private Collection<CProgramMaster> cProgramMasterCollection;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cProgramTypeMaster")
//    private Collection<CStudentAttendance> cStudentAttendanceCollection;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cProgramTypeMaster")
//    private Collection<CStudentMaster> cStudentMasterCollection;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cProgramTypeMaster")
//    private Collection<CStudentProgramChoice> cStudentProgramChoiceCollection;

    public CProgramTypeMaster() {
    }

    public CProgramTypeMaster(String programtype) {
        this.programtype = programtype;
    }

    public CProgramTypeMaster(String programtype, String programtypename) {
        this.programtype = programtype;
        this.programtypename = programtypename;
    }

    public String getProgramtype() {
        return programtype;
    }

    public void setProgramtype(String programtype) {
        this.programtype = programtype;
    }

    public String getProgramtypename() {
        return programtypename;
    }

    public void setProgramtypename(String programtypename) {
        this.programtypename = programtypename;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getDeactive() {
        return deactive;
    }

    public void setDeactive(String deactive) {
        this.deactive = deactive;
    }

    public BigInteger getSeqid() {
        return seqid;
    }

    public void setSeqid(BigInteger seqid) {
        this.seqid = seqid;
    }

//    public Collection<CProgramMaster> getCProgramMasterCollection() {
//        return cProgramMasterCollection;
//    }
//
//    public void setCProgramMasterCollection(Collection<CProgramMaster> cProgramMasterCollection) {
//        this.cProgramMasterCollection = cProgramMasterCollection;
//    }

//    public Collection<CStudentAttendance> getCStudentAttendanceCollection() {
//        return cStudentAttendanceCollection;
//    }
//
//    public void setCStudentAttendanceCollection(Collection<CStudentAttendance> cStudentAttendanceCollection) {
//        this.cStudentAttendanceCollection = cStudentAttendanceCollection;
//    }

//    public Collection<CStudentMaster> getCStudentMasterCollection() {
//        return cStudentMasterCollection;
//    }
//
//    public void setCStudentMasterCollection(Collection<CStudentMaster> cStudentMasterCollection) {
//        this.cStudentMasterCollection = cStudentMasterCollection;
//    }
//
//    public Collection<CStudentProgramChoice> getCStudentProgramChoiceCollection() {
//        return cStudentProgramChoiceCollection;
//    }
//
//    public void setCStudentProgramChoiceCollection(Collection<CStudentProgramChoice> cStudentProgramChoiceCollection) {
//        this.cStudentProgramChoiceCollection = cStudentProgramChoiceCollection;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (programtype != null ? programtype.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CProgramTypeMaster)) {
            return false;
        }
        CProgramTypeMaster other = (CProgramTypeMaster) object;
        if ((this.programtype == null && other.programtype != null) || (this.programtype != null && !this.programtype.equals(other.programtype))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jilit.clxacademics.model.CProgramTypeMaster[ programtype=" + programtype + " ]";
    }
    
}
