package com.PlannerService.Planner.Entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
public class DiscussionsEntity {

    @Id
    @Column(name="dcs_id")
    private Long dsc_id;

    @Column(name="user_id")
    private String user_id;

    @Column(name="cate_id")
    private String cate_id;

    @Column(name="dcs_title", nullable = false)
    private String dcs_title;

    @Column(name="dcs_content", nullable = false)
    private String dcs_content;
}
