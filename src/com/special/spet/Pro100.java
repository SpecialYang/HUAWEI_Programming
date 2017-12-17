package com.special.spet;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/** 
* 数组升序和降序排列
* 
* 降序利用到了自定义比较器
* @author special
* @date 2017年12月12日 下午11:39:53
*/
public class Pro100 {
	public static void sortNums(Integer[] nums, int flag){
		if(flag == 0)
			Arrays.sort(nums);
		else
			Arrays.sort(nums,new Comparator<Integer>(){
				@Override
				public int compare(Integer o1, Integer o2) {
					// TODO Auto-generated method stub
					return o2 - o1;
				}
				
			});
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			Integer[] nums = new Integer[n];
			for(int i = 0; i < n; i++)
				nums[i] = input.nextInt();
			int flag = input.nextInt();
			sortNums(nums,flag);
			for(int i = 0; i < n; i++)
				if(i != n - 1)
					System.out.print(nums[i] + " ");
				else
					System.out.println(nums[i]);
		}
	}

}
