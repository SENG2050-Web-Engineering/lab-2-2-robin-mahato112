package com.unix.enrolment.model;

import java.io.Serializable;

public class Semester implements Serializable {
    private final String id;
    private final String name;
    private final boolean open;

    public Semester(String id, String name, boolean open) {
        this.id = id;
        this.name = name;
        this.open = open;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public boolean isOpen() { return open; }
}
