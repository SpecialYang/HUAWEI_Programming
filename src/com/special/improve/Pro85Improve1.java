package com.special.improve;

import java.util.Scanner;

/** 
* 牛逼的想法
* 错位相与即可找到最大连续1的个数
* 跟n & (n - 1)思想类似
* @author special
* @date 2017年12月7日 下午3:09:52
*/
public class Pro85Improve1 {
	public static int getNumOfContinuousOne(int num){
		int result = 0;
		while(num != 0){
			num &= (num << 1);
			result++;
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int num = input.nextInt();
			int result = getNumOfContinuousOne(num);
			System.out.println(result);
		}
	}
}
