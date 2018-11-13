/**************************************************** 
Program Name: CustomerDB.java 
Programmer's Name: Peter Parkinson 
Program Description: This file contains the database
connection commands for the Flooring app
***********************************************************/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerDB {

	private static String url = "jdbc:mysql://<url here>";
	private static String login = "<username here>";
	private static String password = "<password here>";
    private static Connection conn = null; 
    
    public static void AddNewCustomer(Customer customer)
    {	PreparedStatement insertStmt;
    	String insertQuery = "Insert into Orders (Name, Address, FloorType, Area, Cost) values (?, ?, ?, ?, ?) ";
    	
    	try
        {    	
            //get connection
            conn = DriverManager.getConnection(url, login, password);
            //insert values into DB
            insertStmt = conn.prepareStatement(insertQuery);
            insertStmt.setString(1, customer.getName());
            insertStmt.setString(2, customer.getAddress());
            insertStmt.setString(3, customer.getFloorType());
            insertStmt.setString(4, String.valueOf(customer.getArea()));
            insertStmt.setString(5, String.valueOf(customer.getCost()));
            insertStmt.execute();
          
            conn.close();
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
            System.out.println("Database error");
        }
    }
}
