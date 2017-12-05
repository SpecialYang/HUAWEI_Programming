package com.special.spet;

import java.util.Scanner;

/** 
* 字符串匹配问题
* 也就是短串的中字符是否都在长串中
* @author special
* @date 2017年12月5日 下午10:17:56
*/
public class Pro80 {
	public static boolean isContainsAll(String str1, String str2){
		for(int i = 0; i < str1.length(); i++){
			if(!str2.contains(Character.toString(str1.charAt(i))))
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str1 = input.nextLine();
			String str2 = input.nextLine();
			if(isContainsAll(str1,str2))
				System.out.println(true);
			else
				System.out.println(false);
		}
	}

}
