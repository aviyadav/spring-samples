package org.sample.spring.rest.service;

import java.util.List;
import javax.transaction.Transactional;
import org.sample.spring.rest.dao.CountryDAO;
import org.sample.spring.rest.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("countryService")
public class CountryService {
    
    @Autowired
    CountryDAO countryDAO;

    @Transactional
    public List<Country> getAllCountries() {
        return countryDAO.getAllCountries();
    }
    
    @Transactional
    public Country getCountry(int id) {
        return countryDAO.getCountry(id);
    }
    
    @Transactional
    public void addCountry(Country country) {
        countryDAO.addCountry(country);
    }
    
    @Transactional
    public void updateCountry(Country country) {
        countryDAO.updateCountry(country);
    }
    
    @Transactional
    public void deleteCountry(int id) {
        countryDAO.deleteCountry(id);
    }
}
