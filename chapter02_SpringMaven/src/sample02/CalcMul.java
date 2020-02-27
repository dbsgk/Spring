package sample02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//xml에서 CalcMul를 빈(mul)으로 Setter Injection
@Component
public class CalcMul implements Calc{
	private int x, y;
	
	@Autowired
	public void setX(int x) {
		this.x = x;
	}
	@Autowired
	public void setY(int y) {
		this.y = y;
	}

	@Override
	public void calculate() {
		System.out.println(x+" * "+y+" = "+(x*y));
		
	}

}
