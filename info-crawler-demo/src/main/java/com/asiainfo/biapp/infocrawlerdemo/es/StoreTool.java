/**
 * Project Name:info-crawler-demo File Name:ESStoreTool.java Package Name:com.asiainfo.biapp.infocrawlerdemo.es
 * Date:2017年11月9日上午11:30:58 Copyright (c) 2017, chenzhou1025@126.com All Rights Reserved.
 *
 */

package com.asiainfo.biapp.infocrawlerdemo.es;

import java.util.List;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import com.alibaba.fastjson.JSON;
import com.asiainfo.biapp.infocrawlerdemo.dao.pojo.CrawledInfo;
import com.asiainfo.biapp.infocrawlerdemo.utils.SpringContextUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * ClassName:ESStoreTool <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2017年11月9日 上午11:30:58 <br/>
 * 
 * @author Maclong-work
 * @version
 * @since JDK 1.6
 * @see
 */
@Slf4j
public class StoreTool {

    private static StoreTool storeTool = new StoreTool();

    private PreBuiltTransportClient client;

    private StoreTool() {
        client = (PreBuiltTransportClient) SpringContextUtil.getBean("esConfig");
    }

    public static StoreTool getInstance() {
        return storeTool;
    }

    public void store(List<CrawledInfo> crawledInfos) {

        for (CrawledInfo CrawledInfo : crawledInfos) {

            try {
                String json = JSON.toJSONString(CrawledInfo);

                IndexResponse response =
                                client.prepareIndex("test", "crawledInfo").setSource(json).execute().actionGet();


            } catch (Exception e) {
                log.error("elasticsearch create new index error!", e);
            }

        }

    }

}

