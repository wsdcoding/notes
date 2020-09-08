package com.wsdcoding.springbootdemo.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Authror wsdcoding
 */
@RestController
public class TestController {
    @RequestMapping("/test")
    public String test() {
        return "SpringBootDemo is running";
    }
}
