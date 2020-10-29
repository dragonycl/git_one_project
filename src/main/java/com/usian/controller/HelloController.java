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
        System.out.println("你好啊 学哥");
        logger.info("==============hello==================");
        return "index";
    }
}
