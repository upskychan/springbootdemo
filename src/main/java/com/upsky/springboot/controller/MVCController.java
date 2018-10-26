package com.upsky.springboot.controller;

import com.upsky.springboot.vo.Person;
import org.springframework.web.bind.annotation.*;

@RestController  // @RestController == @Controller + @ResponseBody
@RequestMapping("/mvc")
public class MVCController {

    @RequestMapping("/userInfo")
    public Object userInfo(){
        Person person = new Person();
        person.setName("陈杰");
        person.setAge(33);
        person.setNote("陈杰的个人简介，兴趣爱好，专业技能等等。");

        return person;
    }

    /**
     * 只支持Get请求.
     * @return Person
     */
    @GetMapping("/getUserInfo") // 等同于@RequestMapping(value = "/getUserInfo",method = RequestMethod.GET)
    public Object getUserInfo(){
        Person person = new Person();
        person.setName("陈杰");
        person.setAge(33);
        person.setNote("陈杰的个人简介，兴趣爱好，专业技能等等。");

        return person;
    }

    /**
     * 只支持Post请求.
     * @return Person
     */
    @PostMapping("/postUserInfo")
    public Object postUserInfo(){
        Person person = new Person();
        person.setName("陈杰");
        person.setAge(33);
        person.setNote("陈杰的个人简介，兴趣爱好，专业技能等等。");

        return person;
    }
}
