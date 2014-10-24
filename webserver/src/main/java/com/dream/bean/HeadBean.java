package com.dream.bean;

import com.baidu.common.FormatUtils;

/**
 * 请求头部对象
 * 
 * @author 林翔云
 * @date 2014年10月21日
 */
public class HeadBean {
	// 时间
	public String time = FormatUtils.formatDate("yyyy-MM-dd HH:mm:ss,SSS");
	// 平台
	public String platform = "";
	// 型号
	public String model = "";
	// 品牌
	public String brand = "";
	// SDK
	public String sdk = "";
	// 版本
	public String release = "";
	// 序列号
	public String serial = "";
	// IMEI
	public String imei = "";
	// IMSI
	public String imsi = "";
	// 网络类型
	public String netype = "";
	// 版本号
	public String versionCode = "0";
	// 版本名字
	public String versionName = "";

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getSdk() {
		return sdk;
	}

	public void setSdk(String sdk) {
		this.sdk = sdk;
	}

	public String getRelease() {
		return release;
	}

	public void setRelease(String release) {
		this.release = release;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getImsi() {
		return imsi;
	}

	public void setImsi(String imsi) {
		this.imsi = imsi;
	}

	public String getNetype() {
		return netype;
	}

	public void setNetype(String netype) {
		this.netype = netype;
	}

	public String getVersionCode() {
		return versionCode;
	}

	public void setVersionCode(String versionCode) {
		this.versionCode = versionCode;
	}

	public String getVersionName() {
		return versionName;
	}

	public void setVersionName(String versionName) {
		this.versionName = versionName;
	}

}
