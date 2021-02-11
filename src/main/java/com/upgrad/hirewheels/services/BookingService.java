package com.upgrad.hirewheels.services;

import com.upgrad.hirewheels.entities.Booking;
import com.upgrad.hirewheels.exceptions.APIException;
import com.upgrad.hirewheels.exceptions.InsufficientBalanceException;

public interface BookingService {
    Booking addBooking(Booking booking) throws APIException, InsufficientBalanceException;
}
