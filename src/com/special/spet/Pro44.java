package com.special.spet;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/** 
* 名字的满意度
* 1.利用键索引储存各个字符出现的次数
* 2.利用排序算法得到次数的递增或递减序列
* 3.然后从最大开始乘以26，依次递减得到最大的满意度
* @author special
* @date 2017年10月25日 下午1:54:47
*/
public class Pro44 {
	private static void exch(int[] count, int i ,int j){
		int temp = count[i];
		count[i] = count[j];
		count[j] = temp;
	}
	public static int getSatisfied(String name){
		name = name.toLowerCase();
		int length = name.length();
		int[] count = new int[26];
		int result = 0;
		int redix = 26;
		for(int i = 0; i < length; i++)
			count[name.charAt(i) - 'a']++;
		/**
		 * 插入排序
		 */
		/*for(int i = 1; i < 26; i++)
			for(int j = i; j > 0 && count[j] > count[j - 1]; j--)
				exch(count,j,j - 1);
		for(int i = 0; i < 26; i++){
			if(count[i] == 0) break;
			result += count[i] * redix--;
		}*/
		/**
		 * 利用库函数进行数组排序
		 */
		Arrays.sort(count);
		for(int i = 25; i >= 0; i--){
			if(count[i] == 0) break;
			result += count[i] * redix--;
		}
		return result;
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			String[] names = new String[n];
			for(int i = 0; i < n; i++)
				names[i] = input.next();
			for(int i = 0; i < n; i++){
				int satisfied = getSatisfied(names[i]);
				System.out.println(satisfied);
			}
		}

	}

}
