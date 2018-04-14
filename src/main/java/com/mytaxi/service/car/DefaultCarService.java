package com.mytaxi.service.car;

import org.slf4j.LoggerFactory;

import com.mytaxi.dataaccessobject.CarRepository;
import com.mytaxi.domainobject.CarDO;
import com.mytaxi.exception.CarAlreadyInUseException;
import com.mytaxi.exception.EntityNotFoundException;

public class DefaultCarService implements CarService
{
    private static org.slf4j.Logger LOG = LoggerFactory.getLogger(DefaultCarService.class);
    private final CarRepository carRepository;

    public DefaultCarService(final CarRepository carReporistory)
    {
        this.carRepository = carReporistory;
    }
    @Override
    public CarDO SelectCar(long driverId, long carId) throws CarAlreadyInUseException, EntityNotFoundException
    {
        CarDO carDO = carRepository.findOne(carId);
        if(carDO == null) {
            throw new EntityNotFoundException("Could not find car with id: " + carId);
        }
        if(carDO.getActiveDriverId() != 0) {
            LOG.error(String.format("Car : %s is in used by driver : %s" , carId, carDO.getActiveDriverId()));
            throw new CarAlreadyInUseException("Car already in use");
        }
        
        carRepository.setActiveDriverId(driverId, carId);
        
        return carDO;
    }

}
