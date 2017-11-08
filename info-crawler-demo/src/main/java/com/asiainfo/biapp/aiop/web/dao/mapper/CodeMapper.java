package com.asiainfo.biapp.aiop.web.dao.mapper;

import com.asiainfo.biapp.infocrawlerdemo.dao.pojo.Code;

public interface CodeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Code record);

    int insertSelective(Code record);

    Code selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Code record);

    int updateByPrimaryKey(Code record);
}