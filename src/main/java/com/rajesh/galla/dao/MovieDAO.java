package com.rajesh.galla.dao;

import java.util.Calendar;

public interface MovieDAO {
    void saveQuery(String token,String movieName, Calendar calendar);
}
