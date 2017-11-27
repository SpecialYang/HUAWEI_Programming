package com.special.improve;

import java.util.Scanner;

/** 
* 找出字符串中第一次出现一次的字符
* 对每一个字符找第一次出现的位置 和 最后一次出现的位置
* 若两个位置相等，则说明该字母就是出现一次
* @author special
* @date 2017年11月27日 下午2:12:02
*/
public class Pro58Improve1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str = input.nextLine();
			String result = "-1";
			for(int i = 0; i < str.length(); i++){
				char ch = str.charAt(i);
				if(str.indexOf(ch) == str.lastIndexOf(ch)){
					result = ch + "";
					break;
				}
			}
			System.out.println(result);
		}
	}
}

