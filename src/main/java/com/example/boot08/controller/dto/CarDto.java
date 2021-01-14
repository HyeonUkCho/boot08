package com.example.boot08.controller.dto;

import lombok.*;

@Getter
@RequiredArgsConstructor
public class CarDto {
    // 차량번
    private String carNo;

    // 소유주
    private String owner;

    // 소유형태
    private String ownType;

    // 주행거리
    private String driveDistance;

    // 판매희망금액
    private String salePrice;

    private String color;

    private String gearType;

    @Builder
    public CarDto(String carNo, String owner, String ownType, String driveDistance, String salePrice, String color, String gearType) {
        this.carNo = carNo;
        this.owner = owner;
        this.ownType = ownType;
        this.driveDistance = driveDistance;
        this.salePrice = salePrice;
        this.color = color;
        this.gearType = gearType;
    }
}
