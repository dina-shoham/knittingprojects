package dina.knittingprojects;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "entries")
@Data
@AllArgsConstructor @NoArgsConstructor
public class Entry {
    @Id
    private ObjectId id;
    
    private String body;
    private int date;

    // custom constructor w/ body and date
    public Entry(String body, int date) {
        this.body = body;
        this.date = date;
    }
}
