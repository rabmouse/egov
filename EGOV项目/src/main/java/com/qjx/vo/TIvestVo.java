package com.qjx.vo;

//封装混合查询投资人的条件类
public class TIvestVo {
    private Integer invregnum;
    private String invname;
    private String startdate;
    private String enddate;

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
        this.invname = invname;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }
}
