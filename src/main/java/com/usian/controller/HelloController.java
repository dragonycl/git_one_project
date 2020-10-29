package com.usian.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/hello")
public class HelloController {
    private Logger logger= LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("test")
    public String h1(){
        //注意每天早上要更新同事们的代码
        //bug修改完成1.0版本完毕
        System.out.println("你好啊 学哥");
        logger.info("==============hello==================");
        return "index";
    }
}
