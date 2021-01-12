package com.example.boot08.persistence;

import com.example.boot08.domain.CarInfo;
import com.example.boot08.domain.Member;
import com.example.boot08.domain.MemberRole;
import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
@Commit
public class CarInfoRepositoryTest {

    @Autowired
    CarInfoRepository repo;

    @Test
    public void testInsert() {
        for(int i=0; i < 100; i++) {
            CarInfo carInfo = new CarInfo();
            carInfo.setCarNo("carNo"+i);
            carInfo.setOwner("user"+i);

            if(i < 80) {
                carInfo.setOwnType("자가");
            } else {
                carInfo.setOwnType("리스");
            }

            carInfo.setDriveDistance("10"+i);
            carInfo.setGearType("auto");
            carInfo.setSalePrice("5"+i);

            if(i < 50) {
                carInfo.setOwnType("Red");
            } else {
                carInfo.setOwnType("Blue");
            }
            repo.save(carInfo);
        }
    }

    @Test
    public void testRead() {
        Optional<CarInfo> result = repo.findById("carNo85");
        result.ifPresent(carInfo -> log.info("carInfo" + carInfo));
    }
}
