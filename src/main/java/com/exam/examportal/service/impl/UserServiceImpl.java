package com.exam.examportal.service.impl;

import com.exam.examportal.helper.UserFoundException;
import com.exam.examportal.model.User;
import com.exam.examportal.model.UserRole;
import com.exam.examportal.repository.RoleRepository;
import com.exam.examportal.repository.UserRepository;
import com.exam.examportal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {
        User local = this.userRepository.findByUsername(user.getUsername());
        if( local != null) {
            System.out.println("Already exist!!");
            throw new UserFoundException();
        }
        else {
            //            creating user
            for(UserRole ur:userRoles) {
                roleRepository.save(ur.getRole());
            }
            user.getUserRoles().addAll(userRoles);
            local = this.userRepository.save(user);
        }
        return local;
    }

    // get user by user name
    @Override
    public User getUser(String username) {
        return this.userRepository.findByUsername(username);
    }

    // delete user by user id
    @Override
    public void deleteUser(Long userId) {
        this.userRepository.deleteById(userId);
    }
}
