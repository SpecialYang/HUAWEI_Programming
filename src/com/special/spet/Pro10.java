package com.special.spet;

import java.util.Scanner;

/** 
* 同样是空间换时间的题！
* @author special
* @date 2017年9月5日 下午6:06:24
*/
public class Pro10 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int[] flag = new int[128];
			String str = input.nextLine();
			int count = 0;
			for(int i = 0;i < str.length();i++){
				char ch = str.charAt(i);
				if(flag[ch]==0 && ch >=0 && ch <= 127)
					flag[ch] = 1;
			}
			for(int item : flag)
				if(item == 1)
					count++;
			System.out.println(count);
		}

	}

}
