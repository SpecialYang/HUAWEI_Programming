package com.special.spet;

import java.util.Scanner;

/** 
* 字符串的相似度
* 题目其实与pro48一样，只不过这里多一步倒数的表示
* dp[i][j]表示前i个字符表示为前j个字符所需的最小操作数
* 4种情况求最小：
* 1.若第i个和第j个相等，则dp[i][j] = dp[i - 1][j - 1]
* 2.若第i个和第j个不想等，则dp[i][j] = dp[i - 1][j - 1] + 1;
* 这两种基本情况可能的操作数大于dp[i][j - 1] + 1和dp[i - 1][j] + 1
* 所以要求这3者最小的一种的情况。
* @author special
* @date 2017年12月5日 下午3:33:55
*/
public class Pro78 {
	public static int getDistance(String str1, String str2){
		int length1 = str1.length();
		int length2 = str2.length();
		int[][] dp = new int[length1 + 1][length2 + 1];
		for(int i = 1; i <= length1; i++) dp[i][0] = i;
		for(int i = 1; i <= length2; i++) dp[0][i] = i;
		for(int i = 1; i <= length1; i++)
			for(int j = 1; j <= length2; j++){
				if(str1.charAt(i - 1) == str2.charAt(j - 1))
					dp[i][j] = dp[i - 1][j - 1];
				else
					dp[i][j] = dp[i - 1][j - 1] + 1;
				dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]) + 1,dp[i][j]);
			}
		return dp[length1][length2];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str1 = input.nextLine();
			String str2 = input.nextLine();
			int distance = getDistance(str1,str2);
			System.out.println("1/" + (distance + 1));
		}
	}

}
