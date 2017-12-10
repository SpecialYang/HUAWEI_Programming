package com.special.improve;

import java.util.Scanner;

/** 
* 递归
* 正向求法
* @author special
* @date 2017年12月9日 上午11:49:29
*/
public class Pro90Improve3 {
	private static int n;
	private static int m;
	public static int getKinds(int x, int y){
		if(x == n && y == m) return 1; //到达终点，返回1
		if(x > n || y > m)   return 0; //非法地点，返回0
		return getKinds(x,y + 1) + getKinds(x + 1,y); //只有2种情况，要么向右，要么向左
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			n = input.nextInt();
			m = input.nextInt();
			
			int kinds = getKinds(0,0);
			System.out.println(kinds);
		}
	}

}
