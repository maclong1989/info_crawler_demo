package com.asiainfo.biapp.infocrawlerdemo.dao.pojo;

public class TemplateCode extends TemplateCodeKey {
    private String codeName;

    private String codeInfo;

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName == null ? null : codeName.trim();
    }

    public String getCodeInfo() {
        return codeInfo;
    }

    public void setCodeInfo(String codeInfo) {
        this.codeInfo = codeInfo == null ? null : codeInfo.trim();
    }
}