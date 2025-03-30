package com.kadel.portfolio.service;

import com.kadel.portfolio.model.Experience;
import com.kadel.portfolio.repository.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExperienceService {
    private final ExperienceRepository experienceRepository;

    @Autowired
    public ExperienceService(ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }
    //Method to get all experiences
    public List<Experience> getAllExperiences(){
        return experienceRepository.findAll();
    }
    //Method to find experience by id
    public Optional<Experience> getExperience(Long id){
        return experienceRepository.findById(id);
    }
    //Create an experiences
    public Experience createExperiences(Experience experience){
        return experienceRepository.save(experience);
    }
    public void deleteExperiences(long id){
        experienceRepository.deleteById(id);
    }

}
