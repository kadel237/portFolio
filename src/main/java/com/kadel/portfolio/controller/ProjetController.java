package com.kadel.portfolio.controller;

import com.kadel.portfolio.model.Project;
import com.kadel.portfolio.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/project")
public class ProjetController {
   private final ProjectService projectService ;

    public ProjetController (ProjectService projectService){
        this.projectService = projectService;
    }
    @GetMapping
    public   List<Project>  getAllProject(){
       List<Project>  listOfProject =  projectService.getAllProjects();
        return listOfProject;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Project> getproject(@PathVariable Long id){
       Optional<Project> project = projectService.getProjectById(id) ;
       return project.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody Project project){
        Project projectCreate = projectService.createProject(project);
        return new ResponseEntity(projectCreate,HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Project> deleteProject(@PathVariable Long id){
        projectService.deleteProjectById(id);
        return  ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable Long id, @RequestBody Project project){
        Project createProject =projectService.getProjectById(id).orElseThrow(() -> new RuntimeException("project not found") );
        createProject.setName(project.getName());
        createProject.setDescription(project.getDescription());
        createProject.setTechnologies(project.getTechnologies());
        createProject.setUrl(createProject.getUrl());

        Project projectUpdate = projectService.createProject(createProject);
        return  ResponseEntity.ok(projectUpdate);

    }
}
