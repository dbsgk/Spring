package sample05;

import org.springframework.stereotype.Component;

@Component("sungjukImpl")
public class SungJukImpl implements SungJuk{
	
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int total;
	private double avg;
	
	public SungJukImpl() {
		System.out.print("이름 입력: ");
		name = scan.next();
		System.out.print("국어 입력: ");
		kor = scan.nextInt();
		System.out.print("영어 입력: ");
		eng = scan.nextInt();
		System.out.print("수학 입력: ");		
		math = scan.nextInt();
		calc();
		display();
	}
	@Override
	public void calc() {
		total = kor+eng+math;
		avg = total/3.0;
	}

	@Override
	public void display() {
		System.out.println("이름\t국어\t수학\t영어\t총점\t평균\t");
		System.out.println(name+"\t"+kor+"\t"+eng+"\t"+math+"\t"+total+"\t"+String.format("%.3f", avg));
	}

}
