package com.mytaxi.controller.mapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.mytaxi.datatransferobject.CarDTO;
import com.mytaxi.domainobject.CarDO;

public class CarMapper
{
    //Instead of using Builder pattern to map DO to DTO, we can simply use the mapstruct ( http://mapstruct.org/ ).
    
    public static CarDO makeCarDO(CarDTO carDTO) 
    {
        return new  CarDO(carDTO.getLicensePlate(), carDTO.getRating(), carDTO.getEngineType(), carDTO.getMeterReading());
    }
    
    public static CarDTO makeCarDTO(CarDO carDO)
    {
        CarDTO.CarDTOBuilder carDTOBuilder = CarDTO.newBuilder()
            .setLicensePlate(carDO.getLicensePlate())
            .setConvertible(carDO.isConvertible())
            .setEngineType(carDO.getEngineType())
            .setId(carDO.getId())
            .setManufacturer(carDO.getManufacturer())
            .setMeterReading(carDO.getMeterReading())
            .setRating(carDO.getRating())
            .setSeatCount(carDO.getSeatCount());
        
        return carDTOBuilder.getCarDTO();
    }
    
    public static List<CarDTO> makeCarDTOList(Collection<CarDO> cars)
    {
        return cars.stream()
            .map(CarMapper::makeCarDTO)
            .collect(Collectors.toList());
    }
    

}
