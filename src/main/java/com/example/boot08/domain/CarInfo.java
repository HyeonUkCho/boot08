package com.example.boot08.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="tbl_carinfo")
@EqualsAndHashCode(of="carNo")
@ToString
public class CarInfo {

    // 차량번호
    @Id
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

    @CreationTimestamp
    private LocalDateTime regdate;

    @UpdateTimestamp
    private LocalDateTime updatedate;
}
