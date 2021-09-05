package com.exam.examportal.service;

import com.exam.examportal.model.User;
import com.exam.examportal.model.UserRole;

import java.util.Set;

public interface UserService {

    //    Creating user
    public User createUser (User user, Set<UserRole> userRoles) throws Exception;

    // get user by user name
    public User getUser(String username);

    // delete user by userId
    public void deleteUser(Long userId);
}
