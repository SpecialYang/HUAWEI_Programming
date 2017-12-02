package com.special.improve;

import java.util.Scanner;

/** 
* 通配符问题
* 动态规划
* dp[i][j] = true; 表示前i个字符能够匹配前j个字符
* 有2种情况
* 1.i为*号，即i可以匹配j，也可以不匹配j
* 所以dp[i][j] = dp[i - 1][j] || dp[i][j - 1]
* 2.i不为*号，匹配由当前是否相等或者是否为冒号
* dp[i][j] = dp[i - 1][j - 1] && (ch1 == '?' || ch1 == ch2)
* 
* 注意初始值判定。我们设置了dp[0][0] = T
* 同时对dp[i][0]也要判断当前否为*号和前面是否也是T，才能确定前i个能够匹配0个字符串。
* @author special
* @date 2017年12月2日 下午3:37:06
*/
public class Pro70Improve2 {
	public static boolean isMatch(String matchStr, String originStr){
		int length1 = matchStr.length();
		int length2 = originStr.length();
		boolean[][] dp = new boolean[length1 + 1][length2 + 1];
		dp[0][0] = true;
		for(int i = 1; i <= length1; i++){
			char ch1 = matchStr.charAt(i - 1);
			dp[i][0] = dp[i - 1][0] && ch1 == '*';
			for(int j = 1; j <= length2; j++){
				char ch2 = originStr.charAt(j - 1);
				if(ch1 == '*')
					dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
				else
					dp[i][j] = dp[i - 1][j - 1] && (ch1 == '?' || ch1 == ch2);
			}
		}
		return dp[length1][length2];
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
