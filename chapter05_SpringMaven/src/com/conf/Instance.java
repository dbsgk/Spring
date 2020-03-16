package com.conf;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import user.bean.UserDTO;
import user.dao.UserDAOMybatis;
import user.main.HelloSpring;
import user.service.UserDeleteService;
//클래스 생성 여기서 해봐라.
import user.service.UserInsertService;
import user.service.UserSelectService;
import user.service.UserUpdateService;
@Configuration
public class Instance {
	
    @Bean(destroyMethod="close")
    public DataSource dataSource() {
    	BasicDataSource dataSource = new BasicDataSource();
    	dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
    	dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
    	dataSource.setUsername("c##java");
    	dataSource.setPassword("bit");
    	dataSource.setMaxTotal(20);
    	dataSource.setMaxIdle(3);
        return dataSource;
    }
    
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
    	SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
    	PathMatchingResourcePatternResolver pmrpr = new PathMatchingResourcePatternResolver(); 
    	//마이바티스 컨피그  리소스 받아오는 애
    	
    	sqlSessionFactoryBean.setDataSource(dataSource());
    	sqlSessionFactoryBean.setConfigLocation(pmrpr.getResource("spring/mybatis-config.xml"));
    	sqlSessionFactoryBean.setMapperLocations(pmrpr.getResources("user/dao/userMapper.xml"));//그냥 userMapper.xml써도 되는데 
    	return sqlSessionFactoryBean.getObject();
//    	return (SqlSessionFactory)sqlSessionFactoryBean;
    }
    
    @Bean(name="sqlSession")
    public SqlSessionTemplate sqlSessionTemplate() throws Exception {
    	return new SqlSessionTemplate(sqlSessionFactory());
    }
    
    @Bean
    public DataSourceTransactionManager transactionManager() {
    	DataSourceTransactionManager dstm = new DataSourceTransactionManager();
    	dstm.setDataSource(dataSource());
    	return dstm;
    }
    
    @Bean
    public HelloSpring helloSpring() {
    	return new HelloSpring();
    }
    
    @Bean
    public UserInsertService userInsertService() {
    	return new UserInsertService();
    }
    @Bean
    public UserDeleteService userDeleteService() {
    	return new UserDeleteService();
    }
    @Bean
    public UserSelectService userSelectService() {
    	return new UserSelectService();
    }
    @Bean
    public UserUpdateService userUpdateService() {
    	return new UserUpdateService();
    }
    
    @Bean
    public UserDAOMybatis userDAO() {
    	return new UserDAOMybatis();
    }
    
    @Bean
    public UserDTO userDTO() {
    	return new UserDTO();
    }
}
