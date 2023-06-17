/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Buana_Dev
 */
public class Connection {
    private static java.sql.Connection sqlsrv;
    public static java.sql.Connection configDB()throws SQLException{
        try{
            String url = "jdbc:sqlserver://192.168.1.210:1433;databaseName=galaxy_db;encrypt=true;trustServerCertificate=true";
            String user = "sa";
            String pass = "1tbu4n4megah_2425";
            
            DriverManager.getConnection(url, user, pass);
            sqlsrv = DriverManager.getConnection(url, user, pass);
        }catch(SQLException e){
            System.out.println("Koneksi ke Database Gagal " + e.getMessage());
        }
        return sqlsrv;
    }
}
