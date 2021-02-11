package com.upgrad.hirewheels.controllers;

import com.upgrad.hirewheels.dto.BookingDTO;
import com.upgrad.hirewheels.entities.Booking;
import com.upgrad.hirewheels.exceptions.APIException;
import com.upgrad.hirewheels.exceptions.InsufficientBalanceException;
import com.upgrad.hirewheels.services.BookingService;
import com.upgrad.hirewheels.utils.DTOEntityConverter;
import com.upgrad.hirewheels.utils.EntityDTOConverter;
import com.upgrad.hirewheels.validator.BookingValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping(value="/hirewheels/v1")
public class BookingController {

    @Autowired
    DTOEntityConverter dtoEntityConverter;

    @Autowired
    EntityDTOConverter entityDTOConverter;

    @Autowired
    BookingService bookingService;

    @Autowired
    BookingValidator bookingValidator;

    /**
     *
     * @param bookingDTO
     * @throws APIException
     * @throws ParseException
     * @throws InsufficientBalanceException
     */
    @PostMapping("/bookings")
    public ResponseEntity addBooking(@RequestBody BookingDTO bookingDTO) throws APIException, ParseException, InsufficientBalanceException {
        ResponseEntity responseEntity = null;
        bookingValidator.validateBooking(bookingDTO);
        Booking booking = dtoEntityConverter.convertToBookingEntity(bookingDTO);
        Booking responseBooking = bookingService.addBooking(booking);
        responseEntity = ResponseEntity.ok(entityDTOConverter.convertToBookingDTO(responseBooking));
        return responseEntity;
    }

}
