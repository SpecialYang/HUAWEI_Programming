package com.special.improve;

import java.util.Scanner;

/** 
* ͨ�������
* ��̬�滮
* dp[i][j]��ʾstr1��ǰi���ַ�ƥ��str2��ǰj���ַ��ĳ���
* ��3�������
* 1.��str1�ĵ�i���ַ�Ϊ?��ʾ����str2�ĵ�j���ַ����  dp[i][j] = dp[i - 1][j - 1] + 1;
* 2.��str1�ĵ�i���ַ���str2�ĵ�j���ַ����                    dp[i][j] = dp[i - 1][j - 1] + 1;
* 3.��str1�ĵ�i���ַ�Ϊ*,����ʱj������С��i        dp[i][j] = dp[i - 1][j];(��ʾ*��ƥ���κ��ַ�)
*                      ����ʱj���������ڵ���i	   dp[i][j] = dp[i][j - 1] + 1;(��ʾ*��j-1�Ļ�����ƥ��һ����
* 4.�����϶�����������ô����str1�ĵ�i���ַ���str2�ĵ�j���ַ�����ȣ�dp[i][j] = 0;
* 
* ����ж�dp[i][j] == str2.length(),����֪��str1�Ƿ�ƥ�䵽��str2
* 
* �����ַ�������Ӧ������̬�滮���롣
* @author special
* @date 2017��12��2�� ����2:28:48
*/
public class Pro70Improve1 {
	public static boolean isMatch(String matchStr, String originStr){
		int length1 = matchStr.length();
		int length2 = originStr.length();
		int[][] dp = new int[length1 + 1][length2 + 1];
		for(int i = 1; i <= length1; i++)
			for(int j = 1; j <= length2; j++){
				if(matchStr.charAt(i - 1) == '?' || matchStr.charAt(i - 1) == originStr.charAt(j - 1))
					dp[i][j] = dp[i - 1][j - 1] + 1;
				else if(matchStr.charAt(i - 1) == '*'){
					dp[i][j] = j < i ? dp[i - 1][j] : dp[i][j - 1] + 1;
				}
			}
		return dp[length1][length2] == length2;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String matchStr = input.nextLine();
			String originStr = input.nextLine();
			boolean result = isMatch(matchStr,originStr);
			System.out.println(result);
		}
	}
}
