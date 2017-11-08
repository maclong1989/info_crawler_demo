/**
 * Project Name:info-crawler-demo File Name:TemplateTool.java Package Name:com.asiainfo.biapp.infocrawlerdemo.template
 * Date:2017年11月8日下午7:39:36 Copyright (c) 2017, chenzhou1025@126.com All Rights Reserved.
 *
 */

package com.asiainfo.biapp.infocrawlerdemo.template;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.alibaba.fastjson.JSON;
import com.asiainfo.biapp.infocrawlerdemo.dao.mapper.TemplateMapper;
import com.asiainfo.biapp.infocrawlerdemo.dao.pojo.Template;
import com.asiainfo.biapp.infocrawlerdemo.model.CodeInfo;
import com.asiainfo.biapp.infocrawlerdemo.model.CrawlerInfo;
import com.asiainfo.biapp.infocrawlerdemo.template.decider.TemplateDecider;
import com.asiainfo.biapp.infocrawlerdemo.utils.SpringContextUtil;

import lombok.extern.slf4j.Slf4j;


/**
 * ClassName:TemplateTool <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2017年11月8日 下午7:39:36 <br/>
 * 
 * @author Maclong-work
 * @version
 * @since JDK 1.6
 * @see
 */
@Slf4j
public class TemplateTool {

    private static TemplateTool templateTool;

    private static Lock lock = new ReentrantLock();

    private TemplateMapper templateMapper;

    Map<Integer, TemplateDecider> templateDeciderMap = new HashMap<>();

    private TemplateTool() {

        try {

            templateMapper = (TemplateMapper) SpringContextUtil.getBean("templateMapper");

            List<Template> templates = templateMapper.selectAll();

            for (Template template : templates) {
                templateDeciderMap.put(template.getId(),
                                (TemplateDecider) (Class.forName(template.getDecideClass())).newInstance());
            }
        } catch (Exception e) {
            log.error("templates init error!", e);

        }
    }

    public static TemplateTool getInstance() {

        lock.lock();
        try {
            if (templateTool == null) {
                templateTool = new TemplateTool();
            }
        } finally {
            lock.unlock();
        }
        return templateTool;
    }

    public List<CodeInfo> getCodes(CrawlerInfo crawlerInfo) {

        Integer templateId = null;

        for (Integer id : templateDeciderMap.keySet()) {

            TemplateDecider TemplateDecider = templateDeciderMap.get(id);
            if (TemplateDecider.isDecide(crawlerInfo)) {
                templateId = id;
            }

        }

        if (templateId == null) {
            log.error("templates are all not match!{}" + JSON.toJSONString(crawlerInfo));
            return null;
        }

        return templateMapper.selectCodeInfo(templateId);
    }

}

