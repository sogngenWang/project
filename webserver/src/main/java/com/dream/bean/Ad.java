package com.dream.bean;

public class Ad {

	// 需要随机返回的条数
	private Integer returnnum;

	public Integer getReturnnum() {
		return returnnum;
	}

	public void setReturnnum(Integer returnnum) {
		this.returnnum = returnnum;
	}

	private Integer adid;

	private String adtitle;

	private String adpicpath;

	public Integer getAdid() {
		return adid;
	}

	public void setAdid(Integer adid) {
		this.adid = adid;
	}

	public String getAdtitle() {
		return adtitle;
	}

	public void setAdtitle(String adtitle) {
		this.adtitle = adtitle == null ? null : adtitle.trim();
	}

	public String getAdpicpath() {
		return adpicpath;
	}

	public void setAdpicpath(String adpicpath) {
		this.adpicpath = adpicpath == null ? null : adpicpath.trim();
	}
}