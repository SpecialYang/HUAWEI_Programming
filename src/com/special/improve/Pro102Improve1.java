package com.special.improve;

import java.util.Arrays;
import java.util.Scanner;

/** 
* ��������������⣨����ĿҪ���ǵ����Ҳ������ʱ���������ڷ��ظ������ݣ��м�
* 
* ԭ������󣬿�ʼ���������������
* @author special
* @date 2017��12��17�� ����9:29:40
*/
public class Pro102Improve1 {

	public static int getMoreSteps(int[] height, int n){
		int[] ascHeight = Arrays.copyOf(height, n);
		Arrays.sort(ascHeight);
		int[][] dp = new int[n + 1][n + 1];
		for(int i = 1; i <= n; i++){
			for(int j = 1; j <= n; j++){
				if(height[i - 1] == ascHeight[j - 1])
					dp[i][j] = dp[i - 1][j - 1] + 1;
				else 
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
			}
			
		}
		return dp[n][n];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			int[] height = new int[n];
			for(int i = 0; i < n; i++)
				height[i] = input.nextInt();
			int steps = getMoreSteps(height,n);
			System.out.println(steps);
		}
	}

}
