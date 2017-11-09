/**
 * Project Name:info-crawler-demo File Name:CrawledInfo.java Package Name:com.asiainfo.biapp.infocrawlerdemo.dao.pojo
 * Date:2017年11月9日上午11:19:19 Copyright (c) 2017, chenzhou1025@126.com All Rights Reserved.
 *
 */

package com.asiainfo.biapp.infocrawlerdemo.dao.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName:CrawledInfo <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2017年11月9日 上午11:19:19 <br/>
 * 
 * @author Maclong-work
 * @version
 * @since JDK 1.6
 * @see
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CrawledInfo {

    private Integer taskId;

    private String ip;

    private String codeName;

    private String value;

    private String time;

}

