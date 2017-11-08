package com.asiainfo.biapp.infocrawlerdemo.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.asiainfo.biapp.infocrawlerdemo.control.ControlFactory;
import com.asiainfo.biapp.infocrawlerdemo.model.CrawlerInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;



/**
 * ClassName: CrawlerApi <br/>
 * Function: 爬取API. <br/>
 * Reason: 爬取API. <br/>
 * date: 2017年11月8日 下午3:52:25 <br/>
 *
 * @author jiangyl3
 * @version
 * @since JDK 1.6
 */
@Api(value = "爬取API", description = "爬取API")
@RequestMapping("api")
@RestController
@Slf4j
public class CrawlerApi {


    private ControlFactory controlFactory = ControlFactory.getInstance();

    @ApiOperation(value = "查询应用分类列表", notes = "查询应用分类列表")
    @PostMapping(value = "/new")
    @ResponseBody
    public CrawlerResponce getAppClassifies(@RequestBody CrawlerRequest request) {

        CrawlerResponce responce = new CrawlerResponce();

        try {
            CrawlerInfo crawlerInfo = new CrawlerInfo();
            crawlerInfo.setId(request.getId());
            crawlerInfo.setIp(request.getIp());
            crawlerInfo.setPort(request.getPort());
            crawlerInfo.setUserName(request.getUserName());
            crawlerInfo.setPassword(request.getPassword());
            crawlerInfo.setQuartzReg(request.getQuartzReg());
            crawlerInfo.setType(request.getType());

            controlFactory.sendTask(crawlerInfo);

        } catch (Exception e) {
            log.error("API error!", e);
        }

        return responce;
    }

    @ApiOperation(value = "测试", notes = "测试")
    @GetMapping(value = "/test")
    @ResponseBody
    public CrawlerResponce test() {

        CrawlerResponce responce = new CrawlerResponce();

        log.info("test!");

        return responce;
    }

}
