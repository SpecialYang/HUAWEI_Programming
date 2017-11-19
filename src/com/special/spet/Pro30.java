package com.special.spet;

import java.util.Scanner;

/** 
* ���ʵ���
* ����һ����������firstLetter������¼��һ������ĸ��λ��
* Ȼ������ѭ������iѭ����֮���һ��������ĸ��λ��
* ����firstLetter ��  i ֮�����һ������
* ע�⣺Ҫ����һ������ǵ��ʵ������������һ���մ���ֵ���ַ�������
* @author special
* @date 2017��9��28�� ����1:01:33
*/
public class Pro30 {
	private static boolean isLetter(char ch){
		if(ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z')
			 return true;
		else return false;
	}
	public static String reverse(String str){
		int length = str.length();
		String[] letters = new String[length];
		int index = 0;
		for(int i = 0; i < length;){
			int firstLetter = i;
			while(firstLetter < length && !isLetter(str.charAt(firstLetter)))
				firstLetter++;
			i = firstLetter;
			while(i < length && isLetter(str.charAt(i)))
				i++;
			if(i > firstLetter)
				letters[index++] = str.substring(firstLetter,i);
		}
		StringBuilder result = new StringBuilder();
		for(int i = index - 1; i > 0; i--){
			result.append(letters[i]);
			result.append(' ');
		}
		result.append(letters[0]);
		return result.toString();
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str = input.nextLine();
			String result = reverse(str);
			System.out.print(result);
		}

	}

}
