package com.special.spet;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** 
* 给定字符串，分割8个字符串，不够8个补0
* 我的代码，看起来好多，好复杂啊，自己好笨啊！！！！！
* @author special
* @date 2017年9月2日 下午2:05:19
*/
public class Pro04 {
	public static String getZeroString(int n){
		StringBuilder zeroString = new StringBuilder();
		while(n-- > 0)
			zeroString.append("0");
		return zeroString.toString();
	}
	public static void deriveSubString(List<String> result,String str,int targetLength){
		int strLength = str.length();
		for(int i = 0;i < strLength;i=i+targetLength){
			if(i + targetLength < strLength)
				result.add(str.substring(i, i + targetLength));
			else{
				result.add(str.substring(i,strLength)+getZeroString(i+targetLength-strLength));
			}
				
		}
	}
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int chances = 2;
		int targetLength = 8;
		List<String> result = new ArrayList<String>();
		while(chances-- != 0){
			String str = input.nextLine();
			deriveSubString(result,str,targetLength);
		}
		for(String item : result)
			System.out.println(item);
	}
}
