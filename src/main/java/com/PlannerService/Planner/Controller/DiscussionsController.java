package com.PlannerService.Planner.Controller;

import com.PlannerService.Planner.DTO.CommentDTO;
import com.PlannerService.Planner.DTO.DiscussionsDTO;
import com.PlannerService.Planner.Entity.User;
import com.PlannerService.Planner.Repository.UserRepository;
import com.PlannerService.Planner.Service.DiscussionsService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;


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
    private CommentDTO questionInfo = null;
    @PostMapping("/questionClick")
    public String loadQuestion(@RequestBody CommentDTO dto){
        questionInfo = dto;
        return "LoadedQuestion";
    }
    @GetMapping("/LoadedQuestion")
    public String goToQuestion(Model model){
        if(questionInfo != null){
            model.addAttribute("data", questionInfo);
            System.out.println(questionInfo);
            questionInfo = null;
            return "LoadedQuestion";
        }else
            return "discussions";

    }
    @GetMapping("/AskQuestion")
    public String askQuestion(){
        return "AskQuestion";
    } //질문 올리는 페이지로 이동

    @PostMapping("AskQuestion/submit")
    public String postQuestion(@RequestBody DiscussionsDTO dto){
        discussionsService.save(dto);
        return "discussions";
    }



}