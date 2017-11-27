package com.special.improve;

import java.util.Scanner;

/** 
* 求一组数中最小的k个
* @author special
* @date 2017年11月26日 下午8:25:11
*/
public class Pro57Improve1 {
	private static void exch(int i, int j, int[] nums){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	/**
	 * 利用选择排序，外循环只需k次即可，简单粗暴
	 * @param n
	 * @param k
	 * @param nums
	 */
	public static void getMinK(int n, int k, int[] nums){
		for(int i = 0; i < k; i++){
			int min = i;
			for(int j = i + 1; j < n; j++){
				if(nums[j] < nums[min])
					min = j;
			}
			exch(min,i,nums);
		}
	}
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			int n = input.nextInt();
			int k = input.nextInt();
			int[] nums = new int[n];
			for (int i = 0; i < n; i++)
				nums[i] = input.nextInt();
			getMinK(n, k, nums);
			for (int i = 0; i < k; i++) {
				if (i < k - 1)
					System.out.print(nums[i] + " ");
				else
					System.out.println(nums[i]);
			}
		}
	}
}
