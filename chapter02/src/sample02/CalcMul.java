package sample02;

import lombok.Setter;

//xml에서 CalcMul를 빈(mul)으로 Setter Injection
public class CalcMul implements Calc{
	@Setter
	private int x, y;
	@Override
	public void calculate() {
		System.out.println(x+" * "+y+" = "+(x*y));
		
	}

}
