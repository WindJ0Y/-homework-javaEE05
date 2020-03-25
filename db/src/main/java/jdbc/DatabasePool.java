package jdbc;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DatabasePool {

    private static HikariDataSource hikariDataSource;

    public static HikariDataSource getHikariDataSource(){

        if(hikariDataSource != null){
            return hikariDataSource;
        }

        synchronized (DatabasePool.class){
            HikariConfig hikariConfig = new HikariConfig();
            hikariConfig.setUsername("root");
            hikariConfig.setPassword("wjmysql");
            hikariConfig.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/javaee?serverTimezone=GMT");
            hikariDataSource = new HikariDataSource(hikariConfig);
            return hikariDataSource;
        }
    }

}
