package com.github.khanovmikhail.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(value = NON_NULL)
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;
    //@OneToMany
    //@JoinTable(name = "employees_2_projects")
    //@JoinColumn(name = "position_id")
    //private List<Project> projects;
}