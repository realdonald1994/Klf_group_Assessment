package com.donald.assessment.service.impl;

import com.donald.assessment.dao.UserActivityDao;
import com.donald.assessment.pojo.Report;
import com.donald.assessment.pojo.UserActivity;
import com.donald.assessment.service.UserActivityService;
import com.donald.assessment.utils.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Donald
 * @data 01/07/2020 16:51
 */
@Service
public class UserActivityServiceImpl implements UserActivityService {
    @Autowired
    private UserActivityDao userActivityDao;
    @Override
    public void addUserActivity(UserActivity userActivity) {
        userActivityDao.save(userActivity);
    }

    @Override
    public Page<Report> list(Pageable pageable) {
        Page<Object[]> pages = userActivityDao.listReport(pageable);
        List<Object[]> objects = pages.getContent();
        List<Report> reports = EntityUtils.castEntity(objects, Report.class, new Report());
        System.out.println(reports);
        Page<Report> pageNew = new PageImpl(reports, pageable, pages.getTotalElements());
        return pageNew;
    }

    @Override
    public Page<Report> listNyMonth(int month,Pageable pageable) {
        Page<Object[]> pages = userActivityDao.listReportByMonth(month,pageable);
        List<Object[]> objects = pages.getContent();
        List<Report> reports = EntityUtils.castEntity(objects, Report.class, new Report());
        Page<Report> pageNew = new PageImpl(reports, pageable, pages.getTotalElements());
        return pageNew;
    }

    @Override
    public void deleteByUser(Integer uid) {
        userActivityDao.deleteAllByUserId(uid);
    }
}
