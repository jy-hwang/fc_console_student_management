package org.fastcampus.student_management.repo;

import org.fastcampus.student_management.domain.Course;

import java.util.HashMap;
import java.util.Map;

public class CourseStorage {
  private final Map<String, Course> courses = new HashMap<>();

  public Map<String, Course> getCourses() {
    return courses;
  }
}
