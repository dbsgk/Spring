package sample05;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
public class SungJukDelete implements SungJuk{
	@Qualifier("list")
	@Autowired
	private List<SungJukDTO2> list;
	SungJukDTO2 sungJukDTO2;
	
	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);
		int count = 0;
		System.out.print("삭제할 이름 입력 : ");
		String name = scan.next();
		Iterator<SungJukDTO2> it = list.iterator();
		while(it.hasNext()) {
			if(it.next().getName().equals(name)) {
				count++;
				it.remove();
			}
		}
		if(count==0) 
			System.out.println("삭제하고자 하는 이름이 없습니다.");
		else
			System.out.println(name+"님의 데이터를 삭제했습니다.");
	}

}
