package dina.knittingprojects;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    @Autowired // instantiates this class for us
    private ProjectRepository repository;

    public List<Project> allProjects() {
        return repository.findAll(); // findAll() is a mongorepository built in function
    }

    public Optional<Project> findProjectByName(String name) {
        return repository.findProjectByName(name);
    }

    public Project createProject(String name, String description, int creationDate, int completionDate) {
        Project project = repository.insert(new Project(name, description, creationDate, completionDate)); //insert returns the object you are inserting
        return project;
    }

    public long deleteProjectByName(String name) {
        return repository.deleteProjectByName(name);           
    }
}
