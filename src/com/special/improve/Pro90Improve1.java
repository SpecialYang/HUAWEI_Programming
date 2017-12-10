package com.special.improve;

import java.util.Scanner;

/** 
* 棋盘走路的动态规划
* 问题可以转换为
* dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
* 
* 技巧：对dp[i][0] 和 dp[0][i]的处理很关键
* @author special
* @date 2017年12月9日 上午11:12:21
*/
public class Pro90Improve1 {
	public static int getKinds(int n, int m){
		int[][] dp = new int[n + 1][m + 1];
		for(int i = 0; i <= n; i++) dp[i][0] = 1;
		for(int i = 0; i <= m; i++) dp[0][i] = 1; //i从0开始，其实是为了输入 0 0时，输出1
		for(int i = 1; i <= n; i++)
			for(int j = 1; j <= m; j++)
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
		return dp[n][m];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			int m = input.nextInt();
			
			int kinds = getKinds(n,m);
			System.out.println(kinds);
		}
	}

}
