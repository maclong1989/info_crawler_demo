/**
 * Project Name:info-crawler-demo File Name:QueueTool.java Package Name:com.asiainfo.biapp.infocrawlerdemo.queue
 * Date:2017年11月8日下午5:18:04 Copyright (c) 2017, chenzhou1025@126.com All Rights Reserved.
 *
 */

package com.asiainfo.biapp.infocrawlerdemo.queue;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import com.asiainfo.biapp.infocrawlerdemo.model.CrawlerInfo;

import lombok.extern.slf4j.Slf4j;

/**
 * ClassName:QueueTool <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2017年11月8日 下午5:18:04 <br/>
 * 
 * @author Maclong-work
 * @version
 * @since JDK 1.6
 * @see
 */
@Slf4j
public class QueueTool {

    private static QueueTool tool = new QueueTool();

    private Map<String, BlockingQueue<CrawlerInfo>> queueMap = new HashMap<>();

    private QueueTool() {}

    public static QueueTool getInstance() {
        return tool;
    }

    public boolean isQueued(String key) {
        return queueMap.containsKey(key);
    }

    public BlockingQueue<CrawlerInfo> addNewQueue(String key) {
        BlockingQueue<CrawlerInfo> newQueue = new LinkedBlockingQueue<CrawlerInfo>();
        queueMap.put(key, newQueue);
        return newQueue;
    }

    public void send(String key, CrawlerInfo crawlerInfo) {
        try {
            queueMap.get(key).put(crawlerInfo);
        } catch (InterruptedException e) {
            log.error("queue put task error!", e);

        }
    }

}

