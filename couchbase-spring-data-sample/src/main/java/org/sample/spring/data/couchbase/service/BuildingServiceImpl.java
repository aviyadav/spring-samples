package org.sample.spring.data.couchbase.service;

import java.util.List;
import javax.validation.Valid;
import org.sample.spring.data.couchbase.entities.Building;
import org.sample.spring.data.couchbase.repositories.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class BuildingServiceImpl implements BuildingService {
    
    @Autowired
    private BuildingRepository repository;

    @Override
    public Building save(@Valid Building building) {
        return repository.save(building);
    }

    @Override
    public Building findById(String buildingId) {
        return repository.findById(buildingId).get();
    }

    @Override
    public List<Building> findByCompanyId(String companyId) {
        return repository.findByCompanyId(companyId);
    }

    @Override
    public Building findByCompanyAndAreaId(String companyId, String areaId) {
        return repository.findByCompanyAndAreaId(companyId, areaId);
    }

    @Override
    public List<Building> findByCompanyIdAndNameLike(String companyId, String name, int page) {
        return repository.findByCompanyIdAndNameLikeOrderByName(companyId, name, PageRequest.of(page, 20)).getContent();
    }

    @Override
    public List<Building> findByPhoneNumber(String telephoneNumber) {
        return repository.findByPhoneNumber(telephoneNumber);
    }

    @Override
    public Long countBuildings(String companyId) {
        return repository.countBuildings(companyId);
    }

}
