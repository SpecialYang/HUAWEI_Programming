package com.special.spet;

import java.util.Scanner;

/** 
* 日期到天数的转换
* @author special
* @date 2017年12月2日 下午5:29:34
*/
public class Pro72 {
	public static int[] daysOfMonth = {31,28,31,30,31,30,31,31,30,31,30,31};
	
	private static boolean isLeapYear(int year){
		return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int year = input.nextInt();
			int month = input.nextInt();
			int day = input.nextInt();
			if(isLeapYear(year)) daysOfMonth[1] = 29;
			else                 daysOfMonth[1] = 28;
			if(month < 1 || month > 12 || day < 1 || day > daysOfMonth[month - 1])
				System.out.println(-1);
			else {
				int days = 0;
				for (int i = 0; i < month - 1; i++)
					days += daysOfMonth[i];
				days += day;
				System.out.println(days);
			}
		}
	}

}
