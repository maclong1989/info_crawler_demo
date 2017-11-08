package com.asiainfo.biapp.aiop.web.dao.mapper;

import com.asiainfo.biapp.infocrawlerdemo.dao.pojo.Template;

public interface TemplateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Template record);

    int insertSelective(Template record);

    Template selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Template record);

    int updateByPrimaryKey(Template record);
}