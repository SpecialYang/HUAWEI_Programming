package com.special.spet;

import java.util.Scanner;

/** 
* 删除出现次数最少的字符，若都出现次数相等也要全删
* 1.一般思路都是可能会一个索引指向第一个字符，然后遍历整个字符串并计数，这样复杂度就是n的平方
* 2.进一步优化，可能想到让字符串排序，然后一次遍历并计数，这样复杂度取结于排序算法的复杂度
* 3.更进一步，采用空间换时间的方法，对于这样统计字符出现次数都可以采用此法
* 一般用数组的索引代表字符，可以（char - 26）处理，这样就可以从0 到  25
* 我虽然想到了这样的方法，但是到后面又傻了，我竟然让这个数组排序，这样少的字符就会在前面
* 这样就有个问题，统计次数与数组索引就不照了。我竟然想到再设计一个类，存储字符与次数，再排序
* 太可惜了。既然想到了空间换时间这么优秀的方法，竟然到最后夭折了。
* 最佳做法就是无需排序，然后从数组找到出现次数就少的。
* 然后遍历整个字符串，对于每个字符串去数组中看其对应的次数是否与最少的次数相等，然后决定是否删除（很妙的做法！！！）
* @author special
* @date 2017年9月13日 下午5:54:59
*/
public class Pro22 {

	public static String getReduce(String str){
		StringBuilder reduceResult = new StringBuilder();
		int[] countChar = new int[26];
		/**
		 * 统计字符出现的次数
		 */
		for(int i = 0; i < str.length(); i++){
			char temp = str.charAt(i);
			countChar[temp - 'a']++;
		}
		int min = Integer.MAX_VALUE;
		/**
		 * 找出最少的
		 */
		for(int i = 0; i < 26; i++)
			if(countChar[i] != 0 && countChar[i] < min)
				min = countChar[i];
		/**
		 * 遍历整个字符串，剔除最少的
		 */
		for(int i = 0; i < str.length(); i++){
			char temp = str.charAt(i);
			if(countChar[temp - 'a'] != min)
				reduceResult.append(temp);
		}
		return reduceResult.toString();
	}
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str = input.nextLine();
			String result = getReduce(str);
			System.out.println(result);
		}
	}
}
