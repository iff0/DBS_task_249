package com.database.task1.datastream;

import com.database.task1.entity.Vehicle;

import java.util.ArrayList;

public class PersonInformation {
    String name;      //name
    String personNo;   //身份证号
    String driverLicenseNo; //驾照编号
    ArrayList<String> offenseNo; //违章记录
    ArrayList<Vehicle> Vehicles;       //车辆信息

    public PersonInformation(String name, String personNo, String driverLicenseNo, ArrayList<String> offenseNo, ArrayList<Vehicle> vehicles) {
        this.name = name;
        this.personNo = personNo;
        this.driverLicenseNo = driverLicenseNo;
        this.offenseNo = offenseNo;
        Vehicles = vehicles;
    }

    public String getName() {
        return name;
    }

    public String getPersonNo() {
        return personNo;
    }

    public String getDriverLicenseNo() {
        return driverLicenseNo;
    }

    public ArrayList<String> getOffenseNo() {
        return offenseNo;
    }

    public ArrayList<Vehicle> getVehicles() {
        return Vehicles;
    }

    @Override
    public String toString() {
        return name + " " + personNo + driverLicenseNo + offenseNo + Vehicles;
    }
}
