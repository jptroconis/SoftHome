package com.Managers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conection<NameClass> {

    protected static Connection con;
//    protected static final String url="jdbc:postgresql://localhost:5432/georgia";
//    protected static final String password="admin";
//    protected static final String login="postgres";
//    protected static final String driver="org.postgresql.Driver";

    protected static final String url = "jdbc:mysql://localhost:3306/prueba";
    protected static final String password = "admin";
    protected static final String login = "root";
    protected static final String driver = "com.mysql.jdbc.Driver";

    protected static String sql = null;
    protected static PreparedStatement pst = null;
    protected static ResultSet rs = null;
    

    protected static void desconectar(PreparedStatement pst, ResultSet rs) throws SQLException {
        if (pst != null) {
            pst.close();
        }
        if (rs != null) {
            rs.close();
        }
    }

    protected static String connect() {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, login, password);
            return "conectado....";
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
}
