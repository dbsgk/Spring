package com.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import sample01.LoggingAdvice;
import sample01.MessageBeanImpl;
//클래스 생성 여기서 해봐라.
@Configuration
public class Instance {
	
	@Bean(name="messageBeanImpl")
	public MessageBeanImpl getMessageBeanImpl() {
		return new MessageBeanImpl();
	}
	
	@Bean
	public LoggingAdvice loggingAdvice() {
		return new LoggingAdvice();
	}
}
