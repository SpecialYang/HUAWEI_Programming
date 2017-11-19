package com.special.spet;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/** 
* 简单密码
* @author special
* @date 2017年9月12日 下午8:08:28
*/
public class Pro20 {
	
	private static Map<Character,Character> phoneCode = new HashMap<Character,Character>();
	/**
	 * 静态初始块，初始化键盘对应的数字
	 */
	static{
		phoneCode.put('a', '2');
		phoneCode.put('b', '2');
		phoneCode.put('c', '2');
		phoneCode.put('d', '3');
		phoneCode.put('e', '3');
		phoneCode.put('f', '3');	
		phoneCode.put('g', '4');
		phoneCode.put('h', '4');
		phoneCode.put('i', '4');
		phoneCode.put('j', '5');
		phoneCode.put('k', '5');
		phoneCode.put('l', '5');
		phoneCode.put('m', '6');
		phoneCode.put('n', '6');
		phoneCode.put('o', '6');
		phoneCode.put('p', '7');
		phoneCode.put('q', '7');
		phoneCode.put('r', '7');
		phoneCode.put('s', '7');
		phoneCode.put('t', '8');
		phoneCode.put('u', '8');
		phoneCode.put('v', '8');
		phoneCode.put('w', '9');
		phoneCode.put('x', '9');
		phoneCode.put('y', '9');
		phoneCode.put('z', '9');
	}
	public static String decode(String password){
		StringBuilder decodeString = new StringBuilder();
		for(int i = 0; i < password.length(); i++){
			char temp = password.charAt(i);
			if(temp >= 'a' && temp <= 'z')
				temp = phoneCode.get(temp);
			else if(temp >= 'A' && temp <= 'Z'){
				/**
				 * 注意Java中char与int相加的结果自动转换为int
				 * 如果此处不进行转型的话，就会报错！
				 * 如果不知道小写字母与大写字母差多少
				 * 那么采用  temp = (char) (temp - 'A' + 'a' + 1);
				 */
				/*if(temp != 'Z') temp = (char) (temp + 1 + 32);
				else            temp = 'a';*/
				temp = (char) ((temp + 1 - 'A') % 26 + 'a');
			}
			decodeString.append(temp);
		}
		return decodeString.toString();
	}
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String password = input.nextLine();
			String realPassword = decode(password);
			System.out.println(realPassword);
		}
	}
}
