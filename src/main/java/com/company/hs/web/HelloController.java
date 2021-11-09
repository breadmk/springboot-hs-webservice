package com.company.hs.web;

import com.company.hs.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name,@RequestParam("amount") int amount){
        return new HelloResponseDto(name,amount);
    }
}
