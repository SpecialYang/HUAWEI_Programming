package com.special.improve;

import java.util.Scanner;

/** 
* 最大回文子串
* 改进的动态规划做法
* 成功修复bug，即解决了不能处理abcefcba的情况
* 思路当两个项相等时，即判断当前的i，j索引之和-串长==当前已匹配的最大长度
* 因为i是从左开始的，j是从右开始，所以当匹配到最大长度时，应该满足
* i + j -length = dp[i][j]
* @author special
* @date 2017年12月7日 上午11:47:22
*/
public class Pro84Improve2 {
	public static int getHuiWenMaxLen(String str){
		int maxLen = 1;
		int length = str.length();
		String reverseStr = new StringBuilder(str).reverse().toString();
		int[][] dp = new int[length + 1][length + 1];
		for(int i = 1; i <= length; i++)
			for(int j = 1; j <= length; j++)
				if(str.charAt(i - 1) == reverseStr.charAt(j - 1)){
					dp[i][j] = dp[i - 1][j - 1] + 1;
					if(i + j - length == dp[i][j])
						maxLen = Math.max(maxLen, dp[i][j]);
				}
		return maxLen;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str = input.nextLine();
			int maxLen = getHuiWenMaxLen(str);
			System.out.println(maxLen);
		}
	}
}
