package org.fastcampus.student_management.repo;

import org.fastcampus.student_management.domain.Student;

import java.util.HashMap;
import java.util.Map;

public class StudentStorage {
  private final Map<String, Student> students = new HashMap<>();

  public Map<String, Student> getStudents() {
    return students;
  }
}
