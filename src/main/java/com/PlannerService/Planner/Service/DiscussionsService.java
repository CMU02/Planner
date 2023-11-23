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
    public List<DiscussionsDTO> getQuestions(){
        List<DiscussionsEntity> entities = getAllEntities();
        List<DiscussionsDTO> result = new ArrayList<DiscussionsDTO>();
        for(int i=0; i< entities.size(); i++){
            DiscussionsDTO dto = new DiscussionsDTO();
            dto.setDcs_title(entities.get(i).getTitle());
            dto.setDcs_content(entities.get(i).getContent());
            dto.setCate_content(entities.get(i).getCategories().getName());
            dto.setCate_id(entities.get(i).getCategories());
            dto.setUser_id(entities.get(i).getUser());
            result.add(dto);
        }

        return result;
    }
}