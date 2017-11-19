package com.special.improve;

import java.util.Scanner;

/** 
* 利用以某一个字母为中心进行扩展求最长的回文串
* 只有两种情况
* 1.ABBA   偶数型
* 2.ABBBA  奇数型
* @author special
* @date 2017年9月29日 下午2:46:33
*/
public class Pro31Improve1 {
	public static int getLength(String str){
		int length = str.length();
		int ans = 0;
		/**
		 * 注意i的范围，如果i和i+1比，则到length - 1就可以了
		 */
		for(int i = 0; i < length - 1; i++){
			int begin = i, end = i + 1;
			while(begin >= 0 && end < length && str.charAt(begin) == str.charAt(end)){
				begin--; end++;
			}
			if(ans < end - begin - 1)
				ans = end - begin - 1;
			begin = i - 1;
			end   = i + 1;
			while(begin >= 0 && end < length && str.charAt(begin) == str.charAt(end)){
				begin--;
				end++;
			}
			if(ans < end - begin - 1)
				ans = end - begin - 1;
		}
		return ans;
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str = input.nextLine();
			int longestLength = getLength(str);
			System.out.println(longestLength);
		}
	}

}
