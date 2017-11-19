package com.special.spet;

import java.util.Scanner;

/** 
* С����ظ߶� 
* ����һ����뷨�� ����Ҳ����ȫ�����
* ��Ϊ����Կ���times
* @author special
* @date 2017��10��15�� ����7:06:11
*/
public class Pro37 {
	public static double getJourney(int high, int times){
		double tenthHigh = high;
		double result = tenthHigh;
		for(int i = 2; i <= times; i++){
			tenthHigh /= 2;
			result += tenthHigh * 2;
		}
		return result;
	}
	public static double getTenthHigh(int high, int times){
		double tenthHigh = high;
		for(int i = 1; i <= times; i++)
			tenthHigh /= 2;
		return tenthHigh;
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int high = input.nextInt();
			//int times = input.nextInt();
			int times = 5;
			double journey = getJourney(high,times);
			double tenthHigh = getTenthHigh(high,times);
			System.out.println(journey);
			System.out.println(tenthHigh);
		}
	}

}
