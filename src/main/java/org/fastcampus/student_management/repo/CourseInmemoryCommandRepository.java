package org.fastcampus.student_management.repo;

import org.fastcampus.student_management.application.course.interfaces.CourseCommandRepository;
import org.fastcampus.student_management.domain.Course;

import java.util.List;

public class CourseInmemoryCommandRepository implements CourseCommandRepository {
  private final CourseStorage courseStorage;

  public CourseInmemoryCommandRepository(CourseStorage courseStorage) {
    this.courseStorage = courseStorage;
  }

  public void save(Course course) {
    courseStorage.getCourses().put(course.getCourseName(), course);
  }

  public void saveCourses(List<Course> courses) {
    for (Course course : courses) {
      courseStorage.getCourses().put(course.getCourseName(), course);
    }
  }
}
