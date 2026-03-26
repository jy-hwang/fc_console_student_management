package org.fastcampus.student_management.repo;

import org.fastcampus.student_management.application.course.interfaces.CourseQueryRepository;
import org.fastcampus.student_management.domain.Course;
import org.fastcampus.student_management.domain.DayOfWeek;

import java.util.ArrayList;
import java.util.List;

public class CourseJdbcQueryRepository implements CourseQueryRepository {
  private final CourseStorage courseStorage;

  public CourseJdbcQueryRepository(CourseStorage courseStorage) {
    this.courseStorage = courseStorage;
  }

  public List<Course> getCourseDayOfWeek(DayOfWeek dayOfWeek) {
    List<Course> courses = new ArrayList<>();
    for (Course course : courseStorage.getCourses().values()) {
      if (course.isSameDay(dayOfWeek) && course.isActivateUser()) {
        courses.add(course);
      }
    }
    return courses;
  }

  public List<Course> getCourseListByStudent(String studentName) {
    List<Course> courses = new ArrayList<>();
    for (Course course : courseStorage.getCourses().values()) {
      if (course.getStudentName().equals(studentName)) {
        courses.add(course);
      }
    }
    return courses;
  }
}
