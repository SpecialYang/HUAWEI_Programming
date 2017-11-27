package com.special.spet;

import java.util.Scanner;

/** 
* 找出字符串中第一个出现一次的字符
* 哈希思想，把字符与数组索引对应起来， 值就是出现的次数
* 然后遍历原字符串，若值为1，输出
* @author special
* @date 2017年11月27日 下午1:50:49
*/
public class Pro58 {
	public static final int SIZE = (int) Math.pow(2, 16);
	
	public static void countCharacter(String str, int[] count){
		for(int i = 0; i < str.length(); i++)
			count[str.charAt(i)]++;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str = input.nextLine();
			int[] count = new int[SIZE];
			countCharacter(str,count);
			/*boolean isExit = false;
			for(int i = 0; i < str.length(); i++){
				if(count[str.charAt(i)] == 1){
					isExit = true;
					System.out.println(str.charAt(i));
					break;
				}
			}
			if(!isExit) System.out.println("-1");*/
			String result = "-1";
			for(int i = 0; i < str.length(); i++)
				if(count[str.charAt(i)] == 1){
					result = str.charAt(i) + "";
					break;
				}
			System.out.println(result);
		}
	}

}
