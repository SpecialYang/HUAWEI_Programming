package com.special.improve;

import java.util.Scanner;

/** 
* �˷�������ں������8��0�ַ����������ͱ�����ÿ��ȥ����Ƿ�����8�����������
* @author special
* @date 2017��9��2�� ����2:46:53
*/
public class Pro04Improve {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int targetLength = 8;
		while(input.hasNext()){
			String str = input.nextLine();
			str += "00000000";                    //��8��0���ô�һ���Բ��ü��ĩβ����8���ַ��������
			while(str.length()>targetLength){     //ֻҪ�ַ���С�ڵ���8���˳�ѭ������Ϊ��ζ���Ѿ�û���ַ�����ֵ��
				System.out.println(str.substring(0,targetLength));
				str = str.substring(targetLength);
			}
		}
	}
}
