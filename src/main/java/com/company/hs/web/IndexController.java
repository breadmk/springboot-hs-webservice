package com.company.hs.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


// mustache 기본 템플릿은 src/main/resources/templates 로 자동 지정

@Controller
public class IndexController {
    
    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }
}
