package com.special.improve;

import java.util.Scanner;

/** 
* 放苹果
* 若采用原方法的递归，时间会很慢，因为会对同样的子问题多次进行计算
* 所以我们考虑可以保存自问题的解，故采用动态规划
* dp[i][j] = dp[i][j - 1] + dp[i - j][j]
* 注意 i < j  赋值 0 非常巧妙
* @author special
* @date 2017年11月29日 下午1:22:01
*/
public class Pro60Improve2 {
	public static int putApple(int m, int n){
		int[][] dp = new int[m + 1][n + 1];
		for(int i = 0; i <= n; i++) dp[0][i] = 1;
		for(int i = 1; i <= m; i++)
			for(int j = 1; j <= n; j++)
				dp[i][j] = dp[i][j - 1] + (i < j ? 0 : dp[i - j][j]);
		return dp[m][n];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int m = input.nextInt();
			int n = input.nextInt();
			int result = putApple(m,n);
			System.out.println(result);
		}
	}
}
