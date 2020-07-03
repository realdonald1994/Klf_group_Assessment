package com.donald.assessment.service;

import com.donald.assessment.pojo.Report;
import com.donald.assessment.pojo.UserActivity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author Donald
 * @data 01/07/2020 16:49
 */
public interface UserActivityService {
    void addUserActivity(UserActivity userActivity);

    Page<Report> list(Pageable pageable);

    Page<Report> listNyMonth(int month, Pageable pageable);

    void deleteByUser(Integer uid);
}
