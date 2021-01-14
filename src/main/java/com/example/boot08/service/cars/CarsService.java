package com.example.boot08.service.cars;

import com.example.boot08.controller.dto.CarSearchInfo;
import com.example.boot08.domain.cars.CarsInfo;
import com.example.boot08.domain.cars.CarsInfoRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Log
@Service
public class CarsService {

    @Autowired
    CarsInfoRepository repo;

    public List<CarsInfo> getCarsInfo(String type, String keyword) {
        List<CarsInfo> result = null;
        switch (type) {
            case "carNo":
                result = repo.findByCarNoContaining(keyword);
                break;
            case "carType":
                result = repo.findByCarTypeContains(keyword);
                break;
            case "company":
                result = repo.findByCompanyIsContaining(keyword);
                break;
            default:
                break;
        }

        result.forEach(carsInfo -> log.info("carInfo" + carsInfo));
        return result;
    }
}
