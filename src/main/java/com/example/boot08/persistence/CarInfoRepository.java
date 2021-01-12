package com.example.boot08.persistence;

import com.example.boot08.domain.CarInfo;
import org.springframework.data.repository.CrudRepository;

public interface CarInfoRepository extends CrudRepository<CarInfo, String> {
}
