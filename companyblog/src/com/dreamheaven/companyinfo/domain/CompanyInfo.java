package com.dreamheaven.companyinfo.domain;

import java.util.ArrayList;
import java.util.List;

public class CompanyInfo {

	private String companyId;

	private String uid;

	private String companyName;

	private String maxUsers;

	private String companyDescribe;

	private String companyAddress;

	private String companyContact;
	
	//-------------------------------------
	private List<CompanyInfo> companyInfoList = new ArrayList<CompanyInfo>();
	
	
	public List<CompanyInfo> getCompanyInfoList() {
		return companyInfoList;
	}

	public void setCompanyInfoList(List<CompanyInfo> companyInfoList) {
		this.companyInfoList = companyInfoList;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getMaxUsers() {
		return maxUsers;
	}

	public void setMaxUsers(String maxUsers) {
		this.maxUsers = maxUsers;
	}

	public String getCompanyDescribe() {
		return companyDescribe;
	}

	public void setCompanyDescribe(String companyDescribe) {
		this.companyDescribe = companyDescribe;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getCompanyContact() {
		return companyContact;
	}

	public void setCompanyContact(String companyContact) {
		this.companyContact = companyContact;
	}

}
