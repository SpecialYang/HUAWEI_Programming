package com.special.improve;

import java.util.Scanner;

/** 
* ѧӢ��
* ����ÿ�δ���3λ�ļ�㷽�����б���
* �÷���������2�����㣺
* 1.�ݹ����ÿ3λ
* 2.������δ����ȡÿ3λ
* ������ȡ��ķ�ʽȥ����λ
* �����ó����ķ�ʽ�õ���λ��ĳһλ
* @author special
* @date 2017��10��22�� ����8:39:45
*/
public class Pro41Improve {
	private static String[] bitNum = {"zero","one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
	private static String[] tenNum = {"ten", "eleven", "twelve", "thirteen" ,"fourteen", "fifteen", "seventeen", "eighteen", "nineteen"};
	private static String[] twentyNum = {"zero","ten","twenty", "thirty", "forty","fifty","sixty","seventy","eighty","ninety"};
	
	private static String parse(long number){
		StringBuilder result = new StringBuilder();
		int h = (int) (number / 100);
		if(h != 0)
			result.append(bitNum[h] + " hundred");
		number %= 100;
		int t = (int) (number / 10);
		int d = (int) (number % 10);
		if(t != 0){
			if(h != 0)
				result.append(" and ");
			if(t == 1)
				/**
				 * ���������λ����ȷ�����ڵ���10��Ӧֵ
				 * ������ʮλ��λ�����ȡ����
				 */
				result.append(tenNum[d]);
			else{
				result.append(twentyNum[t]);
				if(d != 0)
					result.append(" " + bitNum[d]);
			}
		}
		else if(d != 0){
			if(h != 0)
				result.append(" and ");
			result.append(bitNum[d]);
		}
		return result.toString();
	}
	public static String getString(long number){
		if(number < 0 || number > 1000000000)
			return "error";
		StringBuilder result = new StringBuilder();
		long million = number / 1000000;
		if(million != 0)
			result.append(parse(million) + " million ");
		number %= 1000000;
		long thousand = number / 1000;
		if(thousand != 0)
			result.append(parse(thousand) + " thousand ");
		number %= 1000;
		long hundred = number;
		if(hundred != 0)
			result.append(parse(hundred));
		return result.toString().trim();	
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			long number = input.nextLong();
			String result = getString(number);
			System.out.println(result);
		}
	}

}
