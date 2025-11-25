package org.fastcampus.student_management.application.course;

import org.fastcampus.student_management.application.course.dto.CourseInfoDto;
import org.fastcampus.student_management.application.student.StudentService;
import org.fastcampus.student_management.domain.Course;
import org.fastcampus.student_management.domain.DayOfWeek;
import org.fastcampus.student_management.domain.Student;
import org.fastcampus.student_management.repo.CourseRepository;

import java.util.ArrayList;
import java.util.List;

public class CourseService {
  private final CourseRepository courseRepository;
  private final StudentService studentService;

  public CourseService(CourseRepository courseRepository, StudentService studentService) {
    this.courseRepository = courseRepository;
    this.studentService = studentService;
  }

  public void registerCourse(CourseInfoDto courseInfoDto) {
    Student student = studentService.getStudent(courseInfoDto.getStudentName());
    Course course = new Course(student, courseInfoDto.getCourseName(), courseInfoDto.getFee(), courseInfoDto.getDayOfWeek(), courseInfoDto.getCourseTime());
    courseRepository.save(course);
  }

  public List<CourseInfoDto> getCourseDayOfWeek(DayOfWeek dayOfWeek) {
    // TODO: 과제 구현 부분
    List<Course> courses = courseRepository.getCourseDayOfWeek(dayOfWeek);
    List<CourseInfoDto> result = new ArrayList<>();

    for (Course course : courses) {
      CourseInfoDto dto = new CourseInfoDto(course);  // Course → CourseInfoDto 변환
      result.add(dto);
    }

    return result;
    // return courses.stream().map(CourseInfoDto::new).toList();
  }

  public void changeFee(String studentName, int fee) {
    // TODO: 과제 구현 부분
    List<Course> courses = courseRepository.getCourseListByStudent(studentName);

    for (Course course : courses) {
      // 수강일이 주말(토요일 또는 일요일)인 경우 수강료는 1.5배
      if (course.isSameDay(DayOfWeek.SATURDAY) || course.isSameDay(DayOfWeek.SUNDAY)) {
        course.changeFee((int) (fee * 1.5));
      }

      course.changeFee(fee);
    }

  }
}
