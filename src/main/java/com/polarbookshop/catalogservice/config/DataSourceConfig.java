package com.polarbookshop.catalogservice.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Configuration
@Component
public class DataSourceConfig {

//    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean(name = "hikariDataSource")
    @Primary
    public DataSource hikariDataSource() {
        HikariConfig hikariConfig = new HikariConfig();
        HikariDataSource dataSource;

        hikariConfig.setJdbcUrl("jdbc:postgresql://localhost:5432/polardb_catalog");
        hikariConfig.setPoolName("MyCustomPool");
        hikariConfig.setUsername("user");
        hikariConfig.setPassword("password");
        hikariConfig.setMaximumPoolSize(5);
        hikariConfig.setConnectionTimeout(2000);
        dataSource = new HikariDataSource(hikariConfig);

        return dataSource;
    }


//    private static HikariConfig config = new HikariConfig();
//    private static HikariDataSource ds;
//
//    static {
//        config.setJdbcUrl("jdbc:postgresql://localhost:5432/polardb_catalog");
//        config.setUsername("user");
//        config.setPassword("password");
//        config.setMaximumPoolSize(5);
//        config.setConnectionTimeout(2000);
//    }
//
//    private DataSource(){}
//
//    public static Connection getConnection() throws SQLException {
//        return ds.getConnection();
//    }

}
