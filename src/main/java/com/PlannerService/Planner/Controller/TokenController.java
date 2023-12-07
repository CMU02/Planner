package com.PlannerService.Planner.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.PlannerService.Planner.Entity.TokenEntity;
@Controller
public class TokenController {

    @GetMapping("/checklogin")
    public String checkSignin(){
        if(TokenEntity.token == null)
            return "login";
        else{
            TokenEntity.token = null;
            return "Calendar";
        }
    }
}