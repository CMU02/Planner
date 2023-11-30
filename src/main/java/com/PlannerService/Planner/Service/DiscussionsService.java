package com.PlannerService.Planner.Service;

import com.PlannerService.Planner.DTO.DiscussionsDTO;
import com.PlannerService.Planner.Entity.Categories;
import com.PlannerService.Planner.Entity.DiscussionsEntity;
import com.PlannerService.Planner.Repository.CategoriesRepository;
import com.PlannerService.Planner.Repository.DiscussionsRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

import java.util.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DiscussionsService {
    private final DiscussionsRepository discussionsRepository;
    private final CategoriesRepository categoriesRepository;
    public void save(DiscussionsDTO discussionsDTO){
        DiscussionsEntity discussionsEntity = DiscussionsEntity.toEntity(discussionsDTO);

        Categories categoriesEntity = new Categories();
        categoriesEntity.setName(discussionsDTO.getCate_content());
        categoriesRepository.save(categoriesEntity);
        discussionsEntity.setCategories(categoriesEntity);

        discussionsRepository.save(discussionsEntity);
    }

    public List<DiscussionsEntity> getAllEntities(){
        return discussionsRepository.findAll();
    }
    public String getQuestions(){
        List<DiscussionsEntity> entities = getAllEntities();

        List<HashMap<String, String>> result = new ArrayList<>();
        for(int i=0; i< entities.size(); i++){
            HashMap<String, String> hash = new HashMap<String, String>();
            hash.put("dcs_title",entities.get(i).getTitle());
            hash.put("dcs_content",entities.get(i).getContent());
            hash.put("cate_content",entities.get(i).getCategories().getName());
            hash.put("dcs_id", entities.get(i).getId().toString());
            result.add(hash);

        }

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(result);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "Error converting to JSON";
        }
    }
    public String getQuestion(int id){
        List<DiscussionsEntity> entities = getAllEntities();

        HashMap<String, String> result = new HashMap<>();
        for(int i=0; i< entities.size(); i++){
            if(entities.get(i).getId() == id) {
                result.put("dcs_title", entities.get(i).getTitle());
                result.put("dcs_content", entities.get(i).getContent());
                result.put("cate_content", entities.get(i).getCategories().getName());
                result.put("dcs_id", entities.get(i).getId().toString());
                break;
            }

        }

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(result);
        } catch (JsonProcessingException e) {
            return "Error converting to JSON";
        }
    }


}