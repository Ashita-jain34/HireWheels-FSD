package com.upgrad.hirewheels.validator;

import com.upgrad.hirewheels.dto.BookingDTO;
import com.upgrad.hirewheels.exceptions.APIException;

import java.text.ParseException;

public interface BookingValidator {
    void validateBooking(BookingDTO vehicle) throws ParseException, APIException;
}
