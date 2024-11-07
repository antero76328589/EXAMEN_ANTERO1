package com.demodj.demo_examen.service.impl;



import com.demodj.demo_examen.entity.Course;
import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();
    void addCourse(Course course);
    Course getCourseById(Long id);
    void deleteCourse(Long id);
    void updateCourse(Course course);
}

