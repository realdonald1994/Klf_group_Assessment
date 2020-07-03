package com.donald.assessment;

import com.donald.assessment.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author Donald
 * @data 03/07/2020 14:06
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class UserTest {
    @Autowired
    private UserService userService;

    @Test
    public void getUserByNameTest(){
        Assert.assertEquals("aaa","aaa");
    }

}
