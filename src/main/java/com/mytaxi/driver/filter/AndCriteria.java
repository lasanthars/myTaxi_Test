package com.mytaxi.driver.filter;

import java.util.List;

import com.mytaxi.domainobject.DriverDO;

public class AndCriteria implements DriverCriteria
{
    private DriverCriteria criteria;
    private DriverCriteria otherCriteria;
    
    public AndCriteria(DriverCriteria criteria, DriverCriteria otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }
    
    @Override
    public List<DriverDO> meetCriteria(List<DriverDO> drivers)
    {
        List<DriverDO> firstCriteriaDrivers = criteria.meetCriteria(drivers);
        return otherCriteria.meetCriteria(firstCriteriaDrivers);
    }

}
