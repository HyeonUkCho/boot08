package com.example.boot08.service.cars;

import com.example.boot08.domain.cars.CarsInfo;
import com.example.boot08.domain.cars.CarsInfoRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    public CarsInfo getCarsInfoBycarNo(String keyword) {

        Optional<CarsInfo> optionalResult = repo.findById(keyword);
        CarsInfo carsInfo = null;
        if (optionalResult.isPresent()) {
            carsInfo = optionalResult.get();
        }
        return carsInfo;
    }

    @Transactional
    public CarsInfo registCarsInfo(CarsInfo carDto) {
        CarsInfo carsInfo = CarsInfo.builder()
                .carNo(carDto.getCarNo())
                .ownerName(carDto.getOwnerName())
                .transmission(carDto.getTransmission())
                .carName(carDto.getCarName())
                .carType(carDto.getCarType())
                .color(carDto.getColor())
                .company(carDto.getCompany())
                .driveDistance(carDto.getDriveDistance())
                .engine(carDto.getEngine())
                .fuelType(carDto.getFuelType())
                .makeYear(carDto.getMakeYear())
                .ownType(carDto.getOwnType())
                .salePrice(carDto.getSalePrice())
                .power(carDto.getPower())
                .seat(carDto.getSeat())
                .build();
        return repo.save(carsInfo);
    }
}
