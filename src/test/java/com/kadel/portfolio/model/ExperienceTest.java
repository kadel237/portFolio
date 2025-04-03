package com.kadel.portfolio.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ExperienceTest {
    Experience experience = new Experience();
    @Test
    public void testExperienceTitle(){

        experience.setTitle("Développeur Full Stack");
        assertEquals("Développeur Full Stack", experience.getTitle());
    }
    @Test
    public void testExperienceCompany(){
        //Experience experience = new Experience();
        experience.setCompany("Orange");
        assertEquals("Orange", experience.getCompany());
    }
    @Test
    public void testExpereinceDescription() {
        //Experience experience = new Experience();
        experience.setDescription("i was the only developper at this post");
        assertEquals("i was the only developper at this post",experience.getDescription());
    }
    @Test
    public void testExperienceStartDate(){
        assertNotNull(experience.getStartDate());
        experience.setStartDate(LocalDate.of(2001,3,12));
        assertEquals(LocalDate.of(2001,3,12),experience.getStartDate());
    }
}
