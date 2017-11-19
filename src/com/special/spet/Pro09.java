package com.special.spet;

import java.util.Scanner;

/** 
* 提取不重复的整数，与Pro03的思想一致
* 同样使用了空间换时间的思想，利用标记数组标记每一位是否已经出现
* 最后生成整数时同时也利用到了移位的思想，尾数每加一个，整体增大为相应进制的倍数
* @author special
* @date 2017年9月5日 下午2:40:13
*/
public class Pro09 {
		public static void main(String[] args){
			Scanner input = new Scanner(System.in);
			while(input.hasNext()){
				int[] flag = new int[10];
				int num = input.nextInt();
				int result = 0;
				while(num != 0){
					int digit = num % 10;
					if(flag[digit] == 0){
						flag[digit] = 1;
						result = result * 10 + digit;
					}
					num /=10;
				}
				System.out.println(result);
			}
		}
}
