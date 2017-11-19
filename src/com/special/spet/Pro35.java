package com.special.spet;

import java.util.Scanner;

/** 
* 字符串加密
* 还是利用空间换时间的方法
* 利用计数排序的思想，让字母作为索引，让出现的字母索引对应的值为1，这样可以剔除重复的字母
* 全部用大写字母来映射，小写的话转大写    -32
* @author special
* @date 2017年10月13日 下午3:39:10
*/
public class Pro35 {
	public static String encrypt(String key, String str){
		int[] flag = new int[26];
		char[] mapLetter = new char[26];
		int lengthKey = key.length();
		int lengthStr = str.length();
		char[] result = new char[lengthStr];
		int index = 0;
		/**
		 * 映射表的前面存key的set值
		 */
		for(int i = 0; i < lengthKey; i++){
			char temp = key.charAt(i);
			if(temp >= 'a' && temp <= 'z')
				temp -= 32;
			if(flag[temp - 'A'] == 0){
				flag[temp - 'A'] = 1;
				mapLetter[index++] = temp;
			}
		}
		/**
		 * 映射表后面取没出现的字母，依次摆放
		 */
		for(int i = 0; i < 26; i++)
			if(flag[i] == 0)
				mapLetter[index++] = (char) (i + 'A');
		for(int i = 0; i < lengthStr; i++){
			char temp = str.charAt(i);
			if(temp >= 'a' && temp <= 'z'){
				temp -= 32;
				result[i] = (char) (mapLetter[temp - 'A'] + 32);
			}
			else
				result[i] = mapLetter[temp - 'A'];
		}
		return new String(result);
	}
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String key = input.nextLine();
			String str = input.nextLine();
			String result = encrypt(key,str); 
			System.out.println(result);
		}
	}
}
