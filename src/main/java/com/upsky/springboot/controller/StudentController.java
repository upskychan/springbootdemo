package com.upsky.springboot.controller;

import com.upsky.springboot.model.Student;
import com.upsky.springboot.service.IStudentService;
import com.upsky.springboot.vo.Person;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private IStudentService studentService;

    /**
     * 直接接收参数。
     * @param includeDel 是否包括已删除学生
     * @return 学生信息列表
     */
    @RequestMapping("/list")
    public @ResponseBody
    List<Student> allStudents(@Param(value="includeDel")Boolean includeDel) {
        return studentService.selectAllStudents(includeDel);
    }

    /**
     * 测试高并发下缓存穿透问题。
     * @param includeDel 是否包括已删除学生
     * @return 学生信息列表
     */
    @RequestMapping("/check/list")
    public @ResponseBody
    List<Student> checkGetAllStudents(@Param(value="includeDel")Boolean includeDel) {
        ExecutorService executorService = Executors.newFixedThreadPool(25);
        for (int i=0;i<10000;i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    studentService.selectAllStudents(includeDel);
                }
            });
        }

        return studentService.selectAllStudents(includeDel);
    }

    /**
     * 通过HttpServletRequest获取参数。
     * @param request HttpServletRequest
     * @return 学生信息列表
     */
    @RequestMapping("/list2")
    public @ResponseBody
    List<Student> allStudents2(HttpServletRequest request) {
        String includeDelStr = request.getParameter("includeDel");
        Boolean includeDel = Boolean.valueOf(includeDelStr);
        return studentService.selectAllStudents(includeDel);
    }

    /**
     * 通过@PathVariable获取路径中的参数。
     * @param includeDel 是否包括已删除学生
     * @return 学生信息列表
     */
    @RequestMapping("/list3/{includeDel}")
    public @ResponseBody
    List<Student> allStudents3(@PathVariable Boolean includeDel) {
        return studentService.selectAllStudents(includeDel);
    }

    /**
     * 更新学生信息。
     * @return 更新结果
     */
    @GetMapping("/update")
    public @ResponseBody Object update(){
        return studentService.updateStudentById();
    }

    /**
     * 更新学生信息。
     * @return 更新结果
     */
    @GetMapping("/update2")
    public @ResponseBody Object update2() {
        try {
            return studentService.updateStudentById2();
        } catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 查询学生信息。
     * @param userId  学生ID
     * @return 学生信息
     */
    @RequestMapping("/user/{userId}")
    public @ResponseBody
    Student studentInfo(@PathVariable("userId") Long userId) {
        return studentService.getStudentById(userId);
    }

    /**
     * 实现RESTfull风格。
     * @param userName 用户名
     * @param age 年龄
     * @return 用户信息
     */
    @RequestMapping("/user/{userName}/{age}")
    public @ResponseBody
    Person studentInfo2(@PathVariable("userName") String userName, @PathVariable("age") Integer age) {
        Person person = new Person();
        person.setName(userName);
        person.setAge(age);
        return person;
    }
}
