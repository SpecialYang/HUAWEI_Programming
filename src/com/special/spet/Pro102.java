package com.special.spet;

import java.util.Scanner;

/** 
* 最长递增子序列长度
* 
* 动态规划做法 复杂度O(n的平方）
* dp[i]表示最后一个走i的最长的递增序列，那么之前的序列肯定存在与0 到 i - 1
* 所以选择0 到 i - 1 中 比它 矮的桩子过来，同时判断从这个桩子过来后，更新最大值即可
* 最后还需要一个全局的最长步数，来记录全局最长步长
* @author special
* @date 2017年12月17日 上午9:09:23
*/
public class Pro102 {
	public static int getMoreSteps(int[] height, int n){
		int steps = 0;
		int[] dp = new int[n + 1];
		for(int i = 1; i <= n; i++) dp[i] = 1;
		for(int i = 1; i <= n; i++){
			for(int j = 1; j < i; j++){
				if(height[j - 1] < height[i - 1]){
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			steps = Math.max(steps, dp[i]);
		}
		return steps;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			int[] height = new int[n];
			for(int i = 0; i < n; i++)
				height[i] = input.nextInt();
			int steps = getMoreSteps(height,n);
			System.out.println(steps);
		}
	}

}
