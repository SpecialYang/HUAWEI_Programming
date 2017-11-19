package com.special.spet;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/** 
* 合唱队
* 实质就是求最长递增子序列与最长递减子序列的变形
* 因为合唱队要求分布曾尖峰状，即高的在中间，两边依次递减
* 那么我就可以求每个数的所在位置的最长递增和最长递减
* 然后相加，即可得到以该数为中心，两边一次递减的数列，不过要注意此处多加了一次1
* 所以最后数列的真实长度为 num - max + 1
* 
* 我这个方法，就是按照求最长公共子序列的方法来的，思想比较老化了
* 用的是原串与递增的串，求最长公共子序列
* 这个方法还要去掉原串中重复的元素，所以有点麻烦！
* @author special
* @date 2017年9月16日 下午3:46:50
*/
public class Pro23 {
	
	public static void getLengthLIC(int[] status, int[] incStatus, int[][]incDp){
		int sizeOfArray = status.length;
		for(int i = 1; i <= sizeOfArray; i++)
			for(int j = 1; j <= sizeOfArray; j++){
				if(status[i - 1] == incStatus[j - 1])
					incDp[i][j] = incDp[i - 1][j - 1] + 1;
				else{
					if(incDp[i][j - 1] > incDp[i - 1][j])
						incDp[i][j] = incDp[i][j - 1];
					else
						incDp[i][j] = incDp[i - 1][j];
				}
			}
	}
	
	public static int getLengthIncDec(int[][] inc, int[][] dec){
		int max = -1;
		int length = inc.length - 1;
		for(int i = 1,j = length; i <= length; i++,j--){
			int temp = inc[i][length] + dec[j][length];
			if(temp > max)
				max = temp;
		}
		return max;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		int[] status = new int[num];
		/**
		 * 注意次数要去掉重复的元素，我做完的时候发现了此法的弊端了
		 * 所以就放弃了！
		 */
		int[] incStatus = new int[num];
		int[] decStatus = new int[num];
		int[][] incDp = new int[num + 1][num + 1];
		int[][] decDp = new int[num + 1][num + 1];
		for(int i = 0; i < num; i++){
			int n = input.nextInt();
			status[i]    = n;
		}
		Arrays.sort(incStatus);
		getLengthLIC(status,incStatus,incDp);
		for(int i = 0; i < num / 2; i++){
			int temp  = status[i];
			status[i] = status[num - i - 1];
			status[num - i - 1] = temp;
		}
		for(int i = 0; i < num; i++)
			decStatus[i] = incStatus[num - i - 1];
		getLengthLIC(status,decStatus,decDp);
		int max = getLengthIncDec(incDp,decDp);
		System.out.println(num - max + 1);
	}

}
