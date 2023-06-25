package Test;

import java.util.Scanner;

public class test04 {
	
	public static void main(String[] args) {
		// 입력받는 함수 호출
		inputInt();
	}
	
	public static void inputInt() {
		Scanner sc = new Scanner(System.in);
		int num;
		int a = 0;
		int b = 0;
		
		for(int i = 0; i < 10; i++) {
			System.out.println("정수를 입력해주세요.");
			num = sc.nextInt();
			
			if(isEvenNum(num)) {
				a++;
			} else {
				b++;
			}
		}
		result(a, b);
	}
	
	public static boolean isEvenNum(int param) {
		if(param%2 == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void result(int a, int b) {
		System.out.println("입력완료");
		System.out.println("a = " + a + " b = " + b);
	}
}
