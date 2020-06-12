package com.github.niefy.config;

import com.github.niefy.config.properties.R2bcProperties;
import io.r2dbc.pool.PoolingConnectionFactoryProvider;
import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.connectionfactory.R2dbcTransactionManager;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.transaction.ReactiveTransactionManager;

@Configuration
@EnableR2dbcRepositories
@EnableConfigurationProperties(R2bcProperties.class)
public class R2bcDatabaseConfiguration {
    @Autowired
    private R2bcProperties properties;

    @Bean
    public ConnectionFactory connectionFactory() {
        return ConnectionFactories.get(ConnectionFactoryOptions.builder()
                .option(ConnectionFactoryOptions.DRIVER, properties.getDriver())
                .option(ConnectionFactoryOptions.PROTOCOL, properties.getProtocal())
                .option(PoolingConnectionFactoryProvider.MAX_SIZE, properties.getMaxSize())
                .option(ConnectionFactoryOptions.HOST, properties.getHost())
                .option(ConnectionFactoryOptions.PORT, properties.getPort())
                .option(ConnectionFactoryOptions.USER, properties.getUsername())
                .option(ConnectionFactoryOptions.PASSWORD, properties.getPassword())
                .option(ConnectionFactoryOptions.DATABASE, properties.getDatabase())
                .build());
    }
    @Bean
    ReactiveTransactionManager transactionManager(ConnectionFactory connectionFactory) {
        return new R2dbcTransactionManager(connectionFactory);
    }


}
