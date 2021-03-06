package sample01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {
	

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		MessageBean bean =context.getBean("messageBeanImpl", MessageBean.class);
		bean.sayHello();
		bean.sayHello("수박", 25000);
		bean.sayHello("사과", 3500, 5);
	}

}
