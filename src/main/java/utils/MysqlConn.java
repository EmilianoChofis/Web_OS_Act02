package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConn {
    public static Connection getConnection(){
        try{
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/web_os","root", "root");
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        Connection conexion = MysqlConn.getConnection();
        if (conexion != null) {
            System.out.println("eres cabron");
        }else {
            System.out.println("nel pastel");
        }
    }
}
