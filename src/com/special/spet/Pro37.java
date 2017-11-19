package com.special.spet;

import java.util.Scanner;

/** 
* 小球落地高度 
* 这是一般的想法， 并且也符合全部情况
* 因为你可以控制times
* @author special
* @date 2017年10月15日 下午7:06:11
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
