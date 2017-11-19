package com.special.spet;

import java.util.Scanner;

/** 
* �ַ�������
* 1.���淽������ԭ�ַ����еķ���ĸ����ĸ�ֿ�
* ����ĸ�����м�¼��ԭ�ַ����г��ֵ�����
* ��ĸ�����ò������򣨱������ȶ��������㷨��
* Ȼ���������������ݷ���ĸ���������λ�����β������ĸ
* ���Ӷ�O(n��ƽ����
* 2.�����Ϸ������иĽ������������¼����ĸ
* ����ĸ���������ֻҪ����ԭ�ַ�����������ĸ�������
* ���δ���ĸ����ȡ�����ַ������棡
* @author special
* @date 2017��9��18�� ����8:12:01
*/
public class Pro25 {
	/**
	 * ��ĸ�Ƚϴ�С������Сд��ĸ�ıȽ�
	 * @param ch1
	 * @param ch2
	 * @return
	 */
	public static boolean less(char ch1, char ch2){
		ch1 = toLower(ch1);
		ch2 = toLower(ch2);
		if(ch1 < ch2) return true;
		else          return false;
	}
	/**
	 * ��������
	 * @param ch
	 * @param length
	 */
	public static void sort(char[] ch , int length){
		for(int i = 1; i < length; i++){
			char temp = ch[i];
			int j = i - 1;
			for(; j >= 0; j--){
				if(less(temp, ch[j]))
					ch[j + 1] = ch[j];
				else
					break;
			}
			/**
			 * �����Ժ�����������ѭ��
			 * ���Ǹ�ֵ��j + 1��λ����
			 */
			ch[j + 1] = temp;
		}
	}
	/**
	 * �ж��ǲ�����ĸ
	 * @param ch
	 * @return
	 */
	public static boolean isNotLetter(char ch){
		if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))
			return false;
		return true;
	}
	/**
	 * ת����Сд��ĸ
	 * @param ch
	 * @return
	 */
	public static char toLower(char ch){
		if(ch >= 'A' && ch <= 'Z')
			return (char) ('a' + ch - 'A');
		return ch;
	}
	/**
	 * �ַ�������
	 * @param str
	 * @return
	 */
	public static String sort(String str){
		int length = str.length();
		int[] flag = new int[length];
		char[] sortedSeq  = new char[length];
		int flagSize = 0;
		int sortedSeqSize = 0;
		for(int i = 0; i < length; i++){
			char temp = str.charAt(i);
			if(isNotLetter(temp)) flag[flagSize++] = i;
			else                  sortedSeq[sortedSeqSize++] = temp;	
		}
		sort(sortedSeq,sortedSeqSize);
		for(int i = 0; i < flagSize; i++){
			int index = flag[i];
			for(int j = sortedSeqSize - 1; j >= index; j--){
				sortedSeq[j + 1] = sortedSeq[j];
			}
			sortedSeq[index] = str.charAt(index);
			sortedSeqSize++;
		}
		return new String(sortedSeq);
	}
	/**
	 * �Ľ����ϵ�sort����
	 * �˷�������Ҫ��¼����ĸ����
	 * �Ҳ���Ҫ���з���ĸ�Ĳ��������
	 * @param str
	 * @return
	 */
	public static String improveSort(String str){
		int length = str.length();
		char[] sortedSeq  = new char[length];
		int sortedSeqSize = 0;
		for(int i = 0; i < length; i++){
			char temp = str.charAt(i);
			if(!isNotLetter(temp)) sortedSeq[sortedSeqSize++] = temp;	
		}
		sort(sortedSeq,sortedSeqSize);
		StringBuilder sortedString = new StringBuilder(str);
		int index = 0;
		/**
		 * �������ﲻ��Ҫ������sort����������¼����ĸ��Ȼ��һ��һ�������
		 * ֱ�ӿ����ж�ԭ�ַ����ǲ�����ĸ���ǵĻ��������δ���ĸ������ȡ
		 * ���ǵĻ�������������ԭ�ַ�
		 * ��������������һ����
		 */
		for(int i = 0; i < length; i++){
			char temp = str.charAt(i);
			if(!isNotLetter(temp)) sortedString.setCharAt(i, sortedSeq[index++]);
		}
		return sortedString.toString();
	}
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str = input.nextLine();
			String result = improveSort(str);
			System.out.println(result);
		}
	}
}
