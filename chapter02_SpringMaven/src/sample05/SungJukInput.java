package sample05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Setter;

//@Setter 안쓰고 알아서 얻어오게 할거임
@Component
@Scope("prototype")
public class SungJukInput implements SungJuk{
	@Qualifier("list")
	@Autowired
	private List<SungJukDTO2> list;
	//List가 부모로서(다형성)
	//여러개의 클래스로 생성될 수 있으므로 반드시 @Qualifier()를 사용해서 Bean id를 등록해야 한다.
	
	@Autowired
	private SungJukDTO2 sungJukDTO2;

	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("이름 입력: ");
		sungJukDTO2.setName(scan.next());
		System.out.print("국어 입력: ");
		sungJukDTO2.setKor(scan.nextInt());
		System.out.print("영어 입력: ");
		sungJukDTO2.setEng(scan.nextInt());
		System.out.print("수학 입력: ");
		sungJukDTO2.setMath(scan.nextInt());
		
		sungJukDTO2.setTotal(sungJukDTO2.getKor()+sungJukDTO2.getEng()+sungJukDTO2.getMath());
		sungJukDTO2.setAvg(sungJukDTO2.getTotal()/3.0);
		
		list.add(sungJukDTO2);
		
		System.out.println(sungJukDTO2.getName()+"님의 데이터를 입력했습니다.");
	}

}
