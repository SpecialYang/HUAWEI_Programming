package com.special.spet;

import java.util.Scanner;

/** 
* 尼克切斯定理
* 任何一个整数m的立方都可以写成m个连续奇数之和
* 
* 注意temp的巧妙之处，只需判断一次是否是偶数或者奇数
* @author special
* @date 2017年12月3日 上午11:26:22
*/
public class Pro75 {
	/**
	 * 看到第23行，我就应该想到先利用数学算一下啊
	 * 因为cubeN/n 消了一个n,意思就是我不用算立方了啊
	 * @param n
	 * @return
	 */
	public static String getExpression(int n){
		StringBuilder result = new StringBuilder();
		int cubeN = (int) Math.pow(n,3);
		int temp = n % 2 == 0 ? 1 : 0;
		int midItem = cubeN / n - temp; //中间项
		int firstItem = midItem - 2 * (n / 2 - temp); //第一项
		while(n-- > 1){
			result.append(firstItem + "+");
			firstItem += 2;
		}
		result.append(firstItem);
		return result.toString();
	}
	public static String getExpressionImprove(int n){
		StringBuilder result = new StringBuilder();
		int firstItem = n * n - n + 1; //第一项
		while(n-- > 1){
			result.append(firstItem + "+");
			firstItem += 2;
		}
		result.append(firstItem);
		return result.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			String expression = getExpressionImprove(n);
			System.out.println(expression);
		}
	}

}
