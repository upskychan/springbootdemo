package com.upsky.springboot;

import com.upsky.springboot.model.Student;
import com.upsky.springboot.service.IStudentService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableScheduling  //定时任务
//@MapperScan("com.upsky.springboot.mapper") // 添加mybatis注解包扫描
@EnableTransactionManagement // 开启事务支持
@ServletComponentScan(basePackages = {"com.upsky.springboot.servlet","com.upsky.springboot.filter"})
public class SpringbootdemoApplication {

    public static void main(String[] args) {
        //SpringApplication.run(SpringbootdemoApplication.class, args);

        //关掉spring boot启动时的logo
        SpringApplication springApplication = new SpringApplication(SpringbootdemoApplication.class);
        springApplication.setBannerMode(Banner.Mode.OFF);//关掉启动时spring boot的logo日志
        ConfigurableApplicationContext context = springApplication.run(args);

        //获取spring容器中的Bean，有两种方法。
        //方法一：
//        IStudentService studentService = (IStudentService)context.getBean("studentServiceImpl");
//        Student student = studentService.getStudentById(1l);
//        System.out.println("*************Student**************");
//        System.out.println(student.getName());
//        System.out.println("*************Student**************");

        //方法二：Spring boot入口类实现CommandLineRunner接口，使用@Autowired把Bean注入，覆盖CommandLineRunner接口的run()方法，然后在run()方法中调用和编写业务逻辑。

    }
}
