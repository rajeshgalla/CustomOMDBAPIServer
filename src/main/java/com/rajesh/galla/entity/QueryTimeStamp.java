package com.rajesh.galla.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Calendar;

@Component
@Entity
public class QueryTimeStamp {

    public QueryTimeStamp() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    long ID;
    long userID;
    String movieName;
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar calendar;

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }
}
