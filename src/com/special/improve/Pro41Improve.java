package com.special.improve;

import java.util.Scanner;

/** 
* 学英语
* 运用每次处理3位的简便方法进行编码
* 该方法有如下2个亮点：
* 1.递归调用每3位
* 2.看看如何处理获取每3位
* 可以用取余的方式去掉高位
* 可以用除法的方式得到高位的某一位
* @author special
* @date 2017年10月22日 下午8:39:45
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
				 * 巧妙，仅看个位即可确定大于等于10对应值
				 * 而不用十位个位相加再取余了
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
