package com.kadel.portfolio.service;

import com.kadel.portfolio.model.Skill;
import com.kadel.portfolio.repository.SkillRepository;

import java.util.List;
import java.util.Optional;

public class SkillService {
    private final SkillRepository skillRepository;
    public SkillService (SkillRepository skillRepository){
        this.skillRepository = skillRepository;
    }
    public List<Skill> getAllSkills(){
        return skillRepository.findAll();
    }
    public Optional<Skill> getSkill(Long id){
        return skillRepository.findById(id);
    }
    public Skill createSkills(Skill skill){
        return skillRepository.save(skill);
    }
    public void deleteSkill(Long id){
         skillRepository.deleteById(id);
    }

}
