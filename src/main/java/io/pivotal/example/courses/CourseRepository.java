package io.pivotal.example.courses;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long>{

    List<Course> findByLocation(String location);
}
