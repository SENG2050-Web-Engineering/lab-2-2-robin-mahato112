package com.unix.enrolment.dao;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DummyUserDAO implements UserDAO {

    private static final Map<String, String> USERS;
    static {
        Map<String, String> m = new HashMap<>();
        m.put("student1", "password");
        m.put("student2", "password");
        m.put("s123456", "password");
        USERS = Collections.unmodifiableMap(m);
    }

    @Override
    public boolean authenticate(String username, String password) {
        if (username == null || password == null) return false;
        String expected = USERS.get(username.trim());
        return expected != null && expected.equals(password);
    }
}
