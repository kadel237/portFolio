package com.kadel.portfolio.controller;

import com.kadel.portfolio.model.Experience;
import com.kadel.portfolio.service.ExperienceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/experiences")
public class ExperienceController {
    private final ExperienceService experienceService;

    public ExperienceController(ExperienceService experienceService){
        this.experienceService=experienceService;
    }

    @GetMapping
    public List<Experience> getAllExperiences(){
        return experienceService.getAllExperiences();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Experience> getExperienceById(@PathVariable Long id){
        Optional<Experience> experience= experienceService.getExperience(id);
        return experience.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<Experience> createExperience(@RequestBody Experience experience){
        Experience creatExperience = experienceService.createExperiences(experience);
        return new ResponseEntity<>(creatExperience, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Experience> deleteExperience(@PathVariable Long id){
        experienceService.deleteExperiences(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Experience> updateExperience(@PathVariable Long id, @RequestBody Experience experience){
          Experience experienceUpdate = experienceService.getExperience(id).orElseThrow( ()->new RuntimeException("Not Experience found"));
          experienceUpdate.setCompany(experience.getCompany());
          experienceUpdate.setTitle(experienceUpdate.getTitle());
          experienceUpdate.setEndDate(experience.getEndDate());
          experienceUpdate.setStartDate(experience.getStartDate());
          experienceUpdate.setDescription(experienceUpdate.getDescription());
          experienceUpdate.setJobType(experience.getJobType());

          Experience xp = experienceService.createExperiences(experienceUpdate);
          return ResponseEntity.ok(xp);

    }

}
