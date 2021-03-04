/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jilit.clxacademics.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.stereotype.Component;

/**
 *
 * @author Gaurav.mathur
 */
@Entity
@Component
@Table(name = "SCT#IRPMLP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sct_IrpMlp.findAll", query = "SELECT s FROM Sct_IrpMlp s")})
public class Sct_IrpMlp implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 100)
    @Column(name = "DATA1")
    private String data1;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "DATA2")
    private String data2;
    @Size(max = 100)
    @Column(name = "DATA3")
    private String data3;
    @Size(max = 100)
    @Column(name = "DATA4")
    private String data4;
    @Size(max = 100)
    @Column(name = "DATA5")
    private String data5;
    @Size(max = 100)
    @Column(name = "DATA6")
    private String data6;
    @Size(max = 100)
    @Column(name = "DATA7")
    private String data7;
    @Size(max = 100)
    @Column(name = "DATA8")
    private String data8;
    @Size(max = 100)
    @Column(name = "DATA9")
    private String data9;
    @Size(max = 100)
    @Column(name = "DATA10")
    private String data10;
    @Size(max = 100)
    @Column(name = "DATA11")
    private String data11;
    @Size(max = 100)
    @Column(name = "DATA12")
    private String data12;
    @Size(max = 100)
    @Column(name = "DATA13")
    private String data13;
    @Size(max = 100)
    @Column(name = "DATA14")
    private String data14;
    @Size(max = 100)
    @Column(name = "DATA15")
    private String data15;
    @Size(max = 100)
    @Column(name = "DATA16")
    private String data16;
    @Size(max = 100)
    @Column(name = "DATA17")
    private String data17;
    @Size(max = 100)
    @Column(name = "DATA18")
    private String data18;
    @Size(max = 100)
    @Column(name = "DATA19")
    private String data19;
    @Size(max = 100)
    @Column(name = "DATA20")
    private String data20;
    @Size(max = 100)
    @Column(name = "DATA21")
    private String data21;
    @Size(max = 100)
    @Column(name = "DATA22")
    private String data22;
    @Size(max = 100)
    @Column(name = "DATA23")
    private String data23;
    @Size(max = 100)
    @Column(name = "ADLOGINID")
    private String adloginid;
    @Size(max = 100)
    @Column(name = "CLIENTID")
    private String clientid;

    public Sct_IrpMlp() {
    }

    public Sct_IrpMlp(String data2) {
        this.data2 = data2;
    }

    public String getData1() {
        return data1;
    }

    public void setData1(String data1) {
        this.data1 = data1;
    }

    public String getData2() {
        return data2;
    }

    public void setData2(String data2) {
        this.data2 = data2;
    }

    public String getData3() {
        return data3;
    }

    public void setData3(String data3) {
        this.data3 = data3;
    }

    public String getData4() {
        return data4;
    }

    public void setData4(String data4) {
        this.data4 = data4;
    }

    public String getData5() {
        return data5;
    }

    public void setData5(String data5) {
        this.data5 = data5;
    }

    public String getData6() {
        return data6;
    }

    public void setData6(String data6) {
        this.data6 = data6;
    }

    public String getData7() {
        return data7;
    }

    public void setData7(String data7) {
        this.data7 = data7;
    }

    public String getData8() {
        return data8;
    }

    public void setData8(String data8) {
        this.data8 = data8;
    }

    public String getData9() {
        return data9;
    }

    public void setData9(String data9) {
        this.data9 = data9;
    }

    public String getData10() {
        return data10;
    }

    public void setData10(String data10) {
        this.data10 = data10;
    }

    public String getData11() {
        return data11;
    }

    public void setData11(String data11) {
        this.data11 = data11;
    }

    public String getData12() {
        return data12;
    }

    public void setData12(String data12) {
        this.data12 = data12;
    }

    public String getData13() {
        return data13;
    }

    public void setData13(String data13) {
        this.data13 = data13;
    }

    public String getData14() {
        return data14;
    }

    public void setData14(String data14) {
        this.data14 = data14;
    }

    public String getData15() {
        return data15;
    }

    public void setData15(String data15) {
        this.data15 = data15;
    }

    public String getData16() {
        return data16;
    }

    public void setData16(String data16) {
        this.data16 = data16;
    }

    public String getData17() {
        return data17;
    }

    public void setData17(String data17) {
        this.data17 = data17;
    }

    public String getData18() {
        return data18;
    }

    public void setData18(String data18) {
        this.data18 = data18;
    }

    public String getData19() {
        return data19;
    }

    public void setData19(String data19) {
        this.data19 = data19;
    }

    public String getData20() {
        return data20;
    }

    public void setData20(String data20) {
        this.data20 = data20;
    }

    public String getData21() {
        return data21;
    }

    public void setData21(String data21) {
        this.data21 = data21;
    }

    public String getData22() {
        return data22;
    }

    public void setData22(String data22) {
        this.data22 = data22;
    }

    public String getData23() {
        return data23;
    }

    public String getAdloginid() {
		return adloginid;
	}

	public void setAdloginid(String adloginid) {
		this.adloginid = adloginid;
	}

	public String getClientid() {
		return clientid;
	}

	public void setClientid(String clientid) {
		this.clientid = clientid;
	}

	public void setData23(String data23) {
        this.data23 = data23;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (data2 != null ? data2.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sct_IrpMlp)) {
            return false;
        }
        Sct_IrpMlp other = (Sct_IrpMlp) object;
        if ((this.data2 == null && other.data2 != null) || (this.data2 != null && !this.data2.equals(other.data2))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jilit.campusportal.dto.Sct_IrpMlp[ data2=" + data2 + " ]";
    }
    
}
