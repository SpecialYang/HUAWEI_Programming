package com.special.spet;

import java.util.Scanner;

/** 
* ��һ�������Ķ�������1�ĸ���
* n &= n - 1 ÿ�����㶼����ʹ���λΪ1��λ����Ϊ0
* ���ڸ���������㷨ͬ�����ԣ�ֻ��������ǲ����к���1�ĸ���
* @author special
* @date 2017��11��29�� ����1:39:47
*/
public class Pro61 {
	public static int getNumOf1(int n){
		int result = 0;
		while(n != 0){
			n &= n - 1;
			result++;
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			int numOf1 = getNumOf1(n);
			System.out.println(numOf1);
		}
	}

}
