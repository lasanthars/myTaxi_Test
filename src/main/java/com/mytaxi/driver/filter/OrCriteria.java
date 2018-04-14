package com.mytaxi.driver.filter;

import java.util.List;

import com.mytaxi.domainobject.DriverDO;

public class OrCriteria implements DriverCriteria
{

    private DriverCriteria criteria;
    private DriverCriteria otherCriteria;
    
    public OrCriteria(DriverCriteria criteria, DriverCriteria otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }
    
    @Override
    public List<DriverDO> meetCriteria(List<DriverDO> drivers)
    {
        List<DriverDO> firstCriteriaDrivers = criteria.meetCriteria(drivers);
        List<DriverDO> otherCriteriaDrivers = otherCriteria.meetCriteria(drivers);
        
        for( DriverDO  driver : otherCriteriaDrivers) {
            if(!firstCriteriaDrivers.contains(driver)) {
                firstCriteriaDrivers.add(driver);
            }
        }
        return firstCriteriaDrivers;
    }

}
