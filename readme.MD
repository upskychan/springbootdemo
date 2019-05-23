Spring Boot开发的学习工程，包括使用Spring Boot框架开发Java项目经常用到的一些功能。

集成redis和mybatis，数据库使用Mysql。

数据库脚本见springbootdb.sql。

启动：java -jar springbootdemo-0.0.1-SNAPSHOT.jar
或    java -jar springbootdemo-0.0.1-SNAPSHOT.war

访问测试：http://localhost:8080/STDemo/
（打jar包运行无法访问jsp页面，IDEA中启动可以访问。打war包也可以访问。）

服务监控Actuator：
http://localhost:8088/STMgr/actuator/health
http://localhost:8088/STMgr/actuator/info