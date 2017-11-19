package com.special.improve;

import java.util.Scanner;

/** 
* ����ӳ��������ַ�ת������Ӧ���뵽��
* ͬʱ����ϣ������
* @author special
* @date 2017��9��27�� ����6:58:41
*/
public class Pro29Improve2 {
	
	private static final String charTable    = "0123456789ABCDEFabcdef";
	private static final String mapCharTable = "084C2A6E195D3B7F5D3B7F";
	/**
	 * ����Ԫ�ؽ���
	 * @param ch
	 * @param i
	 * @param j
	 */
	private static void swap(char[] ch, int i, int j){
		char temp = ch[i];
		ch[i] = ch[j];
		ch[j] = temp;
	}
	/**
	 * ϣ��������ʵ���ǲ���Ϊ2�Ĳ�������
	 * @param ch
	 * @param step
	 */
	private static void shell(char[] ch, int step){
		int length = ch.length;
		/**
		 * ע��i�ĳ�ʼֵ��i������
		 * ע��j�ĳ�ʼֵ��Ϊʲôjȡi,������i + 1�أ�
		 * 1.��Ϊi���ж�����ȷ����������Խ�磬��������jȡiֵһ������Խ��
		 * 2.�������jȡi+1,���Ǿͻ���i����ȷ����
		 * ͬʱע��j���ж������Ͳ���
		 * j>=step ��Ϊ�˷�ֹ�����½�Խ�磡
		 */
		for(int i = step; i < length; i++){
			for(int j = i; j >= step; j -= step){
				if(ch[j] < ch[j - step]) swap(ch,j,j - step);
			}
		}
	}
	/**
	 * �����������һ���汾�����Լ��ٽ����Ĵ���
	 * ��Ҫע��i��j��ȡֵ��ͬʱע����ѭ���Ƚϵ�������
	 * @param ch
	 * @param step
	 */
	private static void improveShell(char[] ch, int step){
		int length = ch.length;
		for(int i = step; i < length; i++){
			char temp = ch[i];
			int j = i - step;
			for(; j >= 0; j -= step){
				if(ch[j] > temp) ch[j + step] = ch[j];
				else                     break;
			}
			ch[j + step] = temp;
		}
	}
	public static String ProcessString(String str1,String str2){
		String mergeString = str1 + str2;
		int length = mergeString.length();
		char[] mergeArr = mergeString.toCharArray();
		shell(mergeArr,2);
		/**
		 * �ַ�ת�����õķ���������ӳ���
		 */
		for(int i = 0; i < length; i++){
			int index = charTable.indexOf(mergeArr[i]);
			if(index != -1)
				mergeArr[i] = mapCharTable.charAt(index);
		}
		return new String(mergeArr);
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str1 = input.next();
			String str2 = input.next();
			String result = ProcessString(str1,str2);
			System.out.println(result);
		}

	}


}
