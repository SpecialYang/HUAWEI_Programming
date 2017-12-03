package com.special.spet;

import java.util.Scanner;

/** 
* �����˹����
* �κ�һ������m������������д��m����������֮��
* 
* ע��temp������֮����ֻ���ж�һ���Ƿ���ż����������
* @author special
* @date 2017��12��3�� ����11:26:22
*/
public class Pro75 {
	/**
	 * ������23�У��Ҿ�Ӧ���뵽��������ѧ��һ�°�
	 * ��ΪcubeN/n ����һ��n,��˼�����Ҳ����������˰�
	 * @param n
	 * @return
	 */
	public static String getExpression(int n){
		StringBuilder result = new StringBuilder();
		int cubeN = (int) Math.pow(n,3);
		int temp = n % 2 == 0 ? 1 : 0;
		int midItem = cubeN / n - temp; //�м���
		int firstItem = midItem - 2 * (n / 2 - temp); //��һ��
		while(n-- > 1){
			result.append(firstItem + "+");
			firstItem += 2;
		}
		result.append(firstItem);
		return result.toString();
	}
	public static String getExpressionImprove(int n){
		StringBuilder result = new StringBuilder();
		int firstItem = n * n - n + 1; //��һ��
		while(n-- > 1){
			result.append(firstItem + "+");
			firstItem += 2;
		}
		result.append(firstItem);
		return result.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			String expression = getExpressionImprove(n);
			System.out.println(expression);
		}
	}

}
