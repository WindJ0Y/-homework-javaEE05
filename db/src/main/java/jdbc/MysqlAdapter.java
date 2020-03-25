package jdbc;

import java.sql.*;

public class MysqlAdapter {

    private static Connection connection = null;

    public static boolean Connect(){
        String url = "jdbc:mysql://127.0.0.1:3306/javaee?serverTimezone=GMT";
        String driverName = "com.mysql.cj.jdbc.Driver";
        try {
            Class.forName(driverName);
            connection = DriverManager.getConnection(url, "root", "wjmysql");
        } catch (SQLException | ClassNotFoundException e) {
            return false;
        }
        return true;
    }

    public static boolean Disconnect(){
        if(connection == null) return true;
        try {
            connection.close();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    public static Connection getConnection(){
        //if(connection == null) Connect();
        //return connection;
        try{
            Connect();
            return DatabasePool.getHikariDataSource().getConnection();
        } catch (SQLException e) {
            return null;
        }

    }
}
