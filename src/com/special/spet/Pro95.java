package com.special.spet;

import java.util.Scanner;

/** 
* 给字符串中的数字两端加星号
* @author special
* @date 2017年12月11日 下午2:36:01
*/
public class Pro95 {
	private static boolean isNum(char ch){ return ch >= '0' && ch <= '9'; }
	
	public static void markNum(String str){
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < str.length();){
			if(isNum(str.charAt(i))){
				sb.append('*');
				do{
					sb.append(str.charAt(i++));
				}while(i < str.length() && isNum(str.charAt(i)));
				sb.append('*');
			}
			if(i < str.length()) sb.append(str.charAt(i++));
		}
		System.out.println(sb.toString());
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
