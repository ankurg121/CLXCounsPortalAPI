/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jilit.clxacademics.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Sushil
 */
@Entity
@Table(name = "C#APPLICATIONMASTER")
public class CApplicationMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CApplicationMasterPK cApplicationMasterPK;
    @Basic(optional = false)
    @Column(name = "APPLICATIONNO")
    private String applicationno;
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Column(name = "MIDDLENAME")
    private String middlename;
    @Column(name = "LASTNAME")
    private String lastname;
    @Column(name = "FATHERNAME")
    private String fathername;
    @Column(name = "MOTHERNAME")
    private String mothername;
    @Column(name = "DISTRICT")
    private String district;
    @Column(name = "CSTATECODE")
    private String cstatecode;
    @Column(name = "PSTATECODE")
    private String pstatecode;
    @Column(name = "CPIN")
    private Integer cpin;
    @Column(name = "STDCODE")
    private String stdcode;
    @Column(name = "PHONENO")
    private String phoneno;
    @Column(name = "MOBILENO")
    private String mobileno;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "INDIAN")
    private String indian;
    @Column(name = "SEX")
    private String sex;
    @Column(name = "DATEOFBIRTH")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateofbirth;
    @Column(name = "YEAROFQUALIFYINGEXAM")
    private Short yearofqualifyingexam;
    @Column(name = "QUALIFIEDEXAMFROMHP")
    private String qualifiedexamfromhp;
    @Column(name = "CATEGORYCODE")
    private String categorycode;
    @Column(name = "OTHERCATEGORY")
    private String othercategory;
    @Column(name = "ENTRYBY")
    private String entryby;
    @Column(name = "ENTRYDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date entrydate;
    @Column(name = "MODIFIEDBY")
    private String modifiedby;
    @Column(name = "MODIFIEDDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifieddate;
    @Column(name = "DEACTIVE")
    private String deactive;
    @Column(name = "APPLICATIONCONFIRMED")
    private String applicationconfirmed;
    @Column(name = "PDISTRICT")
    private String pdistrict;
    @Column(name = "PPIN")
    private BigInteger ppin;
    @Column(name = "CORADDRESSFILENAME")
    private String coraddressfilename;
    @Column(name = "PHOTOGRAPHFILENAME")
    private String photographfilename;
    @Column(name = "PERADDRESSFILENAME")
    private String peraddressfilename;
    @Column(name = "REFNO")
    private String refno;
    @Column(name = "DATAREMARKS")
    private String dataremarks;
    @Column(name = "MAUPDATED")
    private String maupdated;
    @Column(name = "PAUPDATED")
    private String paupdated;
    @Column(name = "SPUPDATED")
    private String spupdated;
    @Column(name = "LISTNO")
    private String listno;
    @Column(name = "FORMRECVD")
    private Character formrecvd;
    @Column(name = "AIEEERANK")
    private String aieeerank;
    @Column(name = "JPRANK")
    private String jprank;
    @Column(name = "JIITRANK")
    private String jiitrank;
    @Column(name = "JUITRANK")
    private String juitrank;
    @Column(name = "JUETRANK")
    private String juetrank;
    @Column(name = "HPRANK")
    private String hprank;
    @Column(name = "CADDRESS1")
    private String caddress1;
    @Column(name = "CADDRESS2")
    private String caddress2;
    @Column(name = "CADDRESS3")
    private String caddress3;
    @Column(name = "CCITY")
    private String ccity;
    @Column(name = "CCOUNTRY")
    private String ccountry;
    @Column(name = "PADDRESS1")
    private String paddress1;
    @Column(name = "PADDRESS2")
    private String paddress2;
    @Column(name = "PADDRESS3")
    private String paddress3;
    @Column(name = "PCITY")
    private String pcity;
    @Column(name = "PCOUNTRY")
    private String pcountry;
    @Column(name = "AIEEEROLLNUMBER")
    private String aieeerollnumber;
    @Column(name = "APPLYFORHP")
    private String applyforhp;
    @Column(name = "REJECTED")
    private String rejected;
    @Column(name = "REJECTEDREMARKS")
    private String rejectedremarks;
    @Column(name = "SCOREOFJEE")
    private Short scoreofjee;
    @Column(name = "XIITHROLLNO")
    private String xiithrollno;
    @Column(name = "XIITHBOARDCODE")
    private String xiithboardcode;
    @Column(name = "XIITHMAXMARKS")
    private Short xiithmaxmarks;
    @Column(name = "XIITHMARKSOBTAINED")
    private Short xiithmarksobtained;
    @Column(name = "OLDSCOREOFJEE")
    private Short oldscoreofjee;
    @Column(name = "JEEAPPLICATIONNO")
    private String jeeapplicationno;
    @Column(name = "XIITHNAMEOFSCHOOL")
    private String xiithnameofschool;
    @Column(name = "XIITHCITYOFSCHOOL")
    private String xiithcityofschool;
    @Column(name = "XIITHSTATEOFSCHOOL")
    private String xiithstateofschool;
    @Column(name = "XIITHNAMEOFBOARD")
    private String xiithnameofboard;
    @Column(name = "XIITHYEAROFPASSING")
    private BigInteger xiithyearofpassing;
    @Column(name = "AADHARNO")
    private String aadharno;
    @Column(name = "DISABILITY")
    private String disability;
    @Column(name = "RELIGION")
    private String religion;
    @Column(name = "JEEROLLNO2")
    private String jeerollno2;
    @Column(name = "DEFENCEWARD")
    private String defenceward;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cApplicationMaster")
//    private Collection<CPersonalBankDetail> cPersonalBankDetailCollection;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cApplicationMaster")
//    private Collection<CApplicationMasterDetail> cApplicationMasterDetailCollection;

    public CApplicationMaster() {
    }

    public CApplicationMaster(CApplicationMasterPK cApplicationMasterPK) {
        this.cApplicationMasterPK = cApplicationMasterPK;
    }

    public CApplicationMaster(CApplicationMasterPK cApplicationMasterPK, String applicationno) {
        this.cApplicationMasterPK = cApplicationMasterPK;
        this.applicationno = applicationno;
    }

    public CApplicationMaster(String counsellingid, String applicationid) {
        this.cApplicationMasterPK = new CApplicationMasterPK(counsellingid, applicationid);
    }

    public CApplicationMasterPK getCApplicationMasterPK() {
        return cApplicationMasterPK;
    }

    public void setCApplicationMasterPK(CApplicationMasterPK cApplicationMasterPK) {
        this.cApplicationMasterPK = cApplicationMasterPK;
    }

    public String getApplicationno() {
        return applicationno;
    }

    public void setApplicationno(String applicationno) {
        this.applicationno = applicationno;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFathername() {
        return fathername;
    }

    public void setFathername(String fathername) {
        this.fathername = fathername;
    }

    public String getMothername() {
        return mothername;
    }

    public void setMothername(String mothername) {
        this.mothername = mothername;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCstatecode() {
        return cstatecode;
    }

    public void setCstatecode(String cstatecode) {
        this.cstatecode = cstatecode;
    }

    public String getPstatecode() {
        return pstatecode;
    }

    public void setPstatecode(String pstatecode) {
        this.pstatecode = pstatecode;
    }

    public Integer getCpin() {
        return cpin;
    }

    public void setCpin(Integer cpin) {
        this.cpin = cpin;
    }

    public String getStdcode() {
        return stdcode;
    }

    public void setStdcode(String stdcode) {
        this.stdcode = stdcode;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIndian() {
        return indian;
    }

    public void setIndian(String indian) {
        this.indian = indian;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(Date dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public Short getYearofqualifyingexam() {
        return yearofqualifyingexam;
    }

    public void setYearofqualifyingexam(Short yearofqualifyingexam) {
        this.yearofqualifyingexam = yearofqualifyingexam;
    }

    public String getQualifiedexamfromhp() {
        return qualifiedexamfromhp;
    }

    public void setQualifiedexamfromhp(String qualifiedexamfromhp) {
        this.qualifiedexamfromhp = qualifiedexamfromhp;
    }

    public String getCategorycode() {
        return categorycode;
    }

    public void setCategorycode(String categorycode) {
        this.categorycode = categorycode;
    }

    public String getOthercategory() {
        return othercategory;
    }

    public void setOthercategory(String othercategory) {
        this.othercategory = othercategory;
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

    public String getModifiedby() {
        return modifiedby;
    }

    public void setModifiedby(String modifiedby) {
        this.modifiedby = modifiedby;
    }

    public Date getModifieddate() {
        return modifieddate;
    }

    public void setModifieddate(Date modifieddate) {
        this.modifieddate = modifieddate;
    }

    public String getDeactive() {
        return deactive;
    }

    public void setDeactive(String deactive) {
        this.deactive = deactive;
    }

    public String getApplicationconfirmed() {
        return applicationconfirmed;
    }

    public void setApplicationconfirmed(String applicationconfirmed) {
        this.applicationconfirmed = applicationconfirmed;
    }

    public String getPdistrict() {
        return pdistrict;
    }

    public void setPdistrict(String pdistrict) {
        this.pdistrict = pdistrict;
    }

    public BigInteger getPpin() {
        return ppin;
    }

    public void setPpin(BigInteger ppin) {
        this.ppin = ppin;
    }

    public String getCoraddressfilename() {
        return coraddressfilename;
    }

    public void setCoraddressfilename(String coraddressfilename) {
        this.coraddressfilename = coraddressfilename;
    }

    public String getPhotographfilename() {
        return photographfilename;
    }

    public void setPhotographfilename(String photographfilename) {
        this.photographfilename = photographfilename;
    }

    public String getPeraddressfilename() {
        return peraddressfilename;
    }

    public void setPeraddressfilename(String peraddressfilename) {
        this.peraddressfilename = peraddressfilename;
    }

    public String getRefno() {
        return refno;
    }

    public void setRefno(String refno) {
        this.refno = refno;
    }

    public String getDataremarks() {
        return dataremarks;
    }

    public void setDataremarks(String dataremarks) {
        this.dataremarks = dataremarks;
    }

    public String getMaupdated() {
        return maupdated;
    }

    public void setMaupdated(String maupdated) {
        this.maupdated = maupdated;
    }

    public String getPaupdated() {
        return paupdated;
    }

    public void setPaupdated(String paupdated) {
        this.paupdated = paupdated;
    }

    public String getSpupdated() {
        return spupdated;
    }

    public void setSpupdated(String spupdated) {
        this.spupdated = spupdated;
    }

    public String getListno() {
        return listno;
    }

    public void setListno(String listno) {
        this.listno = listno;
    }

    public Character getFormrecvd() {
        return formrecvd;
    }

    public void setFormrecvd(Character formrecvd) {
        this.formrecvd = formrecvd;
    }

    public String getAieeerank() {
        return aieeerank;
    }

    public void setAieeerank(String aieeerank) {
        this.aieeerank = aieeerank;
    }

    public String getJprank() {
        return jprank;
    }

    public void setJprank(String jprank) {
        this.jprank = jprank;
    }

    public String getJiitrank() {
        return jiitrank;
    }

    public void setJiitrank(String jiitrank) {
        this.jiitrank = jiitrank;
    }

    public String getJuitrank() {
        return juitrank;
    }

    public void setJuitrank(String juitrank) {
        this.juitrank = juitrank;
    }

    public String getJuetrank() {
        return juetrank;
    }

    public void setJuetrank(String juetrank) {
        this.juetrank = juetrank;
    }

    public String getHprank() {
        return hprank;
    }

    public void setHprank(String hprank) {
        this.hprank = hprank;
    }

    public String getCaddress1() {
        return caddress1;
    }

    public void setCaddress1(String caddress1) {
        this.caddress1 = caddress1;
    }

    public String getCaddress2() {
        return caddress2;
    }

    public void setCaddress2(String caddress2) {
        this.caddress2 = caddress2;
    }

    public String getCaddress3() {
        return caddress3;
    }

    public void setCaddress3(String caddress3) {
        this.caddress3 = caddress3;
    }

    public String getCcity() {
        return ccity;
    }

    public void setCcity(String ccity) {
        this.ccity = ccity;
    }

    public String getCcountry() {
        return ccountry;
    }

    public void setCcountry(String ccountry) {
        this.ccountry = ccountry;
    }

    public String getPaddress1() {
        return paddress1;
    }

    public void setPaddress1(String paddress1) {
        this.paddress1 = paddress1;
    }

    public String getPaddress2() {
        return paddress2;
    }

    public void setPaddress2(String paddress2) {
        this.paddress2 = paddress2;
    }

    public String getPaddress3() {
        return paddress3;
    }

    public void setPaddress3(String paddress3) {
        this.paddress3 = paddress3;
    }

    public String getPcity() {
        return pcity;
    }

    public void setPcity(String pcity) {
        this.pcity = pcity;
    }

    public String getPcountry() {
        return pcountry;
    }

    public void setPcountry(String pcountry) {
        this.pcountry = pcountry;
    }

    public String getAieeerollnumber() {
        return aieeerollnumber;
    }

    public void setAieeerollnumber(String aieeerollnumber) {
        this.aieeerollnumber = aieeerollnumber;
    }

    public String getApplyforhp() {
        return applyforhp;
    }

    public void setApplyforhp(String applyforhp) {
        this.applyforhp = applyforhp;
    }

    public String getRejected() {
        return rejected;
    }

    public void setRejected(String rejected) {
        this.rejected = rejected;
    }

    public String getRejectedremarks() {
        return rejectedremarks;
    }

    public void setRejectedremarks(String rejectedremarks) {
        this.rejectedremarks = rejectedremarks;
    }

    public Short getScoreofjee() {
        return scoreofjee;
    }

    public void setScoreofjee(Short scoreofjee) {
        this.scoreofjee = scoreofjee;
    }

    public String getXiithrollno() {
        return xiithrollno;
    }

    public void setXiithrollno(String xiithrollno) {
        this.xiithrollno = xiithrollno;
    }

    public String getXiithboardcode() {
        return xiithboardcode;
    }

    public void setXiithboardcode(String xiithboardcode) {
        this.xiithboardcode = xiithboardcode;
    }

    public Short getXiithmaxmarks() {
        return xiithmaxmarks;
    }

    public void setXiithmaxmarks(Short xiithmaxmarks) {
        this.xiithmaxmarks = xiithmaxmarks;
    }

    public Short getXiithmarksobtained() {
        return xiithmarksobtained;
    }

    public void setXiithmarksobtained(Short xiithmarksobtained) {
        this.xiithmarksobtained = xiithmarksobtained;
    }

    public Short getOldscoreofjee() {
        return oldscoreofjee;
    }

    public void setOldscoreofjee(Short oldscoreofjee) {
        this.oldscoreofjee = oldscoreofjee;
    }

    public String getJeeapplicationno() {
        return jeeapplicationno;
    }

    public void setJeeapplicationno(String jeeapplicationno) {
        this.jeeapplicationno = jeeapplicationno;
    }

    public String getXiithnameofschool() {
        return xiithnameofschool;
    }

    public void setXiithnameofschool(String xiithnameofschool) {
        this.xiithnameofschool = xiithnameofschool;
    }

    public String getXiithcityofschool() {
        return xiithcityofschool;
    }

    public void setXiithcityofschool(String xiithcityofschool) {
        this.xiithcityofschool = xiithcityofschool;
    }

    public String getXiithstateofschool() {
        return xiithstateofschool;
    }

    public void setXiithstateofschool(String xiithstateofschool) {
        this.xiithstateofschool = xiithstateofschool;
    }

    public String getXiithnameofboard() {
        return xiithnameofboard;
    }

    public void setXiithnameofboard(String xiithnameofboard) {
        this.xiithnameofboard = xiithnameofboard;
    }

    public BigInteger getXiithyearofpassing() {
        return xiithyearofpassing;
    }

    public void setXiithyearofpassing(BigInteger xiithyearofpassing) {
        this.xiithyearofpassing = xiithyearofpassing;
    }

    public String getAadharno() {
        return aadharno;
    }

    public void setAadharno(String aadharno) {
        this.aadharno = aadharno;
    }

    public String getDisability() {
        return disability;
    }

    public void setDisability(String disability) {
        this.disability = disability;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getJeerollno2() {
        return jeerollno2;
    }

    public void setJeerollno2(String jeerollno2) {
        this.jeerollno2 = jeerollno2;
    }

    public String getDefenceward() {
        return defenceward;
    }

    public void setDefenceward(String defenceward) {
        this.defenceward = defenceward;
    }

//    public Collection<CPersonalBankDetail> getCPersonalBankDetailCollection() {
//        return cPersonalBankDetailCollection;
//    }
//
//    public void setCPersonalBankDetailCollection(Collection<CPersonalBankDetail> cPersonalBankDetailCollection) {
//        this.cPersonalBankDetailCollection = cPersonalBankDetailCollection;
//    }
//
//    public Collection<CApplicationMasterDetail> getCApplicationMasterDetailCollection() {
//        return cApplicationMasterDetailCollection;
//    }
//
//    public void setCApplicationMasterDetailCollection(Collection<CApplicationMasterDetail> cApplicationMasterDetailCollection) {
//        this.cApplicationMasterDetailCollection = cApplicationMasterDetailCollection;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cApplicationMasterPK != null ? cApplicationMasterPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CApplicationMaster)) {
            return false;
        }
        CApplicationMaster other = (CApplicationMaster) object;
        if ((this.cApplicationMasterPK == null && other.cApplicationMasterPK != null) || (this.cApplicationMasterPK != null && !this.cApplicationMasterPK.equals(other.cApplicationMasterPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jilit.clxacademics.model.CApplicationMaster[ cApplicationMasterPK=" + cApplicationMasterPK + " ]";
    }
    
}
