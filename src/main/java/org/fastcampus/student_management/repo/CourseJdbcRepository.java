package org.fastcampus.student_management.repo;

import org.fastcampus.student_management.application.course.interfaces.CourseRepository;
import org.fastcampus.student_management.domain.Course;
import org.fastcampus.student_management.domain.DayOfWeek;

import java.util.List;

public class CourseJdbcRepository implements CourseRepository {
  @Override
  public List<Course> getCourseListByStudent(String studentName) {
    return List.of();
  }

  @Override
  public List<Course> getCourseDayOfWeek(DayOfWeek dayOfWeek) {
    return List.of();
  }

  @Override
  public void saveCourses(List<Course> courses) {

  }

  @Override
  public void save(Course course) {

  }
}
