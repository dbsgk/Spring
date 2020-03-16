package sample01;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import lombok.Setter;

//Target(공통사항 넣어지는 대상)
//
//넣어지는 애들만 포인트컷.(타겟대상)
//@Setter setter필요없다고 없애래.
@ComponentScan("com.conf")
public class MessageBeanImpl implements MessageBean {
	@Value("Have a nice day!!")
	private String str;
	
	@Override
	public void showPrintBefore() {
		//공통삽입대상. 
		System.out.println("showPrintBefore 메시지 = "+str);//핵심관심사항
	}

	@Override
	public void viewPrintBefore() {
		//공통삽입대상. 
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("viewPrintBefore 메시지 = "+str);//핵심관심사항

	}

	@Override
	public void display() {
		//삽입안될 대상. 길동이
		System.out.println("display 메시지 = "+str);//핵심관심사항

	}

	@Override
	public void showPrintAfter() {
		System.out.println("showPrintAfter 메시지 = "+str);//핵심관심사항
		
	}

	@Override
	public void viewPrintAfter() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("viewPrintAfter 메시지 = "+str);//핵심관심사항
		
	}

	@Override
	public String showPrint() {
		System.out.println("showPrint 메시지 = "+str);//핵심관심사항
		return "리턴값";
		
	}

	@Override
	public void viewPrint() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("viewPrint 메시지 = "+str);//핵심관심사항
		
	}

}
