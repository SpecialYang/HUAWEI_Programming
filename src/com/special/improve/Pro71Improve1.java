package com.special.improve;

import java.util.Scanner;

/** 
*
* @author special
* @date 2017年12月2日 下午5:19:31
*/
public class Pro71Improve1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			boolean flag = false;
			for(int i = 0 ; i <= 20; i++){
				double j = (200 - 14 * i) / 8.0;
				double k = 100 - i - j;
				if(j == (int) j && j >= 0){
					flag = true;
					System.out.println(i + " " + (int) j + " " + (int) k);
				}
			}
			if(!flag) System.out.println(-1);
		}
	}

}
