package dina.knittingprojects;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    @Autowired // instantiates this class for us
    private ProjectRepository projectRepository;

    public List<Project> allProjects() {
        return projectRepository.findAll(); // findAll() is a mongorepository built in function
    }

    public Optional<Project> findProjectByName(String name) {
        return projectRepository.findProjectByName(name);
    }
}
