package com.special.spet;

import java.util.Scanner;

/** 
* ���ʮ���ƣ�����ÿ�θ�һ������β�����һλ�����൱�ڱ�������ʮ��
* ���ԣ�ʮ�����ƣ�����ͬ��������������ֻ������ÿ�ζ�����ʮ��������
* @author special
* @date 2017��9��4�� ����10:25:18
*/
public class Pro05 {
	public static int getTenth(char ch){
		int result = 0;
		if(ch>='A'&&ch<='F')
			result = 10 + ch - 'A';
		else if(ch>='a'&&ch<='f')
			result = 10 + ch - 'a';
		else
			result = ch - 48;
		return result;
	}
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int result = 0;
			String inputStr = input.next();
			for(int i = 2;i < inputStr.length(); i++){
				char temp = inputStr.charAt(i);
				result = result*16 + getTenth(temp);
				}
			System.out.println(result);
		}
	}
}
