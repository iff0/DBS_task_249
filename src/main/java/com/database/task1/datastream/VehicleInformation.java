package com.database.task1.datastream;

import com.database.task1.item.Color;
import com.database.task1.item.VehicleType;

import java.util.ArrayList;

public class VehicleInformation {
    int vehicleNo;
    String licensePlateNo;
    VehicleType type;
    String personNo;
    Color color;
    ArrayList<String> offenseNo;

    public VehicleInformation(int vehicleNo, String licensePlateNo, VehicleType type, String personNo, Color color, ArrayList<String> offenseNo) {
        this.vehicleNo = vehicleNo;
        this.licensePlateNo = licensePlateNo;
        this.type = type;
        this.personNo = personNo;
        this.color = color;
        this.offenseNo = offenseNo;
    }

    public int getVehicleNo() {
        return vehicleNo;
    }

    public String getLicensePlateNo() {
        return licensePlateNo;
    }

    public VehicleType getType() {
        return type;
    }

    public String getPersonNo() {
        return personNo;
    }

    public Color getColor() {
        return color;
    }

    public ArrayList<String> getOffenseNo() {
        return offenseNo;
    }

    @Override
    public String toString() {
        return vehicleNo+" " + licensePlateNo+" "+type+" "+personNo+" "+color+" "+offenseNo;
    }
}
