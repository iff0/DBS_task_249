package com.database.task1.entity;

public class Person {
    String name;      //name
    String personNo;   //身份证号
    String driverLicenseNo; //驾照编号

    public String getName() {
        return name;
    }

    public String getPersonNo() {
        return personNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPersonNo(String personNo) {
        this.personNo = personNo;
    }

    public String getDriverLicenseNo() {
        return driverLicenseNo;
    }

    public void setDriverLicenseNo(String driverLicenseNo) {
        this.driverLicenseNo = driverLicenseNo;
    }

}
