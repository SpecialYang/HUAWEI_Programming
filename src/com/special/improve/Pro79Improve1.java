package com.special.improve;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/** 
*
* @author special
* @date 2017年12月5日 下午4:18:47
*/
public class Pro79Improve1 {
	public static int[] mergeNum(int[] array1, int[] array2){
		Set<Integer> set = new HashSet<Integer>();
		for(int i = 0; i < array1.length; i++)
			set.add(array1[i]);
		for(int i = 0; i < array2.length; i++)
			set.add(array2[i]);
		int[] mergeNum = new int[set.size()];
		int index = 0;
		for(int item : set)
			mergeNum[index++] = item;
		Arrays.sort(mergeNum);
		return mergeNum;
	}
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			int[] array1 = new int[n];
			for(int i = 0; i < n; i++)
				array1[i] = input.nextInt();
			n = input.nextInt();
			int[] array2 = new int[n];
			for(int i = 0; i < n; i++)
				array2[i] = input.nextInt();
			int[] megerNum = mergeNum(array1,array2);
			for(int item : megerNum)
				System.out.print(item);
			System.out.println();
		}
	}
}
