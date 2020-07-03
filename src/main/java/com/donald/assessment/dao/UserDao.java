package com.donald.assessment.dao;

import com.donald.assessment.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Donald
 * @data 30/06/2020 21:57
 */
public interface UserDao extends JpaRepository<User,Integer> {
    /**
     * login
     * @param name
     * @param password
     * @return
     */
    User findByNameAndPassword(String name,String password);
    User findByName(String name);
}
