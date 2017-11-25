package com.special.spet;

import java.util.Scanner;

/** 
* 挑7
* @author special
* @date 2017年11月25日 上午11:06:19
*/
public class Pro54 {
	private static final int SIZE = 30000 + 5;
	private static boolean[] relevant7 = new boolean[SIZE];
	public static void init(){
		for(int i = 7; i < SIZE; i += 7)
			relevant7[i] = true;
		for(int i = 17; i < SIZE; i++)
			if(!relevant7[i]){
				int item = i;
				while(item != 0){
					if(item % 10 == 7){
						relevant7[i] = true;
						break;
					}
					else  item /= 10;
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
