package com.special.improve;

import java.util.Scanner;

/** 
* ţ�Ƶ��뷨
* ��λ���뼴���ҵ��������1�ĸ���
* ��n & (n - 1)˼������
* @author special
* @date 2017��12��7�� ����3:09:52
*/
public class Pro85Improve1 {
	public static int getNumOfContinuousOne(int num){
		int result = 0;
		while(num != 0){
			num &= (num << 1);
			result++;
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int num = input.nextInt();
			int result = getNumOfContinuousOne(num);
			System.out.println(result);
		}
	}
}
