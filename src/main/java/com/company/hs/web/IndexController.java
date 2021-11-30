package com.company.hs.web;

import com.company.hs.config.auth.LoginUser;
import com.company.hs.config.auth.dto.SessionUser;
import com.company.hs.service.posts.PostsService;
import com.company.hs.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.h2.engine.Mode;
import org.h2.engine.Session;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpSession;


// mustache 기본 템플릿은 src/main/resources/templates 로 자동 지정

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;
    
    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user){

        model.addAttribute("posts",postsService.findAllDesc());

        if (user != null) {

            model.addAttribute("realName", user.getName());

        }


        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }


    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){

        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post",dto);
        return "posts-update";
    }

    @GetMapping("/posts/content/{id}")
    public String postsContent(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post",dto);
        model.addAttribute("view", postsService.updateHit(id));
        return "posts-content";
    }

    @GetMapping("/location/{id}")
    public String location(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("view", postsService.updateHit(id));
        return "location";
    }

    @GetMapping("/parking")
    public String parking(){
        return "parking";
    }

    @GetMapping("/write")
    public String write(){
        return "write";
    }
}
