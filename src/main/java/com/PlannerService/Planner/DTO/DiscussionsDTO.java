package com.PlannerService.Planner.DTO;

import com.PlannerService.Planner.Entity.Categories;
import com.PlannerService.Planner.Entity.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DiscussionsDTO {
    private Long dcs_id;
    private User user_id;
    private Categories cate_id;
    private String dcs_title;
    private String dcs_content;
    private String cate_content;
}