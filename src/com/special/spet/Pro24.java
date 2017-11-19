package com.special.spet;

import java.util.Scanner;

/** 
* 购物车
* 变形的 0 1背包问题
* 
* @author special
* @date 2017年9月17日 下午4:19:06
*/
public class Pro24 {
	public static int maxWeight(int[] price, int[] weight, int[] q, int n, int m){
		int[][] dp = new int[m + 1][n + 1];
		for(int i = 1; i <= m; i++){
			for(int j = 1; j <= n; j++){
				if(q[i - 1] == 0){
					if(price[i - 1] <= j)
						dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - price[i - 1]] + weight[i - 1]);
					else
						dp[i][j] = dp[i - 1][j];
				}
				else{
					if(price[i - 1] + price[q[i - 1] - 1] <= j)
						dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - price[i - 1] - price[q[i - 1]]] 
								          + weight[i - 1] + weight[q[i - 1]]);
					else
						dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[m][n];
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			int m = input.nextInt();
			int[] v = new int[m];
			int[] p = new int[m];
			int[] q = new int[m];
			for(int i = 0; i < m; i++){
				v[i] = input.nextInt();
				p[i] = input.nextInt() * v[i];
				q[i] = input.nextInt();
			}
			int maxWeight = maxWeight(v,p,q,n,m);
			System.out.println(maxWeight);
		}

	}

}
