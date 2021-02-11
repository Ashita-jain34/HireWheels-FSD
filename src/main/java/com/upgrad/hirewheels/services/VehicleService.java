package com.upgrad.hirewheels.services;

import com.upgrad.hirewheels.entities.Vehicle;
import com.upgrad.hirewheels.exceptions.APIException;

import java.util.Date;
import java.util.List;

public interface VehicleService {
    public List<Vehicle> getAvailableVehicles(String categoryName, Date pickUpDate, Date dropDate, int locationId) throws APIException;
    public List<Vehicle> getAllVehicles() throws APIException;
}
