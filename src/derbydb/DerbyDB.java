/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package derbydb;

import java.sql.*;

/**
 *
 * @author njm5648
 */
public class DerbyDB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // setting up database connection
            System.out.println("Testing Derby Database, make sure it it turned on!");
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection dbConnection = DriverManager.getConnection("jdbc:derby://localhost:1527//sample", "app", "app");

            //Test Database Query
            Statement stmt = dbConnection.createStatement();
            String testQuery = "SELECT * FROM CUSTOMER";
            ResultSet results;

            results = stmt.executeQuery(testQuery);
            // processing results
            while (results.next()) {
                System.out.println("Result: " + results.getString("NAME"));
            }
            
            results.close();
            stmt.close();
            dbConnection.close();

        } catch (SQLException e) {
            System.out.println("Cannot connect to database.\n" + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Cannot create an instance of the database driver.\n" + e.getMessage());
        }
    }
}
