package com.example.boot08.domain.cars;

import com.example.boot08.domain.BaseTimeEntity;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name="tbl_caruniqno")
@EqualsAndHashCode(of="carNo")
@ToString
public class CarsUniqNo extends BaseTimeEntity {

    // 차량번호
    @Id
    private String carNo;

    // 차대번호
    private String carUniqNo;

    @Builder
    public CarsUniqNo(String carNo, String carUniqNo) {
        this.carNo = carNo;
        this.carUniqNo = carUniqNo;
    }
}
