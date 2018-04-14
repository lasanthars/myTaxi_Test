package com.mytaxi.dataaccessobject;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mytaxi.domainobject.CarDO;

public interface CarRepository extends CrudRepository<CarDO, Long>
{
    @Modifying
    @Query("update CarDO car set car.activeDriverId = :driverId where car.id = :carId")
    void setActiveDriverId(@Param("driverId") long driverId, @Param("carId") long carId);
}
