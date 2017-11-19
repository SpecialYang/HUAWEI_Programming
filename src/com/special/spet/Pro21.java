package com.special.spet;

import java.util.Scanner;

/** 
* ��ˮƿ
* @author special
* @date 2017��9��13�� ����1:34:37
*/
public class Pro21 {
	
	/**
	 * ��Ϊÿ3����ƿ���Ի�һ�����ģ�����С�ڵ���3ʱֻ�ܺ�һ��
	 * ������3ʱ������4���һ�3����ƿ����ʣһ���������Լ�ʣ��һ�����ٸ��ϰ��һ�����ģ�
	 * ���꣬���3���������Ļ����ϰ塣���û��ƿ��
	 * ����5���һ�3����ƿ����ʣһ���������Լ�ʣ�����������öһ�һƿ���ꡣ���ֻʣ��һ����ƿ�ӣ�ֻ��û�취��
	 * �������ϣ����Եó�������3ʱ�����Ҽ�ȥ3��������������Ժ�  1 + (bottels - 3) / 2 + 1;
	 * ������3ʱ�����Ҽ�ȥ3����ż��������Ժ�  1 + (bottels - 3) / 2;
	 * @param bottels
	 * @return
	 */
	public static int getNumbers(int bottels){
		if(bottels <= 3)                 return 1;
		else if((bottels - 3) % 2 == 0)  return 1 + (bottels - 3) / 2;
		else                             return 1 + (bottels - 3) / 2 + 1;
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
