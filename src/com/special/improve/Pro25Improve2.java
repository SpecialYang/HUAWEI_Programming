package com.special.improve;

import java.util.Scanner;

/** 
*
* @author special
* @date 2017��9��18�� ����1:49:32
*/
public class Pro25Improve2 {
	public static boolean isNotLetter(char ch){
		if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))
			return false;
		return true;
	}
	
	public static char toLower(char ch){
		if(ch >= 'A' && ch <= 'Z')
			return (char) ('a' + ch - 'A');
		return ch;
	}
	
	/**
	 * ���ε�ð��
	 * ����ĸ����������
	 * @param str
	 * @return
	 */
	public static char[] sort(String str){
		int length = str.length();
		char[] strArray = str.toCharArray();
		int letterFirstIndex = 0;
		/**
		 * �ҵ���һ��ĸ��λ��
		 * ������������ѭ����ʱ����ѭ����һ�㡣
		 */
		while(isNotLetter(strArray[letterFirstIndex]))
			letterFirstIndex++;
		for(int i = 0; i < length; i++){
			int swapIndex = letterFirstIndex;
			for(int j = swapIndex + 1; j < length - i; j++){
				if(isNotLetter(strArray[j])) continue;    //�����λ�ò�����ĸ��������һ��
				/**
				 * ����һ��λ�õ���ĸ���ڵ�ǰλ����ĸ���򽻻�
				 */
				if(toLower(strArray[swapIndex]) > toLower(strArray[j])){ 
					char temp = strArray[j];
					strArray[j] = strArray[swapIndex];
					strArray[swapIndex] = temp;
				}
				/**
				 * �����Ƿ񽻻�����Ӧ�ü�סj��λ��
				 * ��Ϊj��λ����Զ��������
				 */
				swapIndex = j; 
			}
		}
		return strArray;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str = input.nextLine();
			char[] result = sort(str);
			System.out.println(result);
		}
	}
}
