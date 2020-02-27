package sample03;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("messageBean") /*나는 id가 messageBean이에요*/
@Scope("prototype") /*나의 scope타입은 prototype이에요*/
public class MessageBeanKo implements MessageBean {
	private int num;
	
	public MessageBeanKo() {
		System.out.println("기본 생성자");
	}
	@Override
	public void sayHello(String name) {
		num++;
		System.out.println("num="+num);
		System.out.println("안녕하세요 "+ name +"!!");		
	}
}
