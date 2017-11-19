package com.special.spet;

import java.util.Scanner;

/** 
* 图片整理
* 把0到1，A到Z,a到z按acii码从小到大排列
* 计数排序
* 注意处理好索引
* @author special
* @date 2017年10月11日 下午1:23:34
*/
public class Pro33 {
	
	private static int getIndex(char temp){
		int index = 0;
		if(temp >= '0' && temp <= '9')
			index = temp - '0';
		else if(temp >= 'A' && temp <= 'Z')
			index = temp - 'A' + 10;
		else if(temp >= 'a' && temp <= 'z')
			index = temp - 'a' + 36;
		return index;
	}
	
	public static String getSequence(String str){
		int length = str.length();
		int max = 10 + 26 + 26 + 1;
		int[] aux    = new int[max];
		char[] result = new char[length];
		for(int i = 0; i < length; i++){
			char temp = str.charAt(i);
			aux[getIndex(temp)]++;
		}
		for(int i = 1; i < max; i++)
			aux[i] += aux[i - 1];
		for(int i = length - 1; i >= 0; i--){
			char temp = str.charAt(i);
			int index = getIndex(temp);
			/**
			 * 注意我们的待排序数组索引是从0开始
			 * 所以这里aux数组存的次数记得减一啊
			 */
			result[aux[index] - 1] = temp;
			aux[index]--;
		}
		return new String(result);
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str = input.nextLine();
			String result = getSequence(str);
			System.out.println(result);
		}

	}

}
