package com.special.improve;

import java.util.Scanner;

/** 
* DNA序列
* 其实不用那么麻烦用字符表，散列数组思想
* 单纯的判断该位是否是GC，计数就可以
* @author special
* @date 2017年11月29日 下午6:02:37
*/
public class Pro62Improve1 {
	private static boolean isGOrC(char ch) { return ch == 'G' || ch == 'C'; }
	
	public static String getMaxRatioOfGC(String str, int n){
		int counts = 0;
		int maxCounts = 0;
		int maxEnd = 0;
		for(int i = 0; i < n; i++)
			if(isGOrC(str.charAt(i)))
				counts++;
		maxCounts = counts;
		maxEnd = n;
		for(int i = maxEnd; i < str.length(); i++){
			if(isGOrC(str.charAt(i - n))) counts--;
			if(isGOrC(str.charAt(i))) counts++;
			if(counts > maxCounts){
				maxCounts = counts;
				maxEnd = i + 1;
			}
		}
		return str.substring(maxEnd - n,maxEnd);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str = input.nextLine();
			int n = input.nextInt();
			String result = getMaxRatioOfGC(str,n);
			System.out.println(result);
		}
	}

}
