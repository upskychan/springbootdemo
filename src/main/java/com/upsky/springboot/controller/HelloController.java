package com.upsky.springboot.controller;

import com.upsky.springboot.vo.Person;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.nio.charset.Charset;
import java.util.Date;

@Controller
@RequestMapping("/hello")
public class HelloController {
    @RequestMapping("/hello")
    public @ResponseBody
    String hello() {
        return "Hello Spring Boot!";
    }

    @RequestMapping("/who")
    public @ResponseBody
    Person who() {// 添加@ResponseBody后返回字符串或者json数据
        Person p = new Person();
        p.setName("Jacky");
        p.setAge(33);
        p.setNote("我的个人介绍！");
        return p;
    }

    @RequestMapping("/who2") // 没有@ResponseBody为页面跳转
    public ResponseEntity<Person> who2() {
        HttpHeaders headers = new HttpHeaders();
        MediaType mediaType = new MediaType("text", "html", Charset.forName("UTF-8"));
//        MediaType mediaType = new MediaType("text", "json", Charset.forName("UTF-8"));
        headers.setContentType(mediaType);

        Person p = new Person();
        p.setName("Jacky");
        p.setAge(33);
        p.setNote("我的个人介绍！");

        return new ResponseEntity<Person>(p, headers, HttpStatus.OK);
    }

    @RequestMapping("/who3")
    public  String who3(){
        System.out.println(this.getClass() + ":call who3() method at " + new Date());
        return "index";
    }

}
