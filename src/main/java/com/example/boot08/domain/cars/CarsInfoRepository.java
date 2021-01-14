package com.example.boot08.domain.cars;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarsInfoRepository extends JpaRepository<CarsInfo, String>{
    List<CarsInfo> findByCarNoContaining(String carNo);
    List<CarsInfo> findByCarTypeContains(String carType);
    List<CarsInfo> findByCompanyIsContaining(String company);
}
