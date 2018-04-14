package com.mytaxi.driver.filter;

import java.util.List;

import com.mytaxi.domainobject.DriverDO;

public interface DriverCriteria
{
    public List<DriverDO> meetCriteria(List<DriverDO> drivers);
}
