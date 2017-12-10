package com.special.spet;

import java.util.Arrays;
import java.util.Scanner;

/** 
* 判断两个数组是否能分开为2个数组，然后他们的和相等
* 
* 思路：递归
* 对于每一个数，要么进第一个组，要么进第二组，因此递归起来哈
* @author special
* @date 2017年12月10日 上午11:29:09
*/
public class Pro92 {
	private static int[] nums;
	private static boolean isEquals;
	
	private static boolean isEqualsSum(int[] array1, int[] array2){
		int sum1 = 0;
		int sum2 = 0;
		for(int i = 0; i < array1.length; i++) sum1 += array1[i];
		for(int i = 0; i < array2.length; i++) sum2 += array2[i];
		return sum1 == sum2;
	}
	
	public static void dfs(int index, int[] array1, int[] array2){
		if(isEquals) return;
		if(index == array1.length){
			if(isEqualsSum(array1,array2))
				isEquals = true;
			return;
		}
		int num = nums[index];
		if(num % 5 == 0 || num % 3 != 0){
			int[] tempArr1 = Arrays.copyOf(array1, array1.length);
			tempArr1[index] = num;
			dfs(index + 1,tempArr1,array2);
		}
		if(num % 3 == 0 || num % 5 != 0){
			int[] tempArr2 = Arrays.copyOf(array2, array2.length);
			tempArr2[index] = num;
			dfs(index + 1,array1,tempArr2);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			nums = new int[n];
			for(int i = 0; i < n; i++)
				nums[i] = input.nextInt();
			isEquals = false;
			
			dfs(0,new int[n],new int[n]);
			System.out.println(isEquals);
		}
	}

}
