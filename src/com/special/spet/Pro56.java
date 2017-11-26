package com.special.spet;

import java.util.Scanner;

/** 
* 大数加减法
* 注意加法的进位，减法的借位
* @author special
* @date 2017年11月26日 上午11:28:17
*/
public class Pro56 {
	
	public static int add(String num1, String num2, char[] result){
		int carry = 0;
		int index = result.length;
		for(int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0; i--, j--){
			int temp = 0;
			if(i >= 0 && j >= 0)
				temp = num1.charAt(i) - '0' + num2.charAt(j) - '0' + carry;
			else if(i >= 0)
				temp = num1.charAt(i) - '0' + carry;
			else if(j >= 0)
				temp = num2.charAt(j) - '0' + carry;
			carry = 0;
			if(temp >= 10){
				carry = temp / 10;
				temp = temp % 10;
			}
			result[--index] = (char) (temp + '0');
		}
		if(carry > 0) result[--index] = (char) (carry + '0');
		return index;
	}
	private static boolean more(String num1, String num2){
		if(num1.length() > num2.length())
			return true;
		else if(num1.length() == num2.length()){
			for(int i = 0; i < num1.length(); i++)
				if(num1.charAt(i) > num2.charAt(i))
					return true;
			return false;
		}else
			return false;
	}
	public static int subtract(String num1, String num2,char[] result){
		int carry = 0;
		int index = result.length;
		for(int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0; i--, j--){
			int temp = 0;
			if(i >= 0 && j >= 0)
				temp = num1.charAt(i) - num2.charAt(j)  - carry;
			else if(i >= 0)
				temp = num1.charAt(i) - '0' - carry;
			else if(j >= 0)
				temp = num2.charAt(j) - '0' - carry;
			carry = 0;
			if(temp < 0){
				carry = 1;
				temp = temp + 10;
			}
			result[--index] = (char) (temp + '0');
		}
		for(; index < result.length - 1; index++)
			if(result[index] != '0')   break;
		return index;
	}
	public static String add(String num1, String num2){
		int resultLength = Math.max(num1.length(), num2.length()) + 1;
		char[] result = new char[resultLength];
		int flag = 0;
		if(num1.charAt(0) == '-' && num2.charAt(0) == '-'){
			flag = 1;
			num1 = num1.substring(1);
			num2 = num2.substring(1);
		}else if(num1.charAt(0) == '-'){
			flag = 2;
			num1 = num1.substring(1);
		}else if(num2.charAt(0) == '-'){
			flag = 3;
			num2 = num2.substring(1);
		}
		if(flag == 0 || flag == 1){
			resultLength = add(num1,num2,result);
			if(flag == 1) result[--resultLength] = '-';
		}
		else if(flag == 2){
			if(more(num1,num2)){
				resultLength = subtract(num1,num2,result);
				result[--resultLength] = '-';
			}
			else
				resultLength = subtract(num2,num1,result);
		}else if(flag == 3){
			if(more(num2,num1)){
				resultLength = subtract(num2,num1,result);
				result[--resultLength] = '-';
			}
			else
				resultLength = subtract(num1,num2,result);
		}
		return new String(result).substring(resultLength);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input  = new Scanner(System.in);
		while(input.hasNext()){
			String num1 = input.nextLine();
			String num2 = input.nextLine();
			String result = add(num1.trim(),num2.trim());
			System.out.println(result);
		}
	}

}
