package com.special.spet;

import java.util.Scanner;

/** 
* �ַ����ϲ�����
* ���ò���Ϊ2��ð������ѡ������
* @author special
* @date 2017��9��27�� ����2:17:09
*/
public class Pro29 {
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
	 * ð������
	 * ע��ð���������ѭ����ÿ�ζ��ӿ�ͷ��ʼ����
	 * ��Ϊð����������е��Ҷ��������
	 * @param ch
	 * @param begin
	 * @param step
	 */
	private static void bubbleSort(char[] ch, int begin, int step){
		int length = ch.length;
		for(int i = begin; i < length - 1; i += step){
			/**
			 * ע��j��ֵ
			 */
			for(int j = begin + step; j < length; j += step){
				if(ch[j] < ch[j - step]) swap(ch,j,j - step);
			}
		}
	}
	/**
	 * ѡ������
	 * ע��ѡ���������ѭ���Ŀ�ͷ�Ǹ�����ѭ���ĳ�ʼֵ������
	 * ��Ϊѡ����������е�����������
	 * @param ch
	 * @param begin
	 * @param step
	 */
	private static void selectSort(char[] ch, int begin, int step){
		int length = ch.length;
		for(int i = begin; i < length; i += step){
			int minIndex = i;
			/**
			 * ע��j��ֵ
			 */
			for(int j = i + step; j < length; j += step)
				if(ch[j] < ch[minIndex]) minIndex = j;
			swap(ch,i,minIndex);
		}
	}
	/**
	 * �Ե����ַ����д���
	 * @param ch
	 * @return
	 */
	private static char solve(char ch){
		StringBuilder binary = new StringBuilder();
		int result = 0;
		if(ch >= '0' && ch <= '9')
			result = ch - '0';
		else if(ch >= 'A' && ch <= 'F')
			result = ch - 'A' + 10;
		else if(ch >= 'a' && ch<= 'f')
			result = ch - 'a' + 10;
		else
			return ch;
		/**
		 * ֱ��������λ����1ȡ�룬��¼ÿһ�ν��
		 * �õ����Ƕ�����λ�ĵ���
		 */
		while(result != 0){
			int temp = result & 1;
			binary.append(temp);
			result >>= 1;
		}
		/**
		 * ��������Ż�һ��
		 * ���ü���һ��"0000"Ȼ��substring��ǰ4���ַ�����Ӵ�
		 * �ô����ǲ���ȥ�ж��Ƿ񳤶�Ϊ4�������'0'
		 */
		/*String bin = binary.toString();
		int length = 4 - bin.length();
		while(length-- > 0)
			bin = bin + "0";*/
		binary.append("0000");
		String binaryStr = binary.substring(0, 4);
		/**
		 * ��������λת������������
		 */
		int ans = 0;
		for(int i = 0; i < 4; i++)
			ans = ans * 2 + (binaryStr.charAt(i) - '0');
		/**
		 * ����������ת����16����
		 */
		if(ans >= 10)
			ch = (char) ('A' + (ans - 10));
		else
			ch = (char) ('0' + (ans - 0));
		return ch;
	}
	public static String ProcessString(String str1,String str2){
		String mergeString = str1 + str2;
		int length = mergeString.length();
		char[] mergeArr    = mergeString.toCharArray();
		selectSort(mergeArr,0,2);
		selectSort(mergeArr,1,2);
		for(int i = 0; i < length; i++){
			mergeArr[i] = solve(mergeArr[i]);
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
