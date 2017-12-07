package com.special.improve;

import java.util.Scanner;

/** 
* ���Ż��������������ֶ���ת
* �Լ��ô���ģ�ⷴת
* @author special
* @date 2017��12��7�� ����11:56:52
*/
public class Pro84Improve3 {
	
	public static int getHuiWenMaxLen(String str){
		int maxLen = 1;
		int length = str.length();
		int[][] dp = new int[length + 2][length + 2];
		for(int i = 1; i <= length; i++)
			for(int j = length; j >= 1; j--)
				if(str.charAt(i - 1) == str.charAt(j - 1)){
					dp[i][j] = dp[i - 1][j + 1] + 1;
					if(i - j + 1 == dp[i][j])
						maxLen = Math.max(maxLen, dp[i][j]);
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
