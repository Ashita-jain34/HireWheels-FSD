package com.upgrad.hirewheels.services;

import com.upgrad.hirewheels.entities.Vehicle;
import com.upgrad.hirewheels.exceptions.VehicleNotFoundException;
import com.upgrad.hirewheels.exceptions.VehicleNumberNotUniqueException;

public interface AdminService {
    Vehicle registerVehicle(Vehicle vehicle) throws VehicleNumberNotUniqueException;
    Vehicle changeAvailability(int vehicleId, int availabilityStatus)throws VehicleNotFoundException;
}
