package com.special.spet;

import java.util.Scanner;

/**  
* 一个偶数总是能有2个质数求和得到（不包括2）
* 找出差值最小的2个质数
* 从中间往两边找
* @author special
* @date 2017年11月27日 下午2:28:37
*/
public class Pro59 {
	public static boolean isPrime(int num){
		for(int i = 2; i <= Math.sqrt(num); i++)
			if(num % i == 0)
				return false;
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int num = input.nextInt();
			for(int i = num / 2; i >= 1; i--)
				if(isPrime(i) && isPrime(num - i)){
					System.out.println(i + "\n" + (num - i));
					break;
				}
		}
	}
}
