package com.special.improve;

import java.util.Scanner;

/** 
* 大数相加减
* 1.补齐0可以简化加减的代码
* 2.异号时，可以把带负号的放到减数，然后再大小交换，
* 根据是否大小交换，确定正负
* 当然也可以先大小交换，然后根据是否交换 和 是否原被减数是否负号决定正负
* @author special
* @date 2017年11月26日 下午3:16:07
*/
public class Pro56Improve1 {
	
	public static int add(String num1, String num2, char[] result){
		int index = result.length;
		int carry = 0;
		int temp = 0;
		for(int i = num1.length() - 1; i >= 0; i--){
			temp = num1.charAt(i) - '0' + num2.charAt(i) - '0' + carry;
			if(temp >= 10){
				carry = temp / 10;
				temp = temp % 10;
			}else carry = 0;
			result[--index] = (char) (temp + '0');
		}
		if(carry > 0) result[--index] = (char) (carry + '0');
		return index; 
	}
	
	private static boolean more(String num1, String num2){
		for (int i = 0; i < num1.length(); i++){
			if (num1.charAt(i) > num2.charAt(i))
				return true;
			else if(num1.charAt(i) < num2.charAt(i))
				return false;
		}
		return false;
	}
	
	public static int subtract(String num1, String num2,char[] result){
		int index = result.length;
		int carry = 0;
		int temp = 0;
		for(int i = num1.length() - 1; i >= 0; i--){
			temp = num1.charAt(i) - num2.charAt(i)  - carry;
			if(temp < 0){
				carry = 1;
				temp = temp + 10;
			}else carry = 0;
			result[--index] = (char) (temp + '0');
		}
		/**
		 * 相减的情况首位可能为0，所以index要走到首位不为0
		 */
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
		/**
		 * 补齐0，方便加减
		 */
		while(num1.length() < num2.length())
			num1 = '0' + num1;
		while(num2.length() < num1.length())
			num2 = '0' + num2;
		/**
		 * 同号的情况
		 */
		if(flag == 0 || flag == 1){
			resultLength = add(num1,num2,result);
			if(flag == 1) result[--resultLength] = '-';
		}
		else if(flag == 2 || flag == 3){
			/**
			 * 把负号放到减数
			 */
			boolean isExch = false;
			if(flag == 2){
				String temp = num2;
				num2 = num1;
				num1 = temp;
			}
			/**
			 * 把最大的放到被减数
			 */
			if(more(num2,num1)){
				String temp = num2;
				num2 = num1;
				num1 = temp;
				isExch = true;
			}
			resultLength = subtract(num1,num2,result);
			if(isExch) result[--resultLength] = '-';
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
