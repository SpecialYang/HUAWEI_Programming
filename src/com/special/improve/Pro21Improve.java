package com.special.improve;

import java.util.Scanner;

/** 
*
* @author special
* @date 2017年9月13日 下午2:06:47
*/
public class Pro21Improve {
	
	/**
	 * 更牛逼的想法，我每两个空瓶子都跟老板借一次，喝完就还他，这样就是 bottels / 2
	 * 太牛逼了！！！！！！！
	 * @param bottels
	 * @return
	 */
	public static int getNumbers(int bottels){
		return bottels / 2;
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N = 10;
		int count = 0;
		int[] numbers = new int[10];
		while(input.hasNext()){
			int bottels = input.nextInt();
			if(bottels == 0 || count >= 10)  break;
			else numbers[count++] = getNumbers(bottels);
		}
		for(int i = 0; i < count; i++)
			System.out.println(numbers[i]);
	}
}
