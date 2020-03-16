package user.main;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import user.service.UserService;

public class HelloSpring {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		HelloSpring helloSpring = context.getBean("helloSpring", HelloSpring.class);
		helloSpring.menu(context);
	}
	private static void menu(ApplicationContext context) {
		UserService userService = null;
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
				userService = context.getBean("userInsertService", UserService.class);
			}else if(choice==2) {
				userService = context.getBean("userSelectService", UserService.class);
			}else if(choice==3) {
				userService = context.getBean("userUpdateService", UserService.class);
			}else if(choice==4) {
				userService = context.getBean("userDeleteService", UserService.class);
			}else if(choice==5) {
				break;
			}else {
				System.out.println("잘못 입력하셨습니다.");
				continue;
			}//else
			userService.execute();
		}//while
	}//menu
}
