package com.special.spet;

import java.util.Scanner;

/** 
* 输入一堆数字，然后去掉重复的并从小到大排列！
* 此法巧妙的之处用的是计数排序的思想，空间换时间！ 
* @author special
* @date 2017年9月1日 下午9:38:35
*/
public class Pro03 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int[]  result = new int[1001]; //反转，数组索引保存输入的数，而存的数为出现的次数
			int num = input.nextInt();
			while(num-- != 0){
				int n = input.nextInt(); 
				result[n] = 1;    //保证每次只有一个数！
			}
			for(int i = 0;i < result.length;i++)
				if(result[i] != 0)
					System.out.println(i);
		}
	}
}
