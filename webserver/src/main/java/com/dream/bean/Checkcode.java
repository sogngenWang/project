package com.dream.bean;

public class Checkcode {
    private Integer checkcodeid;

    private String checkcode;

    private String telephone;

    private String createtime;

    public Integer getCheckcodeid() {
        return checkcodeid;
    }

    public void setCheckcodeid(Integer checkcodeid) {
        this.checkcodeid = checkcodeid;
    }

    public String getCheckcode() {
        return checkcode;
    }

    public void setCheckcode(String checkcode) {
        this.checkcode = checkcode == null ? null : checkcode.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }
}