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
@Table(name="tbl_caruniqno")
@EqualsAndHashCode(of="carNo")
@ToString
public class CarUniqNo {

    // 차량번호
    @Id
    private String carNo;

    // 소유주
    private String carUniqNo;

    @CreationTimestamp
    private LocalDateTime regdate;

    @UpdateTimestamp
    private LocalDateTime updatedate;
}
