package com.kien.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.core.parameters.P;

import javax.sql.DataSource;
import java.sql.Driver;

@Configuration
public class DataServiceConfig {
    private static Logger logger = LoggerFactory.getLogger(DataServiceConfig.class);

    @Bean
    public DataSource dataSource() {
        try {
            EmbeddedDatabaseBuilder embeddedDatabaseBuilder =
                    new EmbeddedDatabaseBuilder();
            embeddedDatabaseBuilder.setType(EmbeddedDatabaseType.H2);
            embeddedDatabaseBuilder.addScripts("classpath:db/test-schema.sql","classpath:db/test-data.sql");
            return  embeddedDatabaseBuilder.build();
        } catch (Exception e) {
            logger.error("Embedded Datasource bean cannot be created!",e);
            return null;
        }
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }
}
