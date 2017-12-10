package com.special.spet;

import java.util.Scanner;

/** 
* 密码强度检测
* 注意一次遍历就行，用各变量记录要求
* @author special
* @date 2017年12月7日 下午11:21:25
*/
public class Pro86 {
	private static boolean isToken(char ch){
		if(ch >= 0x21 && ch <= 0x2F 
					                || ch >= 0x3A && ch <= 0x40
									|| ch >= 0x5B && ch <= 0x60
									|| ch >= 0x7B && ch <= 0x7E)
			return true;
		return false;
	}
	public static int getPwdSecurityLevel(String str){
		int result = 0;
		int length = str.length();
		if(length <= 4)
			result += 5;
		else if(length >= 5 && length <= 7)
			result += 10;
		else result += 25;
		boolean isExitLower = false;
		boolean isExitUpper = false;
		int countOfNum = 0;
		int countOfToken = 0;
		for(int i = 0; i < length; i++){
			char item = str.charAt(i);
			if(item >= 'A' && item <= 'Z')
				isExitUpper = true;
			else if(item >= 'a' && item <= 'z')
				isExitLower = true;
			else if(item >= '0' && item <= '9')
				countOfNum++;
			else if(isToken(item))
				countOfToken++;
		}
		if(isExitLower && isExitUpper)
			result += 20;
		else if(isExitLower || isExitUpper)
			result += 10;
		if(countOfNum > 1)
			result += 20;
		else if(countOfNum == 1)
			result += 10;
		if(countOfToken > 1)
			result += 25;
		else if(countOfToken == 1)
			result += 10;
		if(isExitLower && isExitUpper && countOfNum > 0 && countOfToken > 0)
			result += 5;
		else if((isExitLower || isExitUpper) && countOfNum > 0 && countOfToken > 0)
			result += 3;
		else if((isExitLower || isExitUpper) && countOfNum > 0)
			result += 2;
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String psw = input.nextLine();
			int score = getPwdSecurityLevel(psw);
			if(score >= 90)
				System.out.println("VERY_SECURE");
			else if(score >= 80)
				System.out.println("SECURE");
			else if(score >= 70)
				System.out.println("VERY_STRONG");
			else if(score >= 60)
				System.out.println("STRONG");
			else if(score >= 50)
				System.out.println("AVERAGE");
			else if(score >= 25)
				System.out.println("WEAK");
			else if(score >= 0)
				System.out.println("VERY_WEAK");
		}
	}	

}
