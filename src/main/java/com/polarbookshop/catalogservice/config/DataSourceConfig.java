package com.polarbookshop.catalogservice.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.crac.Context;
import org.crac.Core;
import org.crac.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DelegatingDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.Closeable;

@Configuration
@Component
public class DataSourceConfig implements Resource {

    public DataSourceConfig() {
        System.out.println("Register resource: DataSourceConfig");
        Core.getGlobalContext().register(DataSourceConfig.this);
    }

    @Bean(name = "hikariDataSource")
    @Primary
    public DelegatingDataSource dataSource() {
        HikariDataSource hikariDataSource = setupNewDataSource();

        return new DelegatingDataSource(hikariDataSource);
    }


    @Override
    public void beforeCheckpoint(Context<? extends Resource> context) throws Exception {
        System.out.println("beforeCheckpoint() called in DataSourceConfig");
        DataSource targetDataSource = this.dataSource().getTargetDataSource();
        if (targetDataSource instanceof Closeable) {
            ((Closeable) targetDataSource).close();
        }
    }

    @Override
    public void afterRestore(Context<? extends Resource> context) throws Exception {
        DelegatingDataSource dataSource = this.dataSource();
        dataSource.setTargetDataSource(setupNewDataSource());
    }

    private HikariDataSource setupNewDataSource() {
        HikariConfig hikariConfig = new HikariConfig();
        HikariDataSource hikariDataSource;
        hikariConfig.setJdbcUrl("jdbc:postgresql://localhost:5432/polardb_catalog");
        hikariConfig.setUsername("user");
        hikariConfig.setPassword("password");
        hikariConfig.setMaximumPoolSize(5);
        hikariConfig.setConnectionTimeout(2000);
        hikariDataSource = new HikariDataSource(hikariConfig);
        return hikariDataSource;

    }
}
