package sample03;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

//Constructor Injection
//@Component
@ComponentScan("com.conf")//직접 생성이 아니라 여기서 참조해와라
public class SungJukImpl implements SungJuk{
	
	@Autowired /*component로 생성된 SungJukDTO(변수이름아니고 클래스타입)를 찾는다*/
	SungJukDTO sungjukDTO;
	
	@Override
	public void calcTot() {
		sungjukDTO.setTotal(sungjukDTO.getKor()+sungjukDTO.getEng()+sungjukDTO.getMath());
		
	}

	@Override
	public void calcAvg() {
		sungjukDTO.setAvg(sungjukDTO.getTotal()/3.0);
	}

	@Override
	public void display() {
		System.out.println("이름\t국어\t수학\t영어\t총점\t평균\t");
		System.out.println(sungjukDTO);
	}
	@Override
	public void modify() {
		Scanner scan = new Scanner(System.in);
		System.out.print("이름 입력: ");
		sungjukDTO.setName(scan.next());
		System.out.print("국어 입력: ");
		sungjukDTO.setKor(scan.nextInt());
		System.out.print("영어 입력: ");
		sungjukDTO.setEng(scan.nextInt());
		System.out.print("수학 입력: ");
		sungjukDTO.setMath(scan.nextInt());
		
	}

}
