package com.metacube.hibernate.config;


import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Config Class
 * @author Surender
 */
@Configuration
@EnableTransactionManagement
@PropertySource("classpath:config.properties")
public class StudentConfig {

	@Autowired
	private Environment env;

	@Bean
	public EntityManagerFactory entityManagerFactory() {

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		
		vendorAdapter.setGenerateDdl(true);
		vendorAdapter.setShowSql(false);
		vendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQL5Dialect");
		
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setJpaProperties(hibernateProperties());
		factory.setPackagesToScan("com.metacube.hibernate.model");
		factory.setDataSource(getDataSource());
		factory.afterPropertiesSet();
		
		return factory.getObject();
	}

	@Bean
	public JpaTransactionManager transactionManager() {
		
		JpaTransactionManager txManager = new JpaTransactionManager();
		
		txManager.setDataSource(getDataSource());
		txManager.setEntityManagerFactory(entityManagerFactory());
		
		return txManager;
	}

	
	@Bean
	public DataSource getDataSource() {
	
		BasicDataSource dataSource = new BasicDataSource();
		
		dataSource.setDriverClassName(env.getProperty("database.driver"));
		dataSource.setUrl(env.getProperty("database.url"));
		dataSource.setUsername(env.getProperty("database.root"));
		dataSource.setPassword(env.getProperty("database.password"));
		
		return dataSource;
	}

	/**
	 * Helper Method
	 */
	private Properties hibernateProperties() {
		
		Properties properties = new Properties();
		
		properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
		properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
		properties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		
		return properties;
	}
}
