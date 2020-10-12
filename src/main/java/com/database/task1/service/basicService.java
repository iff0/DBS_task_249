package com.database.task1.service;

import com.database.task1.dao.basicDAOimp;
import com.database.task1.datastream.PersonInformation;
import com.database.task1.datastream.VehicleInformation;
import com.database.task1.entity.Offense;
import com.database.task1.item.Color;
import com.database.task1.item.VehicleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.ArrayList;

@RestController
public class basicService {

    basicDAOimp basicdaoimp = new basicDAOimp();

    public basicService() throws SQLException {
    }

    @PostMapping("/FindDriverByPersonNo")
    public PersonInformation FindDriverByPersonNo(@RequestParam("personNo") String personNo) throws SQLException {
        return basicdaoimp.FindDriverByPersonNo(personNo);
    }

    @PostMapping("/driverLicenseNo")
    public PersonInformation FindDriverByDriverLicenseNo(@RequestParam("driverLicenseNo") String driverLicenseNo) throws SQLException {
        return basicdaoimp.FindDriverByDriverLicenseNo(driverLicenseNo);
    }

    @PostMapping("/vehicleNo")
    public VehicleInformation FindVehicleByVehicleNo(@RequestParam("vehicleNo") int vehicleNo) throws SQLException {
        return basicdaoimp.FindVehicleByVehicleNo(vehicleNo);
    }

    @PostMapping("/licensePlateNo")
    public VehicleInformation FindVehicleByLicensePlateNo(@RequestParam("licensePlateNo") String licensePlateNo) throws SQLException {
        return basicdaoimp.FindVehicleByLicensePlateNo(licensePlateNo);
    }

    @PostMapping("/FindOffense")
    public ArrayList<Offense> FindOffense() throws SQLException {
        return basicdaoimp.FindOffense();
    }

    @PostMapping("/ClaimOffense")
    public void ClaimOffense(@RequestParam("offenseNo")String offenseNo,@RequestParam("driverLicenseNo") String driverLicenseNo) throws SQLException {
        basicdaoimp.ClaimOffense(offenseNo, driverLicenseNo);
    }

    @PostMapping("/DeleteVehicle")
    public void DeleteVehicle(@RequestParam("vehicleNo")int vehicleNo) throws SQLException {
        basicdaoimp.DeleteVehicle(vehicleNo);
    }

    @PostMapping("/AddVehicle")
    public void AddVehicle(@RequestParam("personNo")String personNo,@RequestParam("color") int color,@RequestParam("type") int type) throws SQLException {
        basicdaoimp.AddVehicle(personNo,Color.valueOf(color),VehicleType.valueOf(type));
    }

    @PostMapping("/AddOffense")
    public void AddOffense(@RequestParam("licensePlateNo") String licensePlateNo,@RequestParam("time") String time,@RequestParam("location") String location) throws SQLException {
        basicdaoimp.AddOffense(licensePlateNo, time, location);
    }

    @PostMapping("/DeleteOffense")
    public void DeleteOffense(@RequestParam("offenseNo") int offenseNo) throws SQLException {
        basicdaoimp.DeleteOffense(offenseNo);
    }

    @PostMapping("/FindOffenseByOffenseNo")
    public Offense FindOffenseByOffenseNo(@RequestParam("offenseNo") int offenseNo) throws  SQLException {
        return basicdaoimp.FindOffenseByOffenseNo(offenseNo);
    }

}
