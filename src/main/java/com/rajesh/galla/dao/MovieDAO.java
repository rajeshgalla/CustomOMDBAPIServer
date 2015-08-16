package com.rajesh.galla.dao;

import java.util.Calendar;

public interface MovieDAO {
    void saveTimeStamp(String token, Calendar calendar);
}
