package sample05;

import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {

	public static void main(String[] args) {
		ApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		HelloSpring helloSpring = context.getBean("helloSpring" , HelloSpring.class);
		helloSpring.menu(context);
		System.out.println("프로그램을 종료합니다.");

	}

	private static void menu(ApplicationContext context) {
		SungJuk sungJuk = null;
		Scanner scan = new Scanner(System.in);
		while(true) {
		System.out.println("**************");
		System.out.println("1. 입력");
		System.out.println("2. 출력");
		System.out.println("3. 수정");
		System.out.println("4. 삭제");
		System.out.println("5. 끝");
		System.out.println("**************");
		System.out.print("번호 : ");
		
			int choice = scan.nextInt();
			if(choice==1) {
				sungJuk = context.getBean("sungJukInput", SungJuk.class);
			}else if(choice==2) {
				sungJuk = context.getBean("sungJukOutput", SungJuk.class);
			}else if(choice==3) {
				sungJuk = context.getBean("sungJukModify", SungJuk.class);
			}else if(choice==4) {
				sungJuk = context.getBean("sungJukDelete", SungJuk.class);
			}else if(choice==5) {
				break;
			}else {
				System.out.println("잘못 입력하셨습니다.");
				continue;
			}//else
			sungJuk.execute();
		}//while
	}//menu

}//class