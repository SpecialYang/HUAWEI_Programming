package com.special.spet;

import java.util.Scanner;

/** 
* 求一个整数的二进数中1的个数
* n &= n - 1 每次运算都正好使最低位为1的位数变为0
* 对于负数，这个算法同样可以，只不过求得是补码中含有1的个数
* @author special
* @date 2017年11月29日 下午1:39:47
*/
public class Pro61 {
	public static int getNumOf1(int n){
		int result = 0;
		while(n != 0){
			n &= n - 1;
			result++;
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			int numOf1 = getNumOf1(n);
			System.out.println(numOf1);
		}
	}

}
