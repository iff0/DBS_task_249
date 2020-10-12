package com.database.task1.entity;

import com.database.task1.item.Color;
import com.database.task1.item.VehicleType;

public class Vehicle {
    int vehicleNo;
    String licensePlateNo;
    VehicleType type;
    String personNo;
    Color color;

    public int getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(int vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getLicensePlateNo() {
        return licensePlateNo;
    }

    public void setLicensePlateNo(String licensePlateNo) {
        this.licensePlateNo = licensePlateNo;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(int value) {
        this.type = VehicleType.valueOf(value);
    }

    public String getPersonNo() {
        return personNo;
    }

    public void setPersonNo(String personNo) {
        this.personNo = personNo;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(int value) {
        this.color = Color.valueOf(value);
    }

    @Override
    public String toString() {
        return vehicleNo +" "+licensePlateNo+" "+type+" "+personNo+" "+color;
    }
}
