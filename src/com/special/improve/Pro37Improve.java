package com.special.improve;

import java.util.Scanner;

/** 
* ����϶��� 1�ı�����
* �û��ǵ���������Ϊ������ʲô���ʽ�������ԴӶ���ʽ���ҳ�1�Ĺ�������
* @author special
* @date 2017��10��15�� ����7:31:27
*/
public class Pro37Improve {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int high = input.nextInt();
			System.out.println(high * 2.875);
			System.out.println(high * 0.03125);
		}

	}

}
