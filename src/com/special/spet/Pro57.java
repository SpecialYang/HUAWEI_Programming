package com.special.spet;

import java.util.Scanner;

/** 
* ��һ������С��k��
* �ÿ��������˼�룬�ҵ����ֵ����ô���kλ�õ�ʱ��
* ���ǻ�Ϊ��ô���ܿӵ�����ȻҪ����k��С��
* @author special
* @date 2017��11��26�� ����5:19:01
*/
public class Pro57 {
	private static void exch(int i, int j, int[] nums){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	private static int partion(int low, int high, int[] nums){
		int partion = nums[low];
		int i = low; 
		int j = high + 1;
		while(i < j){
			while(i < high && nums[++i] < partion);
			while(j > low && nums[--j] > partion);
			if(i >= j) break;
			else exch(i,j,nums);
		}
		exch(low,j,nums);
		return j;
	}
	public static void getMinK(int n, int k, int[] nums){
		int low = 0;
		int high = n - 1;
		int index = partion(low,high,nums);
		while(index != k - 1){
			if (index > k - 1)
				index = partion(low, index - 1, nums);
			else if (index < k - 1)
				index = partion(index + 1, high, nums);
		}
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			int k = input.nextInt();
			int[] nums = new int[n];
			for(int i = 0; i < n; i++)
				nums[i] = input.nextInt();
			getMinK(n,k,nums);
			for(int i = 0; i < k; i++){
				if(i < k - 1)
					System.out.print(nums[i] + " ");
				else
					System.out.println(nums[i]);
			}
		}
	}

}
