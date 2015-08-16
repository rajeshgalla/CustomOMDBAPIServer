package com.rajesh.galla.dao.impl;

import com.rajesh.galla.dao.UserDetailsDAO;
import com.rajesh.galla.entity.UserDetails;
import org.hibernate.FlushMode;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserDetailsDAOImplementation extends HibernateDaoSupport implements UserDetailsDAO {

    public void saveUser(UserDetails userDetails) {

        HibernateTemplate hibernateTemplate;
        hibernateTemplate = getHibernateTemplate();
        hibernateTemplate.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
        hibernateTemplate.save(userDetails);
    }
}
