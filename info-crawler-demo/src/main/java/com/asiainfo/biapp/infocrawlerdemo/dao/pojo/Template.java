package com.asiainfo.biapp.infocrawlerdemo.dao.pojo;

public class Template {
    private Integer id;

    private String templateName;

    private String decideClass;

    private String templateType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName == null ? null : templateName.trim();
    }

    public String getDecideClass() {
        return decideClass;
    }

    public void setDecideClass(String decideClass) {
        this.decideClass = decideClass == null ? null : decideClass.trim();
    }

    public String getTemplateType() {
        return templateType;
    }

    public void setTemplateType(String templateType) {
        this.templateType = templateType == null ? null : templateType.trim();
    }
}