package com.kadel.portfolio.model;

import jakarta.persistence.*;
import lombok.*;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "experiences")
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String company;

    private String description;


    @Column(nullable = false)
    private String startDate;

    private String endDate;

    @Enumerated(EnumType.STRING)
    private JobType jobType;

    public enum JobType {
        FULL_TIME, PART_TIME, INTERNSHIP
    }
}