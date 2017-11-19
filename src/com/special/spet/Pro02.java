package com.special.spet;

import java.util.Scanner;

/** 
* @author special
* @date 2017年9月1日 下午8:43:54
*/

public class Pro02 {
	public static int searchNumOfChar(String str,char targetChar){
		int num = 0;
		for(char item : str.toLowerCase().toCharArray())
			if(item == targetChar||((item > 96 && item < 123)&&(item-32)==targetChar))
				num++;
		return num;
	}
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		String str = input.nextLine();
		String targetChar = input.next();
		int num = searchNumOfChar(str,targetChar.charAt(0));
		System.out.println(num);
	}
}
