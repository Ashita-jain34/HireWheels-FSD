package com.upgrad.hirewheels.validator;

import com.upgrad.hirewheels.dto.VehicleDTO;
import com.upgrad.hirewheels.exceptions.APIException;

public interface AdminRequestValidator {
    void validateChangeVehicleAvailability (int availability_status) throws APIException;
    void validateAddVehicleRequest(VehicleDTO vehicleDTO) throws APIException;
}
