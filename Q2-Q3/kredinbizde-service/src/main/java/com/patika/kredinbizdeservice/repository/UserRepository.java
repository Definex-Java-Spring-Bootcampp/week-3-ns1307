package com.patika.kredinbizdeservice.repository;

import com.patika.kredinbizdeservice.model.User;
import com.patika.kredinbizdeservice.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {


    @Autowired
    private LogService logService;
    private List<User> userList = new ArrayList<>();

    public UserRepository(LogService logService) {
        this.logService = logService;
    }

    public void save(User user) {
        userList.add(user);
        logService.sendLog("User created:" + user.getEmail());
    }

    public List<User> getAll() {
        logService.sendLog("pulled all users.");
        return userList;
    }

    public Optional<User> findByEmail(String email) {
        logService.sendLog("user searched:" + email);
        return userList.stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst();
    }

    public void delete(User user) {
        logService.sendLog("user deleted:" + user.getEmail());
        userList.remove(user);
    }

    public User findByUserId(Long userId) {
        return new User();
    }
}
