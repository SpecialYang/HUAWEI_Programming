package com.special.spet;

import java.util.Scanner;

/** 
* 找出两个字符串的公共最大长度字串，若有多个，则输出最先在短字符串出现的
* 动态规划问题
* dp[i][j]表示前i个字符串与前j个字符串的公共最长的字符串的长度
* 若 第i个字符与第j个字符相等，则dp[i][j] = dp[i - 1][j - 1] + 1
* 否则 dp[i][j] = 0
* @author special
* @date 2017年11月30日 上午9:37:15
*/
public class Pro64 {
	public static String getCommonMaxSubStr(String str1, String str2){
		if(str1.length() > str2.length()){
			String temp = str2;
			str2 = str1;
			str1 = temp;
		}
		int length1 = str1.length();
		int length2 = str2.length();
		int[][] dp = new int[length1 + 1][length2 + 1];
		int end = 0;
		int max = 0;
		for(int i = 1; i <= length1; i++)
			for(int j = 1; j <= length2; j++){
				if(str1.charAt(i - 1) == str2.charAt(j - 1))
					dp[i][j] = dp[i - 1][j - 1] + 1;
				if(dp[i][j] > max){
					max = dp[i][j];
					end = i;
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
