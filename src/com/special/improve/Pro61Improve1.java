package com.special.improve;

import java.util.Scanner;

/** 
* �������Ķ����ƺ���1����
* �˷�������λ��˼�룬�����λ��1���룬��Ϊ1����˵����λΪ1
* ע����������λ���õ��߼����Ʒ��ţ���ʵҲ���ǲ����������ƣ������λ��0
* ֻ�������������ø���
* @author special
* @date 2017��11��29�� ����1:57:53
*/
public class Pro61Improve1 {
	public static int getNumOf1(int n){
		int result = 0;
		while(n != 0){
			if((n & 1) == 1) result++;
			n >>>= 1;
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
