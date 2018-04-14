package com.mytaxi.service.car;

import com.mytaxi.domainobject.CarDO;
import com.mytaxi.exception.CarAlreadyInUseException;
import com.mytaxi.exception.EntityNotFoundException;

public interface CarService
{
    CarDO SelectCar(long driverId, long carId) throws CarAlreadyInUseException, EntityNotFoundException;
}
