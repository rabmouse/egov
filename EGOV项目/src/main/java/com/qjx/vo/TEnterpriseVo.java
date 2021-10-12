package com.qjx.vo;

//封装查询外商投资企业的多条件查询条件
public class TEnterpriseVo {
    private Integer orgcode;
    private String cnname;
    private String startdate;
    private String enddate;

    public Integer getOrgcode() {
        return orgcode;
    }

    public void setOrgcode(Integer orgcode) {
        this.orgcode = orgcode;
    }

    public String getCnname() {
        return cnname;
    }

    public void setCnname(String cnname) {
        this.cnname = cnname;
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
