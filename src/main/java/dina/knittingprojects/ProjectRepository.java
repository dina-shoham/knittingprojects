package dina.knittingprojects;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends MongoRepository<Project, ObjectId> {
    Optional<Project> findProjectById(ObjectId id);
    Optional<Project> findProjectByName(String name); // spring data mongodb does the rest
}
