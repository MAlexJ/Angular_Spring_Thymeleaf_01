package com.malex.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.malex.repository")
public class DatabaseConfig {

    // DataSource
    @Value("${db.driver}")
    private String DRIVER;
    @Value("${db.url}")
    private String URL;
    @Value("${db.username}")
    private String USER_NAME;
    @Value("${db.password}")
    private String PASSWORD;
    @Value("${db.entity.package}")
    private String PACKAGE;

    // DBCP
    @Value("${db.initialSize}")
    private Integer INITIAL_SIZE;
    @Value("${db.minIdle}")
    private Integer MIN_IDLE;
    @Value("${db.maxIdle}")
    private Integer MAX_IDLE;
    @Value("${db.timeBetweenEvictionRunsMillis}")
    private Integer TIME_RUNS;
    @Value("${db.minEvictableIdleTimeMillis}")
    private Integer MIN_IDLE_TIME;
    @Value("${db.testOnBorrow}")
    private boolean TEST_ON_BORROW;
    @Value("${db.validationQuery}")
    private String VALIDATION_QUERY;

    // Hibernate
    @Value("${data.showsql}")
    private boolean showSql;
    @Value("${data.generateddl}")
    private boolean generateDdl;
    @Value("${data.dialect}")
    private String DIALECT;
    @Value("${data.hbm2ddl.auto}")
    private String hbm2ddlAuto;
    @Value("${data.database}")
    private String database;

    @Bean
    public DataSource dataSource() {
        // Base DataSource
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName(DRIVER);
        ds.setUrl(URL);
        ds.setUsername(USER_NAME);
        ds.setPassword(PASSWORD);
        // DBCP
        ds.setInitialSize(INITIAL_SIZE);
        ds.setMinIdle(MIN_IDLE);
        ds.setMaxIdle(MAX_IDLE);
        ds.setTimeBetweenEvictionRunsMillis(TIME_RUNS);
        ds.setMinEvictableIdleTimeMillis(MIN_IDLE_TIME);
        ds.setTestOnBorrow(TEST_ON_BORROW);
        ds.setValidationQuery(VALIDATION_QUERY);
        return ds;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setShowSql(showSql);
        jpaVendorAdapter.setGenerateDdl(generateDdl);
        jpaVendorAdapter.setDatabase(Database.valueOf(database));
        return jpaVendorAdapter;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        // DataSource
        entityManagerFactory.setDataSource(dataSource());
        // Provider JPA
        entityManagerFactory.setJpaVendorAdapter(jpaVendorAdapter());
        // Entity package
        entityManagerFactory.setPackagesToScan(PACKAGE);
        // Config Hibernate
        Properties jpaProperties = new Properties();
        jpaProperties.setProperty("hibernate.hbm2ddl.auto", hbm2ddlAuto);
        jpaProperties.setProperty("hibernate.dialect", DIALECT);
        entityManagerFactory.setJpaProperties(jpaProperties);
        return entityManagerFactory;
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        // Register LocalContainerEntityManagerFactoryBean
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }
}
