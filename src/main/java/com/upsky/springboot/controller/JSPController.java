package com.upsky.springboot.controller;

import com.upsky.springboot.vo.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jsp")
public class JSPController {

    @RequestMapping("/index")
    public String index(Model model){
        Person p = new Person();
        p.setName("Jacky");
        p.setAge(33);
        p.setNote("我的个人介绍！");

        model.addAttribute("msg","注意：This is JSPController.");
        model.addAttribute("person",p);
        return "index";
    }
}
