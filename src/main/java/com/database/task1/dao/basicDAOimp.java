package com.database.task1.dao;

import com.database.task1.datastream.PersonInformation;
import com.database.task1.datastream.VehicleInformation;
import com.database.task1.entity.*;
import com.database.task1.item.Color;
import com.database.task1.item.RandomString;
import com.database.task1.item.VehicleType;
import com.mysql.jdbc.Driver;
import java.sql.*;
import java.util.ArrayList;
import java.util.Random;

import static com.database.task1.item.RandomString.getRandomString;

public class basicDAOimp implements basicDAO {

    public static final String url = "jdbc:mysql://127.0.0.1:3306/task1?serverTimezone=GMT%2B8&useSSL=false&allowPublicKeyRetrieval=true&useUnicode=true&characterEncoding=utf8";
    public static final String username = "root";
    public static final String password = "root";

    Connection conn ;

    public basicDAOimp() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void insert(int id, String a, String b) throws SQLException {

        String sql = "insert into test1 (id, name, addr) values (?,?,?)";
        PreparedStatement sm = conn.prepareStatement(sql);
        sm.setInt(1,id);
        sm.setString(2, a);
        sm.setString(3,b);
        boolean rs = sm.execute();
    }

    @Override
    public PersonInformation FindDriverByPersonNo(String personNo) throws SQLException {
        String sql = "select * from person where personNo=?";
        PreparedStatement sm = conn.prepareStatement(sql);
        sm.setString(1,personNo);
        ResultSet rs = sm.executeQuery();
        Person person = new Person();
        rs.next();
        person.setPersonNo(rs.getString(1));
        person.setDriverLicenseNo(rs.getString(2));
        person.setName(rs.getString(3));

        String sql1 = "select * from offense where personNo=?";
        PreparedStatement ps = conn.prepareStatement(sql1);
        ps.setString(1,personNo);
        ResultSet res = ps.executeQuery();
        ArrayList<Offense> offenses = new ArrayList<>();
        for (; res.next();) {
            Offense offense = new Offense();
            offense.setOffenseNo(res.getInt(1));
            offense.setLicensePlateNo(res.getString(2));
            offense.setLocation(res.getString(3));
            offense.setTime(res.getString(4));
            offense.setPersonNo(personNo);
            offenses.add(offense);
        }

        ArrayList<Vehicle> vehicles = new ArrayList<>();
        String sql2 = "select * from vehicle where personNo=?";
        PreparedStatement ps1 = conn.prepareStatement(sql2);
        ps1.setString(1,personNo);
        ResultSet res1 = ps1.executeQuery();
        for (; res1.next(); ) {
            Vehicle vehicle = new Vehicle();
            vehicle.setVehicleNo(res1.getInt(1));
            vehicle.setLicensePlateNo(res1.getString(2));
            vehicle.setType(res1.getInt(3));
            vehicle.setPersonNo(res1.getString(4));
            vehicle.setColor(res1.getInt(5));
            vehicles.add(vehicle);
        }

        return new PersonInformation(person.getName(),personNo,person.getDriverLicenseNo(),offenses,vehicles);
    }

    @Override
    public PersonInformation FindDriverByDriverLicenseNo(String driverLicenseNo) throws SQLException {
        String sql = "select * from person where driverLicenseNo=?";
        PreparedStatement sm = conn.prepareStatement(sql);
        sm.setString(1,driverLicenseNo);
        ResultSet rs = sm.executeQuery();
        Person person = new Person();
        rs.next();
        person.setPersonNo(rs.getString(1));
        person.setDriverLicenseNo(rs.getString(2));
        person.setName(rs.getString(3));

        String sql1 = "select * from offense where personNo=?";
        PreparedStatement ps = conn.prepareStatement(sql1);
        ps.setString(1,person.getPersonNo());
        ResultSet res = ps.executeQuery();
        ArrayList<Offense> offenses = new ArrayList<>();
        for (; res.next();) {
            Offense offense = new Offense();
            offense.setOffenseNo(res.getInt(1));
            offense.setLicensePlateNo(res.getString(2));
            offense.setLocation(res.getString(3));
            offense.setTime(res.getString(4));
            offense.setPersonNo(person.getPersonNo());
            offenses.add(offense);
        }

        ArrayList<Vehicle> vehicles = new ArrayList<>();
        String sql2 = "select * from vehicle where personNo=?";
        PreparedStatement ps1 = conn.prepareStatement(sql2);
        ps1.setString(1,person.getPersonNo());
        ResultSet res1 = ps1.executeQuery();
        for (; res1.next(); ) {
            Vehicle vehicle = new Vehicle();
            vehicle.setVehicleNo(res1.getInt(1));
            vehicle.setLicensePlateNo(res1.getString(2));
            vehicle.setType(res1.getInt(3));
            vehicle.setPersonNo(res1.getString(4));
            vehicle.setColor(res1.getInt(5));
            vehicles.add(vehicle);
        }

        return new PersonInformation(person.getName(),person.getPersonNo(),driverLicenseNo,offenses,vehicles);
    }

