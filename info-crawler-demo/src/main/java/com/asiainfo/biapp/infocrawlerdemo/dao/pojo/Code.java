package com.asiainfo.biapp.infocrawlerdemo.dao.pojo;

public class Code {
    private Integer id;

    private String code;

    private String fix;

    private String codeType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getFix() {
        return fix;
    }

    public void setFix(String fix) {
        this.fix = fix == null ? null : fix.trim();
    }

    public String getCodeType() {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType == null ? null : codeType.trim();
    }
}