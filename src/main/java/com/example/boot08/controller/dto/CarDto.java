package com.example.boot08.controller.dto;

import lombok.*;

@Getter
@RequiredArgsConstructor
@ToString
public class CarDto {
    // 차량번호
    private String carNo;

    // 차이름
    private String carName;

    // 차종 (SUV, SEDAN)
    private String carType;

    // 제조사 (HYUNDAI, KIA, BENZ, AUDI ..)
    private String company;

    // 소유주명
    private String ownerName;

    // 소유형태 (자가, 리스)
    private String ownType;

    // 주행거리
    private String driveDistance;

    // 생산년도
    private String makeYear;

    // 판매희망금액
    private String salePrice;

    // 색상
    private String color;

    // 기어 종류
    private String transmission;

    // 연료 타입
    private String fuelType;

    // 엔진 cc
    private int engine;

    // 마력
    private int power;

    // 몇인승?
    private int seat;

    // Builder 패턴을 사용하면 채워야하는 명확한 데이터를 알 수 있다.
    @Builder
    public CarDto(String carNo,
                    String carName,
                    String carType,
                    String company,
                    String ownerName,
                    String ownType,
                    String driveDistance,
                    String makeYear,
                    String salePrice,
                    String color,
                    String transmission,
                    String fuelType,
                    int engine,
                    int power,
                    int seat) {
        this.carNo = carNo;
        this.carName = carName;
        this.carType = carType;
        this.company = company;
        this.ownerName = ownerName;
        this.ownType = ownType;
        this.driveDistance = driveDistance;
        this.makeYear = makeYear;
        this.salePrice = salePrice;
        this.color = color;
        this.transmission = transmission;
        this.fuelType = fuelType;
        this.engine = engine;
        this.power = power;
        this.seat = seat;
    }
}
