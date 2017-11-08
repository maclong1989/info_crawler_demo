/**
 * Project Name:info-crawler-demo File Name:AllTemplateDecider.java Package
 * Name:com.asiainfo.biapp.infocrawlerdemo.template.decider Date:2017年11月8日下午8:08:51 Copyright (c) 2017,
 * chenzhou1025@126.com All Rights Reserved.
 *
 */

package com.asiainfo.biapp.infocrawlerdemo.template.decider;

import com.asiainfo.biapp.infocrawlerdemo.model.CrawlerInfo;

/**
 * ClassName:AllTemplateDecider <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2017年11月8日 下午8:08:51 <br/>
 * 
 * @author Maclong-work
 * @version
 * @since JDK 1.6
 * @see
 */
public class AllTrueTemplateDecider implements TemplateDecider {

    @Override
    public boolean isDecide(CrawlerInfo crawlerInfo) {
        return true;
    }

}

