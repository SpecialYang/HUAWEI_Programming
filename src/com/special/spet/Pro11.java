package com.special.spet;

import java.util.Scanner;

/** 
*
* @author special
* @date 2017年9月6日 上午8:53:38
*/
public class Pro11 {
	/**
	 * 获取一个整型的逆序字符串输出
	 * @param num
	 * @return
	 */
	public static String getReverseNum(int num){
		StringBuilder result = new StringBuilder();
		//用while的话，需要在循环外添加if语句
		/*if(num == 0)  { return "0"; }
		while(num > 0){
			result.append(num % 10);
			num /= 10;
		}*/
		//若不想添加一个if语句，则可以使用do-while
		do{
			result.append(num % 10);
			num /= 10;
		}while(num > 0);
		return result.toString();
	}
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int num = input.nextInt();
			String result = getReverseNum(num);
			System.out.println(result);
		}
	}
}
