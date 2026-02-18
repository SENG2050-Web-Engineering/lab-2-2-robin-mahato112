package com.unix.enrolment.dao;

import com.unix.enrolment.model.Course;

import java.util.*;

public class DummyCourseDAO implements CourseDAO {


    private static final Map<String, List<Course>> COURSES_BY_SEMESTER;
    static {
        Map<String, List<Course>> m = new HashMap<>();

        m.put("2026S1", Collections.unmodifiableList(Arrays.asList(
                new Course("WE200", "Web Engineering", 3),
                new Course("SE210", "Software Design", 3),
                new Course("DB220", "Databases", 3),
                new Course("AI230", "Intro to AI", 3),
                new Course("UX240", "UX Fundamentals", 3)
        )));

        m.put("2026S2", Collections.emptyList());
        m.put("2025S2", Collections.emptyList());

        COURSES_BY_SEMESTER = Collections.unmodifiableMap(m);
    }

    @Override
    public List<Course> findCoursesOffered(String semesterId) {
        if (semesterId == null) return Collections.emptyList();
        return COURSES_BY_SEMESTER.getOrDefault(semesterId, Collections.emptyList());
    }

    @Override
    public Course findByCode(String semesterId, String code) {
        if (semesterId == null || code == null) return null;
        return findCoursesOffered(semesterId).stream()
                .filter(c -> c.getCode().equals(code))
                .findFirst()
                .orElse(null);
    }
}
