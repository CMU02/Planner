package com.PlannerService.Planner.Service;

import com.PlannerService.Planner.DTO.DiscussionsDTO;
import com.PlannerService.Planner.Entity.DiscussionsEntity;
import com.PlannerService.Planner.Repository.DiscussionsRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DiscussionsService {
    private final DiscussionsRepository discussionsRepository;

    public void save(DiscussionsDTO discussionsDTO){
        DiscussionsEntity discussionsEntity = DiscussionsEntity.toEntity(discussionsDTO);
        discussionsRepository.save(discussionsEntity);
    }

    public List<DiscussionsEntity> getAllEntities(){
        return discussionsRepository.findAll();
    }
}