package com.special.spet;

import java.util.Scanner;

/** 
* �����ַ�����󳤶�
* �����dp[i][j]��ʾstr1��ǰi���ַ�����str2ǰj���ַ�����ȵĳ���
* Ҳ���ǰ���i��j�ĵ�ǰƥ��ĳ��ȣ�������ʾstr1��ǰi���ַ�����str2ǰj���ַ�����ȵ���󳤶�
* ��������һ������������󳤶�
* 
* ��improve�������Ż�һ�£���dp[i][j]Ϊ
* @author special
* @date 2017��12��3�� ����10:46:01
*/
public class Pro74 {
	public static int getCommonMaxLen(String str1, String str2){
		int length1 = str1.length();
		int length2 = str2.length();
		int[][] dp = new int[length1 + 1][length2 + 2];
		int maxLen = 0;
		for(int i = 1; i <= length1; i++)
			for(int j = 1; j <= length2; j++){
				if(str1.charAt(i - 1) == str2.charAt(j - 1)){
					dp[i][j] = dp[i - 1][j - 1] + 1;
					if(dp[i][j] > maxLen)
						maxLen = dp[i][j];
				}
			}
		return maxLen;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str1 = input.next();
			String str2 = input.next();
			int commonMaxLen = getCommonMaxLen(str1,str2);
			System.out.println(commonMaxLen);
		}
	}

}
