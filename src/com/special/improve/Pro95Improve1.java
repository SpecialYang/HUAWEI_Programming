package com.special.improve;

import java.util.Scanner;

/** 
* �ַ����и�������������Ǻ�
* @author special
* @date 2017��12��11�� ����2:47:31
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
