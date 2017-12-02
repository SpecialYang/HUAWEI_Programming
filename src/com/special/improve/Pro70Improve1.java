package com.special.improve;

import java.util.Scanner;

/** 
* 通配符问题
* 动态规划
* dp[i][j]表示str1的前i个字符匹配str2的前j个字符的长度
* 有3种情况：
* 1.若str1的第i个字符为?表示它与str2的第j个字符相等  dp[i][j] = dp[i - 1][j - 1] + 1;
* 2.若str1的第i个字符与str2的第j个字符相等                    dp[i][j] = dp[i - 1][j - 1] + 1;
* 3.若str1的第i个字符为*,若此时j的索引小于i        dp[i][j] = dp[i - 1][j];(表示*不匹配任何字符)
*                      若此时j的索引大于等于i	   dp[i][j] = dp[i][j - 1] + 1;(表示*在j-1的基础再匹配一个）
* 4.若以上都不成立，那么就是str1的第i个字符与str2的第j个字符不相等，dp[i][j] = 0;
* 
* 最后判断dp[i][j] == str2.length(),即可知道str1是否匹配到了str2
* 
* 这种字符串问题应多往动态规划上想。
* @author special
* @date 2017年12月2日 下午2:28:48
*/
public class Pro70Improve1 {
	public static boolean isMatch(String matchStr, String originStr){
		int length1 = matchStr.length();
		int length2 = originStr.length();
		int[][] dp = new int[length1 + 1][length2 + 1];
		for(int i = 1; i <= length1; i++)
			for(int j = 1; j <= length2; j++){
				if(matchStr.charAt(i - 1) == '?' || matchStr.charAt(i - 1) == originStr.charAt(j - 1))
					dp[i][j] = dp[i - 1][j - 1] + 1;
				else if(matchStr.charAt(i - 1) == '*'){
					dp[i][j] = j < i ? dp[i - 1][j] : dp[i][j - 1] + 1;
				}
			}
		return dp[length1][length2] == length2;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String matchStr = input.nextLine();
			String originStr = input.nextLine();
			boolean result = isMatch(matchStr,originStr);
			System.out.println(result);
		}
	}
}
