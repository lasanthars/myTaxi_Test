package com.mytaxi.driver.filter;

import java.util.ArrayList;
import java.util.List;

import com.mytaxi.domainobject.DriverDO;

public class CriteriaFemale implements DriverCriteria
{
    @Override
    public List<DriverDO> meetCriteria(List<DriverDO> drivers)
    {
       List<DriverDO> femaleDrivers = new ArrayList<DriverDO>();
       for (DriverDO driver : drivers) {
           if(driver.getGender().equalsIgnoreCase("female")) {
               femaleDrivers.add(driver);
           }
       }
       
       return femaleDrivers;
    }
}
