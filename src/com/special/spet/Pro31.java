package com.special.spet;

import java.util.Scanner;

/** 
* �ַ�����������ػ�
* @author special
* @date 2017��9��29�� ����2:02:18
*/
public class Pro31 {
	
	/**
	 * �����Ӵ���ÿ�ζ�Ҫ����һ���ַ������ڴ泬��
	 * ���ô�ԭ�ַ����Ϳ�ʼ����β��������987ms.......
	 * @param str
	 * @param begin
	 * @param end
	 * @return
	 */
	private static boolean isFormat(String str, int begin, int end){
		/**
		 * ��ʼ�ͽ�β�������м��
		 */
		int length = begin + (end - begin) / 2;
		while(begin <= length){
			if(str.charAt(begin++) != str.charAt(end--))
				return false;
		}
		return true;
	}
	public static int getLength(String str){
		int length = str.length();
		int ans = 0;
		/**
		 * ע�⾡���ܵļ���ѭ������
		 * ����ҪŪ��i,j��ֵ
		 */
		for(int i = 0; i < length - 1; i++){
			int tempLength = 1;
			for(int j = i + 1; j < length; j++){
				if(isFormat(str,i,j)){
					tempLength = j - i + 1;
					if(tempLength > ans)
						ans = tempLength;
				}
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str = input.nextLine();
			int longestLength = getLength(str);
			System.out.println(longestLength);
		}
	}

}
