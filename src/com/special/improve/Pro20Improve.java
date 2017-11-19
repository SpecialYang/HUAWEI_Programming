package com.special.improve;

import java.util.Scanner;

/**
 *
 * @author special
 * @date 2017年9月12日 下午8:58:05
 */
public class Pro20Improve {

	private static final String ENCODE = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	private static final String DECODE = "bcdefghijklmnopqrstuvwxyza22233344455566677778889999";

	public static String decode(String password) {
		StringBuilder decodeString = new StringBuilder();
		for (int i = 0; i < password.length(); i++) {
			char temp = password.charAt(i);
			if (temp >= 'A' && temp <= 'Z')
				temp = DECODE.charAt(temp - 'A');
			else if (temp >= 'a' && temp <= 'z')
				temp = DECODE.charAt(temp - 'a' + 26);
			decodeString.append(temp);
		}
		return decodeString.toString();
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			String password = input.nextLine();
			String realPassword = decode(password);
			System.out.println(realPassword);
		}
	}

}
