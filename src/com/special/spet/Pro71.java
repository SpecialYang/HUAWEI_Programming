package com.special.spet;

import java.util.Scanner;

/** 
* 百元买百鸡
* 复杂度为n的平方
* 当然可以固定x,求y,k的x的表示
* @author special
* @date 2017年12月2日 下午4:55:11
*/
public class Pro71 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			boolean flag = false;
			for(int i = 0 ; i <= 20; i++)
				for(int j = 0; j <= 33; j++){
					int k = 100 - i - j;
					if(k % 3 == 0 && 5 * i + 3 * j + k / 3 == 100){
						flag = true;
						System.out.println(i + " " + j + " " + k);
					}
				}
			if(!flag) System.out.println(-1);
		}
	}

}
