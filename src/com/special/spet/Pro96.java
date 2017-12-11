package com.special.spet;

import java.util.Scanner;

/** 
* 记负均正
* @author special
* @date 2017年12月11日 下午2:52:51
*/
public class Pro96 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			int countOfNeg = 0;
			int countOfPos = 0;
			double result = 0;
			for(int i = 0; i < n; i++){
				int num = input.nextInt();
				if(num < 0) countOfNeg++;
				else if(num > 0){
					result += num;
					countOfPos++;
				}
			}
			System.out.println(countOfNeg + " " 
					 + String.format("%.1f", result / countOfPos));
		}
	}

}
