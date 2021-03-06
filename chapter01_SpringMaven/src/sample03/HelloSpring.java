package sample03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//이제 직접 안부르고(new 안하고) 컨테이너가 만들어서 데려온다. 
//applicationContext.xml이 만들어서 데려올거야.
//xml이름은 아무거나 써도 되는데 보통 공통적으로 저렇게 쓴다.
public class HelloSpring {
	public static void main(String[] args) {
		//ApplicationContext context = 
					//new FileSystemXmlApplicationContext("src/applicationContext.xml");//주소써주면 불러다 주겠다.
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");//기본위치가 src라서 이렇게만 위치 잡아줘도 나옴.
		MessageBean bean = (MessageBean) context.getBean("messageBean");
		bean.sayHello("Spring");
		System.out.println();

		MessageBean bean2 = context.getBean("messageBean" ,MessageBean.class);//뒤에 있는 타입으로 형변환 하겠따.
		bean2.sayHello("Spring2");
		System.out.println();
		
		/*
		 * MessageBean bean3 = (MessageBean)context.getBean("mb");
		 * bean3.sayHello("Spring3"); System.out.println();
		 */
	}
	
}
