package com.special.spet;

import java.util.Scanner;

/** 
* ͬ���ǿռ任ʱ����⣡
* @author special
* @date 2017��9��5�� ����6:06:24
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
