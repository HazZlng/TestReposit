package Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Test {
	
	public static void main(String args[]) {
		int[] data;
		Random r = new Random();
		int rNum = 0;
		int oSum = 0;
		int eSum = 0;
		int eCnt = 0;
		float avg;
		
		// ������ �����ؼ� �迭ũ�� ���ϱ�
		rNum = r.nextInt(3) + 3;
		data = new int[rNum];
		
		// ������ ���� �� �迭�� �ֱ�
		System.out.print("[ ");
		for(int i = 0; i < data.length; i++) {
			 data[i] = r.nextInt(6) + 100;
			 // ��ȭ1. �������� ������ ������ ������ �迭�� ���� ������ ���Ͽ�
			 //		  ���� �� �ش� �ݺ��� �ǵ�����.
			 for(int j = 0; j < i; j++) {
				 if(data[i] == data[j]) {
					 i--;
				 }
			 }
			 
	         System.out.print(data[i] + " ");
		}
		System.out.print(" ]");
		
		// �迭�� ¦/Ȧ�� �Ǻ��Ͽ� �����ϱ�
		for(int i = 0; i < data.length; i++) {
			// ¦/Ȧ�� �Ǻ�
			if(data[i]%2 == 0) {
				// ¦���� �� ¦���հ� ������ ���ϱ�, ¦��ī��Ʈ �߰�
				eSum += data[i];
				eCnt++;
			} else {
				// Ȧ���� �� Ȧ���հ� ������ ���ϱ�
				oSum += data[i];
			}
		}
		
		System.out.println();
		System.out.println("Ȧ������ : " + oSum);
		System.out.println("¦����� : " + eSum/eCnt);
	}
}
