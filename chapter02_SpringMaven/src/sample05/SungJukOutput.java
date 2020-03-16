package sample05;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class SungJukOutput implements SungJuk{
	@Qualifier("list")
	@Autowired
	private List<SungJukDTO2> list;
	
	@Override
	public void execute() {
		if(list.size()<1) {
			System.out.println("출력할 데이터가 없습니다.");
			return;
		}
		System.out.println("이름\t국어\t수학\t영어\t총점\t평균\t");
		for( SungJukDTO2 dto : list) {
			System.out.println(dto);
		
		}
	}

}
