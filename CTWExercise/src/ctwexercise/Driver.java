/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctwexercise;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author gfgma
 */
public class Driver {
    private String name;
    private String contact;
    private String licenceNumber;
    
    private static DataBaseConnection dbConnection = new DataBaseConnection();
    
    public Driver(String name, String contact, String licenceNumber){
        this.name = name;
        this.contact = contact;
        this.licenceNumber = licenceNumber;
    }
    
    public void addDriver(){
        dbConnection.ligarBd();
        
        Connection connection = dbConnection.getConnection();
        
        try {
            Statement statement = connection.createStatement();
            String query = "INSERT INTO driver (Name, Contact, LicenseNumber) "
                                                        + "VALUES ('" + this.name + "', '" + this.contact + "', '" + this.licenceNumber + "')";
            
            statement.executeUpdate(query);
            
            System.out.println("Driver added successfuly.");
		
	} catch (SQLException e) {
            System.out.println(e);
            System.out.println("Driver not added successfuly.");
	}
    }
}
