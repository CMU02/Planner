package com.PlannerService.Planner.Entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor// 변경됨 -> Discussions 엔티티 생성시 Categoreis 엔티티 새로 생성
public class Categories
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categories_id")
    private Long id;

    @Column(name = "categories_name")
    private String name;
}
