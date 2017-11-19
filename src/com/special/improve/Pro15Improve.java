package com.special.improve;

import java.util.Scanner;

/** 
* 此方法比移位法要简单而且好理解
* 只要这个数大于0，那么他一定含有1个1，然后我们让原数与原数减一相与，即可去掉一个1
* 如果这个数还不为0，说明他还有1，继续相与，直到数中不再含有1
* @author special
* @date 2017年9月6日 下午2:12:59
*/
public class Pro15Improve {
	public static int getNumsOfOne(int num){
		int count = 0;
		while(num != 0){
			count++;
			num = num & (num - 1);
		}
		return count;
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int num = input.nextInt();
			int count = getNumsOfOne(num);
			System.out.println(count);
		}

	}
}
