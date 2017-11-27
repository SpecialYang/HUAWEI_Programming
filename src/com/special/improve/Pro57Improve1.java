package com.special.improve;

import java.util.Scanner;

/** 
* ��һ��������С��k��
* @author special
* @date 2017��11��26�� ����8:25:11
*/
public class Pro57Improve1 {
	private static void exch(int i, int j, int[] nums){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	/**
	 * ����ѡ��������ѭ��ֻ��k�μ��ɣ��򵥴ֱ�
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
