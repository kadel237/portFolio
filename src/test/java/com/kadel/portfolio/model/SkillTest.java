package com.kadel.portfolio.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SkillTest {
    @Test
    public void skillNameTest() {
        Skill skill = new Skill();
        skill.setName("Web Full Stack");
        assertEquals("Web Full Stack", skill.getName());
    }
}
