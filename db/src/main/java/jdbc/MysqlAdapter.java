package jdbc;

import java.sql.*;

public class MysqlAdapter {

    private boolean loaded = false;

    public Connection getConnection(){

        if(!loaded){
            synchronized (MysqlAdapter.class){
                if(!loaded){
                    try{
                        String driverName = "com.mysql.cj.jdbc.Driver";
                        Class.forName(driverName);
                        loaded = true;
                    } catch (ClassNotFoundException e) {
                        return null;
                    }
                }
            }
        }

        try{
            return DatabasePool.getHikariDataSource().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }
}
