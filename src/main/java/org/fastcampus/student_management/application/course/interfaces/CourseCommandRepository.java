package org.fastcampus.student_management.application.course.interfaces;

import org.fastcampus.student_management.domain.Course;

import java.util.List;

public interface CourseCommandRepository {
  void save(Course course);

  void saveCourses(List<Course> courses);
}
