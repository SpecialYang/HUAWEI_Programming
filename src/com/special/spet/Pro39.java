package com.special.spet;

import java.util.Scanner;

/** 
* 统计字符个数
* @author special
* @date 2017年10月18日 下午1:24:18
*/
public class Pro39 {
	private static boolean isLetter(char ch){
		if(ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z')
			return true;
		else return false;
	}
	private static boolean isBlank(char ch){
		if(ch == ' ')
			return true;
		else return false;
	}
	private static boolean isNumber(char ch){
		if(ch >= '0' && ch <= '9')
			return true;
		else return false;
	}
	public static int getEnglishCharCount(String str){
		int count = 0;
		for(int i = 0; i < str.length(); i++){
			if(isLetter(str.charAt(i)))
				count++;
		}
		return count;
	}
	public static int getBlankCharCount(String str){
		int count = 0;
		for(int i = 0; i < str.length(); i++){
			if(isBlank(str.charAt(i)))
				count++;
		}
		return count;
	}
	public static int getNumberCharCount(String str){
		int count = 0;
		for(int i = 0; i < str.length(); i++){
			if(isNumber(str.charAt(i)))
				count++;
		}
		return count;
	}
	public static int getOtherCharCount(String str){
		int count = 0;
		/**
		 * 当时只想起来这个方法了，有点笨啊，还的必须把所有的判断拿出来
		 */
		/*for(int i = 0; i < str.length(); i++){
			char temp = str.charAt(i);
			if(!isLetter(temp) && !isBlank(temp) && !isNumber(temp))
				count++;
		}*/
		/**
		 * 牛逼的想法：利用之前的函数，用""+temp 形成字符串然后判断之前是否都为0
		 */
		for(int i = 0; i < str.length(); i++){
			String temp = "" + str.charAt(i);
			if(getEnglishCharCount(temp) == 0 && getBlankCharCount(temp) == 0
			&& getNumberCharCount(temp) == 0)
				count++;
		}
		return count;
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str = input.nextLine();
			int countLetter = getEnglishCharCount(str);
			int countBlank  = getBlankCharCount(str);
			int countNumber = getNumberCharCount(str);
			int countOther  = getOtherCharCount(str);
			System.out.println(countLetter);
			System.out.println(countBlank);
			System.out.println(countNumber);
			System.out.println(countOther);
		}
	}

}
