//package com.polarbookshop.catalogservice.config;
//import org.crac.Context;
//import org.crac.Resource;
//import com.zaxxer.hikari.HikariConfig;
//import com.zaxxer.hikari.HikariDataSource;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.stereotype.Component;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//
//@Configuration
//@Component
//public class DataSource{
//
//    @ConfigurationProperties(prefix = "spring.datasource")
//    @Bean(name = "customDataSource")
//    @Primary
//    public DataSource customDataSource() {
//        return (DataSource) DataSourceBuilder
//                .create()
//                .url("jdbc:postgresql://localhost:5432/polardb_catalog")
//                .username("user")
//                .password("password")
//                .driverClassName("org.postgresql.Driver")
//                .build();
//    }
//
//    @Bean
//    @
////    private static HikariConfig config = new HikariConfig();
////    private static HikariDataSource ds;
////
////    static {
////        config.setJdbcUrl("jdbc:postgresql://localhost:5432/polardb_catalog");
////        config.setUsername("user");
////        config.setPassword("password");
////        config.setMaximumPoolSize(5);
////        config.setConnectionTimeout(2000);
////    }
////
////    private DataSource(){}
////
////    public static Connection getConnection() throws SQLException {
////        return ds.getConnection();
////    }
//
//}
