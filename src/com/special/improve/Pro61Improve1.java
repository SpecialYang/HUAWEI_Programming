package com.special.improve;

import java.util.Scanner;

/** 
* 求整数的二进制含有1个数
* 此法采用移位的思想，即最低位与1相与，若为1，则说明该位为1
* 注意我这里移位采用的逻辑右移符号，其实也就是不带符号右移，即最高位补0
* 只有这样采用适用负数
* @author special
* @date 2017年11月29日 下午1:57:53
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
