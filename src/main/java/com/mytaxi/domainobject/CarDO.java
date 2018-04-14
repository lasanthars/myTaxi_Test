package com.mytaxi.domainobject;

import com.mytaxi.domainvalue.GeoCoordinate;
import com.mytaxi.domainvalue.OnlineStatus;
import com.mytaxi.util.EngineTypes;

import java.time.ZonedDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(
    name = "car",
    uniqueConstraints = @UniqueConstraint(name = "uc_licensePlate", columnNames = {"licensePlate"})
)
public class CarDO
{
    @Id
    @GeneratedValue
    private Long id;
    
    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private ZonedDateTime dateCreated = ZonedDateTime.now();
    
    @Column(nullable = false)
    @NotNull(message = "License plate can not be null!")
    private String licensePlate;
    
    private int seatCount;
    
    private boolean convertible;
    
    private int rating;
    
    private EngineTypes engineType;
    
    private long meterReading;
    
    private String manufacturer;

    private long activeDriverId;
    
    @ManyToMany
    private List<DriverDO> drivers;
    
    
    public CarDO(
        String licensePlate,int rating, EngineTypes engineType, long meterReading)
    {
        this.dateCreated = null;
        this.licensePlate = licensePlate;
        this.seatCount = 0;
        this.convertible = false;
        this.rating = rating;
        this.engineType = engineType;
        this.meterReading = meterReading;
        this.manufacturer = "";
        this.activeDriverId = 0;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public ZonedDateTime getDateCreated()
    {
        return dateCreated;
    }

    public void setDateCreated(ZonedDateTime dateCreated)
    {
        this.dateCreated = dateCreated;
    }

    public String getLicensePlate()
    {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate)
    {
        this.licensePlate = licensePlate;
    }

    public int getSeatCount()
    {
        return seatCount;
    }

    public void setSeatCount(int seatCount)
    {
        this.seatCount = seatCount;
    }

    public boolean isConvertible()
    {
        return convertible;
    }

    public void setConvertible(boolean convertible)
    {
        this.convertible = convertible;
    }

    public int getRating()
    {
        return rating;
    }

    public void setRating(int rating)
    {
        this.rating = rating;
    }

    public EngineTypes getEngineType()
    {
        return engineType;
    }

    public void setEngineType(EngineTypes engineType)
    {
        this.engineType = engineType;
    }

    public long getMeterReading()
    {
        return meterReading;
    }

    public void setMeterReading(long meterReading)
    {
        this.meterReading = meterReading;
    }

    public String getManufacturer()
    {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer)
    {
        this.manufacturer = manufacturer;
    }

    public long getActiveDriverId()
    {
        return activeDriverId;
    }

    public void setActiveDriverId(long activeDriverId)
    {
        this.activeDriverId = activeDriverId;
    }

    public List<DriverDO> getDrivers()
    {
        return drivers;
    }

    public void setDrivers(List<DriverDO> drivers)
    {
        this.drivers = drivers;
    }
    
}
