package dina.knittingprojects;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "projects")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    @Id
    private ObjectId id;

    private String name;
    private String description;
    private int creationDate;
    private int completionDate;
    
    @DocumentReference // like a foreign key constraint, asks db to store just update ids, and updates are in a separate collection
    private List<Entry> projectEntries;
}
