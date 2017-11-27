package com.special.improve;

import java.util.Scanner;

/** 
* ������Ӽ�
* 1.����0���Լ򻯼Ӽ��Ĵ���
* 2.���ʱ�����԰Ѵ����ŵķŵ�������Ȼ���ٴ�С������
* �����Ƿ��С������ȷ������
* ��ȻҲ�����ȴ�С������Ȼ������Ƿ񽻻� �� �Ƿ�ԭ�������Ƿ񸺺ž�������
* @author special
* @date 2017��11��26�� ����3:16:07
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
		 * ����������λ����Ϊ0������indexҪ�ߵ���λ��Ϊ0
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
		 * ����0������Ӽ�
		 */
		while(num1.length() < num2.length())
			num1 = '0' + num1;
		while(num2.length() < num1.length())
			num2 = '0' + num2;
		/**
		 * ͬ�ŵ����
		 */
		if(flag == 0 || flag == 1){
			resultLength = add(num1,num2,result);
			if(flag == 1) result[--resultLength] = '-';
		}
		else if(flag == 2 || flag == 3){
			/**
			 * �Ѹ��ŷŵ�����
			 */
			boolean isExch = false;
			if(flag == 2){
				String temp = num2;
				num2 = num1;
				num1 = temp;
			}
			/**
			 * �����ķŵ�������
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
