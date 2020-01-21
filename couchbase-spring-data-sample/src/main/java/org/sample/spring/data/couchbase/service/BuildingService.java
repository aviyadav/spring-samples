package org.sample.spring.data.couchbase.service;

import java.util.List;
import javax.validation.Valid;
import org.sample.spring.data.couchbase.entities.Building;

public interface BuildingService {
    
    Building save(@Valid Building building);

    Building findById(String buildingId);

    List<Building> findByCompanyId(String companyId);

    Building findByCompanyAndAreaId(String companyId, String areaId);

    List<Building> findByCompanyIdAndNameLike(String companyId, String name, int page);

    List<Building> findByPhoneNumber(String telephoneNumber);

    Long countBuildings(String companyId);
}
