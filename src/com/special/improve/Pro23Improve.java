package com.special.improve;

import java.util.Scanner;

/** 
* 求最长子序列问题的变形
* dp[i] 表示到i位置，最长递增子序列的长度
* 初始都是1
* if dp[j] < dp[i]  then dp[i] = dp[j] + 1
* @author special
* @date 2017年9月16日 下午4:54:46
*/
public class Pro23Improve {
	/**
	 * 最长递增子序列
	 * @param status
	 * @param incDp
	 */
	public static void getLengthLIC(int[] status, int[] incDp){
		int sizeOfArray = status.length;
		for(int i = 1; i < sizeOfArray; i++)
			for(int j = i - 1; j >= 0; j--){
				if(status[j] < status[i] && incDp[i] < incDp[j] + 1)
					incDp[i] = incDp[j] + 1;
			}
	}
	/**
	 * 最长递减子序列
	 * @param status
	 * @param decDp
	 */
	public static void getLengthLDC(int[] status, int[] decDp){
		int sizeOfArray = status.length;
		for(int i = sizeOfArray - 2; i >= 0; i--)
			for(int j = i + 1; j < sizeOfArray; j++){
				if(status[j] < status[i] && decDp[i] < decDp[j] + 1)
					decDp[i] = decDp[j] + 1;
			}
	}
	/**
	 * 每个位置的最长递增序列与最长递减序列的和
	 * 表示以该位置为中心，呈尖峰状分布的最长长度
	 * @param inc
	 * @param dec
	 * @return
	 */
	public static int getLengthIncDec(int[] inc, int[] dec){
		int max = -1;
		int length = inc.length;
		for(int i = 0; i < length; i++)
			max = Math.max(max,inc[i] + dec[i]);
		/**
		 * 最后减一的目的因为相加时，中间最大的那个元素加了2遍
		 */
		return max - 1;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int num = input.nextInt();
			int[] status = new int[num];
			int[] incDp = new int[num];
			int[] decDp = new int[num];
			for (int i = 0; i < num; i++) {
				int n = input.nextInt();
				status[i] = n;
				incDp[i] = 1;
				decDp[i] = 1;
			}
			getLengthLIC(status, incDp);
			getLengthLDC(status, decDp);
			int max = getLengthIncDec(incDp, decDp);
			System.out.println(num - max);
		}
	}
}
