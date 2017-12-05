package com.special.spet;

import java.util.Scanner;

/** 
* 大数相加
* 补齐0
* @author special
* @date 2017年12月5日 下午2:31:38
*/
public class Pro77 {
	public static String add(String add, String added){
		if(add.length() < added.length()){
			String temp = added;
			added = add;
			add = temp;
		}
		char[] result = new char[add.length() + 1];
		while(add.length() > added.length())
			added = '0' + added;
		int carry = 0;
		int index = result.length;
		for(int i = add.length() - 1; i >= 0; i--){
			int temp = add.charAt(i) - '0' + added.charAt(i) - '0' + carry;
			if(temp >= 10){
				carry = 1;
				temp -= 10;
			}else carry = 0;  //很容易遗忘
			result[--index] = (char) (temp + '0');
		}
		if(carry > 0) result[--index] = (char) (carry + '0');
		return new String(result).substring(index);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String add = input.nextLine();
			String added = input.nextLine();
			String result = add(add,added);
			System.out.println(result);
		}
	}

}
