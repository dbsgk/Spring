package sample03;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

//Setter Injection
@Getter
@Setter
//@Component
@ComponentScan("com.conf")//직접 생성이 아니라 여기서 참조해와라
public class SungJukDTO {
	
	@Value("홍길동")
	private String name;
	private @Value("97")int kor;
	private @Value("100")int eng;
	private @Value("95")int math;
	private int total;
	private double avg;
	@Override
	public String toString() {
		return (name+"\t"+kor+"\t"+eng+"\t"+math+"\t"+total+"\t"+String.format("%.2f", avg));
	}
	
	
}