    @Override
    public VehicleInformation FindVehicleByVehicleNo(int vehicleNo) throws SQLException {
        String sql = "select * from vehicle where vehicleNo=?";
        PreparedStatement sm = conn.prepareStatement(sql);
        sm.setInt(1,vehicleNo);
        ResultSet rs = sm.executeQuery();
        Vehicle vehicle = new Vehicle();
        rs.next();
        vehicle.setVehicleNo(rs.getInt(1));
        vehicle.setLicensePlateNo(rs.getString(2));
        vehicle.setType(rs.getInt(3));
        vehicle.setPersonNo(rs.getString(4));
        vehicle.setColor(rs.getInt(5));

        String sql1 = "select * from offense inner join vehicle on offense.licensePlateNo=vehicle.licensePlateNo where vehicleNo=?";
        PreparedStatement ps = conn.prepareStatement(sql1);
        ps.setInt(1,vehicleNo);
        ResultSet res = ps.executeQuery();
        ArrayList<Offense> offenses = new ArrayList<>();
        for (; res.next();) {
            Offense offense = new Offense();
            offense.setOffenseNo(res.getInt(1));
            offense.setLicensePlateNo(res.getString(2));
            offense.setLocation(res.getString(3));
            offense.setTime(res.getString(4));
            offense.setPersonNo(res.getString(5));
            offenses.add(offense);
        }

        return new VehicleInformation(vehicleNo,vehicle.getLicensePlateNo(),vehicle.getType(),vehicle.getPersonNo(),vehicle.getColor(),offenses);
    }

    @Override
    public VehicleInformation FindVehicleByLicensePlateNo(String licensePlateNo) throws SQLException {
        String sql = "select * from vehicle where licensePlateNo=?";
        PreparedStatement sm = conn.prepareStatement(sql);
        sm.setString(1,licensePlateNo);
        ResultSet rs = sm.executeQuery();
        Vehicle vehicle = new Vehicle();
        rs.next();
        vehicle.setVehicleNo(rs.getInt(1));
        vehicle.setLicensePlateNo(rs.getString(2));
        vehicle.setType(rs.getInt(3));
        vehicle.setPersonNo(rs.getString(4));
        vehicle.setColor(rs.getInt(5));

        String sql1 = "select * from offense where licensePlateNo=?";
        PreparedStatement ps = conn.prepareStatement(sql1);
        ps.setString(1,licensePlateNo);
        ResultSet res = ps.executeQuery();
        ArrayList<Offense> offenses = new ArrayList<>();
        for (; res.next();) {
            Offense offense = new Offense();
            offense.setOffenseNo(res.getInt(1));
            offense.setLicensePlateNo(res.getString(2));
            offense.setLocation(res.getString(3));
            offense.setTime(res.getString(4));
            offense.setPersonNo(res.getString(5));
            offenses.add(offense);
        }

        return new VehicleInformation(vehicle.getVehicleNo(),licensePlateNo,vehicle.getType(),vehicle.getPersonNo(),vehicle.getColor(),offenses);
    }

