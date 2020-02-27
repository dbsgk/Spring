package sample02;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

//xml에서 CalcAdd를 빈(add)으로 Constructor Injection 
@RequiredArgsConstructor
public class CalcAdd implements Calc{
	@NonNull
	private int x, y;
	@Override
	public void calculate() {
		System.out.println(x+" + "+y+" = "+(x+y));
		
	}

}
