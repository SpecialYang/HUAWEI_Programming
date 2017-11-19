package com.special.improve;

import java.util.Scanner;

/** 
* �������⣬�ֱ����ÿ����һ���´󣬶����´������´������
* �����Ӿ����ܵ�������
* @author special
* @date 2017��10��14�� ����11:46:59
*/
public class Pro36Improve {
	public static int getTotalCount(int monthCount){
		int a = 1, b = 0, c = 0;
		while(--monthCount > 0){
			c += b; //ÿ��һ���£������´������������һ
			b  = a; //ÿ��һ���£������´������������һ
			a  = c; //ÿ��һ���£�һ���´�������������������´��������������Ϊ���Ƕ���������һ��
		}
		return a + b + c;
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int monthCount = input.nextInt();
			int result     = getTotalCount(monthCount);
			System.out.println(result);
		}
	}

}
