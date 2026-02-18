package com.unix.enrolment.dao;

public interface UserDAO {
    boolean authenticate(String username, String password);
}
