package com.malex.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@ComponentScan(basePackages = "com.malex")
public class AppConfig {

    @Bean
    public PropertyPlaceholderConfigurer propertyConfigurer() {
        PropertyPlaceholderConfigurer configurer = new PropertyPlaceholderConfigurer();

        ClassPathResource dataSource = new ClassPathResource("db.properties");
        ClassPathResource hibernate = new ClassPathResource("hibernate.properties");

        configurer.setLocations(dataSource, hibernate);
        return configurer;
    }
}
