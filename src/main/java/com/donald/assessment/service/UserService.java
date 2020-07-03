package com.donald.assessment.service;

import com.donald.assessment.pojo.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author Donald
 * @data 30/06/2020 22:03
 */
public interface UserService {
    /**
     * interface of login function
     * @param username
     * @param password
     * @return
     */
    User getUser(String username,String password);

    /**
     * save user
     * @param user
     */
    void addUser(User user);

    boolean isExist(String username);
    User getByName(String username);

    Page<User> getUsers(Pageable pageable);

    void editUser(User updateUser);

    void deleteUser(Integer id);
}
