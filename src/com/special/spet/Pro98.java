package com.special.spet;

import java.util.Scanner;

/** 
* ������
* 
* �ж�һ���ַ��Ƿ�����һ���ĺ�׺
* ˼·�������ַ���������������ɵõ���ʼ������
* ����Ϊ����Ǻ�׺����׺���������������ȣ�
* ����������ʼ�����������ֲ��������
* @author special
* @date 2017��12��11�� ����11:11:31
*/
public class Pro98 {
	private static boolean isEndWithI(int square, int num){
		String squareStr = String.valueOf(square);
		String numStr = String.valueOf(num);
		int index = squareStr.length() - numStr.length();
		return squareStr.substring(index).equals(numStr);
	}
	public static int getCount(int n){
		int count = 0;
		for(int i = 0; i <= n; i++)
			if(isEndWithI(i * i,i))
				count++;
		return count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			int count = getCount(n);
			System.out.println(count);
		}
	}

}
