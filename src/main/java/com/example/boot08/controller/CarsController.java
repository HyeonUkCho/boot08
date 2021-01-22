package com.example.boot08.controller;

import com.example.boot08.domain.cars.CarsInfo;
import com.example.boot08.service.cars.CarsService;
import com.example.boot08.controller.dto.CarDto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/car/")
public class CarsController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @Autowired
    CarsService carsService;

    @PostMapping("/getCarInfo")
    public String getCarInfo(@RequestParam("type") String type,
                             @RequestParam("keyword") String keyword,
                             Model model) {
        logger.info("type : " + type + " keyword : " + keyword);
        List<CarsInfo> infos = carsService.getCarsInfo(type,keyword);
        List<CarDto> cars = new ArrayList<>();
        for(int i=0; i<infos.size(); i++) {
            CarDto car = CarDto.builder()
                    .carNo(infos.get(i).getCarNo())
                    .carName(infos.get(i).getCarName())
                    .carType(infos.get(i).getCarType())
                    .company(infos.get(i).getCompany())
                    .ownerName(infos.get(i).getOwnerName())
                    .ownType(infos.get(i).getOwnType())
                    .driveDistance(infos.get(i).getDriveDistance())
                    .makeYear(infos.get(i).getMakeYear())
                    .salePrice(infos.get(i).getSalePrice())
                    .color(infos.get(i).getColor())
                    .transmission(infos.get(i).getTransmission())
                    .fuelType(infos.get(i).getFuelType())
                    .engine(infos.get(i).getEngine())
                    .power(infos.get(i).getPower())
                    .seat(infos.get(i).getSeat())
                    .build();
            cars.add(car);
        }
        model.addAttribute("result", cars);
        return "carsinfo";
    }

    @GetMapping("/searchByType")
    public String searchByType(@RequestParam("type") String type,
                             @RequestParam("keyword") String keyword,
                             Model model) {
        logger.info("type : " + type + " keyword : " + keyword);
        List<CarsInfo> infos = carsService.getCarsInfo(type,keyword);
        logger.info("infos size : " + infos.size());
        List<CarDto> cars = new ArrayList<>();
        for(int i=0; i<infos.size(); i++) {
            CarDto car = CarDto.builder()
                    .carNo(infos.get(i).getCarNo())
                    .carName(infos.get(i).getCarName())
                    .ownerName(infos.get(i).getOwnerName())
                    .color(infos.get(i).getColor())
                    .driveDistance(infos.get(i).getDriveDistance())
                    .transmission(infos.get(i).getTransmission())
                    .ownType(infos.get(i).getOwnType())
                    .salePrice(infos.get(i).getSalePrice())
                    .build();
            cars.add(car);
        }
        model.addAttribute("result", cars);
        return "carsinfo";
    }

    @PostMapping("/registCar")
    public String registCar(@ModelAttribute CarsInfo carsInfo, Model model) {
        logger.info(carsInfo.toString());
        model.addAttribute("result", carsService.registCarsInfo(carsInfo));
        return "registinfo";
    }

    @GetMapping("/details")
    public String details(@RequestParam String carNo, Model model) {
        logger.info("carNo : " + carNo);
        model.addAttribute("result", carsService.getCarsInfoBycarNo(carNo));
        return "detail";
    }

}
