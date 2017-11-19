package com.special.spet;

import java.util.Scanner;

/** 
* 多线程。。。。我不会，只好这样了。为以后买个坑
* @author special
* @date 2017年11月4日 下午10:48:08
*/
public class Pro48 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			while(n-- > 0)
				System.out.print("ABCD");
			System.out.println();
		}
	}
}
