package com.special.improve;

import java.util.Scanner;

/** 
*
* @author special
* @date 2017年9月18日 下午1:49:32
*/
public class Pro25Improve2 {
	public static boolean isNotLetter(char ch){
		if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))
			return false;
		return true;
	}
	
	public static char toLower(char ch){
		if(ch >= 'A' && ch <= 'Z')
			return (char) ('a' + ch - 'A');
		return ch;
	}
	
	/**
	 * 变形的冒泡
	 * 非字母不参与排序
	 * @param str
	 * @return
	 */
	public static char[] sort(String str){
		int length = str.length();
		char[] strArray = str.toCharArray();
		int letterFirstIndex = 0;
		/**
		 * 找到第一字母的位置
		 * 方便我们下面循环的时候，内循环少一点。
		 */
		while(isNotLetter(strArray[letterFirstIndex]))
			letterFirstIndex++;
		for(int i = 0; i < length; i++){
			int swapIndex = letterFirstIndex;
			for(int j = swapIndex + 1; j < length - i; j++){
				if(isNotLetter(strArray[j])) continue;    //如果该位置不是字母，继续下一个
				/**
				 * 若上一个位置的字母大于当前位置字母，则交换
				 */
				if(toLower(strArray[swapIndex]) > toLower(strArray[j])){ 
					char temp = strArray[j];
					strArray[j] = strArray[swapIndex];
					strArray[swapIndex] = temp;
				}
				/**
				 * 无论是否交换，都应该记住j的位置
				 * 因为j的位置永远代表最大的
				 */
				swapIndex = j; 
			}
		}
		return strArray;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str = input.nextLine();
			char[] result = sort(str);
			System.out.println(result);
		}
	}
}
