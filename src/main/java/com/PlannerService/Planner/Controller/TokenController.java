package com.PlannerService.Planner.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.PlannerService.Planner.Entity.TokenEntity;
@Controller
public class TokenController {

    @GetMapping("/checklogin")
    public String checkSignin(Model model){
        if(TokenEntity.token == null)
            return "login";
        else{
            model.addAttribute("name", TokenEntity.name);
            TokenEntity.name = null;
            TokenEntity.token = null;
            return "Calendar";
        }
    }
}