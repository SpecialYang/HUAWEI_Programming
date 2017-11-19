package com.special.spet;

import java.util.Scanner;

/** 
* �ַ�������
* �������ÿռ任ʱ��ķ���
* ���ü��������˼�룬����ĸ��Ϊ�������ó��ֵ���ĸ������Ӧ��ֵΪ1�����������޳��ظ�����ĸ
* ȫ���ô�д��ĸ��ӳ�䣬Сд�Ļ�ת��д    -32
* @author special
* @date 2017��10��13�� ����3:39:10
*/
public class Pro35 {
	public static String encrypt(String key, String str){
		int[] flag = new int[26];
		char[] mapLetter = new char[26];
		int lengthKey = key.length();
		int lengthStr = str.length();
		char[] result = new char[lengthStr];
		int index = 0;
		/**
		 * ӳ����ǰ���key��setֵ
		 */
		for(int i = 0; i < lengthKey; i++){
			char temp = key.charAt(i);
			if(temp >= 'a' && temp <= 'z')
				temp -= 32;
			if(flag[temp - 'A'] == 0){
				flag[temp - 'A'] = 1;
				mapLetter[index++] = temp;
			}
		}
		/**
		 * ӳ������ȡû���ֵ���ĸ�����ΰڷ�
		 */
		for(int i = 0; i < 26; i++)
			if(flag[i] == 0)
				mapLetter[index++] = (char) (i + 'A');
		for(int i = 0; i < lengthStr; i++){
			char temp = str.charAt(i);
			if(temp >= 'a' && temp <= 'z'){
				temp -= 32;
				result[i] = (char) (mapLetter[temp - 'A'] + 32);
			}
			else
				result[i] = mapLetter[temp - 'A'];
		}
		return new String(result);
	}
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String key = input.nextLine();
			String str = input.nextLine();
			String result = encrypt(key,str); 
			System.out.println(result);
		}
	}
}
