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
		
		// 랜덤값 추출해서 배열크기 정하기
		rNum = r.nextInt(3) + 3;
		data = new int[rNum];
		
		// 랜덤값 추출 후 배열에 넣기
		System.out.print("[ ");
		for(int i = 0; i < data.length; i++) {
			 data[i] = r.nextInt(6) + 100;
			 // 심화1. 랜덤으로 저장한 정수가 기존에 배열에 넣은 정수와 비교하여
			 //		  같을 시 해당 반복을 되돌린다.
			 for(int j = 0; j < i; j++) {
				 if(data[i] == data[j]) {
					 i--;
				 }
			 }
			 
	         System.out.print(data[i] + " ");
		}
		System.out.print(" ]");
		
		// 배열값 짝/홀수 판별하여 저장하기
		for(int i = 0; i < data.length; i++) {
			// 짝/홀수 판별
			if(data[i]%2 == 0) {
				// 짝수일 시 짝수합계 변수에 더하기, 짝수카운트 추가
				eSum += data[i];
				eCnt++;
			} else {
				// 홀수일 시 홀수합계 변수에 더하기
				oSum += data[i];
			}
		}
		
		System.out.println();
		System.out.println("홀수총합 : " + oSum);
		System.out.println("짝수평균 : " + eSum/eCnt);
	}
}
