package com.donald.assessment.service.impl;

import com.donald.assessment.dao.ActivityDao;
import com.donald.assessment.dao.UserDao;
import com.donald.assessment.pojo.Activity;
import com.donald.assessment.pojo.User;
import com.donald.assessment.pojo.UserActivity;
import com.donald.assessment.service.ActivityService;
import com.donald.assessment.service.UserActivityService;
import com.donald.assessment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author Donald
 * @data 01/07/2020 16:45
 */
@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityDao activityDao;
    @Autowired
    private UserService userService;
    @Autowired
    private UserActivityService userActivityService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addActivity(Activity activity, String username, Date startTime) {
        Activity dbActivity = activityDao.findByName(activity.getName());
        if(null==dbActivity){
             dbActivity = activityDao.save(activity);
        }
        UserActivity userActivity = new UserActivity();
        User dbUser = userService.getByName(username);
        System.out.println(dbUser);
        userActivity.setUser_id(dbUser.getId());
        userActivity.setActivity_id(dbActivity.getId());
        userActivity.setOccurrence(startTime);
        userActivityService.addUserActivity(userActivity);
    }
}
