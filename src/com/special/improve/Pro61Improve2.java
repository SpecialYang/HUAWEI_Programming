package com.special.improve;

import java.util.Scanner;

/** 
*
* @author special
* @date 2017年11月29日 下午2:04:41
*/
public class Pro61Improve2 {
	public static int getNumOf1(int n){
		int result = 0;
		int digit = 1;
		for(int i = 0; i < 32; i++){
			if((n & digit) != 0) result++;
			digit <<= 1;
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
