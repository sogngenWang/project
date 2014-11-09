package com.dream.bean;

import com.dream.basebean.PageBase;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@JsonInclude(Include.NON_NULL)
public class Kinds extends PageBase{
	
    private Integer kindsid;
    
    private String kindsname;

    private String secondkindsid;

    public Integer getKindsid() {
        return kindsid;
    }

    public void setKindsid(Integer kindsid) {
        this.kindsid = kindsid;
    }

    public String getKindsname() {
        return kindsname;
    }

    public void setKindsname(String kindsname) {
        this.kindsname = kindsname == null ? null : kindsname.trim();
    }

    public String getSecondkindsid() {
        return secondkindsid;
    }

    public void setSecondkindsid(String secondkindsid) {
        this.secondkindsid = secondkindsid == null ? null : secondkindsid.trim();
    }
}