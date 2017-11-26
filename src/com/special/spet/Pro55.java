package com.special.spet;

import java.util.Scanner;

/** 
* 完美数
* 完全数（Perfect number），又称完美数或完备数，是一些特殊的自然数。
* 它所有的真因子（即除了自身以外的约数）的和（即因子函数），恰好等于它本身。
* 例如：28，它有约数1、2、4、7、14、28，除去它本身28外，其余5个数相加，1+2+4+7+14=28。
* 
* 1.打表法                              数多慢
* 2.直接对每个数遍历判断  数少快
* @author special
* @date 2017年11月26日 上午10:55:48
*/
public class Pro55 {
	private static final int SIZE = 500000 + 5;
	private static boolean[] perfectNum = new boolean[SIZE];
	private static boolean isPerfectNum(int num){
		int result = 1;   //因为我从2开始遍历的，所以默认result初始的时候肯定为1
		double sqrtOfNum = Math.sqrt(num);
		/**
		 * 遍历范围到数的平方根就行，在进行累加小于平方根的约数时
		 * 可以顺带把对应大于平方跟的约数加上
		 * 注意若该数的平方根是整数，那么我们只累加一次
		 */
		for(int i = 2; i <= sqrtOfNum; i++){
			if(num % i == 0){
				result += i;
				if(i != sqrtOfNum)
					result += num / i;
			}
		}
		if(result == num) return true;
		else              return false;
	}
	public static void init(){
		for(int i = 2; i < SIZE; i++)
			if(isPerfectNum(i))
				perfectNum[i] = true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		init();
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			int count = 0;
			for(int i = 1; i <= n; i++)
				if(perfectNum[i])
					count++;
			System.out.println(count);
		}
	}

}
