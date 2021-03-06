package sample04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
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
		
		Calc calc1 = context.getBean("calcAdd", Calc.class);
		calc1.calculate(5, 17);
		System.out.println();
		
		Calc calc = (Calc) context.getBean("calcMul");
		calc.calculate(5, 17);
		System.out.println();

		((AbstractApplicationContext) context).close();
	}
}
