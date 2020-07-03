package com.donald.assessment.service;

import com.donald.assessment.pojo.Activity;

import java.util.Date;

/**
 * @author Donald
 * @data 01/07/2020 16:44
 */
public interface ActivityService {
    void addActivity(Activity activity, String username, Date startTime);
}
