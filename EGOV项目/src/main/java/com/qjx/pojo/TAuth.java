package com.qjx.pojo;

public class TAuth {
    private Integer authno;

    private String orgcode;

    private String remark;

    private String contactman;

    private String contacttel;

    private String filename;

    private String fileremark;

    private String usercode;

    private String feedback;

    private Integer regcap;
    private String regcry;
    private String regdate;

    public Integer getRegcap() {
        return regcap;
    }

    public void setRegcap(Integer regcap) {
        this.regcap = regcap;
    }

    public String getRegcry() {
        return regcry;
    }

    public void setRegcry(String regcry) {
        this.regcry = regcry;
    }

    public String getRegdate() {
        return regdate;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }

    public Integer getAuthno() {
        return authno;
    }

    public void setAuthno(Integer authno) {
        this.authno = authno;
    }

    public String getOrgcode() {
        return orgcode;
    }

    public void setOrgcode(String orgcode) {
        this.orgcode = orgcode == null ? null : orgcode.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename == null ? null : filename.trim();
    }

    public String getFileremark() {
        return fileremark;
    }

    public void setFileremark(String fileremark) {
        this.fileremark = fileremark == null ? null : fileremark.trim();
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode == null ? null : usercode.trim();
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback == null ? null : feedback.trim();
    }
}