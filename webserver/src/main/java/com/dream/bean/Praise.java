package com.dream.bean;

import com.dream.basebean.PageBase;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Praise extends PageBase{
    private Integer praiseid;

    private Integer userid;

    private Integer otherid;

    private Integer praisetype;

    public Integer getPraiseid() {
        return praiseid;
    }

    public void setPraiseid(Integer praiseid) {
        this.praiseid = praiseid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getOtherid() {
        return otherid;
    }

    public void setOtherid(Integer otherid) {
        this.otherid = otherid;
    }

    public Integer getPraisetype() {
        return praisetype;
    }

    public void setPraisetype(Integer praisetype) {
        this.praisetype = praisetype;
    }
}