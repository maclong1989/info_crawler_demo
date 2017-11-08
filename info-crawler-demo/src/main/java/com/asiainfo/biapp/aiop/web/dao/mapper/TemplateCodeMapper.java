package com.asiainfo.biapp.aiop.web.dao.mapper;

import com.asiainfo.biapp.infocrawlerdemo.dao.pojo.TemplateCodeKey;

public interface TemplateCodeMapper {
    int deleteByPrimaryKey(TemplateCodeKey key);

    int insert(TemplateCodeKey record);

    int insertSelective(TemplateCodeKey record);
}