package me.vovcyan.repository;

import me.vovcyan.model.Faculty;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacultyRepository extends CrudRepository<Faculty, String> {
    List<Faculty> findById(String id);
    List<Faculty> findByName(String name);
    List<Faculty> findByUniversity(String university);
}
