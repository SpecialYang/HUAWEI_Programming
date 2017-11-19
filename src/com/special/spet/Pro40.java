package com.special.spet;

import java.util.Scanner;

/** 
* 称砝码
* 采用了dfs来求，方法有点笨
* 利用有序符号表优化查询
* @author special
* @date 2017年10月18日 下午1:52:14
*/
public class Pro40 {
	public static int n;
	public static int[] weight = new int[10 + 5];
	public static int[] number = new int[10 + 5];
	public static int kinds;
	public static int[] result;
	
	private static boolean contains(int weight){
		int low = 0;
		int high = kinds - 1;
		while(low <= high){
			int mid = low + (high - low) / 2;
			if(weight < result[mid]) high = mid - 1;
			else if(weight > result[mid]) low  = mid + 1;
			else return true;
		}
		return false;
	}
	private static void insert(int weight){
		int i = kinds - 1;
		for(; i >= 0; i--){
			if(weight < result[i])
				result[i + 1] = result[i];
			else
				break;
		}
		result[i + 1] = weight;
		kinds++;
	}
	public static void dfs(int index, int currentWeight){
		if(index == n){
			if(!contains(currentWeight))
				insert(currentWeight);
			return;
		}
		for(int i = 0; i <= number[index]; i++)
			dfs(index + 1, currentWeight + i * weight[index]);
	}
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			n = input.nextInt();
			result = new int[46656 + 5];
			kinds = 0;
			for(int i = 0; i < n; i++)
				weight[i] = input.nextInt();
			for(int i = 0; i < n; i++)
				number[i] = input.nextInt();
			dfs(0,0);
			System.out.println(kinds);
		}
	}
}
