package com.special.improve;

import java.util.Scanner;

/** 
* ��ƻ��
* ������ԭ�����ĵݹ飬ʱ����������Ϊ���ͬ�����������ν��м���
* �������ǿ��ǿ��Ա���������Ľ⣬�ʲ��ö�̬�滮
* dp[i][j] = dp[i][j - 1] + dp[i - j][j]
* ע�� i < j  ��ֵ 0 �ǳ�����
* @author special
* @date 2017��11��29�� ����1:22:01
*/
public class Pro60Improve2 {
	public static int putApple(int m, int n){
		int[][] dp = new int[m + 1][n + 1];
		for(int i = 0; i <= n; i++) dp[0][i] = 1;
		for(int i = 1; i <= m; i++)
			for(int j = 1; j <= n; j++)
				dp[i][j] = dp[i][j - 1] + (i < j ? 0 : dp[i - j][j]);
		return dp[m][n];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int m = input.nextInt();
			int n = input.nextInt();
			int result = putApple(m,n);
			System.out.println(result);
		}
	}
}
