package com.donald.assessment.dao;


import com.donald.assessment.pojo.UserActivity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

/**
 * @author Donald
 * @data 01/07/2020 16:48
 */
public interface UserActivityDao extends JpaRepository<UserActivity,Integer> {
    @Query(value = "select user.name as username,activity.name as activity,count(*) as amount,min(occurrence) as firstTime,max(occurrence) as LastTime from user_activity left join user on user_activity.user_id = user.id left join activity on user_activity.activity_id = activity.id group by user_id, activity_id",countQuery = "select count(*) from user_activity left join user on user_activity.user_id = user.id left join activity on user_activity.activity_id = activity.id group by user_id, activity_id",nativeQuery = true)
    Page<Object[]> listReport(Pageable pageable);

    @Query(value = "select user.name as username,activity.name as activity,count(*) as amount,min(occurrence) as firstTime,max(occurrence) as LastTime from user_activity left join user on user_activity.user_id = user.id left join activity on user_activity.activity_id = activity.id where month(occurrence) = :monthNum group by user_id, activity_id",countQuery ="select count(*) from user_activity left join user on user_activity.user_id = user.id left join activity on user_activity.activity_id = activity.id where month(occurrence) = :monthNum group by user_id, activity_id",nativeQuery = true)
    Page<Object[]> listReportByMonth(@Param("monthNum") int month, Pageable pageable);

    @Modifying
    @Query(value = "delete from user_activity where user_id = :uid",nativeQuery = true)
    void deleteAllByUserId(@Param("uid") Integer uid);
}
