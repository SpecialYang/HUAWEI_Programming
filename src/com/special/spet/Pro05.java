package com.special.spet;

import java.util.Scanner;

/** 
* 类比十进制，我们每次给一个数的尾部添加一位，就相当于本数增加十倍
* 所以，十六进制，我们同样可以这样做，只不过是每次都增加十六倍而已
* @author special
* @date 2017年9月4日 上午10:25:18
*/
public class Pro05 {
	public static int getTenth(char ch){
		int result = 0;
		if(ch>='A'&&ch<='F')
			result = 10 + ch - 'A';
		else if(ch>='a'&&ch<='f')
			result = 10 + ch - 'a';
		else
			result = ch - 48;
		return result;
	}
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int result = 0;
			String inputStr = input.next();
			for(int i = 2;i < inputStr.length(); i++){
				char temp = inputStr.charAt(i);
				result = result*16 + getTenth(temp);
				}
			System.out.println(result);
		}
	}
}
