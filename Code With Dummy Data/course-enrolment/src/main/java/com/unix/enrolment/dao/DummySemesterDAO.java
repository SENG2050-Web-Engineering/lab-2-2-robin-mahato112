package com.unix.enrolment.dao;

import com.unix.enrolment.model.Semester;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class DummySemesterDAO implements SemesterDAO {

    private static final List<Semester> SEMESTERS;
    static {
        List<Semester> list = new ArrayList<>();
        list.add(new Semester("2026S1", "2026 Semester 1", true));
        list.add(new Semester("2026S2", "2026 Semester 2", false));
        list.add(new Semester("2025S2", "2025 Semester 2", false));
        SEMESTERS = Collections.unmodifiableList(list);
    }

    @Override
    public List<Semester> findAll() {
        return SEMESTERS;
    }

    @Override
    public Optional<Semester> findById(String id) {
        if (id == null) return Optional.empty();
        return SEMESTERS.stream().filter(s -> s.getId().equals(id)).findFirst();
    }

    @Override
    public boolean hasAnyOpenSemester() {
        return SEMESTERS.stream().anyMatch(Semester::isOpen);
    }
}
