package com.dream.bean;

import com.dream.basebean.PageBase;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@JsonInclude(Include.NON_NULL)
public class Kinds extends PageBase{
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kinds.kindsid
     *
     * @mbggenerated Fri Oct 31 14:24:01 CST 2014
     */
    private Integer kindsid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kinds.kindsname
     *
     * @mbggenerated Fri Oct 31 14:24:01 CST 2014
     */
    private String kindsname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kinds.secondkindsid
     *
     * @mbggenerated Fri Oct 31 14:24:01 CST 2014
     */
    private String secondkindsid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kinds.kindsid
     *
     * @return the value of kinds.kindsid
     *
     * @mbggenerated Fri Oct 31 14:24:01 CST 2014
     */
    public Integer getKindsid() {
        return kindsid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kinds.kindsid
     *
     * @param kindsid the value for kinds.kindsid
     *
     * @mbggenerated Fri Oct 31 14:24:01 CST 2014
     */
    public void setKindsid(Integer kindsid) {
        this.kindsid = kindsid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kinds.kindsname
     *
     * @return the value of kinds.kindsname
     *
     * @mbggenerated Fri Oct 31 14:24:01 CST 2014
     */
    public String getKindsname() {
        return kindsname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kinds.kindsname
     *
     * @param kindsname the value for kinds.kindsname
     *
     * @mbggenerated Fri Oct 31 14:24:01 CST 2014
     */
    public void setKindsname(String kindsname) {
        this.kindsname = kindsname == null ? null : kindsname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kinds.secondkindsid
     *
     * @return the value of kinds.secondkindsid
     *
     * @mbggenerated Fri Oct 31 14:24:01 CST 2014
     */
    public String getSecondkindsid() {
        return secondkindsid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kinds.secondkindsid
     *
     * @param secondkindsid the value for kinds.secondkindsid
     *
     * @mbggenerated Fri Oct 31 14:24:01 CST 2014
     */
    public void setSecondkindsid(String secondkindsid) {
        this.secondkindsid = secondkindsid == null ? null : secondkindsid.trim();
    }
}