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
			
			System.out.println("포켓몬의 이름을 입력하세요.");
			pokemon[i].name = sc.next();
			
			System.out.println("포켓몬의 레벨을 입력하세요.");
			pokemon[i].level = sc.nextInt();
			
			pokemon[i].exp = r.nextInt(11);
		}
		
		while(true) {
			System.out.println("\n\n");
			
			int seq;
			System.out.println("====================");
			System.out.println("1. 게임시작");
			System.out.println("2. 포켓몬 정보");
			System.out.println("999. 게임종료");
			System.out.println("====================");
			
			seq = sc.nextInt();
			
			switch(seq) {
			case 1:		// 1 입력시 게임 한바퀴 돌림
				for(int i = 0; i < pokemon.length; i++) {
					pokemon[i].game();
				}
				break;
				
			case 2: 	// 2 입력시 포켓몬 정보 출력
				for(int i = 0; i < pokemon.length; i++) {
					pokemon[i].printInfo();
				}
				break;
				
			case 999:	// 999 입력시 게임종료 ( 프로그램 종료 )
				System.out.println("게임종료");
				return;
				
			default :
				System.out.println("메뉴 입력이 잘못되었습니다. 다시 입력해주세요.");
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
		System.out.println("이름 : " + this.name + " Lv." + this.level + " ["
				+ this.exp + "/" + this.expMax + "]");
	}
	
	void game() {
		System.out.println("게임 시작 호출");
		Random r = new Random();

		int rValue = r.nextInt(2);
		
		if(rValue == 1) {
			this.exp += r.nextInt(101) + 50;
			System.out.println("성공!");
		} else if(rValue == 0) {
			this.exp += 10;
			System.out.println("실패");
		}
		
		this.isLevelUp();
	}
	
	void isLevelUp() {
		if(this.exp > 99) {
			System.out.println(this.name + " 가 레벨업 했습니다!");
			this.level++;
			this.exp -= 100;
			
			this.printInfo();
		}
	}
}