package com.mytaxi.driver.filter;

import java.util.ArrayList;
import java.util.List;

import com.mytaxi.domainobject.DriverDO;
import com.mytaxi.domainvalue.OnlineStatus;

public class CriteriaOnline implements DriverCriteria
{
    @Override
    public List<DriverDO> meetCriteria(List<DriverDO> drivers)
    {
       List<DriverDO> onlineDrivers = new ArrayList<DriverDO>();
       for (DriverDO driver : drivers) {
           if(driver.getOnlineStatus().equals(OnlineStatus.ONLINE)) {
               onlineDrivers.add(driver);
           }
       }
       
       return onlineDrivers;
    }
}
