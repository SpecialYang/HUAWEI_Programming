package com.special.spet;

import java.util.Scanner;

/** 
* �ַ���ƥ������
* Ҳ���Ƕ̴������ַ��Ƿ��ڳ�����
* @author special
* @date 2017��12��5�� ����10:17:56
*/
public class Pro80 {
	public static boolean isContainsAll(String str1, String str2){
		for(int i = 0; i < str1.length(); i++){
			if(!str2.contains(Character.toString(str1.charAt(i))))
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str1 = input.nextLine();
			String str2 = input.nextLine();
			if(isContainsAll(str1,str2))
				System.out.println(true);
			else
				System.out.println(false);
		}
	}

}
