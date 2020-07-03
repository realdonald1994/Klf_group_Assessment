package com.donald.assessment.service.impl;

import com.donald.assessment.dao.UserDao;
import com.donald.assessment.pojo.User;
import com.donald.assessment.pojo.UserActivity;
import com.donald.assessment.service.UserActivityService;
import com.donald.assessment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Donald
 * @data 30/06/2020 22:04
 */
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserDao userDao;

    @Autowired
    private UserActivityService userActivityService;

    @Override
    public User getUser(String username, String password) {
        return userDao.findByNameAndPassword(username,password);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addUser(User user) {
        userDao.save(user);
    }

    @Override
    public boolean isExist(String username) {
        User user = getByName(username);
        return null!=user;
    }

    @Override
    public User getByName(String name) {
        return userDao.findByName(name);
    }

    @Override
    public Page<User> getUsers(Pageable pageable) {
        return userDao.findAll(pageable);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void editUser(User updateUser) {
        User dbUser = userDao.findById(updateUser.getId()).get();
        System.out.println(updateUser.getName());
        dbUser.setName(updateUser.getName());
        dbUser.setPassword(updateUser.getPassword());

        userDao.save(dbUser);

    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteUser(Integer id) {
        userActivityService.deleteByUser(id);
        userDao.deleteById(id);
    }
}