    @Override
    public ArrayList<Offense> FindOffense() throws SQLException {
        String sql = "select * from offense where personNo is null";
        PreparedStatement sm = conn.prepareStatement(sql);
        ResultSet rs = sm.executeQuery();

        ArrayList<Offense> offenses = new ArrayList<>();
        while (rs.next()) {
            Offense offense = new Offense();
            offense.setOffenseNo(rs.getInt(1));
            offense.setLicensePlateNo(rs.getString(2));
            offense.setLocation(rs.getString(3));
            offense.setTime(rs.getString(4));
            offense.setPersonNo(rs.getString(5));
            offenses.add(offense);
        }

        return offenses;
    }

    @Override
    public void ClaimOffense(String offenseNo, String driverLicenseNo) throws SQLException {
        PersonInformation personInformation = FindDriverByDriverLicenseNo(driverLicenseNo);
        String personNo = personInformation.getPersonNo();

        String sql = "update offense set personNo=? where offenseNo=?";
        PreparedStatement sm = conn.prepareStatement(sql);
        sm.setString(1,personNo);
        sm.setString(2,offenseNo);
        boolean rs = sm.execute();
    }

    @Override
    public void DeleteVehicle(int vehicleNo) throws SQLException {
        String sql = "delete from vehicle where vehicleNo=?";
        PreparedStatement sm = conn.prepareStatement(sql);
        sm.setInt(1,vehicleNo);
        boolean rs = sm.execute();
    }

    @Override
    public void AddVehicle(String personNo, Color color, VehicleType type) throws SQLException {
        try {
            Random r = new Random();
            int vehicleNo = r.nextInt(1000000);
            String licensePlateNo = RandomString.getRandomString(8);
            String sql = "insert into vehicle (vehicleNo,licensePlateNo,type,personNo,color) values (?,?,?,?,?)";
            PreparedStatement sm = conn.prepareStatement(sql);
            sm.setInt(1,vehicleNo);
            sm.setString(2,licensePlateNo);
            sm.setInt(3,type.getValue());
            sm.setString(4,personNo);
            sm.setInt(5,color.getValue());
            boolean rs = sm.execute();
        } catch (Exception e) {
            AddVehicle(personNo,color,type);
        }
    }

    @Override
    public void AddOffense(String licensePlateNo, String time, String location) throws SQLException {
        Random r = new Random();
        int offenseNo = r.nextInt(1000000);
        String sql = "insert into offense (offenseNo,licensePlateNo,location,time) values (?,?,?,?)";
        PreparedStatement sm = conn.prepareStatement(sql);
        sm.setInt(1,offenseNo);
        sm.setString(2,licensePlateNo);
        sm.setString(3,location);
        sm.setString(4,time);
        boolean rs = sm.execute();
    }

    @Override
    public void DeleteOffense(int offenseNo) throws SQLException {
        String sql = "delete from offense where offenseNo=?";
        PreparedStatement sm = conn.prepareStatement(sql);
        sm.setInt(1,offenseNo);
        boolean rs = sm.execute();
    }

    @Override
    public Offense FindOffenseByOffenseNo(int offenseNo) throws SQLException {
        String sql = "select * from offense where offenseNo=?";
        PreparedStatement sm = conn.prepareStatement(sql);
        sm.setInt(1,offenseNo);
        ResultSet rs = sm.executeQuery();
        rs.next();
        Offense offense = new Offense();
        offense.setOffenseNo(rs.getInt(1));
        offense.setLicensePlateNo(rs.getString(2));
        offense.setLocation(rs.getString(3));
        offense.setTime(rs.getString(4));
        offense.setPersonNo(rs.getString(5));
        return offense;
    }

    private Vehicle FindVehicleByLicensePlateNo(int licensePlateNo) throws SQLException {
        String sql = "select * from vehicle where licensePlateNo=?";
        PreparedStatement sm = conn.prepareStatement(sql);
        sm.setInt(1,licensePlateNo);
        ResultSet rs = sm.executeQuery();
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleNo(rs.getInt(1));
        vehicle.setLicensePlateNo(rs.getString(2));
        vehicle.setType(rs.getInt(3));
        vehicle.setPersonNo(rs.getString(4));
        vehicle.setColor(rs.getInt(5));
        return vehicle;
    }
}
