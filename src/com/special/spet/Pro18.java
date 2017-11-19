package com.special.spet;

import java.util.Scanner;

/** 
* ������֤
* �Ĵ�Լ�����������������У����ǿ�����4��������һ�£�Ȼ����Ӻ��Ƿ�С��3��������������
* 
* @author special
* @date 2017��9��8�� ����1:18:08
*/
public class Pro18 {
	
	public static boolean isStandard(String password){
		int length = password.length();
		if(length <= 8)                     return false;
		int[] flag = new int[4];
		for(int i = 0; i < length; i++){
			char ch = password.charAt(i);
			if(ch >= 'A' && ch <= 'Z')      flag[0] = 1;
			else if(ch >= 'a' && ch <= 'z') flag[1] = 1;
			else if(ch >= '0' && ch <= '9') flag[2] = 1;
			else                            flag[3] = 1;
		}
		//�˴�����ĺ�����
		if(flag[0] + flag[1] + flag[2] + flag[3] < 3) return false; 
		//ͨ�������Ӵ�������containsҲͦ���㣡
		for(int i = 0; i < length - 3; i++){
			String subString = password.substring(i, i + 3);
			if(password.substring(i + 1).contains(subString))
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String password = input.nextLine();
			if(isStandard(password))
				System.out.println("OK");
			else
				System.out.println("NG");
		}

	}

}
