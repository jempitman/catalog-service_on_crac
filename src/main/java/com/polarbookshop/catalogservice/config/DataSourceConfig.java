package com.polarbookshop.catalogservice.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.crac.Context;
import org.crac.Core;
import org.crac.Resource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Configuration
@Component
public class DataSourceConfig implements Resource {

    public DataSourceConfig() {
        System.out.println("Register resource: DataSourceConfig");
        Core.getGlobalContext().register(DataSourceConfig.this);
    }

//    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean(name = "hikariDataSource")
    @Primary
    public HikariDataSource hikariDataSource() {
        HikariConfig hikariConfig = new HikariConfig();
        HikariDataSource dataSource;

        hikariConfig.setJdbcUrl("jdbc:postgresql://localhost:5432/polardb_catalog");
//        hikariConfig.setPoolName("MyCustomPool");
        hikariConfig.setUsername("user");
        hikariConfig.setPassword("password");
        hikariConfig.setMaximumPoolSize(5);
        hikariConfig.setConnectionTimeout(2000);
        dataSource = new HikariDataSource(hikariConfig);

        return dataSource;
    }



    @Override
    public void beforeCheckpoint(Context<? extends Resource> context) throws Exception {
        System.out.println("beforeCheckpoint() called in DataSourceConfig");
        this.hikariDataSource().close();


    }

    @Override
    public void afterRestore(Context<? extends Resource> context) throws Exception {

    }
}
