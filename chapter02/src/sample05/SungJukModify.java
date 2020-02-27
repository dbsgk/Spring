package sample05;

import java.util.List;
import java.util.Scanner;

import lombok.Setter;

@Setter
public class SungJukModify implements SungJuk{
	private List<SungJukDTO2> list;
	SungJukDTO2 sungJukDTO2;
	
	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);
		System.out.print("수정할 이름 입력 : ");
		String name = scan.next();
		for( SungJukDTO2 dto : list) {
			if(dto.getName().equals(name)) {
				System.out.print("국어점수 입력 : ");
				dto.setKor(scan.nextInt());
				System.out.print("영어점수 입력 : ");
				dto.setEng(scan.nextInt());
				System.out.print("수학점수 입력 : ");
				dto.setMath(scan.nextInt());

			}
		}
//		이름	국어	영어	수학	총점	평균
//		홍길동
//
//		국어점수 입력 :
//		영어점수 입력 :
//		수학점수 입력 :
//
//		xxx님의 데이터를 수정 하였습니다
		
	}

}
