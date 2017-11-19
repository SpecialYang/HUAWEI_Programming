package com.special.spet;

import java.util.Scanner;

/** 
* ɾ�����ִ������ٵ��ַ����������ִ������ҲҪȫɾ
* 1.һ��˼·���ǿ��ܻ�һ������ָ���һ���ַ���Ȼ����������ַ������������������ӶȾ���n��ƽ��
* 2.��һ���Ż��������뵽���ַ�������Ȼ��һ�α������������������Ӷ�ȡ���������㷨�ĸ��Ӷ�
* 3.����һ�������ÿռ任ʱ��ķ�������������ͳ���ַ����ִ��������Բ��ô˷�
* һ������������������ַ������ԣ�char - 26�����������Ϳ��Դ�0 ��  25
* ����Ȼ�뵽�������ķ��������ǵ�������ɵ�ˣ��Ҿ�Ȼ������������������ٵ��ַ��ͻ���ǰ��
* �������и����⣬ͳ�ƴ��������������Ͳ����ˡ��Ҿ�Ȼ�뵽�����һ���࣬�洢�ַ��������������
* ̫��ϧ�ˡ���Ȼ�뵽�˿ռ任ʱ����ô����ķ�������Ȼ�����ز���ˡ�
* �������������������Ȼ��������ҵ����ִ������ٵġ�
* Ȼ����������ַ���������ÿ���ַ���ȥ�����п����Ӧ�Ĵ����Ƿ������ٵĴ�����ȣ�Ȼ������Ƿ�ɾ���������������������
* @author special
* @date 2017��9��13�� ����5:54:59
*/
public class Pro22 {

	public static String getReduce(String str){
		StringBuilder reduceResult = new StringBuilder();
		int[] countChar = new int[26];
		/**
		 * ͳ���ַ����ֵĴ���
		 */
		for(int i = 0; i < str.length(); i++){
			char temp = str.charAt(i);
			countChar[temp - 'a']++;
		}
		int min = Integer.MAX_VALUE;
		/**
		 * �ҳ����ٵ�
		 */
		for(int i = 0; i < 26; i++)
			if(countChar[i] != 0 && countChar[i] < min)
				min = countChar[i];
		/**
		 * ���������ַ������޳����ٵ�
		 */
		for(int i = 0; i < str.length(); i++){
			char temp = str.charAt(i);
			if(countChar[temp - 'a'] != min)
				reduceResult.append(temp);
		}
		return reduceResult.toString();
	}
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str = input.nextLine();
			String result = getReduce(str);
			System.out.println(result);
		}
	}
}
