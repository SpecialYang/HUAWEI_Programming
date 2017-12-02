package com.special.improve;

import java.util.Scanner;

/** 
* ͨ�������
* ��̬�滮
* dp[i][j] = true; ��ʾǰi���ַ��ܹ�ƥ��ǰj���ַ�
* ��2�����
* 1.iΪ*�ţ���i����ƥ��j��Ҳ���Բ�ƥ��j
* ����dp[i][j] = dp[i - 1][j] || dp[i][j - 1]
* 2.i��Ϊ*�ţ�ƥ���ɵ�ǰ�Ƿ���Ȼ����Ƿ�Ϊð��
* dp[i][j] = dp[i - 1][j - 1] && (ch1 == '?' || ch1 == ch2)
* 
* ע���ʼֵ�ж�������������dp[0][0] = T
* ͬʱ��dp[i][0]ҲҪ�жϵ�ǰ��Ϊ*�ź�ǰ���Ƿ�Ҳ��T������ȷ��ǰi���ܹ�ƥ��0���ַ�����
* @author special
* @date 2017��12��2�� ����3:37:06
*/
public class Pro70Improve2 {
	public static boolean isMatch(String matchStr, String originStr){
		int length1 = matchStr.length();
		int length2 = originStr.length();
		boolean[][] dp = new boolean[length1 + 1][length2 + 1];
		dp[0][0] = true;
		for(int i = 1; i <= length1; i++){
			char ch1 = matchStr.charAt(i - 1);
			dp[i][0] = dp[i - 1][0] && ch1 == '*';
			for(int j = 1; j <= length2; j++){
				char ch2 = originStr.charAt(j - 1);
				if(ch1 == '*')
					dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
				else
					dp[i][j] = dp[i - 1][j - 1] && (ch1 == '?' || ch1 == ch2);
			}
		}
		return dp[length1][length2];
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
