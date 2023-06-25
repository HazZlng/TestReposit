package Test;

public class test06 {	
	
	public static void main(String[] args) {
		asd p1 = new asd();
		asd p2 = new asd();
		
		p1.num = "0";
		p2.num = "0";
		
		System.out.println(p1.num == p2.num);
	}
	
}
class asd {
	String num;
}