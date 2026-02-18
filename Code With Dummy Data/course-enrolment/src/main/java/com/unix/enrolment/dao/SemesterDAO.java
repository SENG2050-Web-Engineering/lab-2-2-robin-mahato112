package com.unix.enrolment.dao;

import com.unix.enrolment.model.Semester;
import java.util.List;
import java.util.Optional;

public interface SemesterDAO {
    List<Semester> findAll();
    Optional<Semester> findById(String id);
    boolean hasAnyOpenSemester();
}
