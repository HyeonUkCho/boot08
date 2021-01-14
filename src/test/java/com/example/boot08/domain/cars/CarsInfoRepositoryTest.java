package com.example.boot08.domain.cars;

import com.example.boot08.domain.cars.CarsInfo;
import com.example.boot08.domain.cars.CarsInfoRepository;
import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
@Commit
public class CarsInfoRepositoryTest {

    @Autowired
    CarsInfoRepository repo;

    @Test
    public void testInsert() {
        for(int i=1; i < 100; i++) {
            CarsInfo carsInfo;
            if(i < 50) {
                carsInfo = CarsInfo.builder()
                        .carNo("carNo" + i)
                        .color("Red")
                        .driveDistance("10" + i)
                        .gearType("auto")
                        .ownType("자가")
                        .owner("user" + i)
                        .salePrice(1000000 / i + "")
                        .build();
            } else {
                carsInfo = CarsInfo.builder()
                        .carNo("carNo" + i)
                        .color("Blue")
                        .driveDistance("10" + i)
                        .gearType("auto")
                        .ownType("리스")
                        .owner("user" + i)
                        .salePrice(50000000 / i + "")
                        .build();
            }
            repo.save(carsInfo);
        }
    }

    @Test
    public void testRead() {
        Optional<CarsInfo> result = repo.findById("carNo85");
        result.ifPresent(carsInfo -> log.info("carInfo" + carsInfo));
    }
}
