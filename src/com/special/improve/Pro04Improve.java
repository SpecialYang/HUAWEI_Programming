package com.special.improve;

import java.util.Scanner;

/** 
* 此法巧妙的在后面加上8个0字符串，这样就避免了每次去检查是否少于8，好巧妙！！！
* @author special
* @date 2017年9月2日 下午2:46:53
*/
public class Pro04Improve {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int targetLength = 8;
		while(input.hasNext()){
			String str = input.nextLine();
			str += "00000000";                    //加8个0，好处一可以不用检查末尾不够8个字符串的情况
			while(str.length()>targetLength){     //只要字符串小于等于8就退出循环，因为意味着已经没有字符串的值了
				System.out.println(str.substring(0,targetLength));
				str = str.substring(targetLength);
			}
		}
	}
}
