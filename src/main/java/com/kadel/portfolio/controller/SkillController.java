package com.kadel.portfolio.controller;

import com.kadel.portfolio.exception.SkillNotFoundException;
import com.kadel.portfolio.model.Skill;
import com.kadel.portfolio.service.SkillService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skill")
public class SkillController {
     SkillService skillService ;
     public SkillController(SkillService skillService){
         this.skillService=skillService ;
     }

     @GetMapping
     public List<Skill> getSkills(){
         return skillService.getAllSkills();
     }
     @GetMapping("/{id}")
     public ResponseEntity<Skill> getOneSkill(@PathVariable Long id){
        Skill skill = skillService.getSkill(id).orElseThrow(()->new SkillNotFoundException("skill with id:"+id+ "not found"));
        return ResponseEntity.ok(skill);
     }
     @PostMapping
     public ResponseEntity<Skill> createSkill (@RequestBody Skill skill){
         return new ResponseEntity(skillService.createSkills(skill), HttpStatus.CREATED);
     }
     @DeleteMapping("/{id}")
     public ResponseEntity<Skill> deleteSkill(@PathVariable Long id){
         skillService.deleteSkill(id);
         return ResponseEntity.noContent().build();
     }
     @PutMapping("/{id}")
    public ResponseEntity<Skill> updateSkill(@PathVariable Long id , @RequestBody Skill skill){
         Skill sk= skillService.getSkill(id).orElseThrow(()->new RuntimeException("Skill not found"));
         sk.setName(skill.getName());
         sk.setDescription(skill.getDescription());
         sk.setLevel(skill.getLevel());
         Skill skillCreated = skillService.createSkills(sk);
         return ResponseEntity.ok(skillCreated);

     }

}
