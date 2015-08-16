package com.rajesh.galla.config;

import com.rajesh.galla.bo.MovieBO;
import com.rajesh.galla.bo.UserDetailsBO;
import com.rajesh.galla.bo.impl.MovieBOImplementation;
import com.rajesh.galla.bo.impl.UserDetailsBOImplementation;
import com.rajesh.galla.dao.MovieDAO;
import com.rajesh.galla.dao.UserDetailsDAO;
import com.rajesh.galla.dao.impl.MovieDAOImplementation;
import com.rajesh.galla.dao.impl.UserDetailsDAOImplementation;
import com.rajesh.galla.entity.UserDetails;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ImportResource("classpath:applicationContext.xml")
public class ApplicationConfig {

    @Autowired
    private SessionFactory sessionFactory;

    public ApplicationConfig() {
    }

    @Bean
    public UserDetailsDAO userDetailsDAO() {

        UserDetailsDAOImplementation userDetailsDAOImplementation = new UserDetailsDAOImplementation();
        userDetailsDAOImplementation.setSessionFactory(sessionFactory);
        return userDetailsDAOImplementation;
    }

    @Bean
    public UserDetailsBO userDetailsBO() {

        return new UserDetailsBOImplementation();
    }

    @Bean
    public MovieDAO movieDAO() {

        MovieDAOImplementation movieDAO = new MovieDAOImplementation();
        movieDAO.setSessionFactory(sessionFactory);
        return movieDAO;
    }

    @Bean
    public MovieBO movieBO() {

        return new MovieBOImplementation();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
