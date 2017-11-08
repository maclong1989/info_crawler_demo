/**
 * Project Name:info-crawler-demo File Name:CrawlerRequest.java Package Name:com.asiainfo.biapp.infocrawlerdemo.api
 * Date:2017年11月8日下午3:59:37 Copyright (c) 2017, chenzhou1025@126.com All Rights Reserved.
 *
 */

package com.asiainfo.biapp.infocrawlerdemo.api;

import lombok.Data;

/**
 * ClassName:CrawlerRequest <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2017年11月8日 下午3:59:37 <br/>
 * 
 * @author Maclong-work
 * @version
 * @since JDK 1.6
 * @see
 */
@Data
public class CrawlerRequest {

    private Integer id;

    private String ip;

    private int port;

    private String userName;

    private String password;

    private String quartzReg;

    private String type;

}

