package com.special.improve;

import java.util.Scanner;

/** 
*
* @author special
* @date 2017年11月29日 上午11:37:53
*/
public class Pro60Improve1 {
	public static int putApple(int m, int n){
		if(m <= 0) return 0;
		if(m == 1 || n == 1) return 1;
		if(n > m) return putApple(m,m);
		else if(m != 0 && m == n)
			return putApple(m,n - 1) + 1;
		else
			return putApple(m,n - 1) + putApple(m - n,n);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int m = input.nextInt();
			int n = input.nextInt();
			int result = putApple(m,n);
			System.out.println(result);
		}
	}
}
