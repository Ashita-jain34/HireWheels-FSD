package com.upgrad.hirewheels.utils;

import com.upgrad.hirewheels.dao.LocationDao;
import com.upgrad.hirewheels.dao.VehicleDao;
import com.upgrad.hirewheels.dao.UserDao;
import com.upgrad.hirewheels.dto.BookingDTO;
import com.upgrad.hirewheels.entities.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DTOEntityConverter {

    @Autowired
    LocationDao locationDao;

    @Autowired
    VehicleDao vehicleDao;

    @Autowired
    UserDao userDao;

    public Booking convertToBookingEntity(BookingDTO bookingDTO) {
        Booking booking = new Booking();
        booking.setBookingId(bookingDTO.getBookingId());
        booking.setAmount(bookingDTO.getAmount());
        booking.setBookingDate(bookingDTO.getBookingDate());
        booking.setDropoffDate(bookingDTO.getDropoffDate());
        booking.setPickupDate(bookingDTO.getPickupDate());
        booking.setLocation(locationDao.findById(bookingDTO.getLocationId()).get());
        booking.setVehicleWithBooking(vehicleDao.findById(bookingDTO.getVehicleId()).get());
        booking.setUser(userDao.findById(bookingDTO.getUserId()).get());
        return booking;
    }

}
