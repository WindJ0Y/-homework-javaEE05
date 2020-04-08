package config;

import jdbc.MysqlAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainConfig {
    @Bean
    public MysqlAdapter mysqlAdapter(){
        return new MysqlAdapter();
    }
}
