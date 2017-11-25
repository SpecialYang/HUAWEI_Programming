package com.special.improve;

import java.util.Scanner;

/** 
* 挑7
* 通过字符串简单点哈
* @author special
* @date 2017年11月25日 上午11:24:04
*/
public class Pro54Improve1 {
	private static final int SIZE = 30000 + 5;
	private static boolean[] relevant7 = new boolean[SIZE];
	
	public static void init(){
		for(int i = 7; i < SIZE; i += 7)
			relevant7[i] = true;
		String s;
		for(int i = 17; i < SIZE; i++){
			if(!relevant7[i]){
				s = String.valueOf(i);
				if (s.contains("7"))
					relevant7[i] = true;
			}
		}
	}
	public static void main(String[] args) {
		init();
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			int count = 0;
			for(int i = 7; i <= n; i++)
				if(relevant7[i])
					count++;
			System.out.println(count);
		}
	}
}
