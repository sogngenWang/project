package com.dream.bean;

public class Prize {
    private Integer prizeid;

    private Integer lotteryid;

    private Integer userid;

    private String prizelevel;

    private String prizetime;

    private Integer isexchange;

    public Integer getPrizeid() {
        return prizeid;
    }

    public void setPrizeid(Integer prizeid) {
        this.prizeid = prizeid;
    }

    public Integer getLotteryid() {
        return lotteryid;
    }

    public void setLotteryid(Integer lotteryid) {
        this.lotteryid = lotteryid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getPrizelevel() {
        return prizelevel;
    }

    public void setPrizelevel(String prizelevel) {
        this.prizelevel = prizelevel == null ? null : prizelevel.trim();
    }

    public String getPrizetime() {
        return prizetime;
    }

    public void setPrizetime(String prizetime) {
        this.prizetime = prizetime == null ? null : prizetime.trim();
    }

    public Integer getIsexchange() {
        return isexchange;
    }

    public void setIsexchange(Integer isexchange) {
        this.isexchange = isexchange;
    }
}