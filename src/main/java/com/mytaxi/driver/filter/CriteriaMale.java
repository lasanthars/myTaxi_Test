package com.mytaxi.driver.filter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.mytaxi.domainobject.DriverDO;

public class CriteriaMale implements DriverCriteria
{

    @Override
    public List<DriverDO> meetCriteria(List<DriverDO> drivers)
    {
       List<DriverDO> maleDrivers = new ArrayList<DriverDO>();
       for (DriverDO driver : drivers) {
           if(driver.getGender().equalsIgnoreCase("male")) {
               maleDrivers.add(driver);
           }
       }
       
       return maleDrivers;
    }

}
