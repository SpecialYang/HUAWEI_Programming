package com.special.spet;

import java.util.Scanner;

/** 
*
* @author special
* @date 2017年9月6日 上午9:07:52
*/
public class Pro12 {
	/**
	 * 获取一个字符串的逆序字符串输出
	 * @param num
	 * @return
	 */
	public static String getReverseStr(String inputStr){
		StringBuilder result = new StringBuilder();
		for(int i = inputStr.length() - 1; i >= 0; i--)
			result.append(inputStr.charAt(i));
		return result.toString();
	}
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String num = input.nextLine();
			String result = getReverseStr(num);
			System.out.println(result);
		}
	}
}
