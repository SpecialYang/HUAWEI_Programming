package com.special.improve;

import java.util.Scanner;

/** 
* 找出两个字符串的公共最大长度字串，若有多个，则输出最先在短字符串出现的
* 暴力解法
* 对短串的中每一个字串判断是否在长串中出现，利用string的库函数即可
* 注意内循环中若不包含的话，可以直接退出，因为之后包含这个字符的串在长串中肯定不存在啊
* @author special
* @date 2017年11月30日 上午10:18:44
*/
public class Pro64Improve1 {
	public static String getCommonMaxSubStr(String str1, String str2){
		if(str1.length() > str2.length()){
			String temp = str2;
			str2 = str1;
			str1 = temp;
		}
		int length1 = str1.length();
		int end = 0;
		int max = 0;
		for(int i = 0; i < length1 - 1; i++)
			for(int j = i + 1; j < length1; j++){
				String temp = str1.substring(i, j);
				if(!str2.contains(temp))
					break;
				else if(j - i > max){
					max = j - i;
					end = j;
				}
			}
		return str1.substring(end - max, end);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str1 = input.nextLine();
			String str2 = input.nextLine();
			String commonMaxSubStr = getCommonMaxSubStr(str1,str2);
			System.out.println(commonMaxSubStr);
		}
	}
}
