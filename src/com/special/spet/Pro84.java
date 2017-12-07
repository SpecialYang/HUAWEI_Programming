package com.special.spet;

import java.util.Scanner;

/** 
* �������Ļ����ַ�������
* @author special
* @date 2017��12��7�� ����9:40:37
*/
public class Pro84 {
	public static int getHuiWenMaxLen(String str){
		int maxLen = 0;
		for(int i = 0; i < str.length(); i++){
			int tempLen = 0, indexI = i, indexJ = i - 1;
			/**
			 * ż�����ȵĻ��Ĵ�
			 */
			while(indexJ >= 0 
							  && indexI < str.length()
							  && str.charAt(indexJ) == str.charAt(indexI)){
				tempLen += 2;
				indexJ--;
				indexI++;
			}
			maxLen = Math.max(tempLen, maxLen);
			tempLen = 1;
			indexI = i + 1;
			indexJ = i - 1;
			while(indexJ >= 0 
					          && indexI < str.length()
					          && str.charAt(indexJ) == str.charAt(indexI)){
				tempLen += 2;
				indexJ--;
				indexI++;
			}
			maxLen = Math.max(tempLen, maxLen);
		}
		return maxLen;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str = input.nextLine();
			int maxLen = getHuiWenMaxLen(str);
			System.out.println(maxLen);
		}
	}

}
