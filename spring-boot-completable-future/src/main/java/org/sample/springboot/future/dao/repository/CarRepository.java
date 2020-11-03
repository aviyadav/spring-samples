package org.sample.springboot.future.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.sample.springboot.future.dao.entity.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long>{

}
