package com.wsdcoding.springbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * SpringBoot 三板斧：加依赖  写注解 加配置
 */
@MapperScan("com.wsdcoding") //扫描Mybatis哪些包里面的接口
@SpringBootApplication
public class SpringbootDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemoApplication.class, args);
    }

}
