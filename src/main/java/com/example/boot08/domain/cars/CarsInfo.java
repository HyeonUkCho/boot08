package com.example.boot08.domain.cars;

import com.example.boot08.domain.BaseTimeEntity;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
//@Setter
// Setter를 사용하지 않고 해당 필드의 값의 변경이 필요할 경우, 명확히 목적과 의도를 나타낼 수 있는 메소드흫 추가해야만 한다.
// 이렇게 하지 않으면 차후 기능 변경 시 복잡해진다.
@Table(name="tbl_carinfo")
@EqualsAndHashCode(of="carNo")
@NoArgsConstructor
@ToString
@Entity
public class CarsInfo extends BaseTimeEntity {

    // 차량번호
    @Id
    private String carNo;

    // 차이름
    private String carName;

    // 차종
    private String carType;

    // 제조사
    private String company;

    // 소유주
    private String owner;

    // 소유형태
    private String ownType;

    // 주행거리
    private String driveDistance;

    // 연
    private String makeYear;

    // 판매희망금액
    private String salePrice;

    private String color;

    private String gearType;

    // Builder 패턴을 사용하면 채워야하는 명확한 데이터를 알 수 있다.
    @Builder
    public CarsInfo(String carNo,
                    String carName,
                    String carType,
                    String company,
                    String owner,
                    String ownType,
                    String driveDistance,
                    String makeYear,
                    String salePrice,
                    String color,
                    String gearType) {
        this.carNo = carNo;
        this.carName = carName;
        this.carType = carType;
        this.company = company;
        this.owner = owner;
        this.ownType = ownType;
        this.driveDistance = driveDistance;
        this.makeYear = makeYear;
        this.salePrice = salePrice;
        this.color = color;
        this.gearType = gearType;
    }
}
