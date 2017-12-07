package com.special.improve;

import java.util.Scanner;

/** 
* �����Ĵ�����
* �ַ�������ķ�ת�ַ�����󹫹��ַ�������
* 
* @author special
* @date 2017��12��7�� ����10:21:52
*/
public class Pro84Improve1 {
	
	public static int getHuiWenMaxLen(String str){
		int maxLen = 1;
		int length = str.length();
		/*
		String reverseStr = new StringBuilder(str).reverse().toString();
		int[][] dp = new int[length + 1][length + 1];
		for(int i = 1; i <= length; i++)
			for(int j = 1; j <= length; j++)
				if(str.charAt(i - 1) == reverseStr.charAt(j - 1)){
					dp[i][j] = dp[i - 1][j - 1] + 1;
					maxLen = Math.max(maxLen, dp[i][j]);
				}
		*/
		/**
		 * �Ż�һ�£�����ת��ֱ�Ӷ�ԭ�����д���
		 */
		int[][] dp = new int[length + 2][length + 2];
		for(int i = 1; i <= length; i++)
			for(int j = length; j >= 1; j--){
				if(str.charAt(i - 1) == str.charAt(j - 1)){
					dp[i][j] = dp[i - 1][j + 1] + 1;
					if(maxLen < dp[i][j]) maxLen = dp[i][j];
				}
			}
		return maxLen;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str = input.nextLine();
			int maxLen = getHuiWenMaxLen(str);
			System.out.println(maxLen);
		}
	}
}
