package Test;

import java.util.Arrays;

public class selectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int temp, min;
		int[] arr = {5, 8, 7, 1, 6};
		
		// �ε��� ����(����)
		for(int i = 0; i < arr.length - 1; i++)
		{
			min = i;
			// �ּҰ� ã��
			for(int j = i + 1; j < arr.length; j++)
			{
				// �ּҰ� ����ϱ�(ŵ�س���)
				if(arr[j] < arr[min])
				{
					min = j;
				}
			}
			
			// �ּ� ���� ���� �ε��� ���� ��ȯ
			temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
		}
		
		System.out.println(Arrays.toString(arr));
	}
}