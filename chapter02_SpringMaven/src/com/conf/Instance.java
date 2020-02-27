package com.conf;

import org.springframework.context.annotation.Bean;

import sample03.SungJukDTO;
import sample03.SungJukImpl;

public class Instance {
	//메소드명을 객체명으로 인식한다
	//그래서 객체명을 getSungJukImpl로 찾으니 없어서 name="sungJukImpl" 을  부여한 것이다.
	@Bean(name="sungJukImpl") /*메모리에 자리잡은 new SungJukImpl을 얻어올 수 있게끔 해줌.*/
	public SungJukImpl getSungJukImpl(){
		return new SungJukImpl();//new하면 메모리 주소가 생기는데 그걸 모른대.
	}
	
	@Bean
	public SungJukDTO sungJukDTO() {
		return new SungJukDTO();
	}
	
	
	
	
	
}
//getSungJukImpl  = new SungJukImpl();