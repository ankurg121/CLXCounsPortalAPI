/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jilit.clxacademics.model;

import java.io.Serializable;
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
@Table(name = "C#CATEGORYMASTER")
public class CCategoryMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CATEGORYCODE")
    private String categorycode;
    @Column(name = "CATEGORYDESC")
    private String categorydesc;
    @Column(name = "CATEGORYTYPE")
    private String categorytype;
    @Column(name = "DEACTIVE")
    private String deactive;
    @Column(name = "SORTON")
    private Short sorton;
    @Column(name = "CATEGORYWISEALLOCATION")
    private Character categorywiseallocation;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cCategoryMaster")
//    private Collection<CInstituteCategoryTagging> cInstituteCategoryTaggingCollection;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cCategoryMaster")
//    private Collection<CRoomStudentTagging> cRoomStudentTaggingCollection;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cCategoryMaster")
//    private Collection<CSeatTransferTagging> cSeatTransferTaggingCollection;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cCategoryMaster1")
//    private Collection<CSeatTransferTagging> cSeatTransferTaggingCollection1;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cCategoryMaster")
//    private Collection<CCategoryAllocationPattern> cCategoryAllocationPatternCollection;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cCategoryMaster")
//    private Collection<CDocumentCategoryTagging> cDocumentCategoryTaggingCollection;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cCategoryMaster")
//    private Collection<CSeatMaster> cSeatMasterCollection;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cCategoryMaster")
//    private Collection<CSeatsTransfer> cSeatsTransferCollection;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cCategoryMaster1")
//    private Collection<CSeatsTransfer> cSeatsTransferCollection1;

    public CCategoryMaster() {
    }

    public CCategoryMaster(String categorycode) {
        this.categorycode = categorycode;
    }

    public String getCategorycode() {
        return categorycode;
    }

    public void setCategorycode(String categorycode) {
        this.categorycode = categorycode;
    }

    public String getCategorydesc() {
        return categorydesc;
    }

    public void setCategorydesc(String categorydesc) {
        this.categorydesc = categorydesc;
    }

    public String getCategorytype() {
        return categorytype;
    }

    public void setCategorytype(String categorytype) {
        this.categorytype = categorytype;
    }

    public String getDeactive() {
        return deactive;
    }

    public void setDeactive(String deactive) {
        this.deactive = deactive;
    }

    public Short getSorton() {
        return sorton;
    }

    public void setSorton(Short sorton) {
        this.sorton = sorton;
    }

    public Character getCategorywiseallocation() {
        return categorywiseallocation;
    }

    public void setCategorywiseallocation(Character categorywiseallocation) {
        this.categorywiseallocation = categorywiseallocation;
    }

//    public Collection<CInstituteCategoryTagging> getCInstituteCategoryTaggingCollection() {
//        return cInstituteCategoryTaggingCollection;
//    }
//
//    public void setCInstituteCategoryTaggingCollection(Collection<CInstituteCategoryTagging> cInstituteCategoryTaggingCollection) {
//        this.cInstituteCategoryTaggingCollection = cInstituteCategoryTaggingCollection;
//    }
//
//    public Collection<CRoomStudentTagging> getCRoomStudentTaggingCollection() {
//        return cRoomStudentTaggingCollection;
//    }
//
//    public void setCRoomStudentTaggingCollection(Collection<CRoomStudentTagging> cRoomStudentTaggingCollection) {
//        this.cRoomStudentTaggingCollection = cRoomStudentTaggingCollection;
//    }
//
//    public Collection<CSeatTransferTagging> getCSeatTransferTaggingCollection() {
//        return cSeatTransferTaggingCollection;
//    }
//
//    public void setCSeatTransferTaggingCollection(Collection<CSeatTransferTagging> cSeatTransferTaggingCollection) {
//        this.cSeatTransferTaggingCollection = cSeatTransferTaggingCollection;
//    }
//
//    public Collection<CSeatTransferTagging> getCSeatTransferTaggingCollection1() {
//        return cSeatTransferTaggingCollection1;
//    }
//
//    public void setCSeatTransferTaggingCollection1(Collection<CSeatTransferTagging> cSeatTransferTaggingCollection1) {
//        this.cSeatTransferTaggingCollection1 = cSeatTransferTaggingCollection1;
//    }
//
//    public Collection<CCategoryAllocationPattern> getCCategoryAllocationPatternCollection() {
//        return cCategoryAllocationPatternCollection;
//    }
//
//    public void setCCategoryAllocationPatternCollection(Collection<CCategoryAllocationPattern> cCategoryAllocationPatternCollection) {
//        this.cCategoryAllocationPatternCollection = cCategoryAllocationPatternCollection;
//    }
//
//    public Collection<CDocumentCategoryTagging> getCDocumentCategoryTaggingCollection() {
//        return cDocumentCategoryTaggingCollection;
//    }
//
//    public void setCDocumentCategoryTaggingCollection(Collection<CDocumentCategoryTagging> cDocumentCategoryTaggingCollection) {
//        this.cDocumentCategoryTaggingCollection = cDocumentCategoryTaggingCollection;
//    }
//
//    public Collection<CSeatMaster> getCSeatMasterCollection() {
//        return cSeatMasterCollection;
//    }
//
//    public void setCSeatMasterCollection(Collection<CSeatMaster> cSeatMasterCollection) {
//        this.cSeatMasterCollection = cSeatMasterCollection;
//    }
//
//    public Collection<CSeatsTransfer> getCSeatsTransferCollection() {
//        return cSeatsTransferCollection;
//    }
//
//    public void setCSeatsTransferCollection(Collection<CSeatsTransfer> cSeatsTransferCollection) {
//        this.cSeatsTransferCollection = cSeatsTransferCollection;
//    }
//
//    public Collection<CSeatsTransfer> getCSeatsTransferCollection1() {
//        return cSeatsTransferCollection1;
//    }
//
//    public void setCSeatsTransferCollection1(Collection<CSeatsTransfer> cSeatsTransferCollection1) {
//        this.cSeatsTransferCollection1 = cSeatsTransferCollection1;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (categorycode != null ? categorycode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CCategoryMaster)) {
            return false;
        }
        CCategoryMaster other = (CCategoryMaster) object;
        if ((this.categorycode == null && other.categorycode != null) || (this.categorycode != null && !this.categorycode.equals(other.categorycode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jilit.clxacademics.model.CCategoryMaster[ categorycode=" + categorycode + " ]";
    }
    
}
