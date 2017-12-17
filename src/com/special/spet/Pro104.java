package com.special.spet;

import java.util.Scanner;

/** 
* 记负均正Ⅱ
* @author special
* @date 2017年12月17日 上午10:20:43
*/
public class Pro104 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int countNei = 0;
		int countPos = 0;
		double sum = 0;
		while(input.hasNext()){
			int num = input.nextInt();
			if(num < 0){
				countNei++;
			}else{
				countPos++;
				sum += num;
			}
		}
		System.out.println(countNei);
		if(countPos == 0)
			System.out.println("0.0");
		else
			System.out.format("%.1f\n", sum / countPos);
	}

}
