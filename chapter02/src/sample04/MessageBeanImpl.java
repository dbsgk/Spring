package sample04;

import lombok.Data;
import lombok.Setter;

public class MessageBeanImpl implements MessageBean {
	
	private String name;
	private String phone;
	private Outputter outputter;
	
	//MessageBean messageBean2 = new sample04.MessageBeanImpl(); --이미 messageBean있어서 객체명만 2로 잡음
	//이름: 홍길동 은 생성자 injection
	//핸드폰 : 010-123-1234는 setter injection
	public MessageBeanImpl(String name) {
		System.out.println("MessageBeanImpl(String name)");
		this.name=name;
	}
	
	public void setPhone(String phone) {
		System.out.println("setPhone(String phone)");
		this.phone = phone;
	}
	
	public void setOutputter(Outputter outputter) {
		this.outputter = outputter;
	}
	
	@Override
	public void helloCall() {
		System.out.println("helloCall()");
		System.out.println("이름: "+name);
		System.out.println("핸드폰: "+phone);
		outputter.output("이름: "+name+"\n핸드폰: "+phone);
	}

}
