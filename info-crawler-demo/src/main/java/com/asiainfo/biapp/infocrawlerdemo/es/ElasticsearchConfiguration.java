/**
 * Project Name:info-crawler-demo File Name:ElasticsearchConfiguration.java Package
 * Name:com.asiainfo.biapp.infocrawlerdemo.es Date:2017年11月9日下午1:45:15 Copyright (c) 2017, chenzhou1025@126.com All
 * Rights Reserved.
 *
 */

package com.asiainfo.biapp.infocrawlerdemo.es;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName:ElasticsearchConfiguration <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2017年11月9日 下午1:45:15 <br/>
 * 
 * @author Maclong-work
 * @version
 * @since JDK 1.6
 * @see
 */
@Configuration("esConfig")
public class ElasticsearchConfiguration implements FactoryBean<TransportClient>, InitializingBean, DisposableBean {
    private static final Logger logger = LoggerFactory.getLogger(ElasticsearchConfiguration.class);
    // 由于项目从2.2.4配置的升级到 5.4.1版本 原配置文件不想动还是指定原来配置参数
    @Value("${spring.data.elasticsearch.cluster-nodes}")
    private String clusterNodes;

    @Value("${spring.data.elasticsearch.cluster-name}")
    private String clusterName;

    private TransportClient client;

    @Override
    public void destroy() throws Exception {
        try {
            logger.info("Closing elasticSearch client");
            if (client != null) {
                client.close();
            }
        } catch (final Exception e) {
            logger.error("Error closing ElasticSearch client: ", e);
        }
    }

    @Override
    public TransportClient getObject() throws Exception {
        return client;
    }

    @Override
    public Class<TransportClient> getObjectType() {
        return TransportClient.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        buildClient();
    }

    protected void buildClient() {
        try {
            PreBuiltTransportClient preBuiltTransportClient = new PreBuiltTransportClient(settings());
            if (!"".equals(clusterNodes)) {
                for (String nodes : clusterNodes.split(",")) {
                    String InetSocket[] = nodes.split(":");
                    String Address = InetSocket[0];
                    Integer port = Integer.valueOf(InetSocket[1]);
                    preBuiltTransportClient.addTransportAddress(
                                    new InetSocketTransportAddress(InetAddress.getByName(Address), port));
                }
                client = preBuiltTransportClient;
            }
        } catch (UnknownHostException e) {
            logger.error(e.getMessage());
        }
    }

    /**
     * 初始化默认的client
     */
    private Settings settings() {
        Settings settings =
                        Settings.builder().put("cluster.name", clusterName).put("client.transport.sniff", true).build();
        client = new PreBuiltTransportClient(settings);
        return settings;
    }
}
