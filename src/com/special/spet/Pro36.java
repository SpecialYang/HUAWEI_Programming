package com.special.spet;

import java.util.Scanner;

/** 
* ͳ��ÿ���µ�����
* ��Ϊÿ���µ���������Ϊ��һ���µ������������ϸ��µ�����
* �ݹ�ȽϷѿռ䣬�����Ż�һ��
* @author special
* @date 2017��10��14�� ����11:33:52
*/
public class Pro36 {
	public static int getTotalCount(int monthCount){
		if(monthCount == 1 || monthCount == 2)
			return 1;
		return getTotalCount(monthCount - 2) + getTotalCount(monthCount - 1);
	}
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int monthCount = input.nextInt();
			int result     = getTotalCount(monthCount);
			System.out.println(result);
		}
	}
}
