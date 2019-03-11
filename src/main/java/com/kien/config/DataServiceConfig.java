package com.kien.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.core.parameters.P;

import javax.sql.DataSource;

@Configuration
public class DataServiceConfig {
    private static Logger logger = LoggerFactory.getLogger(DataServiceConfig.class);

    @Bean
    public DataSource dataSource() {
        try {
            EmbeddedDatabaseBuilder embeddedDatabaseBuilder =
                    new EmbeddedDatabaseBuilder();
            embeddedDatabaseBuilder.setType(EmbeddedDatabaseType.H2);
            embeddedDatabaseBuilder.addScript("classpath:/db/h2/schema.sql");
            return embeddedDatabaseBuilder.build();
        } catch (Exception e) {
            logger.error("Embedded Datasource bean cannot be created!",e);
            return null;
        }
    }
}
