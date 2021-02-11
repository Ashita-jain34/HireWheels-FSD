package com.upgrad.hirewheels.utils;

import com.upgrad.hirewheels.dto.BookingDTO;
import com.upgrad.hirewheels.entities.Booking;
import org.springframework.stereotype.Component;

@Component
public class EntityDTOConverter {

    public BookingDTO convertToBookingDTO(Booking booking) {
        BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setBookingId(booking.getBookingId());
        bookingDTO.setAmount(booking.getAmount());
        bookingDTO.setBookingDate(booking.getBookingDate());
        bookingDTO.setDropoffDate(booking.getDropoffDate());
        bookingDTO.setPickupDate(booking.getPickupDate());
        bookingDTO.setLocationId(booking.getLocation().getLocationId());
        bookingDTO.setVehicleId(booking.getVehicleWithBooking().getVehicleId());
        bookingDTO.setUserId(booking.getUser().getUserId());
        return bookingDTO;
    }
}

