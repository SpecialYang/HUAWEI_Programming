package com.special.spet;

import java.util.Scanner;

/** 
* 通过乘以10可以使小数点后移，然后对10取余即可得到原小数点后一位
* @author special
* @date 2017年9月4日 下午5:59:37
*/
public class Pro07 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			double inputNum = input.nextDouble();
			if(inputNum * 10 % 10 >= 5)      //通过乘以10可以使小数点后移，然后对10取余即可得到原小数点后一位
				System.out.println((int)inputNum + 1);
			else
				System.out.println((int)inputNum);
		}
	}
}
