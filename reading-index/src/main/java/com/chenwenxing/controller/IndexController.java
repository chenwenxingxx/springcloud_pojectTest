package com.chenwenxing.controller;


import com.alibaba.fastjson.JSONObject;
import com.chenwenxing.fegin.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Autowired
    FeignService feignService;

    @RequestMapping("/index1/bookList")
    public String bookList(){
        String bookList = feignService.getBookList();
        return JSONObject.toJSONString(bookList);
    }

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
}
