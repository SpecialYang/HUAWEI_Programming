package com.special.spet;

import java.util.Scanner;

/** 
*
* @author special
* @date 2017年12月6日 下午7:41:14
*/
public class Pro83 {
	public static int getNumOfUpper(String str){
		int result = 0;
		for(int i = 0; i < str.length(); i++)
			if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')
				result++;
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str = input.nextLine();
			int result = getNumOfUpper(str);
			System.out.println(result);
		}
	}

}
