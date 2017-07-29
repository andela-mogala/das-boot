package com.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Das Boot
 *
 */
@SpringBootApplication
@EntityScan(basePackages = {"com.boot.model"} )
@EnableJpaRepositories(basePackages = {"com.boot.repository"})
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
}
