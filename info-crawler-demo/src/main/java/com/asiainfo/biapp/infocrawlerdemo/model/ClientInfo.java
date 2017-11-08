/**
 * Project Name:info-crawler-demo File Name:ClientInfo.java Package Name:com.asiainfo.biapp.infocrawlerdemo.model
 * Date:2017年11月8日下午4:18:48 Copyright (c) 2017, chenzhou1025@126.com All Rights Reserved.
 *
 */

package com.asiainfo.biapp.infocrawlerdemo.model;

import java.util.concurrent.BlockingQueue;

import lombok.Data;

/**
 * ClassName:ClientInfo <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2017年11月8日 下午4:18:48 <br/>
 * 
 * @author Maclong-work
 * @version
 * @since JDK 1.6
 * @see
 */
@Data
public class ClientInfo {

    private String ip;

    private int port;

    private String userName;

    private String password;

    private BlockingQueue<CrawlerInfo> queue;

}

