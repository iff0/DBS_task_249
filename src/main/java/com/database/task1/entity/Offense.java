package com.database.task1.entity;

public class Offense {
    int offenseNo;
    String licensePlateNo;
    String location;
    String time;
    String personNo;

    public void setOffenseNo(int offenseNo) {
        this.offenseNo = offenseNo;
    }

    public void setLicensePlateNo(String licensePlateNo) {
        this.licensePlateNo = licensePlateNo;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setPersonNo(String personNo) {
        this.personNo = personNo;
    }

    public int getOffenseNo() {
        return offenseNo;
    }

    public String getLicensePlateNo() {
        return licensePlateNo;
    }

    public String getLocation() {
        return location;
    }

    public String getTime() {
        return time;
    }

    public String getPersonNo() {
        return personNo;
    }

    @Override
    public String toString() {
        return offenseNo+" "+licensePlateNo+" "+location+" "+time+" "+personNo;
    }
}
