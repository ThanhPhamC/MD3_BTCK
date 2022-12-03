package project.model.until;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static final String DIRVER= "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/projectFinal";
    private static final String USER = "root";
    private static final String PASS = "Phamchithanh1";

    public static Connection openConnection(){
        Connection conn= null;
        try {
            Class.forName(DIRVER);
            conn= DriverManager.getConnection(URL,USER,PASS);
        }catch (SQLException e){
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }
    public static void closeConnection(Connection conn, CallableStatement cast){
       if (conn!=null){
           try {
               conn.close();
           } catch (SQLException e) {
               throw new RuntimeException(e);
           }
       }
       if (cast!=null){
           try {
               cast.close();
           } catch (SQLException e) {
               throw new RuntimeException(e);
           }
       }
    }


}
