package com.donald.assessment.dao;

import com.donald.assessment.pojo.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Donald
 * @data 01/07/2020 16:43
 */
public interface ActivityDao extends JpaRepository<Activity,Integer> {
    Activity findByName(String name);
}
