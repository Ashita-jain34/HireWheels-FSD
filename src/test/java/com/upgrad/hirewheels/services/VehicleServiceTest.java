package com.upgrad.hirewheels.services;

import com.upgrad.hirewheels.dao.FuelTypeDao;
import com.upgrad.hirewheels.dao.LocationDao;
import com.upgrad.hirewheels.dao.VehicleDao;
import com.upgrad.hirewheels.dao.VehicleSubcategoryDao;
import com.upgrad.hirewheels.entities.Vehicle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class VehicleServiceTest {

    @Autowired
    VehicleSubcategoryDao vehicleSubcategoryDao;

    @Autowired
    LocationDao locationDao;

    @Autowired
    FuelTypeDao fuelTypeDao;

    @Mock
    private VehicleDao vehicleDao;

    @InjectMocks
    private VehicleServiceImpl vehicleService;

    @BeforeEach
    public void setupMockito() {
        Mockito.when(vehicleDao.save(new Vehicle("Bat mobile", "JH05AN5799","Blue", 1,"ImageURL", vehicleSubcategoryDao.findById(1).get(),locationDao.findById(1).get(),fuelTypeDao.findById(1).get() )))
                .thenReturn(new Vehicle(1,"Bat mobile", "JH05AN5799","Blue", 1,"ImageURL", vehicleSubcategoryDao.findById(1).get(),locationDao.findById(1).get(),fuelTypeDao.findById(1).get()));
        List<Vehicle> vehiclesList = new ArrayList<Vehicle>();
        vehiclesList.add(new Vehicle(1, "Bat mobile", "JH05AN5799", "Blue", 1, "ImageURL", vehicleSubcategoryDao.findById(1).get(), locationDao.findById(1).get(), fuelTypeDao.findById(1).get()));
        Mockito.when(vehicleDao.findAll()).thenReturn(vehiclesList);
    }

    @Test
    public void testGetAllVehicles() {
        Vehicle vehicle1 = new Vehicle("Bat mobile", "JH05AN5799","Blue", 1,"ImageURL", vehicleSubcategoryDao.findById(1).get(),locationDao.findById(1).get(),fuelTypeDao.findById(1).get());
        vehicleDao.save(vehicle1);
        List<Vehicle> allVehicles= vehicleService.getAllVehicles();
        Assertions.assertEquals(1, allVehicles.size());
        Assertions.assertNotNull(allVehicles);
    }

}
