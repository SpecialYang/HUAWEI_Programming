package com.special.spet;

import java.util.Scanner;

/** 
* ip地址与十进制之间的转变
* @author special
* @date 2017年10月10日 下午1:55:54
*/
public class Pro32 {
	public static long getNumOfIP(String ip){
		String[] fragments = ip.split("\\.");
		long result = 0;
		for(String item : fragments){
			/**
			 * 此处可以利用移位更快的运算
			 * 因为256正好是8位，我们之前处理10进制不移位是因为凑不齐整数位
			 */
			//result = result * 256 + Integer.parseInt(item);
			result = (result << 8) + Integer.parseInt(item);
		}
		return result;
	}
	
	public static String getIPOfNum(long number){
		/*String[] fragments = new String[4];
		int index = 4;
		StringBuilder result = new StringBuilder();
		while(number != 0){
			long temp = number % 256;
			number /= 256;
			fragments[--index] = String.valueOf(temp);
		}
		for(String item : fragments){
			result.append(item);
			result.append(".");
		}
		return result.substring(0,result.length() - 1);*/
		
		/**
		 * 快方法,利用相与和移位,这个方法太巧妙了！！！！
		 */
		String result = ((number&0xff000000)>>24) + "."
				      +	((number&0x00ff0000)>>16) + "."
				      +	((number&0x0000ff00)>>8)  + "."
				      +	((number&0x000000ff))     ;
		return result;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str1 = input.next();
			long str2 = input.nextLong();
			long number = getNumOfIP(str1);
			String ip  = getIPOfNum(str2);
			System.out.println(number);
			System.out.println(ip);
		}

	}

}
