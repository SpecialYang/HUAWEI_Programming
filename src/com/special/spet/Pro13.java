package com.special.spet;

import java.util.Scanner;

/** 
*
* @author special
* @date 2017年9月6日 上午9:14:05
*/
public class Pro13 {
	public static String getReverseSentence(String sentence){
		String[] input  = sentence.split(" ");
		StringBuilder result = new StringBuilder(); 
		for(int i = input.length - 1; i >= 0; i--){
			result.append(input[i]);
			result.append(" ");
		}
		return result.substring(0, sentence.length());
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String sentence = input.nextLine();
			String reverseSentence = getReverseSentence(sentence);
			System.out.println(reverseSentence);
		}
	}

}
