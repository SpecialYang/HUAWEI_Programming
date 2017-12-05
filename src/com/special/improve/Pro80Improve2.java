package com.special.improve;

import java.util.Scanner;

/** 
* 字符充当索引模拟map
* @author special
* @date 2017年12月5日 下午10:44:30
*/
public class Pro80Improve2 {
	public static int MAX_LENGTH_UNICODE = (int) Math.pow(2, 16);
	public static boolean isContainsAll(String str1, String str2){
		boolean[] map = new boolean[MAX_LENGTH_UNICODE];
		for(int i = 0; i < str2.length(); i++)
			map[str2.charAt(i)] = true;
		for(int i = 0; i < str1.length(); i++)
			if(!map[str1.charAt(i)])
				return false;
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
