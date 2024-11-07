package com.demodj.demo_examen.repository;

import com.demodj.demo_examen.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {
}
