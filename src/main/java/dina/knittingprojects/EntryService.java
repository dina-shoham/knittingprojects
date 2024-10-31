package dina.knittingprojects;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class EntryService {
    
    @Autowired
    private EntryRepository repository;

    // used to talk to db
    @Autowired
    private MongoTemplate template;

    public List<Entry> allEntries() {
        return repository.findAll(); // findAll() is a mongorepository built in function
    }


    public Entry createEntry(String body, int date, String projectName) {
        Entry entry = repository.insert(new Entry(body, date)); //insert returns the object you are inserting
        
        template.update(Project.class)
            .matching(Criteria.where("name").is(projectName))
            .apply(new Update().push("projectEntries").value(entry))
            .first();

        return entry;
    }
}
