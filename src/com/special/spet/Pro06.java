package com.special.spet;

import java.util.Scanner;

/**
* ������Ȼ����һ��һ�����������ӣ��Ӷ�����������ȥ��С�ڵ����������Χ�ڵ����е�����
* ��һ��һ������ȥ�������ܷ�ʱ��
* ���ǿ��Ի����Ƕ�ȥ������⣬���һ��������������ô���ı����϶�����
* ��������ͬ����i=2��ʼ�жϣ������������ʹ��������С��Ӧ�ı�����ͬʱ����i����
* ֻ���޷�����ʱ��ʹi������������ʹ����4��Ҳ��ֱ�������ģ���Ϊ�����Ѿ���������Ϊ2��ȡ���� 
* @author special
* @date 2017��9��4�� ����1:28:30
*/
public class Pro06 {
	
	public static String getResult(long inputNum){
		StringBuilder result = new StringBuilder();
		for(long i = 2;inputNum > 1;){
			if(inputNum % i == 0){
				inputNum /=i;
				result.append(i);
				result.append(" ");
			}
			else
				i++;
		}
		return result.toString();
	}
	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			long inputNum = input.nextLong();
			String result = getResult(inputNum);
			System.out.println(result);
		}
	}
}
