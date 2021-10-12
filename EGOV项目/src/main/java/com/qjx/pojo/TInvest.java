package com.qjx.pojo;

public class TInvest {
    private Integer invregnum;

    private String invname;

    private String cty;

    private String orgcode;

    private String contactman;

    private String contacttel;

    private String email;

    private String remark;

    private String usercode;

    private String regdate;
    //根据usercode联合t_user表查询的username
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getInvregnum() {
        return invregnum;
    }

    public void setInvregnum(Integer invregnum) {
        this.invregnum = invregnum;
    }

    public String getInvname() {
        return invname;
    }

    public void setInvname(String invname) {
        this.invname = invname == null ? null : invname.trim();
    }

    public String getCty() {
        return cty;
    }

    public void setCty(String cty) {
        this.cty = cty == null ? null : cty.trim();
    }

    public String getOrgcode() {
        return orgcode;
    }

    public void setOrgcode(String orgcode) {
        this.orgcode = orgcode == null ? null : orgcode.trim();
    }

    public String getContactman() {
        return contactman;
    }

    public void setContactman(String contactman) {
        this.contactman = contactman == null ? null : contactman.trim();
    }

    public String getContacttel() {
        return contacttel;
    }

    public void setContacttel(String contacttel) {
        this.contacttel = contacttel == null ? null : contacttel.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode == null ? null : usercode.trim();
    }

    public String getRegdate() {
        return regdate;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate == null ? null : regdate.trim();
    }
}