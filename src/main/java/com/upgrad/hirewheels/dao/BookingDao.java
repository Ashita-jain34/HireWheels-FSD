package com.upgrad.hirewheels.dao;

import com.upgrad.hirewheels.entities.Booking;
import com.upgrad.hirewheels.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingDao extends JpaRepository<Booking, Integer> {
    List<Booking> findByVehicleWithBooking(Vehicle vehicle);
}
