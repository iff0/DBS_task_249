package com.database.task1.dao;

import com.database.task1.datastream.PersonInformation;
import com.database.task1.datastream.VehicleInformation;
import com.database.task1.item.Color;
import com.database.task1.entity.Offense;
import com.database.task1.item.VehicleType;

import java.sql.SQLException;
import java.util.ArrayList;

public interface basicDAO {

    public void insert(int id, String a, String b) throws SQLException;

    public PersonInformation FindDriverByPersonNo(String personNo) throws SQLException;

    public PersonInformation FindDriverByDriverLicenseNo(String driverLicenseNo) throws SQLException;

    public VehicleInformation FindVehicleByVehicleNo(int vehicleNo) throws SQLException;

    public VehicleInformation FindVehicleByLicensePlateNo(String licensePlateNo) throws SQLException;

    public ArrayList<Offense> FindOffense() throws SQLException;

    public void ClaimOffense(String offenseNo, String driverLicenseNo) throws SQLException;

    public void DeleteVehicle(int vehicleNo) throws SQLException;

    public void AddVehicle(String personNo, Color color, VehicleType type) throws SQLException;

    public void AddOffense(String licensePlateNo, String time, String location) throws SQLException;

    public void DeleteOffense(int offenseNo) throws SQLException;

    public Offense FindOffenseByOffenseNo(int offenseNo) throws  SQLException;

}
