package com.example.boot08.service;

import com.example.boot08.domain.CarInfo;
import com.example.boot08.persistence.CarInfoRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Log
@Service
public class CarService {

    @Autowired
    CarInfoRepository repo;

    public CarInfo getCarInfo(String carNO) {
        Optional<CarInfo> result = repo.findById(carNO);
        result.ifPresent(carInfo -> log.info("carInfo" + carInfo));
        return result.get();
    }
}
