package org.example.service;

import org.example.dto.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private final List<Course> courseCollection = new ArrayList<>();

    public void addCourse(Course course){
        courseCollection.add(course);
    }

    public List<Course> getCourseCollection() {
        return courseCollection;
    }

    public Optional<Course> getById(int id){
        return courseCollection
                .stream()
                .filter(c-> c.getId() == id)
                .findFirst();
    }

    public boolean updateCourse(int id, Course course){
        return  getById(id)
                .map(existingCourse -> {
                    courseCollection.remove(existingCourse);
                    courseCollection.add(course);
                    return true;
                }).orElse(false);
    }

    public boolean deleteCourse(int id){
        return courseCollection.removeIf(c -> c.getId() == id);
    }
}
