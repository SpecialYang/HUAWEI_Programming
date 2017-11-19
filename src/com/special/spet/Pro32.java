package com.special.spet;

import java.util.Scanner;

/** 
* ip��ַ��ʮ����֮���ת��
* @author special
* @date 2017��10��10�� ����1:55:54
*/
public class Pro32 {
	public static long getNumOfIP(String ip){
		String[] fragments = ip.split("\\.");
		long result = 0;
		for(String item : fragments){
			/**
			 * �˴�����������λ���������
			 * ��Ϊ256������8λ������֮ǰ����10���Ʋ���λ����Ϊ�ղ�������λ
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
		 * �췽��,�����������λ,�������̫�����ˣ�������
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
