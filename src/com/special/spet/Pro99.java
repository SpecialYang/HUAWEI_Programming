package com.special.spet;

import java.util.Scanner;

/** 
* 等差数列求和
* @author special
* @date 2017年12月12日 下午11:09:34
*/
public class Pro99 {
	public static int cacluateSum(int n){
		if(n <= 0) return -1;
		return (int) (3 / 2.0 * n * n + 1 / 2.0 * n);
	}
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			int result = cacluateSum(n);
			System.out.println(result);
		}
	}
}
