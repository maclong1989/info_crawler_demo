/**
 * Project Name:info-crawler-demo File Name:QueueFactory.java Package Name:com.asiainfo.biapp.infocrawlerdemo.queue
 * Date:2017年11月8日下午4:13:50 Copyright (c) 2017, chenzhou1025@126.com All Rights Reserved.
 *
 */

package com.asiainfo.biapp.infocrawlerdemo.control;

import java.util.concurrent.BlockingQueue;

import com.alibaba.druid.util.StringUtils;
import com.asiainfo.biapp.infocrawlerdemo.model.ClientInfo;
import com.asiainfo.biapp.infocrawlerdemo.model.CrawlerInfo;
import com.asiainfo.biapp.infocrawlerdemo.quartz.QuartzTool;
import com.asiainfo.biapp.infocrawlerdemo.queue.QueueTool;
import com.asiainfo.biapp.infocrawlerdemo.thread.ThreadTool;

import lombok.extern.slf4j.Slf4j;

/**
 * ClassName:QueueFactory <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2017年11月8日 下午4:13:50 <br/>
 * 
 * @author Maclong-work
 * @version
 * @since JDK 1.6
 * @see
 */
@Slf4j
public class ControlFactory {

    private static ControlFactory controlFactory = new ControlFactory();

    private ThreadTool threadTool = ThreadTool.getInstance();

    private QuartzTool quartzTool = QuartzTool.getInstance();

    private QueueTool queueTool = QueueTool.getInstance();

    private ControlFactory() {}

    public static ControlFactory getInstance() {
        return controlFactory;
    }

    public void sendTask(CrawlerInfo crawlerInfo) {

        if (queueTool.isQueued(crawlerInfo.getIp())) {

        } else {

            BlockingQueue<CrawlerInfo> newQueue = queueTool.addNewQueue(crawlerInfo.getIp());

            ClientInfo clientInfo = new ClientInfo();
            clientInfo.setPort(crawlerInfo.getPort());
            clientInfo.setIp(crawlerInfo.getIp());
            clientInfo.setUserName(crawlerInfo.getUserName());
            clientInfo.setPassword(crawlerInfo.getPassword());
            clientInfo.setQueue(newQueue);

            threadTool.createNewThread(clientInfo);

            if ("0".equals(crawlerInfo.getType())) {

                if (StringUtils.isEmpty(crawlerInfo.getQuartzReg())) {
                    queueTool.send(crawlerInfo.getIp(), crawlerInfo);
                } else {
                    quartzTool.createNewJob(crawlerInfo);
                }
            }
        }
    }
}

