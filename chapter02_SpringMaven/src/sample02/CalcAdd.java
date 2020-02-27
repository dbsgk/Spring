package sample02;

import org.springframework.beans.factory.annotation.Value;

//xml에서 CalcAdd를 빈(add)으로 Constructor Injection 
public class CalcAdd implements Calc{
	private @Value("25")int x;
	private @Value("36")int y;
	@Override
	public void calculate() {
		System.out.println(x+" + "+y+" = "+(x+y));
		
	}

}
