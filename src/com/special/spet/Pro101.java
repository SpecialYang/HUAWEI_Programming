package com.special.spet;

import java.util.Scanner;

/** 
* 字符统计并按次数从大到小排序
* 且相同的次数，ascii码小的在前面
* 
* 思路；两个平行数组
* @author special
* @date 2017年12月13日 下午11:29:30
*/
public class Pro101 {
	private static int[] indexs;
	private static int[] counts;
	private static final int SIZE = 'z' + 1;
	
	private static void exch(int[] nums, int i, int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public static void solve(String str){
		for(int i = 0; i < str.length(); i++){
			char item = str.charAt(i);
			if(item >= '0' && item <= '9'
					|| item >= 'A' && item <= 'Z'
					|| item >= 'a' && item <= 'z'
					|| item == ' ')
				counts[item]++;
		}
		for(int i = 1; i < SIZE; i++)
			for(int j = i; j > 0; j--){
				if(counts[j] > counts[j - 1]){
					exch(counts,j,j - 1);
					exch(indexs,j,j - 1);
				}else if(counts[j] == counts[j - 1]){//次数相等时，只需交换ascii码就可以了
					if(indexs[j] < indexs[j - 1])
						exch(indexs,j,j - 1);
				}
			}
		for(int item : indexs){
			if(item == 0) break; //排序之后，大的在前面，以0结束，0代表之后没有了
			System.out.print((char)item);
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str = input.nextLine();
			indexs = new int[SIZE];
			counts = new int[SIZE];
			for(int i = 0; i < SIZE; i++)
				indexs[i] = i;
			solve(str);
		}
	}

}
