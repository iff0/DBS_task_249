package com.database.task1;

import com.database.task1.dao.basicDAOimp;
import com.database.task1.datastream.PersonInformation;
import com.database.task1.datastream.VehicleInformation;
import com.database.task1.entity.Vehicle;
import com.database.task1.item.Color;
import com.database.task1.item.VehicleType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootTest
class Task1ApplicationTests {

  /*  @Test
    void contextLoads() {
    }


    @Test
    void testselect() throws SQLException {
        basicDAOimp  daOimp = new basicDAOimp();
        PersonInformation personInformation = daOimp.FindDriverByDriverLicenseNo("123");
        System.out.println(personInformation);
        for (Vehicle vehicle : personInformation.getVehicles()) {
            System.out.println(vehicle);
        }
    }

    @Test
    void testveh() throws SQLException {
        basicDAOimp  daOimp = new basicDAOimp();
        VehicleInformation vehicleInformation = daOimp.FindVehicleByVehicleNo(123);
        System.out.println(vehicleInformation);
    }

    @Test
    void estfindoffense() throws SQLException {
        basicDAOimp  daOimp = new basicDAOimp();
        System.out.println(daOimp.FindOffense());
    }

    @Test
    void testclaim() throws SQLException {
        basicDAOimp  daOimp = new basicDAOimp();
        daOimp.ClaimOffense("796","4444");
    }

    @Test
    void testinsert() throws SQLException {
        basicDAOimp  daOimp = new basicDAOimp();
        daOimp.AddVehicle("ery", Color.RED, VehicleType.SALOON);
    }

    @Test
    void testinsertoffense() throws SQLException {
        basicDAOimp  daOimp = new basicDAOimp();
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        daOimp.AddOffense("ppp", dateTime.format(formatter),"here");
    }

    @Test
    void testdelete() throws SQLException {
        basicDAOimp  daOimp = new basicDAOimp();
        daOimp.DeleteOffense(752);
        daOimp.DeleteVehicle(565);
    }

    @Test
    void testfindoffensebyno() throws SQLException {
        basicDAOimp  daOimp = new basicDAOimp();
        System.out.println(daOimp.FindOffenseByOffenseNo(366553));
    }*/
}
