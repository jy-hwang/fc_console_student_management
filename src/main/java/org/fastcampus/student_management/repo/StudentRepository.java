package org.fastcampus.student_management.repo;

import org.fastcampus.student_management.domain.Student;

import java.util.Optional;

public class StudentRepository {

  //private final Map<String, Student> studentMap = new HashMap<>();
  private final StudentStorage storage;

  public StudentRepository(StudentStorage storage) {
    this.storage = storage;
  }

  public void save(Student student) {
    storage.getStudents().put(student.getName(), student);
  }

  public Optional<Student> findByName(String name) {
    return Optional.ofNullable(storage.getStudents().get(name));
  }
}
