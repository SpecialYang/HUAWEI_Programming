package com.special.improve;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/** 
* 数组合并
* 其实就是两个数组union操作
* 先对2个数组排序，然后队头比较就可以了
* 若数组1小于数组2，则数组1进去，同理数组2进去
* 若相等，则只进一个，然后全部后移
* @author special
* @date 2017年12月5日 下午9:58:50
*/
public class Pro79Improve2 {
	public static List<Integer> mergeNum(int[] array1, int[] array2){
		List<Integer> result = new ArrayList<Integer>();
		int i = 0, j = 0;
		while(i < array1.length && j < array2.length){
			if(array1[i] < array2[j])
				result.add(array1[i++]);
			else if(array1[i] > array2[j])
				result.add(array2[j++]);
			else{
				result.add(array1[i++]);
				j++;
			}
		}
		while(i < array1.length)
			result.add(array1[i++]);
		while(j < array2.length)
			result.add(array2[j++]);
		return result;
	}
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			int[] array1 = new int[n];
			for(int i = 0; i < n; i++)
				array1[i] = input.nextInt();
			Arrays.sort(array1);
			n = input.nextInt();
			int[] array2 = new int[n];
			for(int i = 0; i < n; i++)
				array2[i] = input.nextInt();
			Arrays.sort(array2);
			List<Integer> megerNum = mergeNum(array1,array2);
			for(int item : megerNum)
				System.out.print(item);
			System.out.println();
		}
	}
}
