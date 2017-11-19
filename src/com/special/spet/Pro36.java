package com.special.spet;

import java.util.Scanner;

/** 
* 统计每个月的兔子
* 因为每个月的兔子数量为上一个月的数量加上上上个月的数量
* 递归比较费空间，可以优化一下
* @author special
* @date 2017年10月14日 上午11:33:52
*/
public class Pro36 {
	public static int getTotalCount(int monthCount){
		if(monthCount == 1 || monthCount == 2)
			return 1;
		return getTotalCount(monthCount - 2) + getTotalCount(monthCount - 1);
	}
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int monthCount = input.nextInt();
			int result     = getTotalCount(monthCount);
			System.out.println(result);
		}
	}
}
