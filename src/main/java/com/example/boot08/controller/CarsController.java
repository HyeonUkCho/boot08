package com.example.boot08.controller;

import com.example.boot08.domain.cars.CarsInfo;
import com.example.boot08.service.cars.CarsService;
import com.example.boot08.controller.dto.CarDto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
                    .owner(infos.get(i).getOwner())
                    .color(infos.get(i).getColor())
                    .driveDistance(infos.get(i).getDriveDistance())
                    .gearType(infos.get(i).getGearType())
                    .ownType(infos.get(i).getOwnType())
                    .salePrice(infos.get(i).getSalePrice())
                    .build();
            cars.add(car);
        }
        model.addAttribute("result", cars);
        return "carsinfo";
    }
}
