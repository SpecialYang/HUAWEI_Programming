package com.special.improve;

import java.util.Scanner;

/** 
* �����ַ���������󳤶�
* ÿ�ν�ȡһ�����ȵ�str1,����contains�ж�str2�Ƿ����
* ��������������������˳���ѭ������Ϊ��i��ͷ���ַ����Ѿ��޷�ƥ����
* 
* ��������ҿ��Աȶ�̬�滮�����һ�㣬�Ҵ�����գ�
* @author special
* @date 2017��12��3�� ����11:03:31
*/
public class Pro74Improve1 {
	public static int getCommonMaxLen(String str1, String str2){
		int maxLen = 0;
		for(int i = 0; i < str1.length() - 1; i++)
			for(int j = i + 1; j <= str1.length(); j++){
				String temp = str1.substring(i,j);
				if(!str2.contains(temp)) break;
				else if (j - i > maxLen) maxLen = j - i;
			}
		return maxLen;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str1 = input.next();
			String str2 = input.next();
			int commonMaxLen = getCommonMaxLen(str1,str2);
			System.out.println(commonMaxLen);
		}
	}
}
