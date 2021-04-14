package com.soave.freelancerdeals.configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.logging.Logger;

@Configuration
public class PostgresConfiguration {

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @Bean(name = "postgresProperties")
    public HikariConfig hikariConfig(PostgresConfigurationProperties props) {
        logger.info("Loading database configuration...");
        logger.info("URL: " + props.getUrl());

        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setUsername("postgres"); //todo: consume from yml file
        hikariConfig.setPassword("@UnixtrF1363"); //todo: consume from yml file
        hikariConfig.setJdbcUrl(props.getUrl());
        hikariConfig.setDriverClassName(props.getDriverClassName());
        hikariConfig.setConnectionTimeout(props.getConnectionTimeout());
        hikariConfig.setMaxLifetime(props.getMaxLifetime());
        hikariConfig.setConnectionTestQuery(props.getConnectionTestQuery());
        hikariConfig.setMaximumPoolSize(props.getMaxPoolSize());

        logger.info("Connection OK...");
        return hikariConfig;
    }

    @Bean(name = "postgresDataSource")
    public DataSource dataSource(@Qualifier("postgresProperties") HikariConfig hikariConfig) {
        return new HikariDataSource(hikariConfig);
    }

    @Lazy
    @Bean(name = "postgresJdbcTemplate")
    public JdbcTemplate jdbcTemplate(@Qualifier("postgresDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Lazy
    @Bean(name = "postgresNamedJdbcTemplate")
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(@Qualifier("postgresDataSource") DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Lazy
    @Bean(name = "postgresTransaction")
    public DataSourceTransactionManager dataSourceTransactionManager(
            @Qualifier("postgresDataSource") DataSource datasource) {
        return new DataSourceTransactionManager(datasource);
    }
}
