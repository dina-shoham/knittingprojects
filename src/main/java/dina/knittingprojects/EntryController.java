package dina.knittingprojects;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/entries")
public class EntryController {
    @Autowired
    private EntryService service;

    @PostMapping
    public ResponseEntity<Entry> createEntry(@RequestBody Map<String, String> payload) {
        return new ResponseEntity<Entry>(service.createEntry(payload.get("body"), Integer.parseInt(payload.get("date")), payload.get("name")), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Entry>> getAllEntries() {
        return new ResponseEntity<List<Entry>>(service.allEntries(), HttpStatus.OK);
    }
    
}
