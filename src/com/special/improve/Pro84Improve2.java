package com.special.improve;

import java.util.Scanner;

/** 
* �������Ӵ�
* �Ľ��Ķ�̬�滮����
* �ɹ��޸�bug��������˲��ܴ���abcefcba�����
* ˼·�����������ʱ�����жϵ�ǰ��i��j����֮��-����==��ǰ��ƥ�����󳤶�
* ��Ϊi�Ǵ���ʼ�ģ�j�Ǵ��ҿ�ʼ�����Ե�ƥ�䵽��󳤶�ʱ��Ӧ������
* i + j -length = dp[i][j]
* @author special
* @date 2017��12��7�� ����11:47:22
*/
public class Pro84Improve2 {
	public static int getHuiWenMaxLen(String str){
		int maxLen = 1;
		int length = str.length();
		String reverseStr = new StringBuilder(str).reverse().toString();
		int[][] dp = new int[length + 1][length + 1];
		for(int i = 1; i <= length; i++)
			for(int j = 1; j <= length; j++)
				if(str.charAt(i - 1) == reverseStr.charAt(j - 1)){
					dp[i][j] = dp[i - 1][j - 1] + 1;
					if(i + j - length == dp[i][j])
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
