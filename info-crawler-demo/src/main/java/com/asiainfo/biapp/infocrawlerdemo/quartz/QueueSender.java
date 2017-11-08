/**
 * Project Name:info-crawler-demo File Name:QueueSender.java Package Name:com.asiainfo.biapp.infocrawlerdemo.quartz
 * Date:2017年11月8日下午4:53:54 Copyright (c) 2017, chenzhou1025@126.com All Rights Reserved.
 *
 */

package com.asiainfo.biapp.infocrawlerdemo.quartz;


import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.alibaba.fastjson.JSON;
import com.asiainfo.biapp.infocrawlerdemo.model.CrawlerInfo;
import com.asiainfo.biapp.infocrawlerdemo.queue.QueueTool;

import lombok.extern.slf4j.Slf4j;

/**
 * ClassName:QueueSender <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2017年11月8日 下午4:53:54 <br/>
 * 
 * @author Maclong-work
 * @version
 * @since JDK 1.6
 * @see
 */
@Slf4j
public class QueueSender implements Job {

    private QueueTool queueTool = QueueTool.getInstance();

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

        JobDataMap jobDataMap = context.getMergedJobDataMap();
        CrawlerInfo crawlerInfo = (CrawlerInfo) jobDataMap.get("crawlerInfo");

        log.info("job start!info:{}", JSON.toJSONString(crawlerInfo));

        queueTool.send(crawlerInfo.getIp(), crawlerInfo);

    }

}

