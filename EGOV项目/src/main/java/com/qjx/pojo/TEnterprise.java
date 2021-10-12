package com.qjx.pojo;

public class TEnterprise {
    private Integer orgcode;

    private String regno;

    private String cnname;

    private String enname;

    private String contactman;

    private String contacttel;

    private Integer regcap;

    private Integer outregcap;

    private String regcry;

    private String usercode;

    private String regdate;

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getOrgcode() {
        return orgcode;
    }

    public void setOrgcode(Integer orgcode) {
        this.orgcode = orgcode;
    }

    public String getRegno() {
        return regno;
    }

    public void setRegno(String regno) {
        this.regno = regno == null ? null : regno.trim();
    }

    public String getCnname() {
        return cnname;
    }

    public void setCnname(String cnname) {
        this.cnname = cnname == null ? null : cnname.trim();
    }

    public String getEnname() {
        return enname;
    }

    public void setEnname(String enname) {
        this.enname = enname == null ? null : enname.trim();
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

    public Integer getRegcap() {
        return regcap;
    }

    public void setRegcap(Integer regcap) {
        this.regcap = regcap;
    }

    public Integer getOutregcap() {
        return outregcap;
    }

    public void setOutregcap(Integer outregcap) {
        this.outregcap = outregcap;
    }

    public String getRegcry() {
        return regcry;
    }

    public void setRegcry(String regcry) {
        this.regcry = regcry == null ? null : regcry.trim();
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