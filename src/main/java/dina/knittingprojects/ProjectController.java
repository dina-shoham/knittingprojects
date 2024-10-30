package dina.knittingprojects;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
