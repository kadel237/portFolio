package com.kadel.portfolio.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExperienceTest {
    @Test
    public void testExperienceTitle(){
        Experience experience = new Experience();
        experience.setTitle("Développeur Full Stack");
        assertEquals("Développeur Full Stack", experience.getTitle());
    }
    @Test
    public void testExperienceCompany(){
        Experience experience = new Experience();
        experience.setCompany("Orange");
        assertEquals("Orange", experience.getCompany());
    }
}
