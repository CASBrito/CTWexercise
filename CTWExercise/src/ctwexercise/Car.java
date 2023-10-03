/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctwexercise;

import java.awt.image.BufferedImage;
import ctwexercise.EngineType;
import java.sql.*;

/**
 *
 * @author gfgma
 */
public class Car {
    private int id;
    private String brand;
    private String model;
    private int seats;
    private String licencePlate;
    //private enum EngineType{COMBUSTION, ELECTRIC, HYBRID;};
    private EngineType engineType;
    private int currentAutonomy;
    private BufferedImage image;
    
    private static DataBaseConnection dbConnection = new DataBaseConnection();
    
    //Construtor
    public Car(String brand, String model, int seats, String licencePlate, String engineTypeValue, int currentAutonomy){
        
        dbConnection.ligarBd();
        
        Connection connection = dbConnection.getConnection();        
               
        this.brand = brand;
        this.model = model;
        this.seats = seats;
        this.licencePlate = licencePlate;
        this.engineType = EngineType.valueOf(engineTypeValue);
        this.currentAutonomy = currentAutonomy;
        this.image = image;
        
    }
        
    //Empty Constructor
    public Car(){}
    
    public void addCar(){
        
        dbConnection.ligarBd();
        
        Connection connection = dbConnection.getConnection();
        
        try {
            Statement statement = connection.createStatement();
            String query = "INSERT INTO car(Brand, Model, Seats, LicensePlate, EngineType, CurrentAutonomy) "
                                                        + "VALUES ('" + this.brand + "', '" + this.model + "', '" + this.seats + "', '" + this.licencePlate + "', '" + this.engineType + "', '" + this.currentAutonomy + "')";
            statement.executeUpdate(query);
            
            System.out.println("Car added successfuly.");
		
	} catch (SQLException e) {
            System.out.println(e);
            System.out.println("Car not added successfuly.");
	}
    }
    
    public void getCar(){
        
        dbConnection.ligarBd();
        
        Connection connection = dbConnection.getConnection();
        
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from car");
            
            while (resultSet.next()){
                System.out.println("Car Model: " + resultSet.getString(3));
            }
		
	} catch (SQLException e) {
            System.out.println(e);
	}
        
    }
    
    public void getCarDetail(String model){
        
        dbConnection.ligarBd();
        
        Connection connection = dbConnection.getConnection();
        
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from car where model='" + model + "'");
            
            resultSet.next();
            System.out.println("Car Brand: " + resultSet.getString(2));
            System.out.println("Car Model: " + resultSet.getString(3));
            System.out.println("Car Seats: " + resultSet.getInt(4));
            System.out.println("Car License Plate: " + resultSet.getString(5));
            System.out.println("Car EngineType: " + resultSet.getString(6));
            System.out.println("Car Current Autonomy: " + resultSet.getInt(7));            
		
	} catch (SQLException e) {
            System.out.println(e);
	}
        
    }
    
    public void deleteCar(String carModel){
        
        dbConnection.ligarBd();
        
        Connection connection = dbConnection.getConnection();
        
        try {
            Statement statement = connection.createStatement();
            String query = "delete from car where model='" + carModel + "'";
            
            statement.executeUpdate(query);
            
            System.out.println("Car deleted successfuly.");
		
	} catch (SQLException e) {
            System.out.println(e);
            
            System.out.println("Car not deleted.");
	}
        
    }
}
