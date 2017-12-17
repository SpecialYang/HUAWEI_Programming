package com.special.improve;

import java.util.Scanner;

/** 
* 自守数
* 有个特点就是 平方数 - 尾数 应该是能整除10的
* 所以我们应始终保持redix比i多一位，且为10，100，1000......
* @author special
* @date 2017年12月11日 下午11:49:29
*/
public class Pro98Improve1 {

	public static int getCount(int n){
		int count = 0;
		int redix = 1;
		for(int i = 0; i <= n; i++){
			if(redix <= i)
				redix *= 10;
			if(i * (i - 1) % redix == 0)
				count++;
		}
		return count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			int count = getCount(n);
			System.out.println(count);
		}
	}

}
