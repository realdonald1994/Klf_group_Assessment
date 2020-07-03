package com.donald.assessment.pojo;

import com.donald.assessment.utils.DateUtil;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;

/**
 * @author Donald
 * @data 01/07/2020 17:09
 */
public class Report {

    private String username;
    private String activity;
    private BigInteger amount;
    private Timestamp firstTime;
    private Timestamp lastTime;

    public Report(String username, String activity, BigInteger amount, Timestamp firstTime, Timestamp lastTime) {
        this.username = username;
        this.activity = activity;
        this.amount = amount;
        this.firstTime = firstTime;
        this.lastTime = lastTime;
    }

    public Report() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public BigInteger getAmount() {
        return amount;
    }

    public void setAmount(BigInteger amount) {
        this.amount = amount;
    }

    public Timestamp getFirstTime() {
        return firstTime;
    }

    public void setFirstTime(Timestamp firstTime) throws ParseException {
        String dateToString = DateUtil.dateToString(firstTime, "yyyy-MM-dd HH:mm:ss");

        this.firstTime = (Timestamp) DateUtil.StringToDate(dateToString,"yyyy-MM-dd HH:mm:ss");
    }

    public Timestamp getLastTime() {
        return this.lastTime;
    }

    public void setLastTime(Timestamp lastTime) throws ParseException {
        String dateToString = DateUtil.dateToString(lastTime, "yyyy-MM-dd HH:mm:ss");

        this.lastTime = (Timestamp) DateUtil.StringToDate(dateToString,"yyyy-MM-dd HH:mm:ss");

    }

    @Override
    public String toString() {
        return "Report{" +
                "username='" + username + '\'' +
                ", activity='" + activity + '\'' +
                ", amount=" + amount +
                ", firstTime=" + firstTime +
                ", LastTime=" + lastTime +
                '}';
    }
}
