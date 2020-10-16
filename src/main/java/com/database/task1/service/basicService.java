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
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping("/service")
public class basicService {

    basicDAOimp basicdaoimp = new basicDAOimp();

    public basicService() throws SQLException {
    }

    @PostMapping("/FindDriverByPersonNo")
    public PersonInformation FindDriverByPersonNo(@RequestParam("personNo") String personNo) {
        try {
            return basicdaoimp.FindDriverByPersonNo(personNo);
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping("/driverLicenseNo")
    public PersonInformation FindDriverByDriverLicenseNo(@RequestParam("driverLicenseNo") String driverLicenseNo) {
        try {
            return basicdaoimp.FindDriverByDriverLicenseNo(driverLicenseNo);
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping("/vehicleNo")
    public VehicleInformation FindVehicleByVehicleNo(@RequestParam("vehicleNo") int vehicleNo) {
        try {
            return basicdaoimp.FindVehicleByVehicleNo(vehicleNo);
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping("/licensePlateNo")
    public VehicleInformation FindVehicleByLicensePlateNo(@RequestParam("licensePlateNo") String licensePlateNo)  {
        try {
            return basicdaoimp.FindVehicleByLicensePlateNo(licensePlateNo);
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping("/FindOffense")
    public ArrayList<Offense> FindOffense() {
        try {
            return basicdaoimp.FindOffense();
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping("/ClaimOffense")
    public boolean ClaimOffense(@RequestParam("offenseNo")String offenseNo,@RequestParam("driverLicenseNo") String driverLicenseNo) {
        try {
            basicdaoimp.ClaimOffense(offenseNo, driverLicenseNo);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @PostMapping("/DeleteVehicle")
    public boolean DeleteVehicle(@RequestParam("vehicleNo")int vehicleNo) {
        try {
            basicdaoimp.DeleteVehicle(vehicleNo);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @PostMapping("/AddVehicle")
    public boolean AddVehicle(@RequestParam("personNo")String personNo,@RequestParam("color") int color,@RequestParam("type") int type)  {
        try {
            try {
                basicdaoimp.FindDriverByPersonNo(personNo);
            } catch (Exception e) {
                return false;
            }
            basicdaoimp.AddVehicle(personNo,Color.valueOf(color),VehicleType.valueOf(type));
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @PostMapping("/AddOffense")
    public boolean AddOffense(@RequestParam("licensePlateNo") String licensePlateNo,@RequestParam("time") String time,@RequestParam("location") String location)  {
        try {
            basicdaoimp.AddOffense(licensePlateNo, time, location);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @PostMapping("/DeleteOffense")
    public boolean DeleteOffense(@RequestParam("offenseNo") int offenseNo)  {
        try {
            basicdaoimp.DeleteOffense(offenseNo);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @PostMapping("/FindOffenseByOffenseNo")
    public Offense FindOffenseByOffenseNo(@RequestParam("offenseNo") int offenseNo) {
        try {
            return basicdaoimp.FindOffenseByOffenseNo(offenseNo);
        } catch (Exception e) {
            return null;
        }
    }

}
