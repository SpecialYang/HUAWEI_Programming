package com.special.spet;

import java.util.Scanner;

/** 
* 
放苹果分为两种情况，一种是有盘子为空，一种是每个盘子上都有苹果。
令(m,n)表示将m个苹果放入n个盘子中的摆放方法总数。
1.假设至少有一个盘子为空，则(m,n)问题转化为将m个苹果放在n-1个盘子上，即求得(m,n-1)即可
2.假设所有盘子都装有苹果，则每个盘子上至少有一个苹果，
即最多剩下m-n个苹果，问题转化为将m-n个苹果放到n个盘子上  即求(m-n，n)
综上所述：
(m，n)=(m,n-1)+(m-n,n);
*
* @author special
* @date 2017年11月29日 上午11:04:41
*/
public class Pro60 {
	public static int putApple(int m, int n){
		if(m <= 0) return 0;      //如果没有苹果，肯定0种
		if(m == 1 || n == 1) return 1; //只要苹果或者盘子为1，肯定为1种方法
		/**
		 * 当苹果不为0，且苹果与盘子数量相等，那就不用递归了
		 * 根据条件二描述，对（0，盘子）放苹果肯定无意思啊
		 */
		if(m != 0 && m - n == 0)     
			return putApple(m,n - 1) + 1;
		return putApple(m,n - 1) + putApple(m - n,n); 
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int m = input.nextInt();
			int n = input.nextInt();
			int result = putApple(m,n);
			System.out.println(result);
		}
	}

}
