package com.special.spet;

import java.util.Scanner;

/** 
* ͼƬ����
* ��0��1��A��Z,a��z��acii���С��������
* ��������
* ע�⴦�������
* @author special
* @date 2017��10��11�� ����1:23:34
*/
public class Pro33 {
	
	private static int getIndex(char temp){
		int index = 0;
		if(temp >= '0' && temp <= '9')
			index = temp - '0';
		else if(temp >= 'A' && temp <= 'Z')
			index = temp - 'A' + 10;
		else if(temp >= 'a' && temp <= 'z')
			index = temp - 'a' + 36;
		return index;
	}
	
	public static String getSequence(String str){
		int length = str.length();
		int max = 10 + 26 + 26 + 1;
		int[] aux    = new int[max];
		char[] result = new char[length];
		for(int i = 0; i < length; i++){
			char temp = str.charAt(i);
			aux[getIndex(temp)]++;
		}
		for(int i = 1; i < max; i++)
			aux[i] += aux[i - 1];
		for(int i = length - 1; i >= 0; i--){
			char temp = str.charAt(i);
			int index = getIndex(temp);
			/**
			 * ע�����ǵĴ��������������Ǵ�0��ʼ
			 * ��������aux�����Ĵ����ǵü�һ��
			 */
			result[aux[index] - 1] = temp;
			aux[index]--;
		}
		return new String(result);
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str = input.nextLine();
			String result = getSequence(str);
			System.out.println(result);
		}

	}

}
