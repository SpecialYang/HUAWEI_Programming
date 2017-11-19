package com.special.improve;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** 
*
* @author special
* @date 2017年9月18日 上午11:30:33
*/
public class Pro25Improve1 {
	/**
	 * 没有采用排序，而是按字母表的每一位来考察原字符串是否含有。
	 * 有的话，就添加到list中，这样就不用考虑处理顺序，必然自动维护一个顺序
	 * 然后就在遍历一次字符串，其中的每一位字母位都从list中取
	 * 大神的杰作！
	 * @param str
	 * @return
	 */
	public static String sort(String str){
		int length = str.length();
		List<Character> letterList = new ArrayList<Character>();
		for(int i = 0; i < 26; i++){
			for(int j = 0; j < length; j++){
				char temp = str.charAt(j);
				/**
				 * 这里判断是否是按顺序来的字母的方法也很巧妙
				 * 以后可以借鉴一下
				 */
				if((temp - 'a' == i) || (temp - 'A' == i))
					letterList.add(temp);
			}
		}
		StringBuilder sortedString = new StringBuilder(str);
		int index = 0;
		for(int i = 0; i < length; i++){
			char temp = str.charAt(i);
			if((temp >= 'a' && temp <= 'z') || (temp >= 'A' && temp <= 'Z')) 
				sortedString.setCharAt(i, letterList.get(index++));
		}
		return sortedString.toString();
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str = input.nextLine();
			String result = sort(str);
			System.out.println(result);
		}
	}

}
