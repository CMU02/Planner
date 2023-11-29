package com.PlannerService.Planner.Controller;

import com.PlannerService.Planner.DTO.DiscussionsDTO;
import com.PlannerService.Planner.Service.DiscussionsService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;

@Controller
@RequiredArgsConstructor
public class DiscussionsController {

    private final DiscussionsService discussionsService;

    @GetMapping("/discussions")
    public String discussions(Model model){
        String result = discussionsService.getQuestions();
        model.addAttribute("data", result);
        return "discussions";
    }
    @GetMapping("/askQuestion")
    public String askQuestion(){
        return "askQuestion";
    } //질문 올리는 페이지로 이동

    @PostMapping("askQuestion/submit")
    public String postQuestion(@RequestBody DiscussionsDTO dto){
        discussionsService.save(dto);
        return "discussions";
    }



}