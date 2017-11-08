package com.asiainfo.biapp.infocrawlerdemo.dao.mapper;

import com.asiainfo.biapp.infocrawlerdemo.dao.pojo.TemplateCode;
import com.asiainfo.biapp.infocrawlerdemo.dao.pojo.TemplateCodeKey;

public interface TemplateCodeMapper {
    int deleteByPrimaryKey(TemplateCodeKey key);

    int insert(TemplateCode record);

    int insertSelective(TemplateCode record);

    TemplateCode selectByPrimaryKey(TemplateCodeKey key);

    int updateByPrimaryKeySelective(TemplateCode record);

    int updateByPrimaryKey(TemplateCode record);
}