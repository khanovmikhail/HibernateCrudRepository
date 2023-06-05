package com.github.khanovmikhail.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(value = NON_NULL)
@Entity
@Table(name = "positions")
public class Position {

    @Id
    private Long id;
    @Column(name = "position_name")
    private String positionName;
//    @OneToMany
//    @JoinColumn(name = "position_id")
//    private List<Employee> employees;
}