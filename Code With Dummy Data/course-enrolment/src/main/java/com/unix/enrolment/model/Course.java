package com.unix.enrolment.model;

import java.io.Serializable;

public class Course implements Serializable {
    private final String code;
    private final String name;
    private final int units;

    public Course(String code, String name, int units) {
        this.code = code;
        this.name = name;
        this.units = units;
    }

    public String getCode() { return code; }
    public String getName() { return name; }
    public int getUnits() { return units; }
}
