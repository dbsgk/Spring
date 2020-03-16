package com.conf;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import user.bean.UserDTO;
import user.dao.UserDAOImpl;
import user.main.HelloSpring;
import user.service.UserDeleteService;
import user.service.UserInsertService;
import user.service.UserSelectService;
import user.service.UserService;
import user.service.UserUpdateService;
//클래스 생성 여기서 해봐라.
@Configuration
public class Instance {
	
//	@Bean(name="userDAOImpl")
//	public UserDAOImpl getMessageBeanImpl() {
//		return new UserDAOImpl();
//	}
//	
//	@Bean
//	public UserDTO userDTO() {
//		return new UserDTO();
//	}
//	
//	@Bean
//	public UserService userInsertService() {
//		return new UserInsertService();
//	}
//	
//	@Bean
//	public UserService userSelectService() {
//		return new UserSelectService();
//	}
//	@Bean
//	public UserService userUpdateService() {
//		return new UserUpdateService();
//	}
//	@Bean
//	public UserService userDeleteService() {
//		return new UserDeleteService();
//	}
    @Bean(destroyMethod="close")
    public DataSource getDataSource() {
    	BasicDataSource dataSource = new BasicDataSource();
    	dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
    	dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
    	dataSource.setUsername("c##java");
    	dataSource.setPassword("bit");
    	dataSource.setMaxTotal(20);
    	dataSource.setMaxIdle(3);
        return dataSource;
    }
}
