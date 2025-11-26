package org.fastcampus.student_management.domain;

import java.util.List;

public class CourseList {

  private final List<Course> courses;

  public CourseList(List<Course> courses) {
    this.courses = courses;
  }

  public void changeAllCoursesFee(int fee) {
    for (Course course : courses) {
      // 수강일이 주말(토요일 또는 일요일)인 경우 수강료는 1.5배
      if (course.isSameDay(DayOfWeek.SATURDAY) || course.isSameDay(DayOfWeek.SUNDAY)) {
        course.changeFee((int) (fee * 1.5));
      }
      course.changeFee(fee);
    }
  }

}
