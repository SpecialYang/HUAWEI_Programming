package com.special.spet;

import java.util.Scanner;

/** 
* �ҳ��ַ����е�һ������һ�ε��ַ�
* ��ϣ˼�룬���ַ�������������Ӧ������ ֵ���ǳ��ֵĴ���
* Ȼ�����ԭ�ַ�������ֵΪ1�����
* @author special
* @date 2017��11��27�� ����1:50:49
*/
public class Pro58 {
	public static final int SIZE = (int) Math.pow(2, 16);
	
	public static void countCharacter(String str, int[] count){
		for(int i = 0; i < str.length(); i++)
			count[str.charAt(i)]++;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str = input.nextLine();
			int[] count = new int[SIZE];
			countCharacter(str,count);
			/*boolean isExit = false;
			for(int i = 0; i < str.length(); i++){
				if(count[str.charAt(i)] == 1){
					isExit = true;
					System.out.println(str.charAt(i));
					break;
				}
			}
			if(!isExit) System.out.println("-1");*/
			String result = "-1";
			for(int i = 0; i < str.length(); i++)
				if(count[str.charAt(i)] == 1){
					result = str.charAt(i) + "";
					break;
				}
			System.out.println(result);
		}
	}

}
