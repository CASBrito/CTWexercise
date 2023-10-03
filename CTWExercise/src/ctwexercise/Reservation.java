/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctwexercise;

import java.sql.*;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gfgma
 */
public class Reservation {
    private Timestamp pickupDate;
    private Timestamp dropOffDate;
    
    private static DataBaseConnection dbConnection = new DataBaseConnection();
    
    private static Driver driver;
    
    Scanner myObj = new Scanner(System.in);
    
    public void newReservation(Timestamp pickupDate, Timestamp dropOffDate){
        
        this.pickupDate = pickupDate;
        this.dropOffDate = dropOffDate;
        
        dbConnection.ligarBd();
        
        Connection connection = dbConnection.getConnection();
        
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from car");
            
                while(resultSet.next()){
                    System.out.println("Car Model: " + resultSet.getString(3));                   
                }
                
                System.out.println("Please select the car to reserve: ");
                String model = myObj.nextLine();
                
                ResultSet resultSetID = statement.executeQuery("select idCar from car where model='" + model + "'");
                resultSetID.next();
                int idCar = resultSetID.getInt(1);
                
                System.out.println("Insert driver info");
                System.out.print("Name: ");
                String name = myObj.nextLine();
                System.out.print("Contact: ");
                String contact = myObj.nextLine();
                System.out.print("Licence Number: ");
                String licenceNumber = myObj.nextLine();
                
                driver = new Driver(name, contact, licenceNumber);
                driver.addDriver();
                
                ResultSet resultSetDriver = statement.executeQuery("select idDriver from driver where name='" + name + "'");
                resultSetDriver.next();
                int idDriver = resultSetDriver.getInt(1);
                
                String query = "INSERT INTO reservation (car_idCar, Driver_idDriver, pickupDate, dropOffDate) VALUES ('" + idCar + "', '" + idDriver + "', '" + this.pickupDate + "', '" + this.dropOffDate + "')";
                
                statement.executeUpdate(query);
                
                System.out.println("Reservation created successfuly");
		
	} catch (SQLException e) {
            System.out.println(e);
	}
        
    }
    
    public void checkReservation(){
        
        dbConnection.ligarBd();
            
        Connection connection = dbConnection.getConnection();
            
        try{
            
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select idReservation, pickupDate, DropOffDate from reservation");
            
        while(resultSet.next()){
            System.out.println("Reservation ID: " + resultSet.getInt(1) + ", Pickup Date: " + resultSet.getTimestamp(2) + ", Drop Off Date: " + resultSet.getTimestamp(3));
        }
            
        } catch (SQLException ex) {
            
            Logger.getLogger(Reservation.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
}
