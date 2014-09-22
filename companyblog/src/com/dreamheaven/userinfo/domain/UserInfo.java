package com.dreamheaven.userinfo.domain;

import java.io.File;
import java.util.List;

import com.dreamheaven.common.domain.CommonSuper;
import com.dreamheaven.companyinfo.domain.CompanyInfo;

public class UserInfo extends CommonSuper{
	
	private String uid ;
	
	private String nickName;
	
	private String age;
	
	private String sex;
	
	private String birthday;
	
	private String hoby;
	
	private String companyId;
	
	private String headImgPath;
	
	//-----------------------
	
	private String listenFlag;
	
	private File headFile;
	
	private List<UserInfo> userInfoList;
	
	private CompanyInfo companyInfo;
	
	public CompanyInfo getCompanyInfo() {
		return companyInfo;
	}

	public void setCompanyInfo(CompanyInfo companyInfo) {
		this.companyInfo = companyInfo;
	}

	public List<UserInfo> getUserInfoList() {
		return userInfoList;
	}

	public void setUserInfoList(List<UserInfo> userInfoList) {
		this.userInfoList = userInfoList;
	}

	public String getHeadFileFileName() {
		return headFileFileName;
	}

	public void setHeadFileFileName(String headFileFileName) {
		this.headFileFileName = headFileFileName;
	}

	public String getHeadFileContentType() {
		return headFileContentType;
	}

	public void setHeadFileContentType(String headFileContentType) {
		this.headFileContentType = headFileContentType;
	}

	private String headFileFileName;
	
	private String headFileContentType;
	
	public File getHeadFile() {
		return headFile;
	}

	public void setHeadFile(File headFile) {
		this.headFile = headFile;
	}

	public String getListenFlag() {
		return listenFlag;
	}

	public void setListenFlag(String listenFlag) {
		this.listenFlag = listenFlag;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getHoby() {
		return hoby;
	}

	public void setHoby(String hoby) {
		this.hoby = hoby;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getHeadImgPath() {
		return headImgPath;
	}

	public void setHeadImgPath(String headImgPath) {
		this.headImgPath = headImgPath;
	}
	
	
	
}
