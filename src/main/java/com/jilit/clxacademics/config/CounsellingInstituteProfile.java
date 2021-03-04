package com.jilit.clxacademics.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

//@Component
@Configuration
@ConfigurationProperties(prefix = "counsellinginstitute")
public class CounsellingInstituteProfile {

//	@Value("${counsellinginstitute.name}")
//	private String name;
//	@Value("${counsellinginstitute.address1}")
//	private String address1;
//	@Value("${counsellinginstitute.address2}")
//	private String address2;
//	@Value("${counsellinginstitute.city}")
//	private String city;
//	@Value("${counsellinginstitute.state}")
//	private String state;
//	@Value("${counsellinginstitute.decleration}")
//	private String decleration;
//	@Value("${counsellinginstitute.telephone}")
//	private String telephone;
//	@Value("${counsellinginstitute.fax}")
//	private String fax;
//	@Value("${counsellinginstitute.website}")
//	private String website;
//	@Value("${counsellinginstitute.logourl}")
//	private String logourl;
//	@Value("${counsellinginstitute.watermarkurl}")
//	private String watermarkurl;
	
	private String name;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String decleration;
	private String telephone;
	private String fax;
	private String website;
	private String logourl;
	private String watermarkurl;
	
	public String getName() {
		return name;
	}
	public String getAddress1() {
		return address1;
	}
	public String getAddress2() {
		return address2;
	}
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
	public String getDecleration() {
		return decleration;
	}
	public String getTelephone() {
		return telephone;
	}
	public String getFax() {
		return fax;
	}
	public String getWebsite() {
		return website;
	}
	public String getLogourl() {
		return logourl;
	}
	public String getWatermarkurl() {
		return watermarkurl;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setDecleration(String decleration) {
		this.decleration = decleration;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public void setLogourl(String logourl) {
		this.logourl = logourl;
	}
	public void setWatermarkurl(String watermarkurl) {
		this.watermarkurl = watermarkurl;
	}
	
	
	
	
}
