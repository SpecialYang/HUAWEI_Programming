package com.special.improve;

import java.util.Scanner;

/** 
* �ҳ��ַ����е�һ�γ���һ�ε��ַ�
* ��ÿһ���ַ��ҵ�һ�γ��ֵ�λ�� �� ���һ�γ��ֵ�λ��
* ������λ����ȣ���˵������ĸ���ǳ���һ��
* @author special
* @date 2017��11��27�� ����2:12:02
*/
public class Pro58Improve1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str = input.nextLine();
			String result = "-1";
			for(int i = 0; i < str.length(); i++){
				char ch = str.charAt(i);
				if(str.indexOf(ch) == str.lastIndexOf(ch)){
					result = ch + "";
					break;
				}
			}
			System.out.println(result);
		}
	}
}

