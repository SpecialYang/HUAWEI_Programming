package com.special.improve;

import java.util.Scanner;

/** 
* 1.相比于第一种方法，这个方法不需要变换第一个映射表
* 且不需要判断字母大小写和数字
* 2.也可以不适用映射表
* 若是小写字母则：(ch - 'a' + 1) % 26 + 'a'
* 若是大写字母则：(ch - 'A' + 1) % 26 + 'A'
* 若是小写字母则：(ch - '0' + 1) % 10 + '0'
* @author special
* @date 2017年9月26日 下午2:06:59
*/
public class Pro28Improve1 {

	private static final String encryptTable   = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	private static final String unencryptTable = "bcdefghijklmnopqrstuvwxyzaBCDEFGHIJKLMNOPQRSTUVWXYZA1234567890";
	public static String encrypt(String pwd){
		char[] pwdChar = pwd.toCharArray();
		for(int i = 0; i < pwd.length(); i++){
			char temp = pwd.charAt(i);
			pwdChar[i] = unencryptTable.charAt(encryptTable.indexOf(temp));
		}
		return new String(pwdChar);
	}
	public static String unencrypt(String unPwd){
		char[] pwdChar = unPwd.toCharArray();
		for(int i = 0; i < unPwd.length(); i++){
			char temp = unPwd.charAt(i);
			pwdChar[i] = encryptTable.charAt(unencryptTable.indexOf(temp));
		}
		return new String(pwdChar);
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String pwdEncrypt   = input.nextLine();
			String pwdUnencrypt = input.nextLine();
			pwdEncrypt = encrypt(pwdEncrypt);
			pwdUnencrypt = unencrypt(pwdUnencrypt);
			System.out.println(pwdEncrypt);
			System.out.println(pwdUnencrypt);
		}

	}


}
