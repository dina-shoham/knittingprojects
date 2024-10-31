package dina.knittingprojects;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/projects")
public class ProjectController {
    
    @Autowired
    private ProjectService service;

    @GetMapping
    public ResponseEntity<List<Project>> getAllProjects() {
        return new ResponseEntity<List<Project>>(service.allProjects(), HttpStatus.OK);
    }

    // get project by name
    @GetMapping("/{name}")
    public ResponseEntity<Optional<Project>> getProjectByName(@PathVariable String name) {
        return new ResponseEntity<Optional<Project>>(service.findProjectByName(name), HttpStatus.OK);
    }

    // create new project
    @PostMapping("/{name}")
    public ResponseEntity<Project> createProject(@RequestBody Map<String, String> payload) {
        String name = payload.get("name");
        String description = payload.get("description");
        int creationDate = Integer.parseInt(payload.get("creationDate"));
        int completionDate = Integer.parseInt(payload.get("completionDate"));

        return new ResponseEntity<Project>(service.createProject(name, description, creationDate, completionDate), HttpStatus.CREATED);
    }

    // delete a project by its name
    @DeleteMapping("/{name}")
    public long deleteProject(@RequestBody Map<String, String> payload) {
        return service.deleteProjectByName(payload.get("name"));
        // returns 0 if it works, 1 if nothing found
    }

    /*
     *  @DeleteMapping("person/{id}")
    public Long deletePerson(@PathVariable String id) {
        return personService.delete(id);
    }
     */
    
}
