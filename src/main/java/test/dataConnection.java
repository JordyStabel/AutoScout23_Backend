package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dataConnection {


    public static void main(String[] args){

        System.out.println("Test");

        //String connectionString = "jdbc:sqlserver://testdbjan.database.windows.net:1433;database=AutoScout23;user=jan@testdbjan;password={fun4databasepassword!};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
        String connectionString = "jdbc:sqlserver://testdbjan.database.windows.net:1433;database=AutoScout23;";
        String user = "jan@testdbjan";
        String pw = "fun4databasepassword!";

        Connection myConnection = null;

        try {
            System.out.println("Connection to database: " + connectionString);

            myConnection = DriverManager.getConnection(connectionString, user, pw);

            System.out.println("Connection successful.");
            myConnection.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                myConnection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}
