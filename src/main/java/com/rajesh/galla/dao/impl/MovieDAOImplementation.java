package com.rajesh.galla.dao.impl;

import com.rajesh.galla.dao.MovieDAO;
import com.rajesh.galla.entity.QueryTimeStamp;
import com.rajesh.galla.entity.UserDetails;
import org.hibernate.FlushMode;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Iterator;
import java.util.List;


@Repository
@Transactional
public class MovieDAOImplementation extends HibernateDaoSupport implements MovieDAO{

    @Autowired
    QueryTimeStamp queryTimeStamp;

    public void saveTimeStamp(String token, Calendar calendar) {

        Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery("from UserDetails where token = ?");
        query.setString(0, token);
        List<UserDetails> userDetailsList = query.list();

        System.out.println("userDetailsList " + userDetailsList);
        Iterator iter = userDetailsList.iterator();

        UserDetails userDetails = (UserDetails) iter.next();

        System.out.println("UserID is " + userDetails.getUserID());

        queryTimeStamp.setCalendar(calendar);
        queryTimeStamp.setUserID(userDetails.getUserID());

        getHibernateTemplate().save(queryTimeStamp);
    }
}
