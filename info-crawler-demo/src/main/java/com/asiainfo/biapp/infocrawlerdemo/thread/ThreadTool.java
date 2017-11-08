/**
 * Project Name:info-crawler-demo File Name:ThreadPool.java Package Name:com.asiainfo.biapp.infocrawlerdemo.thread
 * Date:2017年11月8日下午4:13:07 Copyright (c) 2017, chenzhou1025@126.com All Rights Reserved.
 *
 */

package com.asiainfo.biapp.infocrawlerdemo.thread;

import com.asiainfo.biapp.infocrawlerdemo.model.ClientInfo;

import lombok.extern.slf4j.Slf4j;

/**
 * ClassName:ThreadPool <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2017年11月8日 下午4:13:07 <br/>
 * 
 * @author Maclong-work
 * @version
 * @since JDK 1.6
 * @see
 */
@Slf4j
public class ThreadTool {

    private static ThreadTool tool = new ThreadTool();

    private ThreadTool() {

    }

    public static ThreadTool getInstance() {
        return tool;
    }

    public void createNewThread(ClientInfo clientInfo) {

        CrawlerThread newThread = new CrawlerThread(clientInfo);

        (new Thread(newThread)).start();
    }

}

