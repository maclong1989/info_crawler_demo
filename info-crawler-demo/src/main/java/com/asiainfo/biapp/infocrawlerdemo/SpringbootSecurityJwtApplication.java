package com.asiainfo.biapp.infocrawlerdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Sample application for demonstrating security with JWT Tokens
 * 
 * @author vladimir.stankovic
 *
 *         Aug 3, 2016
 */
// @SpringBootApplication(exclude = {DataSourceAutoConfiguration.class,
// DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class,
// JpaRepositoriesAutoConfiguration.class, JdbcTemplateAutoConfiguration.class})
@SpringBootApplication
@ServletComponentScan("com.asiainfo")
@EnableConfigurationProperties
@EnableTransactionManagement
@MapperScan("com.asiainfo.biapp.infocrawlerdemo.dao.mapper")
@EnableScheduling
public class SpringbootSecurityJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSecurityJwtApplication.class, args);
    }
}
