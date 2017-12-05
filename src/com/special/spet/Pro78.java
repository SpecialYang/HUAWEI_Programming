package com.special.spet;

import java.util.Scanner;

/** 
* �ַ��������ƶ�
* ��Ŀ��ʵ��pro48һ����ֻ���������һ�������ı�ʾ
* dp[i][j]��ʾǰi���ַ���ʾΪǰj���ַ��������С������
* 4���������С��
* 1.����i���͵�j����ȣ���dp[i][j] = dp[i - 1][j - 1]
* 2.����i���͵�j������ȣ���dp[i][j] = dp[i - 1][j - 1] + 1;
* �����ֻ���������ܵĲ���������dp[i][j - 1] + 1��dp[i - 1][j] + 1
* ����Ҫ����3����С��һ�ֵ������
* @author special
* @date 2017��12��5�� ����3:33:55
*/
public class Pro78 {
	public static int getDistance(String str1, String str2){
		int length1 = str1.length();
		int length2 = str2.length();
		int[][] dp = new int[length1 + 1][length2 + 1];
		for(int i = 1; i <= length1; i++) dp[i][0] = i;
		for(int i = 1; i <= length2; i++) dp[0][i] = i;
		for(int i = 1; i <= length1; i++)
			for(int j = 1; j <= length2; j++){
				if(str1.charAt(i - 1) == str2.charAt(j - 1))
					dp[i][j] = dp[i - 1][j - 1];
				else
					dp[i][j] = dp[i - 1][j - 1] + 1;
				dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]) + 1,dp[i][j]);
			}
		return dp[length1][length2];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str1 = input.nextLine();
			String str2 = input.nextLine();
			int distance = getDistance(str1,str2);
			System.out.println("1/" + (distance + 1));
		}
	}

}
