package sample03;

import lombok.Getter;
import lombok.Setter;

//Setter Injection
@Setter
@Getter
public class SungJukDTO {
	
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int total;
	private double avg;
	@Override
	public String toString() {
		return (name+"\t"+kor+"\t"+eng+"\t"+math+"\t"+total+"\t"+String.format("%.2f", avg));
	}
	
	
}
