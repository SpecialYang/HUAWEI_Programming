package com.special.spet;

import java.util.Scanner;

/** 
* 
��ƻ����Ϊ���������һ����������Ϊ�գ�һ����ÿ�������϶���ƻ����
��(m,n)��ʾ��m��ƻ������n�������еİڷŷ���������
1.����������һ������Ϊ�գ���(m,n)����ת��Ϊ��m��ƻ������n-1�������ϣ������(m,n-1)����
2.�����������Ӷ�װ��ƻ������ÿ��������������һ��ƻ����
�����ʣ��m-n��ƻ��������ת��Ϊ��m-n��ƻ���ŵ�n��������  ����(m-n��n)
����������
(m��n)=(m,n-1)+(m-n,n);
*
* @author special
* @date 2017��11��29�� ����11:04:41
*/
public class Pro60 {
	public static int putApple(int m, int n){
		if(m <= 0) return 0;      //���û��ƻ�����϶�0��
		if(m == 1 || n == 1) return 1; //ֻҪƻ����������Ϊ1���϶�Ϊ1�ַ���
		/**
		 * ��ƻ����Ϊ0����ƻ��������������ȣ��ǾͲ��õݹ���
		 * �����������������ԣ�0�����ӣ���ƻ���϶�����˼��
		 */
		if(m != 0 && m - n == 0)     
			return putApple(m,n - 1) + 1;
		return putApple(m,n - 1) + putApple(m - n,n); 
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int m = input.nextInt();
			int n = input.nextInt();
			int result = putApple(m,n);
			System.out.println(result);
		}
	}

}
