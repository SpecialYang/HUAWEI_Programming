package com.special.improve;

import java.util.Scanner;

/** 
* 再优化，哈哈，不用手动反转
* 自己用代码模拟反转
* @author special
* @date 2017年12月7日 上午11:56:52
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
