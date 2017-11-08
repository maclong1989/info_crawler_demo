package com.asiainfo.biapp.infocrawlerdemo.dao.mapper;

import java.util.List;

import com.asiainfo.biapp.infocrawlerdemo.dao.pojo.Template;
import com.asiainfo.biapp.infocrawlerdemo.model.CodeInfo;

public interface TemplateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Template record);

    int insertSelective(Template record);

    Template selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Template record);

    int updateByPrimaryKey(Template record);

    List<Template> selectAll();

    List<CodeInfo> selectCodeInfo(Integer templateId);
}
