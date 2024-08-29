package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class Conexion {

    Connection con;
    String url = "jdbc:mysql://localhost:3306/queriquitoesta";
    String user = "root";
    String pass = "Gu@t3m@l@.2024";

    public Connection Conexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            System.out.println("Error"+e);
        }
        return con;
    }

}
