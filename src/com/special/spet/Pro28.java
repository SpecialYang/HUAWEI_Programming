package com.special.spet;

import java.util.Scanner;

/** 
* 字符串加密解密
* 运用两个字符串记住所有的映射，然后需要就去访问对应的映射即可。
* @author special
* @date 2017年9月26日 下午1:36:43
*/
public class Pro28 {
	private static final String encryptTable   = "zabcdefghijklmnopqrstuvwxyZABCDEFGHIJKLMNOPQRSTUVWXY9012345678";
	private static final String unencryptTable = "bcdefghijklmnopqrstuvwxyzaBCDEFGHIJKLMNOPQRSTUVWXYZA1234567890";
	public static String encrypt(String pwd){
		char[] pwdChar = pwd.toCharArray();
		for(int i = 0; i < pwd.length(); i++){
			char temp = pwd.charAt(i);
			if(temp >= 'A' && temp <= 'Z')
				temp = unencryptTable.charAt(temp - 'A');
			else if(temp >= 'a' && temp <= 'z')
				temp = unencryptTable.charAt(temp - 'a' + 26);
			else if(temp >= '0' && temp <= '9')
				temp = unencryptTable.charAt(temp - '0' + 52);
			pwdChar[i] = temp;
		}
		return new String(pwdChar);
	}
	public static String unencrypt(String unPwd){
		char[] pwdChar = unPwd.toCharArray();
		for(int i = 0; i < unPwd.length(); i++){
			char temp = unPwd.charAt(i);
			if(temp >= 'A' && temp <= 'Z')
				temp = encryptTable.charAt(temp - 'A');
			else if(temp >= 'a' && temp <= 'z')
				temp = encryptTable.charAt(temp - 'a' + 26);
			else if(temp >= '0' && temp <= '9')
				temp = encryptTable.charAt(temp - '0' + 52);
			pwdChar[i] = temp;
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
