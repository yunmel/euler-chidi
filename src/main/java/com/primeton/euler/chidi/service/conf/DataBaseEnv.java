/*******************************************************************************
 *
 *==============================================================================
 *
 * Copyright (c) 2001-2016 Primeton Technologies, Ltd.
 * All rights reserved.
 * 
 * Created on 2016年4月2日 下午2:58:47
 *******************************************************************************/


package com.primeton.euler.chidi.service.conf;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 数据库相关环境
 *
 * @author wuyuhou (mailto:wuyuhou@primeton.com)
 */
@Configuration
@MapperScan("com.primeton.euler.chidi.service.dao")
@EnableTransactionManagement
public class DataBaseEnv {
	
	@Value("${jdbc.driver}")
    private String dbDriverClass;

    @Value("${jdbc.user}")
    private String dbUser;

    @Value("${jdbc.password}")
    private String dbPassword;

    @Value("${jdbc.url}")
    private String jdbcUrl;

    @Value("${jdbc.maxPoolSize}")
    private int maxPoolSize;
    
    @Autowired
    private DataSource dataSource;
	
	@Bean
    public DataSource dataSource() throws PropertyVetoException {

        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(dbDriverClass);
        dataSource.setUser(dbUser);
        dataSource.setPassword(dbPassword);
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setMaxPoolSize(maxPoolSize);
        dataSource.setTestConnectionOnCheckin(true);
        dataSource.setTestConnectionOnCheckout(true);
        return dataSource;
    }
	
	@Bean
    public DataSourceTransactionManager dataSourceTransactionManager() throws PropertyVetoException {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        return sessionFactory;
    }
    
	/*
    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/META-INF/mapper/*.xml"));
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean;
    }
    */
}
