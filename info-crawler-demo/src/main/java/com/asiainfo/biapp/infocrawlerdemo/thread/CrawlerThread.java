/**
 * Project Name:info-crawler-demo File Name:CrawlerThread.java Package Name:com.asiainfo.biapp.infocrawlerdemo.thread
 * Date:2017年11月8日下午4:21:46 Copyright (c) 2017, chenzhou1025@126.com All Rights Reserved.
 *
 */

package com.asiainfo.biapp.infocrawlerdemo.thread;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

import org.apache.commons.lang3.StringUtils;

import com.asiainfo.biapp.infocrawlerdemo.dao.pojo.CrawledInfo;
import com.asiainfo.biapp.infocrawlerdemo.es.StoreTool;
import com.asiainfo.biapp.infocrawlerdemo.excute.ExcuteTool;
import com.asiainfo.biapp.infocrawlerdemo.model.ClientInfo;
import com.asiainfo.biapp.infocrawlerdemo.model.CodeInfo;
import com.asiainfo.biapp.infocrawlerdemo.model.CrawlerInfo;
import com.asiainfo.biapp.infocrawlerdemo.ssh.SSHExcute;
import com.asiainfo.biapp.infocrawlerdemo.ssh.SSHSessionFactory;
import com.asiainfo.biapp.infocrawlerdemo.template.TemplateTool;
import com.jcraft.jsch.Session;

import lombok.extern.slf4j.Slf4j;

/**
 * ClassName:CrawlerThread <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2017年11月8日 下午4:21:46 <br/>
 * 
 * @author Maclong-work
 * @version
 * @since JDK 1.6
 * @see
 */
@Slf4j
public class CrawlerThread implements Runnable {

    private ClientInfo info;

    private SSHExcute sshExcute;

    private Session session;

    private TemplateTool templateTool = TemplateTool.getInstance();

    private ExcuteTool excuteTool = ExcuteTool.getInstance();

    private StoreTool storeTool = StoreTool.getInstance();

    private DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public CrawlerThread(ClientInfo info) {
        session = SSHSessionFactory.getSession(info.getIp(), info.getPort(), info.getUserName(), info.getPassword());
        sshExcute = new SSHExcute(session);
        this.info = info;
    }

    @Override
    public void run() {

        while (true) {
            try {
                BlockingQueue<CrawlerInfo> queue = info.getQueue();

                CrawlerInfo crawlerInfo = queue.take();

                List<CodeInfo> codeInfos = templateTool.getCodes(crawlerInfo);

                Map<String, CodeInfo> resultMap = excuteTool.excute(crawlerInfo, codeInfos, sshExcute);

                List<CrawledInfo> crawledInfos = new ArrayList<CrawledInfo>();

                for (Map.Entry<String, CodeInfo> result : resultMap.entrySet()) {
                    log.info("crawlerdInfo:key:{},velue:{},info:{}.", result.getKey(), result.getValue().getResults(),
                                    result.getValue().getCodeInfo());

                    CrawledInfo crawledInfo = new CrawledInfo();
                    crawledInfo.setIp(crawlerInfo.getIp());
                    crawledInfo.setTaskId(crawlerInfo.getId());
                    crawledInfo.setCodeName(result.getValue().getCodeName());
                    crawledInfo.setValue(StringUtils.join(result.getValue().getResults(), "\n"));
                    crawledInfo.setTime(df.format(result.getValue().getTime()));

                    crawledInfos.add(crawledInfo);
                }


                storeTool.store(crawledInfos);

            } catch (InterruptedException e) {
                log.error("take crawlerInfo interrupted!", e);
            } catch (Exception e) {
                log.error("take crawlerInfo error!", e);
            }

        }

    }

}

