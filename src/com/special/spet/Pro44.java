package com.special.spet;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/** 
* ���ֵ������
* 1.���ü�������������ַ����ֵĴ���
* 2.���������㷨�õ������ĵ�����ݼ�����
* 3.Ȼ������ʼ����26�����εݼ��õ����������
* @author special
* @date 2017��10��25�� ����1:54:47
*/
public class Pro44 {
	private static void exch(int[] count, int i ,int j){
		int temp = count[i];
		count[i] = count[j];
		count[j] = temp;
	}
	public static int getSatisfied(String name){
		name = name.toLowerCase();
		int length = name.length();
		int[] count = new int[26];
		int result = 0;
		int redix = 26;
		for(int i = 0; i < length; i++)
			count[name.charAt(i) - 'a']++;
		/**
		 * ��������
		 */
		/*for(int i = 1; i < 26; i++)
			for(int j = i; j > 0 && count[j] > count[j - 1]; j--)
				exch(count,j,j - 1);
		for(int i = 0; i < 26; i++){
			if(count[i] == 0) break;
			result += count[i] * redix--;
		}*/
		/**
		 * ���ÿ⺯��������������
		 */
		Arrays.sort(count);
		for(int i = 25; i >= 0; i--){
			if(count[i] == 0) break;
			result += count[i] * redix--;
		}
		return result;
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			String[] names = new String[n];
			for(int i = 0; i < n; i++)
				names[i] = input.next();
			for(int i = 0; i < n; i++){
				int satisfied = getSatisfied(names[i]);
				System.out.println(satisfied);
			}
		}

	}

}
