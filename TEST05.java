package Test;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TEST05 {	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		Pokemon[] pokemon = new Pokemon[1];

		Pokemon a = new Pokemon();
		Pokemon b = new Pokemon();
		
		System.out.println(a.equals(b));
		
		for(int i = 0; i < pokemon.length; i++) {
			pokemon[i] = new Pokemon();
			
			System.out.println("���ϸ��� �̸��� �Է��ϼ���.");
			pokemon[i].name = sc.next();
			
			System.out.println("���ϸ��� ������ �Է��ϼ���.");
			pokemon[i].level = sc.nextInt();
			
			pokemon[i].exp = r.nextInt(11);
		}
		
		while(true) {
			System.out.println("\n\n");
			
			int seq;
			System.out.println("====================");
			System.out.println("1. ���ӽ���");
			System.out.println("2. ���ϸ� ����");
			System.out.println("999. ��������");
			System.out.println("====================");
			
			seq = sc.nextInt();
			
			switch(seq) {
			case 1:		// 1 �Է½� ���� �ѹ��� ����
				for(int i = 0; i < pokemon.length; i++) {
					pokemon[i].game();
				}
				break;
				
			case 2: 	// 2 �Է½� ���ϸ� ���� ���
				for(int i = 0; i < pokemon.length; i++) {
					pokemon[i].printInfo();
				}
				break;
				
			case 999:	// 999 �Է½� �������� ( ���α׷� ���� )
				System.out.println("��������");
				return;
				
			default :
				System.out.println("�޴� �Է��� �߸��Ǿ����ϴ�. �ٽ� �Է����ּ���.");
			}
			sc.next();
		}
		
	}
	
}

class Pokemon {
	String name;
	int level;
	int exp;
	int expMax;
	
	Pokemon() {
		this.expMax = 100;
	}
	
	void printInfo() {
		System.out.println("�̸� : " + this.name + " Lv." + this.level + " ["
				+ this.exp + "/" + this.expMax + "]");
	}
	
	void game() {
		System.out.println("���� ���� ȣ��");
		Random r = new Random();

		int rValue = r.nextInt(2);
		
		if(rValue == 1) {
			this.exp += r.nextInt(101) + 50;
			System.out.println("����!");
		} else if(rValue == 0) {
			this.exp += 10;
			System.out.println("����");
		}
		
		this.isLevelUp();
	}
	
	void isLevelUp() {
		if(this.exp > 99) {
			System.out.println(this.name + " �� ������ �߽��ϴ�!");
			this.level++;
			this.exp -= 100;
			
			this.printInfo();
		}
	}
}