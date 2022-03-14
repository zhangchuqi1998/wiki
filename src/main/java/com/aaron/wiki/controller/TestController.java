package com.aaron.wiki.controller;

import com.aaron.wiki.domain.Test;
import com.aaron.wiki.service.TestService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class TestController {

    @Value("${test.hello:TEST}")
    private String testHello;

    @Resource
    private TestService testService;

    @PostMapping("/hello/post")
    public String helloPost(String name) {
        return "Hello!"+name;
    }


    @GetMapping("/test/list")
    public List<Test> list() {
        return testService.list();
    }
}
