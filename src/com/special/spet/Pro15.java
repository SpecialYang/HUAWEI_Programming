package com.special.spet;

import java.util.Scanner;

/** 
*
* @author special
* @date 2017年9月6日 下午1:59:43
*/
public class Pro15 {
	
	public static int getNumsOfOne(int num){
		int count = 0;
		while(num != 0){
			if((num & 1) ==1)
				count++;
			num >>= 1;
		}
		return count;
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int num = input.nextInt();
			int count = getNumsOfOne(num);
			System.out.println(count);
		}

	}

}
