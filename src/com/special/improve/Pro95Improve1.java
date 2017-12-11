package com.special.improve;

import java.util.Scanner;

/** 
* 字符串中给数字两端添加星号
* @author special
* @date 2017年12月11日 下午2:47:31
*/
public class Pro95Improve1 {

	private static boolean isNum(char ch){ return ch >= '0' && ch <= '9'; }
	
	public static void markNum(String str){
		for(int i = 0; i < str.length();){
			if(isNum(str.charAt(i))){
				System.out.print("*");
				do{
					System.out.print(str.charAt(i++));
				}while(i < str.length() && isNum(str.charAt(i)));
				System.out.print("*");
			}
			if(i < str.length()) System.out.print(str.charAt(i++));
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str = input.nextLine();
			markNum(str);
		}
	}

}
