package com.special.improve;

import java.util.Scanner;

/** 
* ������·�Ķ�̬�滮
* �������ת��Ϊ
* dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
* 
* ���ɣ���dp[i][0] �� dp[0][i]�Ĵ���ܹؼ�
* @author special
* @date 2017��12��9�� ����11:12:21
*/
public class Pro90Improve1 {
	public static int getKinds(int n, int m){
		int[][] dp = new int[n + 1][m + 1];
		for(int i = 0; i <= n; i++) dp[i][0] = 1;
		for(int i = 0; i <= m; i++) dp[0][i] = 1; //i��0��ʼ����ʵ��Ϊ������ 0 0ʱ�����1
		for(int i = 1; i <= n; i++)
			for(int j = 1; j <= m; j++)
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
		return dp[n][m];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			int m = input.nextInt();
			
			int kinds = getKinds(n,m);
			System.out.println(kinds);
		}
	}

}
