package com.upsky.springboot.controller;

import com.upsky.springboot.config.MyConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
@RequestMapping("/config")
public class ConfigInfoController {

    @Value("${upsky.name}")
    private String authorName;
    @Value("${upsky.location}")
    private String authorLocation;

    @Autowired
    private MyConfig myConfig;

    @RequestMapping("/authorInfo")
    public @ResponseBody
    String authorInfo() {
        System.out.println(this.getClass() + "--" + new Date().toLocaleString());
        return authorName + "---" + authorLocation + "==" + myConfig.getName() + "---" + myConfig.getLocation();
    }
}
