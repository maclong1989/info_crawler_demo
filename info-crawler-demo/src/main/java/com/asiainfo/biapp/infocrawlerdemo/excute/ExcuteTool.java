/**
 * Project Name:info-crawler-demo File Name:ExcuteTool.java Package Name:com.asiainfo.biapp.infocrawlerdemo.excute
 * Date:2017年11月8日下午8:46:58 Copyright (c) 2017, chenzhou1025@126.com All Rights Reserved.
 *
 */

package com.asiainfo.biapp.infocrawlerdemo.excute;

import java.util.List;
import java.util.Map;

import com.asiainfo.biapp.infocrawlerdemo.model.CodeInfo;
import com.asiainfo.biapp.infocrawlerdemo.model.CrawlerInfo;

/**
 * ClassName:ExcuteTool <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2017年11月8日 下午8:46:58 <br/>
 * 
 * @author Maclong-work
 * @version
 * @since JDK 1.6
 * @see
 */
public class ExcuteTool {

    private static ExcuteTool excuteTool = new ExcuteTool();

    private ExcuteTool() {}

    public ExcuteTool getExcuteTool() {
        return excuteTool;
    }

    public Map<String, String> excute(CrawlerInfo crawlerInfo, List<CodeInfo> codeInfos) {

        return null;
    }

}

