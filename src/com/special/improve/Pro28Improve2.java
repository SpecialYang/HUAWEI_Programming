package com.special.improve;

import java.util.Scanner;

/** 
* 充分利用取余数来做
* @author special
* @date 2017年9月26日 下午2:19:41
*/
public class Pro28Improve2 {
	public static String encrypt(String pwd){
		char[] pwdChar = pwd.toCharArray();
		for(int i = 0; i < pwd.length(); i++){
			char temp = pwd.charAt(i);
			if(temp >= 'A' && temp <= 'Z')
				temp = (char) ((temp + 1 - 'A') % 26 + 'a');
			else if(temp >= 'a' && temp <= 'z')
				temp = (char) ((temp + 1 - 'a') % 26 + 'A');
			else if(temp >= '0' && temp <= '9')
				temp = (char) ((temp + 1 - '0') % 10 + '0');
			pwdChar[i] = temp;
		}
		return new String(pwdChar);
	}
	public static String unencrypt(String unPwd){
		char[] pwdChar = unPwd.toCharArray();
		for(int i = 0; i < unPwd.length(); i++){
			char temp = unPwd.charAt(i);
			if(temp >= 'A' && temp <= 'Z')
				temp = (char) ((temp - 1 + 26 - 'A') % 26 + 'a');
			else if(temp >= 'a' && temp <= 'z')
				temp = (char) ((temp - 1 + 26 - 'a') % 26 + 'A');
			else if(temp >= '0' && temp <= '9')
				temp = (char) ((temp - 1 + 10 - '0') % 10 + '0');
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
