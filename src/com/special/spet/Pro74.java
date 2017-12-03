package com.special.spet;

import java.util.Scanner;

/** 
* 公共字符串最大长度
* 这里的dp[i][j]表示str1的前i个字符串与str2前j个字符串相等的长度
* 也就是包括i，j的当前匹配的长度，并不表示str1的前i个字符串与str2前j个字符串相等的最大长度
* 而是用另一个变量保存最大长度
* 
* 在improve里我们优化一下，让dp[i][j]为
* @author special
* @date 2017年12月3日 上午10:46:01
*/
public class Pro74 {
	public static int getCommonMaxLen(String str1, String str2){
		int length1 = str1.length();
		int length2 = str2.length();
		int[][] dp = new int[length1 + 1][length2 + 2];
		int maxLen = 0;
		for(int i = 1; i <= length1; i++)
			for(int j = 1; j <= length2; j++){
				if(str1.charAt(i - 1) == str2.charAt(j - 1)){
					dp[i][j] = dp[i - 1][j - 1] + 1;
					if(dp[i][j] > maxLen)
						maxLen = dp[i][j];
				}
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
