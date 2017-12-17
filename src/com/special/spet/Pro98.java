package com.special.spet;

import java.util.Scanner;

/** 
* 自守数
* 
* 判断一个字符是否是另一个的后缀
* 思路：两个字符串长度相减，即可得到开始的索引
* （因为如果是后缀，后缀长度相等且内容相等）
* 从索引处开始遍历，若出现不相等则不是
* @author special
* @date 2017年12月11日 下午11:11:31
*/
public class Pro98 {
	private static boolean isEndWithI(int square, int num){
		String squareStr = String.valueOf(square);
		String numStr = String.valueOf(num);
		int index = squareStr.length() - numStr.length();
		return squareStr.substring(index).equals(numStr);
	}
	public static int getCount(int n){
		int count = 0;
		for(int i = 0; i <= n; i++)
			if(isEndWithI(i * i,i))
				count++;
		return count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			int count = getCount(n);
			System.out.println(count);
		}
	}

}
