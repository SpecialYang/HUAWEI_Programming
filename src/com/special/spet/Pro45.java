package com.special.spet;

import java.util.Scanner;

/** 
* 截取字符串
* 此题给了明确的表示，说非汉字字符占1个字节，汉字占2个字节
* C和C++来做的话比较方便，因为其字符本身就占一个字节
* 而Java中字符是占2个字节，所以我们如果还要坚持用Java
* 
* ☆☆☆☆☆☆注意Java中char是无符号型的，取值范围为0到65536（包括了汉字）,所以toCharArray()其实不把汉字分开
* ☆☆☆☆☆☆注意C/C++中char是有符号型的，取值范围为-128到127（不包括了汉字）,所以可以通过每个字符的编码值小于0来判断
* 
* 
* 就要用从索引上下手，确保对应题目的要求
* 此题技巧：
* 1.汉字字符的码对应的int值是大于127
* 2.设置一个计数器，若当前字符为汉字，则加2，否则加1，模拟字节
* @author special
* @date 2017年10月26日 下午1:46:23
*/
public class Pro45 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str = input.next();
			int n = input.nextInt();
			int count = 0;
			StringBuilder result = new StringBuilder();
			for(int i = 0; i < str.length() && count < n; i++){
				if(str.charAt(i) > 127){
					count += 2;
					if(count > n) break;
				}
				else   
					count++;
				result.append(str.charAt(i));
			}
			System.out.println(result);
		}

	}

}
