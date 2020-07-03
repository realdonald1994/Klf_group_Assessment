package com.donald.assessment.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Donald
 * @data 01/07/2020 14:42
 */
@Entity
@Table(name = "user_activity")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class UserActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer activity_id;
    private Integer user_id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date occurrence;

    public Integer getActivity_id() {
        return activity_id;
    }

    public void setActivity_id(Integer activity_id) {
        this.activity_id = activity_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Date getOccurrence() {
        return occurrence;
    }

    public void setOccurrence(Date occurrence) {
        this.occurrence = occurrence;
    }
}
