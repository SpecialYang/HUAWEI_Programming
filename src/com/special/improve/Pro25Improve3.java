package com.special.improve;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/** 
* ����Ͱ����
* @author special
* @date 2017��9��18�� ����2:29:39
*/
public class Pro25Improve3 {
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
	 * ���ε�ð�ݷ������ϣ������
	 * ����ĸ����������
	 * @param str
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static char[] sort(String str){
		int length = str.length();
		char[] strArray = str.toCharArray();
		/**
		 * ����Java�������������飬�ᱨ��
		 * ֻ�ܲ������ֲ���ȫ������
		 */
		Queue[] letterList = new LinkedList[26];
		for(int i = 0; i < 26; i++)
			letterList[i] = new LinkedList();
		for(int i = 0; i < length; i++){ 
			if(isNotLetter(strArray[i])) continue;
			else letterList[toLower(strArray[i]) - 'a'].add(strArray[i]);
		}
		int noEmptyIndex = 0;
		for(int i = 0; i < length; i++){
			if(isNotLetter(strArray[i])) continue;
			while(letterList[noEmptyIndex].size() == 0){
				noEmptyIndex++;
			}
			strArray[i] = (char) letterList[noEmptyIndex].poll();
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
