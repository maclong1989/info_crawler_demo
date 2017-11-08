/**
 * Project Name:info-crawler-demo File Name:QuartzTool.java Package Name:com.asiainfo.biapp.infocrawlerdemo.quartz
 * Date:2017年11月8日下午4:37:02 Copyright (c) 2017, chenzhou1025@126.com All Rights Reserved.
 *
 */

package com.asiainfo.biapp.infocrawlerdemo.quartz;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.asiainfo.biapp.infocrawlerdemo.model.CrawlerInfo;

import lombok.extern.slf4j.Slf4j;


/**
 * ClassName:QuartzTool <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2017年11月8日 下午4:37:02 <br/>
 * 
 * @author Maclong-work
 * @version
 * @since JDK 1.6
 * @see
 */
@Slf4j
public class QuartzTool {

    private Scheduler scheduler;

    private static QuartzTool tool = new QuartzTool();

    private QuartzTool() {
        init();
    }

    public static QuartzTool getInstance() {
        return tool;
    }

    private void init() {
        SchedulerFactory sf = new StdSchedulerFactory();
        try {
            scheduler = sf.getScheduler();
            scheduler.start();
        } catch (SchedulerException e) {
            log.error("quartz init error!", e);
        }
    }

    public void createNewJob(CrawlerInfo crawlerInfo) {

        try {

            JobDataMap jobDataMap = new JobDataMap();
            jobDataMap.put("crawlerInfo", crawlerInfo);

            JobDetail jobDetail = JobBuilder.newJob(QueueSender.class)
                            .withIdentity(crawlerInfo.getIp() + "_job_" + crawlerInfo.getId(), "group1")
                            .setJobData(jobDataMap).build();

            Trigger trigger = TriggerBuilder.newTrigger()
                            .withIdentity(crawlerInfo.getIp() + "_trigger_" + crawlerInfo.getId(), "group1")
                            .withSchedule(CronScheduleBuilder.cronSchedule(crawlerInfo.getQuartzReg())).build();

            scheduler.scheduleJob(jobDetail, trigger);
        } catch (Exception e) {
            log.error("create new job error!", e);
        }

    }

}

