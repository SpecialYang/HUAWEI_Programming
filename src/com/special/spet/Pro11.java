package com.special.spet;

import java.util.Scanner;

/** 
*
* @author special
* @date 2017��9��6�� ����8:53:38
*/
public class Pro11 {
	/**
	 * ��ȡһ�����͵������ַ������
	 * @param num
	 * @return
	 */
	public static String getReverseNum(int num){
		StringBuilder result = new StringBuilder();
		//��while�Ļ�����Ҫ��ѭ�������if���
		/*if(num == 0)  { return "0"; }
		while(num > 0){
			result.append(num % 10);
			num /= 10;
		}*/
		//���������һ��if��䣬�����ʹ��do-while
		do{
			result.append(num % 10);
			num /= 10;
		}while(num > 0);
		return result.toString();
	}
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int num = input.nextInt();
			String result = getReverseNum(num);
			System.out.println(result);
		}
	}
}
