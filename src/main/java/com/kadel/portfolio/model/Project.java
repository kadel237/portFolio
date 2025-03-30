package com.kadel.portfolio.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id ;

    @Column (nullable=false)
     private String name ;

    @Column (nullable=false)
     private String description;

    @Column (nullable=false)
     private String url;

    @Column (nullable=false)
     private String technologies;
}
