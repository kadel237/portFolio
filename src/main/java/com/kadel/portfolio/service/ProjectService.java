package com.kadel.portfolio.service;

import com.kadel.portfolio.model.Project;
import com.kadel.portfolio.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    public final ProjectRepository projectRepository;
    //Injection of the repository project via the constructor
    @Autowired
    public ProjectService(ProjectRepository projectRepository){
        this.projectRepository=projectRepository;
    }
    // to get all projects
    public List<Project> getAllProjects(){
        return projectRepository.findAll();
    }
    //get project by id
    public Optional<Project> getProjectById(Long id){
        return projectRepository.findById(id);
    }
    // create a new project
    public Project createProject(Project project){
        return projectRepository.save(project);
    }
    //delete project
    public void deleteProjects(Project project){
        projectRepository.delete(project);
    }
    //delete project by id
    public void deleteProjectById(Long id){
        projectRepository.deleteById(id);
    }


}
