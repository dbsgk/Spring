package sample02;

public class HelloSpring {
	public static void main(String[] args) {
		//MessageBeanEn bean = new MessageBeanEn();//1:1관계, 결합도 100%
		MessageBean bean = new MessageBeanEn();//결합도 낮추기, 부모 = 자식
		bean.sayHello("Spring");
	}
}
//소스변경 - 컴파일 - 톰캣 껐다가 켰다가.
//그렇게 껐다가 켰다가 하면 안좋대.
