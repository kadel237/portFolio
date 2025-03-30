package com.kadel.portfolio.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProjectTest {
    @Test
    public void ProjetcNameTest() {
        Project project = new Project();
        project.setName("Réemploi");
        assertEquals("Réemploi", project.getName());
    }
}
