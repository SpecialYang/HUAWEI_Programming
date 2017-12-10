package com.special.improve;

import java.util.Scanner;

/** 
* 递归
* 倒序求法
* @author special
* @date 2017年12月9日 上午11:32:38
*/
public class Pro90Improve2 {
	public static int getKinds(int n ,int m){
		if(n == 0 || m == 0) return 1;
		else return getKinds(n - 1,m) + getKinds(n,m - 1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			int m = input.nextInt();
			
			int kinds = getKinds(n,m);
			System.out.println(kinds);
		}
	}

}
