package sample03;

import java.util.Scanner;

import lombok.AllArgsConstructor;

//Constructor Injection
@AllArgsConstructor
public class SungJukImpl implements SungJuk{
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
		System.out.println(sungjukDTO.getName()+"\t"+sungjukDTO.getKor()+"\t"+sungjukDTO.getEng()+"\t"+sungjukDTO.getMath()+"\t"+sungjukDTO.getTotal()+"\t"+String.format("%.2f", sungjukDTO.getAvg()));
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
