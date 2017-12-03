package com.special.improve;

import java.util.Scanner;

/** 
* 公共字符串序列最大长度
* 每次截取一定长度的str1,利用contains判断str2是否包含
* 如果不包含，可以立即退出内循环，因为以i开头的字符串已经无法匹配了
* 
* 这个方法我可以比动态规划好理解一点，且代码紧凑！
* @author special
* @date 2017年12月3日 上午11:03:31
*/
public class Pro74Improve1 {
	public static int getCommonMaxLen(String str1, String str2){
		int maxLen = 0;
		for(int i = 0; i < str1.length() - 1; i++)
			for(int j = i + 1; j <= str1.length(); j++){
				String temp = str1.substring(i,j);
				if(!str2.contains(temp)) break;
				else if (j - i > maxLen) maxLen = j - i;
			}
		return maxLen;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str1 = input.next();
			String str2 = input.next();
			int commonMaxLen = getCommonMaxLen(str1,str2);
			System.out.println(commonMaxLen);
		}
	}
}
