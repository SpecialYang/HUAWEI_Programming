package com.special.spet;

import java.util.Scanner;

/** 
* 通配符匹配，不知道咋做对了
* 可能情况没有涵盖全部
* @author special
* @date 2017年12月2日 上午11:54:16
*/
public class Pro70 {
	public static boolean isMatch(String matchStr, String originStr){
		int matchLen = matchStr.length();
		int oriLen = originStr.length();
		boolean flag = true;
		int index = 0;
		int i = 0;
		while(i < oriLen && index < matchLen){
			char item = originStr.charAt(i);
			if (matchStr.charAt(index) == '?' || item == matchStr.charAt(index)) {
				index++;
				i++;
			} else if (matchStr.charAt(index) == '*' 
					&& (index + 1) < matchLen && (i + 1) < oriLen
					&& originStr.charAt(i + 1) == matchStr.charAt(index + 1)) {
				index += 2;
				i += 2;
			} else if (matchStr.charAt(index) == '*') {
				i++;
			} else {
				flag = false;
				break;
			}
		}
		if(!flag || i < oriLen) return false;
		else                    return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String matchStr = input.nextLine();
			String originStr = input.nextLine();
			boolean result = isMatch(matchStr,originStr);
			System.out.println(result);
		}
	}

}
