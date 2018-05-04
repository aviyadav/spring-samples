package org.sample.spring.rest.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.sample.spring.rest.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CountryDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Country> getAllCountries() {
        return sessionFactory.getCurrentSession().createQuery("from Country").list();
    }

    public Country getCountry(int id) {
        return sessionFactory.getCurrentSession().find(Country.class, id);
    }

    public Country addCountry(Country country) {
        sessionFactory.getCurrentSession().persist(country);
        return country;
    }

    public void updateCountry(Country country) {
        sessionFactory.getCurrentSession().update(country);
    }

    public void deleteCountry(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Country p = (Country) session.load(Country.class, id);
        if (null != p) {
            session.delete(p);
        }
    }
}
