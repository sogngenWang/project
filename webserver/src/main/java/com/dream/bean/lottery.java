package com.dream.bean;

public class lottery {
    private Integer drawid;

    private Integer lotteryid;

    private Integer activityid;

    private String lotterydate;

    private String prizelevel;

    private Integer prizetype;

    private Integer prizecount;

    private Float prizepercentrate;

    private Integer bonuspoint;

    public Integer getDrawid() {
        return drawid;
    }

    public void setDrawid(Integer drawid) {
        this.drawid = drawid;
    }

    public Integer getLotteryid() {
        return lotteryid;
    }

    public void setLotteryid(Integer lotteryid) {
        this.lotteryid = lotteryid;
    }

    public Integer getActivityid() {
        return activityid;
    }

    public void setActivityid(Integer activityid) {
        this.activityid = activityid;
    }

    public String getLotterydate() {
        return lotterydate;
    }

    public void setLotterydate(String lotterydate) {
        this.lotterydate = lotterydate == null ? null : lotterydate.trim();
    }

    public String getPrizelevel() {
        return prizelevel;
    }

    public void setPrizelevel(String prizelevel) {
        this.prizelevel = prizelevel == null ? null : prizelevel.trim();
    }

    public Integer getPrizetype() {
        return prizetype;
    }

    public void setPrizetype(Integer prizetype) {
        this.prizetype = prizetype;
    }

    public Integer getPrizecount() {
        return prizecount;
    }

    public void setPrizecount(Integer prizecount) {
        this.prizecount = prizecount;
    }

    public Float getPrizepercentrate() {
        return prizepercentrate;
    }

    public void setPrizepercentrate(Float prizepercentrate) {
        this.prizepercentrate = prizepercentrate;
    }

    public Integer getBonuspoint() {
        return bonuspoint;
    }

    public void setBonuspoint(Integer bonuspoint) {
        this.bonuspoint = bonuspoint;
    }
}