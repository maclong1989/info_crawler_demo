/**
 * Project Name:AIOP_WEB File Name:DruidStatViewServlet.java Package Name:com.asiainfo.biapp.si.coc.trunk.api.rest
 * Date:2017年8月7日下午3:14:39 Copyright (c) 2017, chenzhou1025@126.com All Rights Reserved.
 *
 */

package com.asiainfo.biapp.infocrawlerdemo.druid;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

import com.alibaba.druid.support.http.StatViewServlet;

/**
 * ClassName:DruidStatViewServlet <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2017年8月7日 下午3:14:39 <br/>
 * 
 * @author Maclong-work
 * @version
 * @since JDK 1.6
 * @see
 */
@WebServlet(urlPatterns = "/druid/*",
                initParams = {@WebInitParam(name = "loginUsername", value = "admin"), // 用户名
                                @WebInitParam(name = "loginPassword", value = "Aa123456"), // 密码
                                @WebInitParam(name = "resetEnable", value = "false")// 禁用HTML页面上的“Reset All”功能
                })
public class DruidStatViewServlet extends StatViewServlet {
    private static final long serialVersionUID = 1L;

}
