package Test;

import java.util.Scanner;

public class test04 {
	
	public static void main(String[] args) {
		// �Է¹޴� �Լ� ȣ��
		inputInt();
	}
	
	public static void inputInt() {
		Scanner sc = new Scanner(System.in);
		int num;
		int a = 0;
		int b = 0;
		
		for(int i = 0; i < 10; i++) {
			System.out.println("������ �Է����ּ���.");
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
		System.out.println("�Է¿Ϸ�");
		System.out.println("a = " + a + " b = " + b);
	}
}
