package com.unix.enrolment.dao;

import com.unix.enrolment.model.Course;
import java.util.List;

public interface CourseDAO {
    List<Course> findCoursesOffered(String semesterId);
    Course findByCode(String semesterId, String code);
}
