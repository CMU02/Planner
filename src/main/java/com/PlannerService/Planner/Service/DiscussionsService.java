package com.PlannerService.Planner.Service;

import com.PlannerService.Planner.DTO.DiscussionsDTO;
import com.PlannerService.Planner.Entity.Categories;
import com.PlannerService.Planner.Entity.DiscussionsEntity;
import com.PlannerService.Planner.Repository.CategoriesRepository;
import com.PlannerService.Planner.Repository.DiscussionsRepository;
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
            result.add(hash);
        }

        return result.toString();
    }
}