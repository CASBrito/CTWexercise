/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctwexercise;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author gfgma
 */
public class DataBaseConnection {
        private String url = "jdbc:mysql://localhost:3306/ctwexercise";
	private String username = "root";
        
        //Mudar palavra passe para a palavra passe apropriada
	private String password = "carlosbrito543990";
        
	private Connection connection;
	
	public void ligarBd() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection = DriverManager.getConnection(url, username, password);
			
			//teste de connection
			/*Statement statement = connection.createStatement();
			
			ResultSet resultSet = statement.executeQuery("SELECT * FROM idoso");
			
			while (resultSet.next()) {
				System.out.println(resultSet.getString(2));
			}*/
		}
		catch (Exception e) {
			System.out.println(e);
			
		}
	}
	
	public Connection getConnection() {
		return connection;
	}
}
