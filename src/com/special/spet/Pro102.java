package com.special.spet;

import java.util.Scanner;

/** 
* ����������г���
* 
* ��̬�滮���� ���Ӷ�O(n��ƽ����
* dp[i]��ʾ���һ����i����ĵ������У���ô֮ǰ�����п϶�������0 �� i - 1
* ����ѡ��0 �� i - 1 �� ���� ����׮�ӹ�����ͬʱ�жϴ����׮�ӹ����󣬸������ֵ����
* �����Ҫһ��ȫ�ֵ������������¼ȫ�������
* @author special
* @date 2017��12��17�� ����9:09:23
*/
public class Pro102 {
	public static int getMoreSteps(int[] height, int n){
		int steps = 0;
		int[] dp = new int[n + 1];
		for(int i = 1; i <= n; i++) dp[i] = 1;
		for(int i = 1; i <= n; i++){
			for(int j = 1; j < i; j++){
				if(height[j - 1] < height[i - 1]){
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			steps = Math.max(steps, dp[i]);
		}
		return steps;
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
