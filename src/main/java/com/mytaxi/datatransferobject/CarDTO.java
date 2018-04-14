package com.mytaxi.datatransferobject;

import java.time.ZonedDateTime;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.mytaxi.datatransferobject.DriverDTO.DriverDTOBuilder;
import com.mytaxi.util.EngineTypes;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarDTO
{
    @JsonIgnore
    private Long id;
    
    private ZonedDateTime dateCreated = ZonedDateTime.now();
    
    @NotNull(message = "License plate can not be null!")
    private String licensePlate;
    
    private int seatCount;
    
    private boolean convertible;
    
    private int rating;
    
    private EngineTypes engineType;
    
    private long meterReading;
    
    private String manufacturer;

    private CarDTO() {
        
    }
    
    private CarDTO(
        Long id, ZonedDateTime dateCreated, String licensePlate, int seatCount, boolean convertible, int rating, EngineTypes engineType, long meterReading, String manufacturer)
    {
        this.id = id;
        this.dateCreated = dateCreated;
        this.licensePlate = licensePlate;
        this.seatCount = seatCount;
        this.convertible = convertible;
        this.rating = rating;
        this.engineType = engineType;
        this.meterReading = meterReading;
        this.manufacturer = manufacturer;
    }

    public static CarDTOBuilder newBuilder()
    {
        return new CarDTOBuilder();
    }

    public Long getId()
    {
        return id;
    }

    public ZonedDateTime getDateCreated()
    {
        return dateCreated;
    }

    public String getLicensePlate()
    {
        return licensePlate;
    }

    public int getSeatCount()
    {
        return seatCount;
    }

    public boolean isConvertible()
    {
        return convertible;
    }

    public int getRating()
    {
        return rating;
    }

    public EngineTypes getEngineType()
    {
        return engineType;
    }

    public long getMeterReading()
    {
        return meterReading;
    }

    public String getManufacturer()
    {
        return manufacturer;
    }
    
    public static class CarDTOBuilder {
        private Long id;
        private ZonedDateTime dateCreated = ZonedDateTime.now();
        private String licensePlate;
        private int seatCount;
        private boolean convertible;
        private int rating;
        private EngineTypes engineType;
        private long meterReading;
        private String manufacturer;
        
        public CarDTOBuilder setId(Long id)
        {
            this.id = id;
            return this;
        }
        public CarDTOBuilder setDateCreated(ZonedDateTime dateCreated)
        {
            this.dateCreated = dateCreated;
            return this;
        }
        public CarDTOBuilder setLicensePlate(String licensePlate)
        {
            this.licensePlate = licensePlate;
            return this;
        }
        public CarDTOBuilder setSeatCount(int seatCount)
        {
            this.seatCount = seatCount;
            return this;
        }
        public CarDTOBuilder setConvertible(boolean convertible)
        {
            this.convertible = convertible;
            return this;
        }
        public CarDTOBuilder setRating(int rating)
        {
            this.rating = rating;
            return this;
        }
        public CarDTOBuilder setEngineType(EngineTypes engineType)
        {
            this.engineType = engineType;
            return this;
        }
        public CarDTOBuilder setMeterReading(long meterReading)
        {
            this.meterReading = meterReading;
            return this;
        }
        public CarDTOBuilder setManufacturer(String manufacturer)
        {
            this.manufacturer = manufacturer;
            return this;
        }
        
        public CarDTO getCarDTO() {
            return new CarDTO(id, dateCreated, licensePlate, seatCount, convertible, rating, engineType, meterReading, manufacturer);
        }
    }
    
    
}
