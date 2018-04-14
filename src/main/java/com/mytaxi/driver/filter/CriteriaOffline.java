package com.mytaxi.driver.filter;

import java.util.ArrayList;
import java.util.List;

import com.mytaxi.domainobject.DriverDO;
import com.mytaxi.domainvalue.OnlineStatus;

public class CriteriaOffline implements DriverCriteria
{
    @Override
    public List<DriverDO> meetCriteria(List<DriverDO> drivers)
    {
       List<DriverDO> offlineDrivers = new ArrayList<DriverDO>();
       for (DriverDO driver : drivers) {
           if(driver.getOnlineStatus().equals(OnlineStatus.OFFLINE)) {
               offlineDrivers.add(driver);
           }
       }
       
       return offlineDrivers;
    }
}
