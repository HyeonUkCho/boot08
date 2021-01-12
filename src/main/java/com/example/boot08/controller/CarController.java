package com.example.boot08.controller;

import com.example.boot08.domain.CarInfo;
import com.example.boot08.service.CarService;
import com.example.boot08.vo.CarVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/car/")
public class CarController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @Autowired
    CarService carService;

    @GetMapping("/getCarInfo")
    public String getCarInfo(String carNo, Model model) {
        logger.info("carNo : " + carNo);
        CarInfo info = carService.getCarInfo(carNo);
        CarVO car = CarVO.builder()
                .carNo(info.getCarNo())
                .owner(info.getOwner())
                .color(info.getColor())
                .driveDistance(info.getDriveDistance())
                .gearType(info.getGearType())
                .ownType(info.getOwnType())
                .salePrice(info.getSalePrice())
                .build();
        model.addAttribute("result", car);
        return "carinfo";
    }
}
