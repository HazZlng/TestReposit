package Test;

import java.util.Arrays;

public class selectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int temp, min;
		int[] arr = {5, 8, 7, 1, 6};
		
		// 인덱스 지정(선택)
		for(int i = 0; i < arr.length - 1; i++)
		{
			min = i;
			// 최소값 찾기
			for(int j = i + 1; j < arr.length; j++)
			{
				// 최소값 기억하기(킵해놓기)
				if(arr[j] < arr[min])
				{
					min = j;
				}
			}
			
			// 최소 값과 현재 인덱스 값을 교환
			temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
		}
		
		System.out.println(Arrays.toString(arr));
	}
}