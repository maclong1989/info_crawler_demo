/**
 * Project Name:info-crawler-demo File Name:ExcuteTool.java Package Name:com.asiainfo.biapp.infocrawlerdemo.excute
 * Date:2017年11月8日下午8:46:58 Copyright (c) 2017, chenzhou1025@126.com All Rights Reserved.
 *
 */

package com.asiainfo.biapp.infocrawlerdemo.excute;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.asiainfo.biapp.infocrawlerdemo.model.CodeInfo;
import com.asiainfo.biapp.infocrawlerdemo.model.CrawlerInfo;
import com.asiainfo.biapp.infocrawlerdemo.ssh.SSHExcute;

import lombok.extern.slf4j.Slf4j;

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
@Slf4j
public class ExcuteTool {

    private static ExcuteTool excuteTool = new ExcuteTool();

    private ExcuteTool() {}

    public static ExcuteTool getInstance() {
        return excuteTool;
    }

    public Map<String, CodeInfo> excute(CrawlerInfo crawlerInfo, List<CodeInfo> codeInfos, SSHExcute sshExcute) {

        Map<String, CodeInfo> resultMap = new HashMap<>();

        for (CodeInfo codeinfo : codeInfos) {

            if ("0".equals(codeinfo.getCodeType())) {

                codeinfo.setTime(new Date());
                int ret = sshExcute.excute(codeinfo.getCode());

                if (ret == -1) {
                    log.error("SSH excute error!");
                    continue;
                }

                List<String> retStr = sshExcute.getStandardOutput();

                codeinfo.setResults(retStr);

                resultMap.put(codeinfo.getCodeName(), codeinfo);
            }
        }

        return resultMap;
    }

}

