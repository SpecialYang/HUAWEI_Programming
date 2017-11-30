package com.special.spet;

import java.util.Scanner;

/** 
* �ҳ������ַ����Ĺ�����󳤶��ִ������ж��������������ڶ��ַ������ֵ�
* ��̬�滮����
* dp[i][j]��ʾǰi���ַ�����ǰj���ַ����Ĺ�������ַ����ĳ���
* �� ��i���ַ����j���ַ���ȣ���dp[i][j] = dp[i - 1][j - 1] + 1
* ���� dp[i][j] = 0
* @author special
* @date 2017��11��30�� ����9:37:15
*/
public class Pro64 {
	public static String getCommonMaxSubStr(String str1, String str2){
		if(str1.length() > str2.length()){
			String temp = str2;
			str2 = str1;
			str1 = temp;
		}
		int length1 = str1.length();
		int length2 = str2.length();
		int[][] dp = new int[length1 + 1][length2 + 1];
		int end = 0;
		int max = 0;
		for(int i = 1; i <= length1; i++)
			for(int j = 1; j <= length2; j++){
				if(str1.charAt(i - 1) == str2.charAt(j - 1))
					dp[i][j] = dp[i - 1][j - 1] + 1;
				if(dp[i][j] > max){
					max = dp[i][j];
					end = i;
				}
			}
		return str1.substring(end - max, end);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str1 = input.nextLine();
			String str2 = input.nextLine();
			String commonMaxSubStr = getCommonMaxSubStr(str1,str2);
			System.out.println(commonMaxSubStr);
		}
	}

}
