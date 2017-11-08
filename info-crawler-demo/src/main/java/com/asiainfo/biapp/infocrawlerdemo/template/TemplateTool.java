/**
 * Project Name:info-crawler-demo File Name:TemplateTool.java Package Name:com.asiainfo.biapp.infocrawlerdemo.template
 * Date:2017年11月8日下午7:39:36 Copyright (c) 2017, chenzhou1025@126.com All Rights Reserved.
 *
 */

package com.asiainfo.biapp.infocrawlerdemo.template;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * ClassName:TemplateTool <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2017年11月8日 下午7:39:36 <br/>
 * 
 * @author Maclong-work
 * @version
 * @since JDK 1.6
 * @see
 */
public class TemplateTool {

    private static TemplateTool templateTool;

    private static Lock lock = new ReentrantLock();

    private TemplateTool() {

    }

    public static TemplateTool getInstance() {

        lock.lock();
        try {
            if (templateTool == null) {
                templateTool = new TemplateTool();
            }
        } finally {
            lock.unlock();
        }
        return templateTool;
    }

}

