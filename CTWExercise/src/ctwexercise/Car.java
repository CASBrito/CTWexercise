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
    public Car(String brand, String model, int seats, String licencePlate, String engineTypeValue, int currentAutonomy, BufferedImage image){
        
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
    
    public void addCar(){
        
        dbConnection.ligarBd();
        
        Connection connection = dbConnection.getConnection();
        
        try {
            Statement statement = connection.createStatement();
            String query = "INSERT INTO car (Brand, Model, Seats, LicencePlate, EngineType, CurrentAutonomy) "
                                                        + "VALUES (" + this.brand + ", " + this.model + ", " + this.seats + ", " + this.licencePlate + ", " + this.engineType + ", " + this.currentAutonomy + ")";
            statement.executeUpdate(query);
            
            System.out.println("Car added successfuly.");
		
	} catch (SQLException e) {
            System.out.println(e);
            System.out.println("Car not added successfuly.");
	}
    }
    
    public ResultSet getCar(){
        
        dbConnection.ligarBd();
        
        Connection connection = dbConnection.getConnection();
        
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from car");
            
            return resultSet;
		
	} catch (SQLException e) {
            System.out.println(e);
	}
        
        return null;
        
    }
    
    public ResultSet getCarDetail(String model){
        
        dbConnection.ligarBd();
        
        Connection connection = dbConnection.getConnection();
        
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from car where model='" + model + "'");
            
            return resultSet;
		
	} catch (SQLException e) {
            System.out.println(e);
	}
        
        return null;
        
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
