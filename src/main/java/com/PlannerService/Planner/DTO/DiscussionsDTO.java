package com.PlannerService.Planner.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class DiscussionsDTO {
    private Long dsc_id;
    private String user_id;
    private String cate_id;
    private String dcs_title;
    private String dcs_content;
}
