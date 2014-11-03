package com.dream.bean;

public class Friends {
    private Integer friendid;

    private Integer userid;

    private Integer frienduserid;

    private String isbefriend;

    public Integer getFriendid() {
        return friendid;
    }

    public void setFriendid(Integer friendid) {
        this.friendid = friendid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getFrienduserid() {
        return frienduserid;
    }

    public void setFrienduserid(Integer frienduserid) {
        this.frienduserid = frienduserid;
    }

    public String getIsbefriend() {
        return isbefriend;
    }

    public void setIsbefriend(String isbefriend) {
        this.isbefriend = isbefriend == null ? null : isbefriend.trim();
    }
}