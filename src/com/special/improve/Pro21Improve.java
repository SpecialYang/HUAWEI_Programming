package com.special.improve;

import java.util.Scanner;

/** 
*
* @author special
* @date 2017��9��13�� ����2:06:47
*/
public class Pro21Improve {
	
	/**
	 * ��ţ�Ƶ��뷨����ÿ������ƿ�Ӷ����ϰ��һ�Σ�����ͻ������������� bottels / 2
	 * ̫ţ���ˣ�������������
	 * @param bottels
	 * @return
	 */
	public static int getNumbers(int bottels){
		return bottels / 2;
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N = 10;
		int count = 0;
		int[] numbers = new int[10];
		while(input.hasNext()){
			int bottels = input.nextInt();
			if(bottels == 0 || count >= 10)  break;
			else numbers[count++] = getNumbers(bottels);
		}
		for(int i = 0; i < count; i++)
			System.out.println(numbers[i]);
	}
}
