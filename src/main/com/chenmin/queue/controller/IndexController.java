package com.chenmin.queue.controller;

import com.alibaba.fastjson.JSONObject;
import com.chenmin.queue.constans.LinkindQueue;
import com.chenmin.queue.service.IndexService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/index")
public class IndexController {
    @Autowired
    private IndexService indexService;

    @RequestMapping(value = "/testAddQueue",method = RequestMethod.POST)
    @ApiOperation("测试队列插入数据")
    @ResponseBody
    public String testAddQueue(String name,String age,Integer status){
        return indexService.addqueue(name,age,status);
    }

    @ResponseBody
    @RequestMapping(value = "/queryErrorQueue",method = RequestMethod.POST)
    @ApiOperation("查询失败信息")
    public String queryErrorQueue(){
        return JSONObject.toJSONString(LinkindQueue.ERROR_QUEUE);
    }

    @ResponseBody
    @RequestMapping(value = "/querySuccessQueue",method = RequestMethod.POST)
    @ApiOperation("查询成功信息")
    public String querySuccessQueue(){
        return JSONObject.toJSONString(LinkindQueue.TESTQUEUE);
    }
}
