package org.fastcampus.student_management;

import org.fastcampus.student_management.application.course.CourseService;
import org.fastcampus.student_management.application.course.dto.CourseInfoDto;
import org.fastcampus.student_management.application.course.interfaces.CourseCommandRepository;
import org.fastcampus.student_management.application.student.StudentService;
import org.fastcampus.student_management.application.student.dto.StudentInfoDto;
import org.fastcampus.student_management.repo.*;
import org.fastcampus.student_management.ui.UserInputType;
import org.fastcampus.student_management.ui.course.CourseController;
import org.fastcampus.student_management.ui.course.CoursePresenter;
import org.fastcampus.student_management.ui.student.StudentController;
import org.fastcampus.student_management.ui.student.StudentPresenter;

public class Main {

  public static void main(String[] args) {
    StudentStorage studentStorage = new StudentStorage();
    CourseStorage courseStorage = new CourseStorage();

    StudentRepository studentRepository = new StudentRepository(studentStorage);
    CourseCommandRepository courseCommandRepository = new CourseInmemoryCommandRepository(courseStorage);
    CourseJdbcQueryRepository courseQueryRepository = new CourseJdbcQueryRepository(courseStorage);

    StudentService studentService = new StudentService(studentRepository);
    CourseService courseService = new CourseService(courseCommandRepository, courseQueryRepository, studentService);

    CoursePresenter coursePresenter = new CoursePresenter();
    StudentPresenter studentPresenter = new StudentPresenter();

    CourseController courseController = new CourseController(coursePresenter, courseService, studentPresenter);
    StudentController studentController = new StudentController(studentPresenter, studentService);

    // Added Default Setting
    StudentInfoDto studentInfoDto1 = new StudentInfoDto("홍길동", 25, "서울시 강북구");
    StudentInfoDto studentInfoDto2 = new StudentInfoDto("성춘향", 17, "서울시 강남구");
    StudentInfoDto studentInfoDto3 = new StudentInfoDto("이몽룡", 19, "서울시 서초구");
    studentService.saveStudent(studentInfoDto1);
    studentService.saveStudent(studentInfoDto2);
    studentService.saveStudent(studentInfoDto3);

    CourseInfoDto courseInfoDto1 = new CourseInfoDto("프로그래밍", 100000, "MONDAY", "홍길동", 10L);
    CourseInfoDto courseInfoDto2 = new CourseInfoDto("바이올린", 200000, "THURSDAY", "성춘향", 17L);
    CourseInfoDto courseInfoDto3 = new CourseInfoDto("트럼본", 300000, "MONDAY", "이몽룡", 14L);
    courseService.registerCourse(courseInfoDto1);
    courseService.registerCourse(courseInfoDto2);
    courseService.registerCourse(courseInfoDto3);

    studentPresenter.showMenu();
    UserInputType userInputType = studentController.getUserInput();
    while (userInputType != UserInputType.EXIT) {
      switch (userInputType) {
        case NEW_STUDENT:
          studentController.registerStudent();
          break;
        case NEW_COURSE:
          courseController.registerCourse();
          break;
        case SHOW_COURSE_DAY_OF_WEEK:
          courseController.showCourseDayOfWeek();
          break;
        case ACTIVATE_STUDENT:
          studentController.activateStudent();
          break;
        case DEACTIVATE_STUDENT:
          studentController.deactivateStudent();
          break;
        case CHANGE_FEE:
          courseController.changeFee();
          break;
        default:
          studentPresenter.showErrorMessage();
          break;
      }
      studentPresenter.showMenu();
      userInputType = studentController.getUserInput();
    }
  }
}