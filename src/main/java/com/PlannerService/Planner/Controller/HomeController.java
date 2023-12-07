package com.PlannerService.Planner.Controller;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/") // JDevList 메인 홈페이지
    public String mainPage() {
        return "index";
    }
    @GetMapping("/signUp") // 회원가입 페이지
    public String signUp() {
        return "createdAccount";
    }
    @GetMapping("/signIn") // 로그인 페이지
    public String signIn() {
        return "login";
    }
    @GetMapping("/help")
    public String help(){
        return "Help";
    }
    @GetMapping("/roadmap")
    public String roadmap(){
        return "Roadmap";
    }
}
