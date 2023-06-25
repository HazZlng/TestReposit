package Test;

public class test02 {

	public static void func(int a) {
		a = 100;
		System.out.println("" + a);
	}	
	
	public static void func(char a){
		// 인자 = 인수 = 매개변수 = 파라미터(parameter) = param
	}
	
	public static void func(String a){
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 10;
		System.out.println("a = " + a);
		func(a);
		System.out.println("a = " + a);
		func(++a);
		System.out.println("a = " + a);
	}

}
