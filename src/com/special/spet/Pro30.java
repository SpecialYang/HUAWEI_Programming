package com.special.spet;

import java.util.Scanner;

/** 
* 单词倒排
* 利用一个辅助变量firstLetter，来记录第一个是字母的位置
* 然后利用循环变量i循环到之后第一个不是字母的位置
* 这样firstLetter 到  i 之间就是一个单词
* 注意：要处理一下最后不是单词的情况，否则会把一个空串赋值给字符串数组
* @author special
* @date 2017年9月28日 下午1:01:33
*/
public class Pro30 {
	private static boolean isLetter(char ch){
		if(ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z')
			 return true;
		else return false;
	}
	public static String reverse(String str){
		int length = str.length();
		String[] letters = new String[length];
		int index = 0;
		for(int i = 0; i < length;){
			int firstLetter = i;
			while(firstLetter < length && !isLetter(str.charAt(firstLetter)))
				firstLetter++;
			i = firstLetter;
			while(i < length && isLetter(str.charAt(i)))
				i++;
			if(i > firstLetter)
				letters[index++] = str.substring(firstLetter,i);
		}
		StringBuilder result = new StringBuilder();
		for(int i = index - 1; i > 0; i--){
			result.append(letters[i]);
			result.append(' ');
		}
		result.append(letters[0]);
		return result.toString();
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str = input.nextLine();
			String result = reverse(str);
			System.out.print(result);
		}

	}

}
