package com.study.springcore.jdbc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

// Java 配置
@Configuration
@ComponentScan
@EnableTransactionManagement
@PropertySource(value={ "classpath:db.properties" }, ignoreResourceNotFound=true)
public class SpringConfig {
	
	@Autowired
    protected Environment env;
	
	@Bean
	public DataSource dataSource() {
		ComboPooledDataSource ds = new ComboPooledDataSource();
		try {
			ds.setDriverClass(env.getProperty("jdbc.driver"));
			ds.setJdbcUrl(env.getProperty("jdbc.url"));
			ds.setUser(env.getProperty("jdbc.username"));
			ds.setPassword(env.getProperty("jdbc.password"));
			
			ds.setMinPoolSize(10);
			ds.setMaxPoolSize(100);
			ds.setMaxIdleTime(1800); // 秒
			ds.setAcquireIncrement(3);
			ds.setMaxStatements(1000);
			ds.setInitialPoolSize(10);
			ds.setIdleConnectionTestPeriod(60);
			ds.setAcquireRetryAttempts(30);
			ds.setBreakAfterAcquireFailure(true);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ds;
	}

	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}
	
	@Bean
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate() {
		return new NamedParameterJdbcTemplate(dataSource());
	}
	
	@Bean   
	public DataSourceTransactionManager transactionManager() {
	    return new DataSourceTransactionManager(dataSource());
	}

}
