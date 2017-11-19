package com.special.improve;

import java.util.Scanner;

/** 
* 1.����ڵ�һ�ַ����������������Ҫ�任��һ��ӳ���
* �Ҳ���Ҫ�ж���ĸ��Сд������
* 2.Ҳ���Բ�����ӳ���
* ����Сд��ĸ��(ch - 'a' + 1) % 26 + 'a'
* ���Ǵ�д��ĸ��(ch - 'A' + 1) % 26 + 'A'
* ����Сд��ĸ��(ch - '0' + 1) % 10 + '0'
* @author special
* @date 2017��9��26�� ����2:06:59
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
