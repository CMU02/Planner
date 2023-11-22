package com.PlannerService.Planner.DTO;

import com.PlannerService.Planner.Entity.Categories;
import com.PlannerService.Planner.Entity.User;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DiscussionsDTO {
    private Long dsc_id;
    private User user_id;
    private Categories cate_id;
    private String dcs_title;
    private String dcs_content;
}
